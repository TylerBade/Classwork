# Tyler Bade
# HW 3_17

from sys import exit

# Begin with Input
userInput = input("Please enter a string: ")
userString = str(userInput)

# Contains only letters
if userString.isalpha():
    
    # Starts with an uppercase letter
    if userString[0].isalpha() and userString[0].isupper():
        print("The string starts with an uppercase letter.")
    else:
        print("The string does not begin with an uppercase letter.")

    # Ends with a period
    if userString.endswith("."):
        print("The string ends with a period.")
    else:
        print("The string does not end with a period.")

    # Contains only uppercase letters
    if userString.isupper():
        exit(print("The string only uses uppercase letters."))
        
    # Contains only lowercase letter
    elif userString.islower():
        exit(print("The string uses only lowercase letters."))

    else:
        exit(print("The string uses upper and lowercase letters."))
        
# Contains only digits
elif userString.isdigit():
    exit(print("The string only contains numbers"))

# Contains only letters and digits
elif userString.isalnum():
    exit(print("The string contains both letters and numbers"))
    
    # Starts with an uppercase letter
    if userString[0].isalpha() and userString[0].isupper():
        print("The string starts with an uppercase letter.")
    else:
        print("The string does not begin with an uppercase letter.")

    # Ends with a period
    if userString.endswith("."):
        print("The string ends with a period.")
    else:
        print("The string does not end with a period")
        


else:
    print("The string contains more than letters and numbers")
    
    # Starts with an uppercase letter
    if userString[0].isalpha() and userString[0].isupper():
        print("The string starts with an uppercase letter.")
    else:
        print("The string does not begin with an uppercase letter.")

    # Ends with a period
    if userString.endswith("."):
        print("The string ends with a period.")
    else:
        print("The string does not end with a period.")
