#!/bin/bash

# script to run the crawler program with user input

# setting the directory to be the current directory the shell is in.

PWD=$PWD

echo "Please enter the seed url for the crawler: "
read seedUrl

echo "Please enter how many unique results you want: "
read num

PWD+= "\crawler.py"

python PWD "$seedUrl" "$num"