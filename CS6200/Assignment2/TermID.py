# creating a class to hold the termID, the names of documents containing the term
# and the document frequency of the term.
class termID:
	def __init__(self):
		self.termID = termID
		self.documents = []
		self.documentFrequency = 0

	# used to return the TermID
	def getTermID(self):
		return self.termID

	# used to set the termID.
	def setTermID(self, termID):
		self.termID = termID

	# used to return the documents that contain the TermID
	def getDocuments(self):
		return self.documents

	def addDocument(self, document):
		self.documents.append(document)
	# used to return the document frequency for the TermID 
	def getFrequency(self):
		return self.documentFrequency

	# used to set the document frequency. Preferably used after the documents array
	# has been finished.
	def setFrequency(self):
		frequency = len(self.documents)
		self.documentFrequency = frequency

	# used to generate TermIDs from the output file from RunDataTransformer
	def generateTermID(self, filename):
		resultIDs = {}
		filenameMarker = ".txt"
		# trying to deal with newline markers
		removalObject = "\n"
		replacementObject = ""

		# the dictionary that will link tokens to TermIDs
		with open(filename, "rb") as tokenfile:
			filename = None
			for line in tokenfile:
				line = line.decode('utf-8')
				if filenameMarker in line:
					filename = line
					print(filename)
				else:
					try:
						result = resultIDs[line]
						if filename not in result.documents:
							result.documents.append(filename)
							result.setFrequency()
							resultIDs[line] = result

					except KeyError:
						newTermID = termID()
						newTermID.setTermID(line.replace(removalObject, replacementObject))
						newTermID.addDocument(filename)
						newTermID.setFrequency()
						resultIDs[line] = newTermID




