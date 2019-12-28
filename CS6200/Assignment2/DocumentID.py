import json

# creating a class to hold the documentID, the names of documents containing the term
# and the document frequency of the term.

class documentID:
	def __init__(self):
		self.name = None
		self.length = 0

	# use to return the document name.
	def getDocumentName(self):
		return self.name

	# use to set the document name.
	def setDocumentName(self, name):
		self.name = name

	# use to return the document length.
	def getDocumentLength(self):
		return self.length

	# use to set the document length.
	def setDocumentLength(self, length):
		self.length = length

	# used to increment the document length
	def incrementDocumentLength(self):
		self.length += 1

	# main function to get the document ids and document lengths from the documents in the file.
	def generateDocumentID(self, filename):
		documentOutputName = "./DocumentIDFile.json"
		print("Creating a documentID list.\n")
		filenameMarker = ".txt"
		results = {}

		removalObject = '\n'
		replacementObject = ""

		# the dictionary that will link document names to DocumentIDs
		with open(filename, "r") as tokenfile:
			newDocumentID = None
			for line in tokenfile:
				if filenameMarker in line:
					newDocumentID = documentID()
					newDocumentID.setDocumentName(line.replace(removalObject, replacementObject))
					results[line] = newDocumentID
					
				else:
					newDocumentID.incrementDocumentLength()

		with open(documentOutputName, "w") as output:
			holder = {}
			for createdDocumentID in sorted(results.keys()):
				doc = results[createdDocumentID]
				docTitle = doc.getDocumentName()
				holder[docTitle] = []
				holder[docTitle].append({
					'name' : docTitle,
					'length' : doc.getDocumentLength()
					})

			json.dump(holder, output)
			print("Successfully generated a documentID list.\n")

		return output


