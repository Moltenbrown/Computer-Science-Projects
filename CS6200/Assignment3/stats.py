newline = "\n"

# a group of functions that gather all the information needed for the output file:
class stats:
	def __init__(self):
		self.query = None
		self.tokens = []
		self.results = []

	# used to obtain the original query
	def getQuery(self):
		return self.query

	# sed to set the original query
	def setQuery(self, query):
		self.query = query

	# used to get the tokens from the stats object
	def getTokens(self):
		return self.tokens

	# used to set the tokens of the stats object
	def setTokens(self, tokens):
		self.tokens = tokens

	# used to get the document results from the queries:
	def getResults(self):
		return self.results

	# used to set the document results from the queries:
	def setResults(self, doc_stats):
		self.results = doc_stats
	
	# used to add a query to a preexisting stat object
	def addQuery(self, line):
		self.query = line

	# used to create a list of stat objects associated with queries in the document. 
	def setQuery(self, line, results):
		global newline
		line = line.replace(newline, "")
		new_stats = stats()
		new_stats.addQuery(line)
		results.append(new_stats)

	# used to add the query tokens to the list of stat objects
	def setQueryTokens(self, stats_list, qt_list):
		results = []
		for block in qt_list:
			index = qt_list.index(block)
			stat = stats_list[index]
			token_list = []
			for word in block:
				token_list.append(word)

			stat.setTokens(token_list)
			results.append(stat)
		return results

	# used to add the doc_stats associated with the query to it's particular stat object
	def setDocStats(self, stats_list, ds_list):
		results = []
		for block in stats_list:
			index = stats_list.index(block)
			doc_stats = ds_list[index]
			block.setResults(doc_stats)
			results.append(block)

		return results 

	# used to create an output file that will write all the stats to an output file
	def createOutputFile(self, stats_list):
		outputFileName = "Output.txt"
		global newline
		comma = ", "
		semicolon = "; "
		with open(outputFileName, "w") as output:				
			for block in stats_list:
				output.write(block.getQuery())
				output.write(newline)
				tokens = block.getTokens()
				length = len(tokens)
				for value in range(0, length):
					output.write(tokens[value])
					if value != length - 1:
						output.write(comma)
				output.write(newline)
				doc_stats = block.getResults()
				for doc in doc_stats:
					output.write(doc.getName())
					output.write(newline)
					snippet = doc.getSnippet()
					snippet = str(snippet.encode("utf8"))
					output.write(snippet)
					output.write(newline)

					# because write requires a str not a float
					output.write(str(doc.getCosine()))
					output.write(newline)
					contributions = doc.getContributions()
					string = ""
					for cont in contributions:
						string += cont + ": " + str(contributions[cont]) + semicolon
					output.write(string[:-2])
					output.write(newline)
					output.write(newline)
				output.write(newline)
				output.write(newline)




