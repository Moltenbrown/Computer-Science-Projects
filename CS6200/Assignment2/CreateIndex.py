from DocumentID import documentID
from InvertedIndex import invertedIndex
from TermID import termID
from RunDataTransformer import RunDataTransformer
import sys
import os

stat_name = "./stats.txt"
termIDOutput = "./TermIDFile.json"
documentIDOutput = "./DocumentIDFile.json"
new_line = "\n"

file_directory = sys.argv[1]
amount_to_parse = sys.argv[2]

output = RunDataTransformer(file_directory, amount_to_parse)
output_name = output.getOutputFile()

invertedIndex = invertedIndex()
invertedOutput = invertedIndex.generateFile(output_name)

files = [termIDOutput, documentIDOutput, invertedOutput]

total = 0

for file in files:
	filestats = os.stat(file)
	total += filestats.st_size

output.setTotalIndexSize(total)
output.setIndexToFile()

with open(stat_name, "w") as final_output:
	final_output.write("The total file size of all of the inputs files is: " + str(output.getTotalSize()))
	final_output.write(new_line)
	final_output.write("The total number of tokens across all input files is: " + str(output.getTotalToken()))
	final_output.write(new_line)
	final_output.write("The total number of unique tokens across all input files is: " + str(output.getUniqueTokens()))
	final_output.write(new_line)
	final_output.write("The total size of all index files is: " + str(output.getTotalIndexSize()))
	final_output.write(new_line)
	final_output.write("The ratio of the total index size to the total file size is: " + output.getIndexToFile())