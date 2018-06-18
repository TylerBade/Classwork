#!/usr/bin/env python3

# big-O demo for searches

from random import randrange
from time import time


##
#  This module implements a function for executing binary searches in a list.
#

## Finds a value in a range of a sorted list, using the binary search algorithm.
#  @param values the list in which to search
#  @param low the low index of the range
#  @param high the high index of the range
#  @param target the value to find
#  @return the index at which the target occurs, or -1 if it does not occur in the list
#
def binarySearch(values, low, high, target) :
   if low <= high :
      mid = (low + high) // 2

      if values[mid] == target :
         return mid
      elif values[mid] < target :
         return binarySearch(values, mid + 1, high, target)
      else :
         return binarySearch(values, low, mid - 1, target)

   else :
      return -1



def main():
	print("%8s %16s %16s %16s %16s" % ("size","mySequential","using 'in'","dictionary","binary"))
	for size in [100,1000,10000,100000,1000000]:
		searchList = list(range(0,size*3,3))
		searchDict = {} # will contain original index as value for each integer in list
		for n,v in enumerate(searchList):
		    searchDict[v] = n

        # These are the 5 values that will be searched for
		targets = [0,-1,1,searchList[-1],searchList[size//2]]

		mySeqStart = time()
		for i in targets:
		    for j in searchList:
		        if i == j: break # do the work but throw away the result
		mySeqEnd = time()
		aTime = mySeqEnd - mySeqStart


		usingInStart = time()
		for i in targets:
		    x = (i in searchList) # do the work but throw away the result
		usingInEnd = time()
		bTime = usingInEnd - usingInStart

		dictionaryStart = time()
		for i in targets:
		    x = (i in searchDict) # do the work but throw away the result
		dictionaryEnd = time()
		cTime = dictionaryEnd - dictionaryStart


		binaryStart = time()
		for i in targets:
		    x = binarySearch(searchList, 0, size -1, i) # do the work but throw away the result
		binaryEnd = time()
		dTime = binaryEnd - binaryStart

		print("%8d|%16.7f %16.7f %16.7f %16.7f" % (size,aTime,bTime,cTime,dTime))

main()

