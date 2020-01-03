import math
from queryToken import query_token
from idf_generator import query_idf_generator

class tf_idf:
	def __init__(self):
		self.tf_idf = 0

	# returns the tf_idf from the tf_idf
	def get_tf_idf(self):
		return self.tf_idf

	# sets the tf-idf from the two values entered
	def set_tf_idf(self, tf, idf):
		self.tf_idf = tf * idf

	# generates the tf-idfs for all the tokens in the query or related documents 
	def generate_tf_idf(self, tokenlist, idf_list):
		results = []
		for query in tokenlist:
			tf_idfs = {}
			index = tokenlist.index(query);
			for word in query:
				token = tf_idf()
				tf = query[word]
				idf = idf_list[index]
				word = word.replace("\n", "")
				idf = idf[word]
				tf = tf.getWeightedFrequency()
				idf = idf.get_idf()
				token.set_tf_idf(tf, idf)
				tf_idfs[word] = token
			results.append(tf_idfs)

		return results


