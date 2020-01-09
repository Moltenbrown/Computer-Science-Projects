import re

removalInfo = "../Assignment1/files/"
bytes_to_read = 200

# class to hold the name, snippet, cosine score, and contributions of each word
class doc_stats:
	def __init__(self):
		self.name = None
		self.snippet = None
		self.cosine = None
		self.contributions = {}

	# used to get the document name
	def getName(self):
		return self.name

	# used to set the document name
	def setName(self, name):
		self.name = name

	# used to get the document snippet
	def getSnippet(self):
		return self.snippet

	# used to set the document snippet
	def setSnippet(self, snippet):
		self.snippet = snippet

	# used to get the document similarity cosine
	def getCosine(self):
		return self.cosine

	# used to set the document similarity cosin
	def setCosine(self, cosine):
		self.cosine = cosine

	# used to get the how much each term contributed to the similarity cosine
	def getContributions(self):
		return self.contributions

	# used to add how much a term contributed to the similarity cosine:
	def addContribution(self, word, value):
		self.contributions[word] = value

	# used to get a list of the top doc_stats for a query
	def generate_doc_stat_list(self, final_score_list):
		doc_stat_list = []
		for block in final_score_list:
			doc_list = []
			for doc in block:
				name = doc[0]
				new_doc_stat = doc_stats()
				new_doc_stat.setName(name)
				new_doc_stat.setCosine(doc[1])
				doc_list.append(new_doc_stat)
			doc_stat_list.append(doc_list)

		return doc_stat_list

	# used to get the contributions for each terms in the query relative to the doc stat:
	def fill_contribution(self, doc_stat_list, norm_doc_list_update):
		for block in norm_doc_list_update:
			index = norm_doc_list_update.index(block)
			doc_stats_for_block = doc_stat_list[index]
			for word in block:
				names_used = []
				for doc_stat in doc_stats_for_block:
					word_results = block[word]
					doc_name = doc_stat.getName()
					for doc in word_results:
						names_used.append(doc.getDocumentName())
						if doc.getDocumentName() == doc_name:
							doc_stat.addContribution(word, doc.getDocumentLength())
					if doc_name not in names_used:
						doc_stat.addContribution(word, 0)

		return doc_stat_list

	# used to get the first 200 bytes of the document for the document stat:
	def fill_snippet(aelf, doc_stat_list, file_folder):
		global bytes_to_read
		for block in doc_stat_list:
			for doc_stat in block:
				name = doc_stat.getName()
				name = name.replace(removalInfo, "")
				doc_stat.setName(name)
				filename = file_folder + "/" + name
				with open(filename, 'r', encoding="utf8") as doc_file:
					testor = True
					whole_file = doc_file.read()
					seek_start = whole_file.index("<p>")
					doc_file.seek(seek_start)
					doc_stat.setSnippet(doc_file.read(bytes_to_read))

		return doc_stat_list


