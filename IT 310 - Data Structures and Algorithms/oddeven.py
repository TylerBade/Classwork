evenList = [];
oddList = [];

def oddeven(list):
    if len(list) <= 0:
        print(evenList + oddList);
        return;
    else:
        if list[0] % 2 == 0:
            evenList.append(list[0]);
            return oddeven(list[1:]);
        else:
            oddList.append(list[0]);
            return oddeven(list[1:]);

NewList = [5,9,7,8,4,6,1,2]
oddeven(NewList);
