from TermID import termID
from DocumentID import documentID
import json
# creating a class to create the InvertedIndex. Using the termID List to make things easier.

class invertedIndex:
	def __init__(self):
		self.termIDList = None
		self.termToDocStats = {}
		self.documentIDs = None

	#used to return the termID list
	def getTermIDList(self):
		return self.termIDList

	# used to set the termID list
	def setTermIDList(self, termIDList):
		self.termIDList = termIDList

	#used to return the termID list
	def getDocumentIDList(self):
		return self.documentIDs

	# used to set the termID list
	def setDocumentIDList(self, documentIDs):
		self.documentIDs = documentIDs

	# used to get the term to doc stats
	def getTermToDocStats(self):
		return self.termToDocStats

	# used to initialize array for term to doc stats
	def initializeTermToDocStatsEntry(self, key):
		self.termToDocStats[key] = []

	# used a pairing to term to doc stats
	def addTermToDocStats(self, key, value):
		self.termToDocStats[key].append(value)

	# used to create the initial termID List and associate it with the InvertedIndex
	def createInvertedIndex(self, filename):
		forIndex = termID()
		termIDList = forIndex.generateTermID(filename)
		forDocuments = documentID()
		documentIDList = forDocuments.generateDocumentID(filename)

		self.setTermIDList(termIDList)
		self.setDocumentIDList(documentIDList)

	# used to create the inverted index file
	def generateFile(self, filename):
		invertedIndexOutput = "./InvertedIndex.json"
		print("Generating an inverted index.\n")
		print("Starting the termID portion.\n")
		newIndex = invertedIndex()
		newIndex.createInvertedIndex(filename)

		fileChecker = ".txt"
		termIDList = newIndex.getTermIDList()
		print("Now generating and outputting the inverted index.\n")
		with open(filename, "r") as file:
			# converting the file to a more manageable form so I don't have to read it repeatedly.
			holder = file.readlines()
			limit = len(holder)
			limit -= 1

			for key in termIDList:
				newIndex.initializeTermToDocStatsEntry(key)
				termIDHolder = termIDList[key]
				docs = termIDHolder.getDocuments()
				#dealing with situations where a "," was replaced with " "
				secondaryKey = key.replace("\n", " \n")
				for doc in docs:
					starter = holder.index(doc)
					docStat = documentID()
					docStat.setDocumentName(doc)
					starter += 1
					currentToken = holder[starter]
					while fileChecker not in currentToken:
						if currentToken == key or currentToken == secondaryKey:
							docStat.incrementDocumentLength()
							if starter == limit:
								starter = -1
							starter += 1
							currentToken = holder[starter]
						else:
							if starter == limit:
								starter = -1
							starter += 1
							currentToken = holder[starter]
					newIndex.addTermToDocStats(key, docStat)

		with open(invertedIndexOutput, "w") as output:
			holder = {}
			stats = newIndex.getTermToDocStats()
			for stat in sorted(stats.keys()):
				docStat = stats[stat]
				stat = stat.replace("\n", "")
				holder[stat] = []
				for docinfo in docStat:
					holder[stat].append({
						'document name' : docinfo.getDocumentName(),
						'term frequency' : docinfo.getDocumentLength()
						})

			json.dump(holder, output)
			print("Successfully generated an inverted index.\n")


		return invertedIndexOutput


