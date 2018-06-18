# Bubble sort code
def bubbleSort(alist):
    for passnum in range(len(alist)-1,0,-1):
        for i in range(passnum):
            if alist[i]>alist[i+1]:
                temp = alist[i]
                alist[i] = alist[i+1]
                alist[i+1] = temp

##alist = [54,26,93,17,77,31,44,55,20]
##bubbleSort(alist)
##print(alist)

# Selection sort code
def selectionSort(alist):
   for fillslot in range(len(alist)-1,0,-1):
       positionOfMax=0
       for location in range(1,fillslot+1):
           if alist[location]>alist[positionOfMax]:
               positionOfMax = location

       temp = alist[fillslot]
       alist[fillslot] = alist[positionOfMax]
       alist[positionOfMax] = temp

##alist = [54,26,93,17,77,31,44,55,20]
##selectionSort(alist)
##print(alist)

#Insertion code sort
def insertionSort(alist):
   for index in range(1,len(alist)):

     currentvalue = alist[index]
     position = index

     while position>0 and alist[position-1]>currentvalue:
         alist[position]=alist[position-1]
         position = position-1

     alist[position]=currentvalue

##alist = [54,26,93,17,77,31,44,55,20]
##insertionSort(alist)
##print(alist)

#Merge sort code
def mergeSort(alist):
    #print("Splitting ",alist)
    #Continues to split the list until there is only one item
    if len(alist)>1:
        mid = len(alist)//2
        lefthalf = alist[:mid]
        righthalf = alist[mid:]

        mergeSort(lefthalf)
        mergeSort(righthalf)

        i=0
        j=0
        k=0
        while i < len(lefthalf) and j < len(righthalf):
            if lefthalf[i] < righthalf[j]:
                alist[k]=lefthalf[i]
                i=i+1
            else:
                alist[k]=righthalf[j]
                j=j+1
            k=k+1

        while i < len(lefthalf):
            alist[k]=lefthalf[i]
            i=i+1
            k=k+1

        while j < len(righthalf):
            alist[k]=righthalf[j]
            j=j+1
            k=k+1
    #print("Merging ",alist)

##alist = [54,26,93,17,77,31,44,55,20]
##mergeSort(alist)
##print(alist)

#Quicksort code
#Begins quicksort
def quickSort(alist):
   quickSortHelper(alist,0,len(alist)-1)

#quicksort Helper code, from the return value of the partition method, it will continue to
   #sort the list until the first value is less than the last value
def quickSortHelper(alist,first,last):
   if first<last:

        #First partition is the full list, Returned rightmark is the splitpoint
       splitpoint = partition(alist,first,last)

        #next Partitions will be the list either up to or after the split point
       quickSortHelper(alist,first,splitpoint-1)
       quickSortHelper(alist,splitpoint+1,last)


def partition(alist,first,last):
   pivotvalue = alist[first]

   leftmark = first+1
   rightmark = last

   done = False
   while not done:

        #Both while loops will be done while the left and right marks havent crossed
        #Or until it finds a value which is supposed to be on the other side of the pivot value
       while leftmark <= rightmark and alist[leftmark] <= pivotvalue:
           leftmark = leftmark + 1

       while alist[rightmark] >= pivotvalue and rightmark >= leftmark:
           rightmark = rightmark -1

        #If both while loops are broken, checks if marks have crossed
       if rightmark < leftmark:
           done = True
       else: #Otherwise, it switches values at left and right marks
           temp = alist[leftmark]
           alist[leftmark] = alist[rightmark]
           alist[rightmark] = temp
           
    #when whole loop is done, switch pivot value with right mark to finish this increment
   temp = alist[first]
   alist[first] = alist[rightmark]
   alist[rightmark] = temp


   return rightmark

##alist = [54,26,93,17,77,31,44,55,20]
##quickSort(alist)
##print(alist)

inputList = list()
numItems = int(input("How many items in your list: "))
listtype = input("Numbers or srings? ")
while numItems > 0:
    if listtype.lower() == "int":
        listItem = int(input("Enter a value to put into the list: "))
        inputList.append(listItem)
        numItems -= 1
    if listtype.lower() == "string":
        listItem = input("Enter a value to put into the list: ")
        inputList.append(listItem)
        numItems -= 1

#inputList = [10,9,8,7,6,5,4,3,2,1]
print(inputList)
print("Avalable sort methods: Bubble, Selection, Insertion, Merge and Quick sorts.")
sortmethod = input("How do you want to sort this list? (one of the 5 above): ")
valid = False
while valid == False:
    if sortmethod == 'Bubble':
        bubbleSort(inputList)
        valid = True
    if sortmethod == 'Selection':
        selectionSort(inputList)
        valid = True
    if sortmethod == 'Insertion':
        insertionSort(inputList)
        valid = True
    if sortmethod == 'Merge':
        mergeSort(inputList)
        valid = True
    if sortmethod == 'Quick':
        quickSort(inputList)
        valid = True
    else:
        sortmethod = input("Not a valid method, try again: ")

print(inputList)
