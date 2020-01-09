import sys
from queryToken import query_token
from idf_generator import query_idf_generator
from query_tf_idf_generator import query_tf_idf
from document_tf_idf import *
from normalize import *
from scoring import *
from doc_stats import *
from stats import stats

indexFilename = sys.argv[1]
contentFilename = sys.argv[2]
queryFilename = sys.argv[3]
k = int(sys.argv[4])

starter_stats = []
query = query_token()
queryList = query.generateListOfTokens(queryFilename, starter_stats)

stat = stats()
idf_generator = query_idf_generator()
query_idf_list = idf_generator.generate_idf_list(queryList, indexFilename)
updated_stats = stat.setQueryTokens(starter_stats, query_idf_list)

tf_idf = query_tf_idf()
query_tf_idf = tf_idf.generate_tf_idf(queryList, query_idf_list)
normalize_query = normalize_query(query_tf_idf)

endresult = create_doc_tf_idf(indexFilename, queryFilename)
subresult = sq_tot_doc(endresult)
docresult = sqrt_tot_doc(subresult)
result = normalize_doc(docresult, endresult)

result = multi_for_scoring(normalize_query, result)
result_final = add_for_scoring(result)
top_k = get_top_k(result_final, k)

stat_list = doc_stats()
stats = stat_list.generate_doc_stat_list(top_k)
stat2 = stat_list.fill_contribution(stats, result)
stat3 = stat_list.fill_snippet(stat2, contentFilename)

final_stats = stat.setDocStats(updated_stats, stat3)
stat.createOutputFile(final_stats)
