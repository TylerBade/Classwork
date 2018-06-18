from array import *
newList = array('i', [1,2,3,4,6,7,8,10,17,20,22,11,14]);

i = 0;
found = False;
while i < len(newList) and found != True:
    if newList[i] == 12:
        print(i);
        found = True;
    else:
        if i >= len(newList)-1:
            print("Not Found");
    i = i + 1

nextList = array('i', [1,2,3,4,6,7,8,10,11,12,17,20,22]);
lowBound = 0;
upBound = len(nextList);
while upBound > lowBound:
    midPt = (lowBound + upBound) /2;
    midVal = nextList[midPt]
    if midVal < 12:
        lowBound = midPt + 1;
    elif midVal > 12:
        upBound = midPt - 1;
    else:
        exit("Found at position " + midPt);
