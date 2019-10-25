from tracker import tracker
import requests
import re
import time


# url to attach references to.
BaseURL = "http://en.wikipedia.org"
SecureURL = "https://en.wikipedia.org"
#count = 0

#trying to create a function that takes the tracker class as an object to make sure 
#depth is never breached.
def depth_checker(depth, url, tracker, pages):	
	if len(tracker.getVisited()) < int(pages):
		if depth > 0:
			if url.find(BaseURL) < 0 and url.find(SecureURL):
				print(url)
				url = BaseURL + url
			tracker.visitSite(url)
			time.sleep(2)
			depth -= 1
			if depth < tracker.max_depth:
				tracker.max_depth = depth
			holder = requests.get(url)
			next_level = re.findall(rb"(\/wiki\/(?!Main_Page|\w+\:)[^>\s\"]+)", holder.content)

			# converting the urls in the wikipedia page into an array of visitable links
			string_list = []

			for val in next_level:
				string_list.append(val.decode('utf-8'))


			new_string_list = []
			for val in string_list:
				if val not in url:
					new_string_list.append(val)

			for sm in new_string_list:
				if sm not in tracker.visited_list:
					new_url = BaseURL + sm
					depth_checker(depth, new_url, tracker, pages)
					#print(count)

