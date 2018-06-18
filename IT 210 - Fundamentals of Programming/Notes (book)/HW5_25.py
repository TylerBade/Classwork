# Tyler Bade

def main():
        userInput = input("Please enter your ZIP code: ")
        print("|" + printBarCode(userInput) + "|")
        
def printBarCode(zipCode):
        barCode = ""
        sum = 0
        for i in range(len(zipCode)):
                barCode = barCode + printDigit(i)
        for char in zipCode:
                sum = sum + int(char)
        checkVal = sum % 10
        check = 10 - checkVal
        barCode = barCode + printDigit(check)
        return barCode

def printDigit(d):
        if d == 1 : return ":::||"
        if d == 2 : return "::|:|"
        if d == 3 : return "::||:"
        if d == 4 : return ":|::|"
        if d == 5 : return ":|:|:"
        if d == 6 : return ":||::"
        if d == 7 : return "|:::|"
        if d == 8 : return "|::|:"
        if d == 9 : return "|:|::" 
        if d == 0 : return "||:::"
        return ""
        
main()
