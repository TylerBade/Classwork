# Your Name

class Cat :
    def __init__(self, name, breed): # Age & weight init to zero
        pass

    def addAge(self, time): # time is amount to increase age
        pass

    def addWeight(self, gain): # gain is amount to add to weight
        pass

    def getAge(self):
        pass

    def getWeight(self):
        pass

    def getName(self):
        pass

    def getBreed(self):
        pass

    def __repr__(self):
        return "Dummy String."


if __name__ == "__main__":
    cats = []
    cats.append(Cat("Fluff", "Angora"))
    cats.append(Cat("Fang", "Bengal Tiger"))
    cats.append(Cat("Friend", "Siamese"))

    for cat in cats:
        print(cat)
    print()

    ages = [3,6,4]
    weights = [4.5, 73., 3.4]
    for i in range(3):
        cats[i].addAge(ages[i])
        cats[i].addWeight(weights[i])

    for cat in cats:
        print(cat.getName())
        print(cat.getBreed())
        print(cat.getAge())
        print(cat.getWeight())
        print()

    cats[1].addWeight(15)
    cats[1].addAge(1)
    for cat in cats:
        print(cat)
