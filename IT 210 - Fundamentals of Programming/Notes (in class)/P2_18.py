# P2.18

# Get the inputs
cStr = input("Enter the length of the chord: ")
c = float(cStr)
dStr = input("Enter the length of the diameter: ")
d = float(dStr)

# Find h and area
r = d/2
h = r - (r*r - (c/2)**2)**.5
area = 2*c*h/3 + h**3/(2*c)

# print the area
areaRounded = round(area,2)
print(areaRounded)
print("The area of the slice is %.2f" % (area))

