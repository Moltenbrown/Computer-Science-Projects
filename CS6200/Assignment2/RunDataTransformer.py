import sys
from Stats import stats


counter = 0

def RunDataTransformer(file_directory, amount_to_parse):
	stats_output = stats()
	outputfile = stats_output.getStats(file_directory, amount_to_parse)

	return outputfile

