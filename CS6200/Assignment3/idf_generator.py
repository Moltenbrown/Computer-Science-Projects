import math
import json

# creating a global variable for amount of documents since we've used 1000 documents for all assignments.
# recognize that I could have the number adjustible based on how many files are in the initial content 
# folder, but thought that might be overkill.
amount_of_documents = 1000
invertedIndexFile = "/TermIDFile.json"


class query_idf_generator:
	def __init__(self):
		self.term = None
		self.df = 0
		self.idf = 0

	# returns the term for the idf_generator
	def get_term(self):
		return self.term

	# set term for the idf_generator:
	def set_term(self, term):
		self.term = term

	# returns the df for the idf_generator
	def get_df(self):
		return self.df

	# set df for the idf_generator:
	def set_df(self, df):
		self.df = df

	# gets the idf for the idf_generator:
	def get_idf(self):
		return self.idf

	# sets the idf value for the idf_generator:
	def set_idf(self):
		result = amount_of_documents/self.df
		self.idf = math.log10(result)


	# sets the idf for each term in each query the query:
	def generate_idf_list(self, queryTokenList, termFolder):
		filename = termFolder + invertedIndexFile
		with open(filename, "r") as invertedFile:
			useable_inverted = json.load(invertedFile)
			results = []
			missing_words = []
			for query in queryTokenList:
				tokens = {}
				for key in query:
					key = key.replace("\n", "")
					term_info = query_idf_generator()
					term_info.set_term(key)

					try:
						current_key_info = useable_inverted[key]
						current_key_info = current_key_info[0]
						term_info.set_df(current_key_info['frequency'])
						term_info.set_idf()
						tokens[key] = term_info

					except KeyError:
						missing_words.append(key)
				results.append(tokens)

		return results