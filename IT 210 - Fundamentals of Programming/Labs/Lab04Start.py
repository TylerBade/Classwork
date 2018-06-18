## Tyler Bade

## P5.30
#  Check whether a password has the required properties.
#

def main() :
   # Read input from the user.
   password1 = input("Enter your password: ")
   password2 = input("Re-enter your password: ")

   # Keep looping until the passwords match and have the desired properties.
   while password1 != password2 or not isValidPassword(password1) :
      print("Passwords didn't match or didn't have the required properties.")

      # Read the next pair of passwords.
      password1 = input("Enter your password: ")
      password2 = input("Re-enter your password: ")

   # Display the final message.
   print("That pair of passwords will work.")

## Determine if a password has the desired properties: >=8 characters long, at
#  least one uppercase letter, at least one lowercase letter and at least one
#  digit.
#  @param password the password to check
#  @return True if all four properties are present, False otherwise
#
def isValidPassword(password) :
   ctDig = 0
   ctUpp = 0
   ctLow = 0
   if len(password) < 8:
      return False
   else:
      for char in password:
         if char.isupper():
            ctUpp += 1
      for char in password:
         if char.islower():
            ctLow += 1
      for char in password:
         if char.isdigit():
            ctDig += 1
      if ctUpp > 0 and ctLow > 0 and ctDig > 0:
         return True
      else:
         return False


# Call the main function.
main()
