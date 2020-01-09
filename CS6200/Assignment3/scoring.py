import math

# function to multiply the normalized scores for each word in the query, by all
# the scores fo the documents associated with that word
def multi_for_scoring(norm_query_list, norm_doc_list):
	for block in norm_doc_list:
		location = norm_doc_list.index(block)
		current_query = norm_query_list[location]
		for word in block:
			current_word_results = current_query[word]
			mul_factor = current_word_results.get_tf_idf()
			doc_results = block[word]
			for doc in doc_results:
				doc_value = doc.getDocumentLength()
				doc_value *= mul_factor
				doc.setDocumentLength(doc_value)

	return norm_doc_list

# function to add all the scores associated with a document given a specific query
def add_for_scoring(norm_doc_list_update):
	results = []
	for block in norm_doc_list_update:
		end_result = {}
		for word in block:
			doc_results = block[word]
			for doc in doc_results:
				try:
					current_add = end_result[doc.getDocumentName()]
					addor_value = doc.getDocumentLength()
					current_add += addor_value
					name = doc.getDocumentName()
					end_result[doc.getDocumentName()] = current_add

				except KeyError:
					name = doc.getDocumentName()
					value = doc.getDocumentLength()
					end_result[name] = value
		results.append(end_result)

	for block in results:
		index = results.index(block)
		results[index] = sorted(block.items(), key=lambda x: x[1], reverse=True)

	return results

# function that returns only the k scores of the documents in descending order
def get_top_k(final_score_list, k):
	print("getting top k:" + str(k))
	results = []
	limit = k
	for block in final_score_list:
		top_docs = []
		for value in range(0, limit):
			top_docs.append(block[value])
			
		results.append(top_docs)
		

	return results





