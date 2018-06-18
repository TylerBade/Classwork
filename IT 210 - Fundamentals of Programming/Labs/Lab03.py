from sys import exit

userInput = input("Please enter your PIN number: ")
pin = str(userInput)
CORRECTPIN = "1234"
attempts = int(0)

print(userInput)
if pin == CORRECTPIN:
     exit(print("Your PIN is correct."))
else:
    attempts = attempts + 1
    exit(print("Your PIN is incorrect."))
    if attempts < 3:
        userInput = input("Please enter your PIN number: ")
        print(userInput)
    else:
        exit(print("Your bank card has been blocked."))
