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
		self.output_file = None
	# use to return the total size of everything we crawled through
	def getTotalSize(self):
		return self.total_size

	# use to get the total size of all the tokens created	
	def getTotalToken(self):
		return self.total_token

	# use to get the all the unique tokens from the stats.
	def getTokenList(self):
		return self.tokens

	# use to get the total size of all the unique token.
	def getUniqueTokens(self):
		return self.unique_token

	def getTotalIndexSize(self):
		return self.total_index_size

	# use to set the total size of index files that are created by the end function.
	def setTotalIndexSize(self, value):
		self.total_index_size = value

	# use to get the output file name form the stats object
	def getOutputFile(self):
		return self.output_file

	# use to get the ratio of the total index size to the total file size
	def getIndexToFile(self):
		return self.index_to_file

	# use to set the ratio of the total index size to the total file size
	def setIndexToFile(self):
		index = None
		file = None
		if self.total_index_size > self.total_size:
			index = self.total_index_size / self.total_size
			file = self.total_size / self.total_size
		else:
			index = self.total_index_size / self.total_index_size
			file = self.total_size / self.total_index_size
		self.index_to_file = str(index) + "/" + str(file)

	#main function for going through the files
	def getStats(self, FolderName, NumFilesToProcess):
		global counter

		parse_amount = int(NumFilesToProcess)
		global new_line
		new_line = '\n'

		output_name = "output.txt"

		file_directory = FolderName

		files = os.listdir(file_directory)
		# had to handle everything as bytes of the program wouldn't work.
		output_file = open("output.txt", "w")
		for file in files:
			print(counter)
			if counter != parse_amount:
				file_name = file_directory + "/" + file
				info = os.stat(file_name)
				self.total_size += info.st_size
				with open(file_name, "rb") as current_file:
					output_file.write(file_name)
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
							if token == rb',':
								token = None
								continue
							else:
								token = token.replace(rb",", rb" ")
								token = token.decode("utf-8")
								token = token.casefold()
								output_file.write(token)
								output_file.write(new_line)
								self.total_token = self.total_token + 1

								# lowercasing tokens to make sure we aren't double counting based on whether or not a word is capitalized.
								
								checker = token
								if self.tokens.count(checker) == 0:
									self.tokens.append(checker)
				current_file.closed
				output_file.write(new_line)

				counter = counter + 1
			
			else:
				break

		self.unique_token = len(self.tokens)
		output_file.close()

		# print(self.total_token)
		# print(self.unique_token)
		# print(self.total_size)

		self.output_file = output_name

		return self
