#!/bin/bash


cat /proc/cpuinfo | grep cores | awk '{print $2 $3" "$4}'
free -m | grep Mem |awk '{print "memory: " $4 "/" $2}'
df -h --total | grep total | awk '{print "storage: " $4 "/" $2}'


