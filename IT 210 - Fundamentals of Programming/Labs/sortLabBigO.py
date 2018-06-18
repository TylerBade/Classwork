#!/usr/bin/env python3

# big-O demo for sorts

from random import randrange
from time import time



## Sorts a list, using Shell sort.
#  @param values the list to sort
#
def shellSort(values) :
   # Generate the sequence values.
   columns = []
   c = 1
   while c < len(values) :
      columns.append(c)
      c = 3 * c + 1

   # For each column count, sort all columns.
   s = len(columns) - 1
   while s >= 0 :
      c = columns[s]
      for k in range(c) :
         insertionSort(values, k, c)
      s = s - 1

## Sorts a column, using insertion sort.
#  @param values the list to sort
#  @param k the index of the first element in the column
#  @param c the gap between elements in the column
#
def insertionSort(values, k, c) :
   i = k + c
   while i < len(values) :
      next = values[i]
      # Move all larger elements up.
      j = i
      while j >= c and values[j - c] > next :
         values[j] = values[j - c]
         j = j - c

      # Insert the element.
      values[j] = next
      i = i + c


## Sorts a list, using selection sort.
#  @param values the list to sort
#
def selectionSort(values) :
   for i in range(len(values)) :
      minPos = minimumPosition(values, i)
      temp = values[minPos]  # swap the two elements
      values[minPos] = values[i]
      values[i] = temp

## Finds the smallest element in a tail range of the list.
#  @param values the list to sort
#  @param start the first position in values to compare
#  @return the position of the smallest element in the
#  range values[start] . . . values[len(values) - 1]
#
def minimumPosition(values, start) :
   minPos = start
   for i in range(start + 1, len(values)) :
      if values[i] < values[minPos] :
         minPos = i

   return minPos


## Sorts a portion of a list, using quicksort.
#  @param values the list to sort
#  @param start the first index of the portion to be sorted
#  @param to the last index of the portion to be sorted
#
def quickSort(values, start, to) :
   if start >= to : return
   p = partition(values, start, to)
   quickSort(values, start, p)
   quickSort(values, p + 1, to)

## Partitions a portion of a list.
#  @param values the list to partition
#  @param start the first index of the portion to be partitioned
#  @param to the last index of the portion to be partitioned
#  @return the last index of the first partition
#
def partition(values, start, to) :
   pivot = values[start]
   i = start - 1
   j = to + 1
   while i < j :
      i = i + 1
      while values[i] < pivot :
         i = i + 1
      j = j - 1
      while values[j] > pivot :
         j = j - 1
      if i < j :
         temp = values[i] # Swap the two elements
         values[i] = values[j]
         values[j] = temp
   return j


   ## Sorts a list, using merge sort.
#  @param values the list to sort
#
def mergeSort(values) :
   if len(values) <= 1 : return
   mid = len(values) // 2
   first = values[ : mid]
   second = values[mid : ]
   mergeSort(first)
   mergeSort(second)
   mergeLists(first, second, values)

## Merges two sorted lists into a third list.
#  @param first the first sorted list
#  @param second the second sorted list
#  @param values the list into which to merge first and second
#
def mergeLists(first, second, values) :
   iFirst = 0   # Next element to consider in the first list.
   iSecond = 0  # Next element to consider in the second list
   j = 0        # Next open position in values.

   # As long as neither iFirst nor iSecond is past the end, move
   # the smaller element into values
   while iFirst < len(first) and iSecond < len(second) :
      if first[iFirst] < second[iSecond] :
         values[j] = first[iFirst]
         iFirst = iFirst + 1
      else :
         values[j] = second[iSecond]
         iSecond = iSecond + 1

      j = j + 1

   # Note that only one of the two loops below copies entries.
   # Copy any remaining entries of the first list.
   while iFirst < len(first) :
      values[j] = first[iFirst]
      iFirst = iFirst + 1
      j = j + 1

   # Copy any remaining entries of the second list.
   while iSecond < len(second) :
      values[j] = second[iSecond]
      iSecond = iSecond + 1
      j = j + 1


def main():
	print("%8s %16s %16s %16s %16s" % ("size","selection","shell","merge","quick"))
	for size in [10,100,1000,10000,100000]:
		randList = [randrange(size) for i in range(size)]
		a = list(randList)
		selectionStart = time()
		selectionSort(a)
		selectionEnd = time()
		aTime = selectionEnd - selectionStart

		b = list(randList)
		shellStart = time()
		shellSort(b)
		shellEnd = time()
		bTime = shellEnd - shellStart

		c = list(randList)
		mergeStart = time()
		mergeSort(c)
		mergeEnd = time()
		cTime = mergeEnd - mergeStart

		d = list(randList)
		quickStart = time()
		quickSort(d,0,size-1)
		quickEnd = time()
		dTime = quickEnd - quickStart

		print("%8d|%16.7f %16.7f %16.7f %16.7f" % (size,aTime,bTime,cTime,dTime))

main()

# Sample output follows:
"""
    size        selection            shell            merge            quick
      10|       0.0000191        0.0000250        0.0000319        0.0000210
     100|       0.0006280        0.0002601        0.0004101        0.0002329
    1000|       0.0590339        0.0049040        0.0055170        0.0033669
   10000|       5.6660919        0.0849969        0.0686259        0.0406280
  100000|     572.7824669        1.2521031        0.8487308        0.5168550
"""