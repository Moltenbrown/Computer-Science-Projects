import ssl
import os
import certifi
import depth_checker
import urllib.request
import urllib.robotparser


class tracker:
	def __init__(self):
		self.maximum_size = 0
		self.minimum_size = 10000000
		self.total = 0
		self.visited = 0
		self.visited_list = []
		

	def displayMax(self):
		print(tracker.maximum_size)

	def displayMin(self):
		print(tracker.minimum_size)

	def getMax(self):
		return tracker.maximum_size

	def getMin(self):
		return tracker.minimum_size

	def getAverage(self):
		return tracker.total/tracker.visited

	def visitSite(self, url):
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

		robot = urllib.robotparser.RobotFileParser()
		checkerUrl = BaseURL + "robots.txt"
		robot.set_url(checkerUrl)
		#checking so see whether this is parseable based on topics
		if url is not None:
			if rp.can_fetch("*",url):
				with url_handler.open(url, timeout=2) as start:
					cantral = start.info()
					current_size = cantral.get("Content-Length")
					if current_size is not None:
						number_version = int(current_size)
						self.total+=number_version
						if self.maximum_size < number_version:
							self.maximum_size = number_version
						if self.minimum_size > number_version:
							self.minimum_size = number_version
						self.visited += 1
						self.visited_list.append(url)

	def getVisited(self):
		return self.visited_list




