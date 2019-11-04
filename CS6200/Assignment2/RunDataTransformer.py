
import sys
from Stats import stats


counter = 0

file_directory = sys.argv[1]
amount_to_parse = sys.argv[2]

stats_output = stats()
stats_output.getStats(file_directory, amount_to_parse)


