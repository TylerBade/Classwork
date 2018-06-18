# Tyler Bade
# February 4
# Lab quiz 1

# String prompt
userInput = input("Please enter a string: ")
userStr = str(userInput)

# Empty string case
if userStr == "":
    print("Empty string")

# Second character
elif len(userStr) % 2 == 0:
    second = userStr[1]
    print("The second character is ", second)
    if userStr.endswith(userStr[0]):
        print("Bookends")

# Middle character
else:
    mid = len(userStr) // 2
    if userStr[mid].isdigit():
        print("The middle character is a digit")

# End
print("Done")
