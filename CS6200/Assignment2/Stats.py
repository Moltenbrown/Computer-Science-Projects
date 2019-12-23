import os
import re

counter = 0

# class to keep track of the stats of the files we are going through.
class stats:

	def __init__(self):
		self.total_size = 0
		self.total_token = 0
		self.unique_token = 0
		self.total_index_size = 0
		self.index_to_file = 0
		self.tokens = []
	# use to return the total size of everything we crawled through
	def getTotalSize(self):
		return self.total_size

	# use to get the total size of all the tokens created	
	def getTotalToken(self):
		return self.total_token

	# use to get the all the unique tokens from the stats.
	def getTokenList(self):
		return self.tokens

	#use to get the total size of all the unique token.
	def getUniqueTokens(self):
		return self.unique_token

	#main function for going through the files
	def getStats(self, FolderName, NumFilesToProcess):
		global counter

		parse_amount = int(NumFilesToProcess)
		new_line = '\n'
		new_line = str.encode(new_line)
		new_line = bytes(new_line)

		#where the final set of all the tokens generated will go
		output_file = open("output.txt", "wb")


		file_directory = FolderName

		files = os.listdir(file_directory)
		output_file = open("output.txt", "wb")
		for file in files:
			print(counter)
			if counter != parse_amount:
				file_name = file_directory + "/" + file
				info = os.stat(file_name)
				self.total_size += info.st_size
				with open(file_name, "rb") as current_file:
					output_file.write(bytes(file_name, encoding='utf8'))
					output_file.write(new_line)
					output_file.write(new_line)
					file_data = current_file.read()
					file_data = re.sub(rb'(<title>)[^<]+(</title>)', rb' ', file_data)
					file_data = re.sub(rb'(<script)[^<]+(</script>)', rb' ', file_data)
					file_data = re.sub(rb'(<style)[^<]+(</style>)', rb' ', file_data)
					file_data = re.sub(rb'(<li>)[^<]+(</li>)', rb' ', file_data)
					file_data = re.sub(rb'(<a class)[^<]+(</a>)', rb' ', file_data)
					file_data = re.sub(rb'<[^>]+>', rb' ', file_data)
					file_data = re.sub(rb'\w+(?=\.com)', rb' ', file_data)
					tokens = re.findall(rb'(?<= |>|")[\w\,]+', file_data)
					for token in tokens:
						if token is not None:
							if token is rb',':
								token = None
								continue
							else:  
								token = token.replace(rb",", rb" ")
								output_file.write(bytes(str(token), encoding='utf8'))
								output_file.write(new_line)
								self.total_token = self.total_token + 1
								if self.tokens.count(token) == 0:
									self.tokens.append(token)
				current_file.closed
				output_file.write(new_line)

				counter = counter + 1
			
			else:
				break

		self.unique_token = len(self.tokens)
		output_file.close()
