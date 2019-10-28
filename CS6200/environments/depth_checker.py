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
		next_level = re.findall(r"\/wiki\/)(?!Main_Page)\w+", holder)
		for level in next_level:
			if level not in tracker.visited
			depth_checker(depth, url, tracker)
