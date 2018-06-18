# Tyler Bade

class Cat :
    def __init__(self, name, breed): # Age & weight init to zero
        self._name = name
        self._breed = breed
        self._age = 0
        self._weight = 0

    def addAge(self, time): # time is amount to increase age
        self._age = self._age + time

    def addWeight(self, gain): # gain is amount to add to weight
        self._weight = self._weight + gain

    def getAge(self):
        return self._age

    def getWeight(self):
        return self._weight

    def getName(self):
        return self._name

    def getBreed(self):
        return self._breed

    def __repr__(self):
        return "%s is a %d year-old %s weighing %.1f pounds." %\
               (self._name, self._age, self._breed, self._weight)


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
