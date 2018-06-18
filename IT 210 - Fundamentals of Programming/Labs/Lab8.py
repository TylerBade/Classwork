# Tyler Bade
# Sebastian Millin
# Olufemi Oyinkansola


class Toy:
    
    def __init__(self, name):
        self._name = str(name)
        self._price = 0
        self._gender = "Both"
        self._minAge = 0

    def setPrice(self, price):
        self._price = price

    def getPrice(self):
        return "$" + str(self._price)

    def setGender(self, gender):
        self._gender = gender

    def getGender(self):
        return self._gender

    def setMinAge(self, minAge):
        self._minAge = minAge

    def getMinAge(self):
        return self._minAge

    def __repr__(self):
        return "Name: " + self._name + " " + "Price: $" + str(self._price) + " " + \
               "Gender: " + self._gender + " " + "Min Age: " + str(self._minAge)

if __name__ == "__main__":
    def main():
        toyCar = Toy("Sedan")
        toyCar.setPrice(3.15)
        print(toyCar.getPrice())
        toyCar.setGender("Boy")
        print(toyCar.getGender())
        toyCar.setMinAge(5)
        print(toyCar.getMinAge())
        print(toyCar)
    main()
