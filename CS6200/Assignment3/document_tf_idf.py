import sys
import math
import curses.ascii

sys.path.append("../Assignment2")

from UseIndex import *

# a function to return all the documents and term frequencies of each term of the query words
# from the inverted index. 

def get_document_tf(foldername, query):
	jsonObject = queryCheck(foldername, query)
	checkingTerm = jsonToTermID(jsonObject)
	docResults = checkInvertedList(foldername, checkingTerm)
	adjusted_results = jsonToDocumentID(docResults)

	return adjusted_results

# a function to take a list of inverted index results and change the term frequencies to weighted
# tfs. Since the document frequency for documents is 1, and tf-idf is just tf * the document frequencxy
# this functions as returning the tf-idf for all documents associated with that term.
def create_weighted_doc_tf_idf(results):
	for res in results:
		new_length = 1 + math.log10(res.getDocumentLength())
		res.setDocumentLength(new_length)

	return results

# add 0 to the weights if the document doesn't have any of the terms in the sentence
# using the results from the
def create_doc_tf_idf(foldername, queryDoc):
	documentsForQueries = []
	with open(queryDoc, "r") as queries:
		for line in queries:
			queryResults = {}
			line = line.split(' ')
			for word in line:
				word = word.casefold()
				word = word.replace("\n", "")
				for letter in word:
					if curses.ascii.ispunct(letter):
						word = word.replace(letter, "")
				initial_doc_results = get_document_tf(foldername, word)
				initial_doc_results = create_weighted_doc_tf_idf(initial_doc_results)
				queryResults[word] = initial_doc_results
			documentsForQueries.append(queryResults)

	return documentsForQueries






