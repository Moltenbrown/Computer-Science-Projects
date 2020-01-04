import sys
from queryToken import query_token
from idf_generator import query_idf_generator
from tf_idf_generator import tf_idf
from document_tf import *

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

endresult = create_doc_tf_idf(termFolder, filename)
for line in endresult:
	for word in line:
		res = line[word]
		for r in res:
			print(r.getDocumentLength())
			print(r.getDocumentName())

# current error message

# C:\Users\madub\Documents\Computer-Science-Projects\CS6200\Assignment3>python queryProcessor.py Queries.txt ../Assignment2
# Traceback (most recent call last):
#   File "queryProcessor.py", line 25, in <module>
#     endresult = create_doc_tf_idf(termFolder, filename)
#   File "C:\Users\madub\Documents\Computer-Science-Projects\CS6200\Assignment3\document_tf.py", line 48, in create_doc_tf_idf
#     initial_doc_results = create_weighted_doc_tf_idf(initial_doc_results)
#   File "C:\Users\madub\Documents\Computer-Science-Projects\CS6200\Assignment3\document_tf.py", line 29, in create_weighted_doc_tf_idf
#     new_length = 1 + math.log10(res.getDocumentLength())
# AttributeError: 'str' object has no attribute 'getDocumentLength'