import os
import re
import sys

file_directory = sys.argv[1]
amount_to_parse = sys.argv[2]
new_line = '\n'
new_line = str.encode(new_line)
new_line = bytes(new_line)

files = os.listdir(file_directory)
output_file = open("output.txt", "wb")
for file in files:
	print(file)
	file_name = file_directory + "/" + file
	with open(file_name, "rb") as current_file:
		file_data = current_file.read()
		tokens = re.findall(rb"(\w+(?!\.|\_\:)[^>\s\"]+)", file_data)
		for token in tokens:
			output_file.write(token)
			output_file.write(new_line)
	current_file.closed
	output_file.write(new_line)

output_file.close()

