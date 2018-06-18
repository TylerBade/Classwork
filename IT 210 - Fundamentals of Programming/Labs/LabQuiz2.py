# Tyler Bade
# Lab Quiz 4

from string import ascii_letters, ascii_lowercase, ascii_uppercase
from string import digits, hexdigits, punctuation

def main():
    st = input("Please enter a string: ")
    while st != "":
        print("The string length is: ", len(st))
        print(punct(st))
        print(upp(st))
        print("Total Hexdigits: ", hexdig(st))
        print("")
        st = input("Please enter a string: ")
    print("Done")

def punct(string):
    st = ""
    for char in string:
        if char not in punctuation:
            st = st + char
    return st

def upp(string):
    st = ""
    for char in string:
        if char in ascii_uppercase:
            st = st + char
    return st

def hexdig(string):
    count = 0
    for char in string:
        if char in hexdigits:
            count = count + 1
    return count

main()
