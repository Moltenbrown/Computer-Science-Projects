from tracker import tracker
import requests
import re


# url to attach references to.
BaseURL = "http://en.wikipedia.org"

#trying to create a function that takes the tracker class as an object to make sure 
#depth is never breached.
def depth_checker(depth, url, tracker, pages):
	if len(tracker.visited_list) < int(pages):
		if depth > 0:
			tracker.visitSite(url)
			depth -= 1
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


