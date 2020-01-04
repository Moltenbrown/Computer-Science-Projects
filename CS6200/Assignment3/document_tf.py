import sys
import math

# trying to add UseIndex to the path so I can used it readily.
sys.path.append('../Assignment2')

from UseIndex import *

# a function to return all the documents and term frequencies of each term of the query words
# from the inverted index. 

def get_document_tf(query):
	results = []
	jsonObject = queryCheck(query)
	checkingTerm = jsonToTermID(jsonObject)
	docResults = checkInvertedList(checkingTerm)
	adjusted_results = jsonToDocumentID(docResults)
	for res in adjusted_results:
		results.append(checkDocumentsList(res))

	return results

# a function to take a list of inverted index results and change the term frequencies to weighted
# tfs. Since the document frequency for documents is 1, and tf-idf is just tf * the document frequencxy
# this functions as returning the tf-idf for all documents associated with that term.
def create_weighted_doc_tf_idf(results):
	for res in results:
		new_length = 1 + math.log10(res.getDocumentLength())
		res.setDocumentLength(new_length)

	return results

# since the document frequency
def create_doc_tf_idfs(results):





