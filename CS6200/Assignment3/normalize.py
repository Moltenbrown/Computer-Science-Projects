import math

power = 2

# creating normalizing functions that results in normalized tf-idf
# values for both documents and queries.

# NOTE: I use the word block often: this for me represents an indexed value 
# in a list.

# a function to normalize the tf-idf values for the query
def normalize_query(query_tf_idf_list):
	global power
	for block in query_tf_idf_list:
		total_tf_idf = 0
		for word in block:
			tf_idf = block[word]
			tf_idf = tf_idf.get_tf_idf()

			#squaring each of the tf-idfs before adding it to the 
			tf_idf = math.pow(tf_idf, power)
			total_tf_idf += tf_idf

		# getting the square root of all the values added together
		sqrt_total = math.sqrt(total_tf_idf)
		for word in block:
			norm_tf_idf = block[word]
			current_tf_idf = norm_tf_idf.get_tf_idf()
			current_tf_idf = current_tf_idf/sqrt_total
			norm_tf_idf.set_norm_tf_idf(current_tf_idf)
			block[word] = norm_tf_idf

	return query_tf_idf_list

# a function to get the sum tf-idf values for each document that is associated with a word in a query.
def sq_tot_doc(document_tf_idf_list):
	global power
	norm_doc = []
	for block in document_tf_idf_list:
		doc_idf_dic = {}
		#getting the total amount of all the squared tf-idfs of the documents for each word in a query
		for word in block:
			doc_list = block[word]
			for doc in doc_list:
				doc_name = doc.getDocumentName()
				try:
					current_total = doc_idf_dic[doc_name]
					sq_tf_idf = math.pow(doc.getDocumentLength(), power)
					current_total += sq_tf_idf
					doc_idf_dic[doc_name] = current_total

				except KeyError:
					current_total = math.pow(doc.getDocumentLength(), power)
					doc_idf_dic[doc_name] = current_total
		norm_doc.append(doc_idf_dic)

	return norm_doc

# a function to get the square roots of all the totals from the previous function.
def sqrt_tot_doc(doc_total_dict):
	for block in doc_total_dict:
		for doc in block:
			doc_sum = block[doc]
			doc_sum = math.sqrt(doc_sum)
			block[doc] = doc_sum

	return doc_total_dict

# a function to normalize each document's tf-idf scores for the particular word in the query.
def normalize_doc(doc_total_dict, doc_tf_idf_list):
	for block in doc_tf_idf_list:
		location = doc_tf_idf_list.index(block)
		doc_sqrt_tot = doc_total_dict[location]
		for word in block:
			doc = block[word]
			for d in doc:
				name = d.getDocumentName()
				division_number = 0
				for docID in doc_sqrt_tot:
					if docID == name:
						division_number = doc_sqrt_tot[docID]
				current_total = d.getDocumentLength()
				current_total = current_total/division_number
				d.setDocumentLength(current_total)

	return doc_tf_idf_list
