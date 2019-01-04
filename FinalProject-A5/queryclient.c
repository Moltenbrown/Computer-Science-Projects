#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <ctype.h>
#include <errno.h>
#include "includes/queryprotocol.h"

#define bufferLength 100
#define sendRecvFlag 0
#define responseLength 1500
#define queryCharacterLimit 100

extern int errno;
const char *ipAddress = NULL;
const char *port = NULL;
int socket_fd, rv, goodbyeCheck, killCheck;
struct addrinfo hints, *servinfo, *p;
int ackSuccess;

void RunQuery(char *query) {
  int i;	
	memset(&hints, 0, sizeof hints);
	hints.ai_family = AF_INET;
	hints.ai_flags = AI_NUMERICHOST | AI_PASSIVE; 
	hints.ai_socktype = SOCK_STREAM;

  for(i = 0; i < strlen(port); i++) {
    if(isalpha(port[i])) {
      printf("For this program to work, you need to provide the address of the server as an numerical IPAddress and the port as a number. Please try again.\n");
    }
  }
  
  if((rv = getaddrinfo(ipAddress, port, &hints, &servinfo)) != 0) {
    printf("Something is wrong with the IP Address and/or the port you input, please check those and try again. Here is the error message: %s\n", gai_strerror(rv));
    exit(1);
  }

  for(p = servinfo; p != NULL; p = p->ai_next) {
    if ((socket_fd = socket(p->ai_family, p->ai_socktype, p->ai_protocol)) == -1) {
      perror("The program was unable to create a socket. Please check your input if this error continues.\n");
      continue;
    }

    if ((connect(socket_fd, p->ai_addr, p->ai_addrlen)) == -1) {
      if (errno == ECONNREFUSED) {
        printf("The server is currently rejecting connection. Therefore, we will be closing the program. Please check to make sure the IP address you are using and the port are correct.\n");
				exit(1);
      }

      perror("The program was unable to connect to the IP address provided. Please check to make sure what you put in was correct.\n");
      close(socket_fd);
      continue;
    }

    break;
 }

	freeaddrinfo(servinfo);
  char *response = (char *)malloc(sizeof(char *));
  int recvSuccess;

  if ((recvSuccess =  recv(socket_fd, response, bufferLength, sendRecvFlag)) <= 0) {
    perror("The program failed to recieve anything from the server. Please address the error.\n");
    close(socket_fd);
    exit(2);
  }

  if ((ackSuccess = CheckAck(response)) != 0) {
    printf("The system was unable to successfully receive an ACK to server. Please check to make sure the server is functioning and try again.\n");
    close(socket_fd);
    exit(2);
  }

  int sendSuccess;
  int queryLength = strlen(query);

  if ((sendSuccess = send(socket_fd, query, queryLength, sendRecvFlag)) == -1) {
     perror("The query was unable to be sent. Please address the following error.\n");
     close(socket_fd);
     exit(2);
  }

  char *results = (char *)malloc(sizeof(char *)); 

// creating a loop so that get all the responses from the server for our query.
  while(1) {
    if ((recvSuccess = recv(socket_fd, results, responseLength, sendRecvFlag)) == -1) {
      perror("Error while receiving from server. Exiting program.\n");
      close(socket_fd);
      exit(2);
    }

		if(results != 0){
			printf("%s", results);
			//results = NULL;
			printf("\n");

    	if ((ackSuccess = SendAck(socket_fd)) == -1) {
      	printf("Client unable to send acknowledgement to server. Please check server.\n");
				exit(2);
    	}
		}

		if (results == 0) {
			break;
		}
	}

	if ((recvSuccess = recv(socket_fd, results, responseLength, sendRecvFlag)) == -1) {
		perror("Error receiving end notice.");
		close(socket_fd);
		exit(2);
	}

	if((goodbyeCheck = CheckGoodbye(results)) == 0) {		
		free(socket_fd);
		RunPrompt();
	}
}

void KillServer() {
  if((rv = getaddrinfo(ipAddress, port, &hints, &servinfo)) != 0) {
    printf("Something is wrong with the IP Address and/or the port you input, please check those and try again. Here is the error message: %s\n", gai_strerror(rv));
    exit(1);
  }

  for (p = servinfo; p != NULL; p = p->ai_next) {
    if ((socket_fd = socket(p->ai_family, p->ai_socktype, p->ai_protocol))-1) {
      perror("The program was unable to create a socket. Please check your input if this error continues.\n");
      continue;
    }

    if ((connect(socket_fd, p->ai_addr, p->ai_addrlen)) == -1) {
      if (errno == ECONNREFUSED) {
        printf("The server is currently rejecting connection. Therefore, we will be closing the program. Please check to make sure the IP address you are using and the port are correct.\n");
				close(socket_fd);
				exit(2);
      }

      perror("The program was unable to connect to the IP address provided. Please check to make sure what you put in was correct.\n");
      close(socket_fd);
      continue;
    }

    break;
  }
  
  if ((killCheck = SendKill(socket_fd)) != 0) {
		printf("There was an error sending a KILL msg to the server. Please check the connection.\n");
	}

  close(socket_fd);
	freeaddrinfo(servinfo);
}

void RunPrompt() {
  char input[1000];

  while (1) {
    printf("Enter a term to search for, q to quit or k to kill. The term can only be 100 characters.\n");
    scanf("%s", input);
    
		if (strlen(input) > queryCharacterLimit) {
			printf("Your input is limited to 100 characters. Please try again.\n");
			exit(1);
		}

    if (strlen(input) == 1) {
      if (input[0] == 'q') {
			 	printf("Thank you for using the program.\n");
				exit(1);

     } else {
       if ((input[0] == 'k') || input[0] == 'K') {
        KillServer();
				exit(1);
       }
     }
   }

   if (strlen(input) > 1) {
	 	 RunQuery(input);
		 continue;
	 }
 }
}

int main(int argc, char **argv) {  
  if(argv < 3) {
      printf("You must include an IP address and port for the program to work. Please try again.\n");
  }

  else {
    ipAddress = argv[1];
    port = argv[2];
    RunPrompt();
  }

  return 0;
}
