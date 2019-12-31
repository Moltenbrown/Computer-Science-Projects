import math
import json
import sys

# creating a global variable for amount of documents since we've used 1000 documents for all assignments.
# recognize that I could have the number adjustible based on how many files are in the initial content 
# folder, but thought that might be overkill.
amount_of_documents = 1000
invertedIndexFile = "/TermIDFile.json"


class idf_generator:
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

	# sets the idf for each term in each query the query:
	def generate_idf(self, queryTokenList, termFolder):
		sys.path.insert(0, termFolder)
		filename = IndexFolder + invertedIndexFile
		with open(invertedIndexFile, "r") as invertedFile:
			useable_inverted = json.load(invertedFile)
			results = []
			for query in queryTokenList:
				tokens = {}
				for key in query:
					term_info = idf_generator()
					term_info.set_term(key)
					current_key_info = useable_inverted[key]



