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
		file_data = re.sub(rb'(<title>)[^<]+(</title>)', rb' ', file_data)
		file_data = re.sub(rb'(<script)[^<]+(</script>)', rb' ', file_data)
		file_data = re.sub(rb'(<style)[^<]+(</style>)', rb' ', file_data)
		file_data = re.sub(rb'(<li>)[^<]+(</li>)', rb' ', file_data)
		file_data = re.sub(rb'(<a)[^<]+(</a>)', rb' ', file_data)
		file_data = re.sub(rb'<[^>]+>', rb' ', file_data)
		file_date = re.sub(rb'\w+(?=\.com)', rb' ', file_data)
		tokens = re.findall(rb'(?<= |>|")[\w\,]+', file_data)
		for token in tokens:
			if token is not None:
				token = token.replace(rb",", rb" ")
				if token is rb',':
					token = None
					continue 
				output_file.write(bytes(str(token), encoding='utf8'))
				output_file.write(new_line)
	current_file.closed
	output_file.write(new_line)

output_file.close()

