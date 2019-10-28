import os
import re
import sys

file_directory = sys.argv[1]
amount_to_parse = sys.argv[2]

output_file = open("output.txt", "wb")

files = os.listdir(file_directory)
for file in files:
	print(file)
	file_name = file_directory + "/" + file
	with open(file_name, "rb") as current_file:
		output_file.write(bytes(file_name, encoding='utf8'))
		output_file.write(bytes('\n', encoding='utf8'))
		file_data = current_file.read()
		tokens = re.findall(rb"(?<!^<)([a-z]|[A-Z])+(?![0-9])", file_data)
		for token in tokens:
			output_file.write(bytes(''.join(str(letter) for letter in token), encoding='utf8'))
			output_file.write(bytes('\n', encoding='utf8'))
	current_file.closed
	output_file.write(bytes('\n', encoding='utf8'))

output_file.close()


