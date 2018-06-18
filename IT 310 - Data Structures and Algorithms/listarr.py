import array;
import random;

listA = [0,2,5,4,7,8,9,1];
listB = [11,13,17,20,10,15];
listA.append(6);
print(listA);
listA.extend(listB);
print(listA);
listA.insert(2,3);
print(listA);
listA.remove(20);
print(listA);
print(listA.pop(10));
print(listA.index(2));
print(listA.count(1));
listA.sort();
print(listA);
listA.reverse();
print(listA);

valueArr1 = array.array( 'I', [5,4,6,7,8,3,9,0]);
valueArr2 = array.array('i', [10,11,15,17,12]);
for value in valueArr:
    print(value);

valueArr1.insert(0,1);
print(valueArr1);
valueArr1.append(2);
print(valueArr1);
valueArr1.extend(valueArr2);
print(valueArr1);
