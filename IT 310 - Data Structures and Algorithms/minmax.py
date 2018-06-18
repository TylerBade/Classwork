numlist = [1,3,5,7,9];
print(numlist);
minimum = 10000000;
maximum = 0;

for num in numlist:
    if num > maximum:
        maximum = num;
    if num < minimum:
        minimum = num;

print(minimum);
print(maximum);
