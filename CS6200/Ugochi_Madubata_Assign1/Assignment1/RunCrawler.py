#!/usr/bin/env python3

from tracker import tracker
from depth_checker import depth_checker
import sys
import io

# path for the crawled file
crawled_path = './URLsCrawled.txt'

# path for the stats file
stats_path = "./stats.txt"

info_gatherer = tracker()
depth = 5


# the function will take command line arguments for the seedURL and the num of webpages.
SeedURL = sys.argv[1]
Numpages = sys.argv[2]

depth_checker(depth, SeedURL, info_gatherer, Numpages)

crawled = open(crawled_path, 'w')

for val in info_gatherer.visited_list:
	crawled.write(val + '\n')

crawled.close()

stats = open(stats_path, 'w')
stats.write('Maximum size: ' + str(info_gatherer.getMax()) + ' bytes\n')
stats.write('Minimum size: ' + str(info_gatherer.getMin()) + ' bytes\n')
stats.write('Average size: ' + str(info_gatherer.getAverage()) + ' bytes\n')
stats.write('Maximum depth reach: ' + str(depth - info_gatherer.getMaxDepth()))

stats.close()
