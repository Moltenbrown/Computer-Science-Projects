import tracker
import ssl
import urllib.robotparser
import sys
import certifi
import os
import requests

#trying to create a function that takes the tracker class as an object to make sure 
#depth is never breached.
def depth_checker(depth, url, tracker):
	if depth > 0:
		tracker.visitSite(irl)
		depth--;
		holder = urllib.request.urlopen(url).read()
		holder = holder.decode('ISO-8859-1')
		print(holder)
<<<<<<< HEAD
		next_level = re.findall(r"\/wiki\/)(?!Main_Page)\w+", holder)
=======
		next_level = re.findall(r"^(?:http(s)?:\/\/en\.wikipedia\.org\/wiki)(?!Main_Page)\w+", holder)
>>>>>>> aabff0f5d8afd22d53d7a079f3062426614b9fec
		for level in next_level:
			if level not in tracker.visited
			depth_checker(depth, url, tracker)
