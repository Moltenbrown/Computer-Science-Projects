#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/wait.h>
#include <signal.h>
#include <errno.h>

#include "includes/queryprotocol.h"
#include "includes/docset.h"
#include "includes/movieIndex.h"
#include "includes/docidmap.h"
#include "includes/Hashtable.h"
#include "includes/queryprocessor.h"
#include "includes/fileparser.h"
#include "includes/filecrawler.h"

#define bufferLength 100
#define sendRecvFlag 0
#define responseLength 1500
#define backlog 10

const char *port = NULL;
const char *data_dir = NULL;
int socket_fd, rv, second_socket, sendSuccess, recvSuccess, ackCheck, bindCheck, listenCheck, ackSuccess, checkHolder, searchResultCheck, rowSuccess, goodbyeCheck;
struct addrinfo hints, *servinfo, *p;
struct sockaddr_storage infoHolder;
socklen_t addr_size;

int Cleanup(); 

DocIdMap docs;
Index docIndex;

int SEARCH_RESULT_LENGTH = 1500; 

char movieSearchResult[SEARCH_RESULT_LENGTH];


void sigchld_handler(int s)
{
  write(0, "Handling zombies...\n", 20); 
  // waitpid() might overwrite errno, so we save and restore it:
  int saved_errno = errno;
  
  while(waitpid(-1, NULL, WNOHANG) > 0);
  
  errno = saved_errno;
}


void sigint_handler(int sig)
{
  write(0, "Ahhh! SIGINT!\n", 14);
  Cleanup();
  exit(0); 
}



/**
 * 
 */
int HandleConnections(int sock_fd) {
	addr_size = sizeof infoHolder;

	while(1) {
		addr_size = sizeof infoHolder;
		if ((second_socket = acccept(socket_fd, (struct sockaddr *)&infoHolder, &addr_size)) == -1) {
			perror("Program unable to accept connections.\n");
			continue;
		}

		if (!fork()) {
			close(socket_fd);
			if ((ackSuccess = SendAck(second_socket)) == -1) {
				printf("Sending acknowledgement has failed. Please check client. Closing program.\n");
				close(second_socket);
				close(socket_fd);
				exit(2);
			}

			char *query = (char *)malloc(sizeof(char*));
			if ((recvSuccess = recv(second_socket, query, bufferLength, sendRecvFlag)) == -1) {
				perror("Server failed to receive query from client. Please check client. Closing program.\n");
				close(second_socket);
				close(socket_fd);
				exit(2);
			}

			if ((checkHolder = CheckKill(query)) == 0) {
				close (second_socket);
				close(socket_fd);
				free(query);
				exit(1);
			}

			SearchResultIter results = FindMovies(docIndex, query);
			free(query);

			while (SearchResultIterHasMore(results)) {
				SearchResult output;
				if ((searchResultCheck = GetNextSearchResult(results, output)) != 0) {
					printf("Unable to get search result. Please check code.\n");
					continue;
				}

				if ((rowSuccess = GetRowFromFile(output, docs, movieSearchResult)) != 0) {
					printf("Unable to retrieve row from DocIDMap.\n");
					continue;
				}

				if ((sendSuccess = send(second_socket, movieSearchResult, SEARCH_RESULT_LENGTH, sendRecvFlag)) == -1) {
					perror("Unable to send search result to client. Please check client.\n");
					close(second_socket);
					close(socket_fd);
					exit(2);
				}

				char *response = (char *)malloc(sizeof(char *));
				if ((recvSuccess = recv(second_socket, response, bufferLength, sendRecvFlag)) == -1) {
					perror("Problem receiving acknowledgement.\n");
					close(second_socket);
					close(socket_fd);
					exit(2);
				}

				if ((ackCheck = CheckAck(response)) == -1) {
					printf("Failed to receive an acknowledgement from the client. Please check the client.\n");
					close(second_socket);
					close(socket_fd);
					exit(2);
				}

				free(response);
				free(output);
				for (int i = 0; i < strlen(movieSearchResult); i++) {
					movieSearchResult[i] = 0;
				}
			}

			char stop[1] = {0};
			if ((sendSuccess = send(second_socket, stop, 1, sendRecvFlag)) = -1) {
				perror("Issue sending a stop signal.");
				close(second_socket);
				close(socket_fd);
				exit(2);
			}

			if ((goodbyeCheck = SendGoodbye(second_socket)) == -1) {
				printf("Issue sending goodbye to client. Please check client.\n");
			}

			close(second_socket);
			DestroySearchResultIter(results);
			exit(0);
		}

		close(second_socket);
	}	

	return 0;

}

void Setup(char *dir) {
  struct sigaction sa;
  
    sa.sa_handler = sigchld_handler; // reap all dead processes
    sigemptyset(&sa.sa_mask);
    sa.sa_flags = SA_RESTART;
    if (sigaction(SIGCHLD, &sa, NULL) == -1) {
      perror("sigaction");
      exit(1);
    }

    struct sigaction kill;

    kill.sa_handler = sigint_handler;
    kill.sa_flags = 0; // or SA_RESTART
    sigemptyset(&kill.sa_mask);

    if (sigaction(SIGINT, &kill, NULL) == -1) {
      perror("sigaction");
      exit(1);
    }

    printf("Crawling directory tree starting at: %s\n", dir); 
  // Create a DocIdMap
    docs = CreateDocIdMap();
    CrawlFilesToMap(dir, docs);

    printf("Crawled %d files.\n", NumElemsInHashtable(docs)); 

  // Create the index
    docIndex = CreateIndex();

  // Index the files
    printf("Parsing and indexing files...\n");
    ParseTheFiles(docs, docIndex); 
    printf("%d entries in the index.\n", NumElemsInHashtable(docIndex)); 
  }

  int Cleanup() {

    DestroyIndex(docIndex); 

    DestroyDocIdMap(docs);

    return 0; 
  }

  int main(int argc, char **argv)
  {
    if (argv < 3) {
			printf("You must enter a diretory and a port for this program to work. Please try again.\n");
		}

		port = argv[2];
		data_dir = argv[1];


    Setup(data_dir);

		memset(&hints, 0, sizeof hints);
		hints.ai_family = AF_INET;
		hints.ai_flags = AI_PASSIVE; 
		hints.ai_socktype = SOCK_STREAM;

		if ((rv = getaddrinfo(NULL, port, &hints, &servinfo)) != 0) {
			printf("Something is wrong with the port provided. Please check to make sure it is correct and try again. Here is the error message: %s\n", gai_strerror(rv));
			exit(1);
		}

		for (p = servinfo; p != NULL; p = p->ai_next) {
			if ((socket_fd = socket(p->ai_family, p->ai_socktype, p->ai_protocol)) == -1) {
				perror("The program was unable to create a socket. Please check your input if this error coninues.\n");
				continue;
			}

			if ((bindCheck = bind(socket_fd, p->ai_addr, p->ai_addrlen)) == -1) {
			perror("The program is unable to bind to this socket.\n");
			close(socket_fd);
			continue;
		}

		break;
	}

	freeaddrinfo(servinfo);

	if ((listenCheck = listen(socket_fd, backlog)) == -1) {
		perror("Check your client to make sure it's reaching out to the server.\n");
	}

	HandleConnections(socket_fd);

    // Got Kill signal
    close(sock_fd); 
    
    Cleanup(); 

    return 0;
  }
