# creating a class to hold the termID, the names of documents containing the term
# and the document frequency of the term.
class TermID:
	def __init__(self, TermID):
		self.termID = TermID
		self.documents = []
		self.documentFrequency = 0

	# used to return the TermID
	def getTermID(self):
		return self.termID

	# used to return the documents that contain the TermID
	def getDocuments(self):
		return self.documents

	# used to return the document frequency for the TermID 
	def getFrequency:
		return self.documentFrequency

	# used to set the document frequency. Preferably used after the documents array
	# has been finished.
	def setFrequency:
		frequency = documents.len()
		self.documentFrequency = frequency

	# used to generate TermIDs from the output file from RunDataTransformer
	def generateTermID(self, filename):
		resultIDs = {}
		with open(filename, "rb") as tokenfile:
			filename = null
			for line in tokenfile:
				if ".txt" in line:
					filename = line
				else:
					try:
						result = resultsID[line]
						if filename not in result.documents:
							result.documents.append(filename)
							result.setFrequency()
							resultsID[line] = result

					except KeyError:
						termID = TermID()
						termID.documents.append(filename)
						termID.setFrequency()
						resultsID[line] = termID




