#!/usr/bin/env python3

from tracker import tracker
from depth_checker import depth_checker
import sys

info_gatherer = tracker()


# the function will take command line arguments for the seedURL and the num of webpages.
SeedURL = sys.argv[1]
Numpages = sys.argv[2]

depth_checker(5, SeedURL, info_gatherer, Numpages)

print(info_gatherer.getVisited())