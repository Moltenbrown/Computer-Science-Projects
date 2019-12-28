import sys
import operator
import json
from TermID import termID
from DocumentID import documentID

termIDFile = "./TermIDFile.json"
documentIDFile = "./DocumentIDFile.json"
invertedIndexFile = "./InvertedIndex.json"
removalInfo = "../Assignment1/files/"

# returns the term ID associated with the term.
def queryCheck(query):
	result = None

	with open(termIDFile, 'r') as termFile:
		info = json.load(termFile)
		result = info[query]

	return result

# dealing with the json wrappings of the information recieved from query check
def jsonToTermID(queryCheckResult):
	jsonObject = queryCheckResult[0]
	newTermID = termID()
	newTermID.setTermID(jsonObject['token'])
	for doc in jsonObject['documents']:
		newTermID.addDocument(doc)

	newTermID.setFrequency()

	return newTermID

# returns a list of document id's associated with the term.
def checkInvertedList(termID):
	results = None
	term = termID.getTermID()

	with open(invertedIndexFile, 'r') as indexFile:
		info = json.load(indexFile)
		results = info[term]

	docResults = []

	with open(documentIDFile, 'r') as documentFile:
		info = json.load(documentFile)
		for result in results:
			docName = result['document name']
			docName = docName.replace("\n", "")
			docResults.append(info[docName])

	return docResults

# used to convert the results from checkInvertedList from the json format to a documentID format
def jsonToDocumentID(results):
	docIDList = []
	for result in results:
		result = result[0]
		newDocID = documentID()
		newDocID.setDocumentName(result['name'])
		newDocID.setDocumentLength(result['length'])
		docIDList.append(newDocID)

	return docIDList


# returns a the document name associated with the id.
def checkDocumentsList(documentID):
	name = documentID.getDocumentName()
	name = name.replace(removalInfo, "")
	return name

# ties all the helper functions together to get a list of documents associated with the terms in the query.
def main():
	termToFindInfoFor = sys.argv[1].split(' ')
	result = {}
	temp = []

	for term in termToFindInfoFor:
		jsonObject = queryCheck(term)
		checkingTerm = jsonToTermID(jsonObject)
		docResults = checkInvertedList(checkingTerm)
		adjusted_results = jsonToDocumentID(docResults)

		for res in adjusted_results:
			temp.append(checkDocumentsList(res))

		temp = set(temp)

		if len(result) == 0:
			result = temp
		else:
			# attempting to get only the set of documents that contain all the words in the query.
			result = temp.intersection(result)

	print(result)

main()
