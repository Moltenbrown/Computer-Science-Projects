import os
import re
import sys

file_directory = sys.argv[1]
amount_to_parse = sys.argv[2]
new_line = '\n'
new_line = str.encode(new_line)
new_line = bytes(new_line)

output_file = open("output.txt", "wb")

files = os.listdir(file_directory)
output_file = open("output.txt", "wb")
for file in files:
	print(file)
	file_name = file_directory + "/" + file
	output_file.write(bytes(file_name, encoding='utf8'))
	output_file.write(new_line)
	output_file.write(new_line)
	with open(file_name, "rb") as current_file:
		output_file.write(bytes(file_name, encoding='utf8'))
		output_file.write(bytes('\n', encoding='utf8'))
		file_data = current_file.read()
		file_data = re.sub(rb'[.*]', rb'', file_data)
		file_data = re.sub(rb'(<title>)[\S\s]+(<\/title>)', rb'', file_data)
		file_data = re.sub(rb'(<script type=).*(?!\s)(<\/script>)', rb'', file_data)
		file_data = re.sub(rb'(<a href).*(Category:)', rb'', file_data)
		file_data = re.sub(rb'<--.*-->', rb'', file_data)
		file_data = re.sub(rb'(<script>)\S+(\}\);\}\);\}\);<\/script>)', rb'', file_data)
		file_data = re.sub(rb'(<meta).*\"\/>', rb'', file_data)
		file_data = re.sub(rb'(<html).*\">', rb'', file_data)
		file_data = re.sub(rb'(<script>document\.documentElement\.className\=)[\S\s]*(\];<\/script>)', rb'', file_data)
		# file_date = re.sub(rb'(<script>document\.documentElement\.className\=\"client-js\";RLCONF\=\{).+\}', rb'', file_data)
		# stop_words = ['\sa\s', '\sA\s', '\sis\s', '\sif\s', '\sthe\s', '\sand\s', '\sof\s', '\sfrom\s', '\swith\s', '\sto\s', '\sor\s', '\sall\s', '\sThe\s', '\sand\s', '\sof\s', '\sFrom\s', '\sWith\s', '\sTo\s', '\sOr\s', '\sAll\s', '\sIs\s', '\sIf\s',]
		# for word in stop_words:
		# 	file_data = re.sub(bytes(word, encoding='utf8'), rb' ', file_data)
		tokens = re.findall(rb'\w+', file_data)
		for token in tokens:
			for comma in token:
				if comma is ',':
					comma = ' '
			for period in token:
				if period is '.':
					if isinstance(token[token.index(period)-1], 'num'):
						period = ' '
					else:
						period = ''
			if token is not None:
				output_file.write(bytes(str(token), encoding='utf8'))
				output_file.write(new_line)
	current_file.closed
	output_file.write(new_line)

output_file.close()

