# Tyler Bade

from string import ascii_letters, ascii_lowercase, ascii_uppercase
from string import digits, hexdigits, punctuation

instr = input("Please enter a string: ")
digs = set()
hexdigs = set()
lowlet = set()
anylet = set()

for char in instr:
    if char in digits:
        digs.add(char)
    if char in hexdigits:
        hexdigs.add(char)
    if char in ascii_lowercase:
        lowlet.add(char)
    if char in ascii_letters:
        anylet.add(char)

anystr = ""
for item in sorted(anylet):
    anystr += item
intstr = ""
for item in sorted(lowlet.intersection(hexdigs)):
    intstr += item
difstr = ""
for item in sorted(hexdigs.difference(digs)):
    difstr += item
print("\nThe set of Any Letters:")
print(anystr)
print("\nIntersection:")
print(intstr)
print("\nDifference:")
print(difstr)
