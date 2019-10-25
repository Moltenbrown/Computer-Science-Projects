import urllib
import re
import sys

# Global variable containing the beginning of the url every url that can be crawled requires.
limiter_string = "http://en.wikipedia.org/wiki/"

# Global variable for the maximum depth you can crawl down from one url.
depth = 5

def crawler_function():
	var1 = sys.argv[1]
	var2 = sys.argv[2]
	print var1, var2