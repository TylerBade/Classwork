# Tyler Bade

from string import ascii_uppercase

userin1 = input("Enter a string: ")
userin2 = input("Enter another string: ")

newuser1 = ""
for char in userin1:
    if char.isalpha():
        newuser1 += char
        
userstr1 = newuser1.upper()
userset1 = set(userstr1)
if " " in userin1:
    userset1.add("<space>")

newuser2 = ""
for char in userin2:
    if char.isalpha():
        newuser2 += char

userstr2 = newuser2.upper()
userset2 = set(userstr2)
if " " in userin2:
    userset2.add("<space>")

newset = set()
for char in ascii_uppercase:
    if char not in userset1 and char not in userset2:
        newset.add(char)

alpha1 = userset1.intersection(userset2)
alpha2 = userset1.symmetric_difference(userset2)
alpha3 = newset

print("Characters in both strings:", sorted(alpha1))
print("Characters in one string, but not the other:", \
      sorted(alpha2))
print("Characters not in either string:", sorted(alpha3))
