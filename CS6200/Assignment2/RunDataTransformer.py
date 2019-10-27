import os
import re
import sys

file_directory = sys.argv[1]
amount_to_parse = sys.argv[2]

files = os.listdir(file_directory)
for file in files:
	print(file)
	file_name = file_directory + "/" + file
	with open(file_name, "rb") as current_file:
		file_data = current_file.read()
		tokens = re.findall(rb"(([a-z]|[A-Z])*(?!\.|\w+\:)[^>\s\"]+)", file_data)
		print(tokens)
	current_file.closed

