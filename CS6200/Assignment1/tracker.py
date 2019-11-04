import ssl
import os
import certifi
import urllib.request
import urllib.robotparser
import requests
import os

# url for robots.txt file for wikipedia
CheckerURL = "http://en.wikipedia.org/robots.txt"

#creating a robot parser to handle the robot.txt file
robot = urllib.robotparser.RobotFileParser()
robot.set_url(CheckerURL)
current_directory = "./files/"

try:
	os.makedirs(current_directory)
except:
	os.chdir(current_directory)
else:
	os.chdir(current_directory)

counter = 1

class tracker:

	def __init__(self):
		self.maximum_size = 0
		self.minimum_size = 10000000
		self.total = 0
		self.visited_list = []
		self.max_depth = 5;
		
	
	def displayMax(self):
		print(self.maximum_size)

	def displayMin(self):
		print(self.minimum_size)

	def getMax(self):
		return self.maximum_size

	def getMin(self):
		return self.minimum_size

	def getAverage(self):
		return self.total/len(self.visited_list)

	def visitSite(self, url):
		global counter 

		# trying to get around the SSL issue that occurs when you use urlopen from urllib.request
		ssl_context = ssl.SSLContext(ssl.PROTOCOL_TLS)
		ssl_context.verify_mode = ssl.CERT_REQUIRED
		ssl_context.check_hostname = True
		ssl_context.load_default_certs()
		ssl_context.load_verify_locations(cafile=os.path.relpath(certifi.where()),
			capath=None,
			cadata=None)

		https_handler = urllib.request.HTTPSHandler(context=ssl_context)

		url_handler = urllib.request.build_opener(https_handler)

		#checking so see whether this is parseable based on topics
		#checking so see whether this is parseable based on topics
		if url is not None:
			if robot.can_fetch("*",url): 
				print("robot")
			print(url)
			try:
				start = url_handler.open(url, timeout=5) 
			except:
				pass
			else: 
				if not url in self.visited_list:
					cantral = start.info()
					current_size = cantral.get("Content-Length")
					if current_size is not None:
						number_version = int(current_size)
						self.total+=number_version
						if self.maximum_size < number_version:
							self.maximum_size = number_version
						if self.minimum_size > number_version:
							self.minimum_size = number_version
						self.visited_list.append(url)
						page = requests.get(url)
						filename = str(counter) + ".txt"
						file = open(filename, "wb")
						counter += 1
						file.write(page.content)
						file.close()
			

	def getVisited(self):
		return self.visited_list

	def getMaxDepth(self):
		return self.max_depth



	
