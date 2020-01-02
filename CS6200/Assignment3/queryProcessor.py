import sys
from queryToken import query_token
from idf_generator import idf_generator

# class queryProcessor:
# 	def __init__(self):
# 		self.initialQuery = None
# 		self.tokenQuery = []
# 		self.docResults = {}

filename = sys.argv[1]
termFolder = sys.argv[2]

query = query_token()
queryList = query.generateListOfTokens(filename)

idf_generator = idf_generator()
idf_generator.generate_idf_list(queryList, termFolder)