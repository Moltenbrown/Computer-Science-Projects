import sys
from queryToken import query_token
from idf_generator import query_idf_generator
from tf_idf_generator import tf_idf

# class queryProcessor:
# 	def __init__(self):
# 		self.initialQuery = None
# 		self.tokenQuery = []
# 		self.docResults = {}

filename = sys.argv[1]
termFolder = sys.argv[2]

query = query_token()
queryList = query.generateListOfTokens(filename)

idf_generator = query_idf_generator()
idf_list = idf_generator.generate_idf_list(queryList, termFolder)

tf_idf = tf_idf()
query_tf_idf = tf_idf.generate_tf_idf(queryList, idf_list)