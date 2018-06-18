# Tyler Bade

# Creates class
class Lightbulb():

    # Initalizes variables
    def __init__(self, manufacturer="No Manufacturer"):
        self._manufacturer = manufacturer
        self._model = None
        self._tech = None
        self._watts = None
        self._price = None
        self._expLife = None
        self._eff = None

    # Following two definitions set and return the Manufacturer variable

    def setMan(self, manufacturer):
        self._manufacturer = manufacturer
        
    def getMan(self):
        return self._manufacturer

    # Following two definitions set and return the Model variable

    def setModel(self, model="No Model"):
        self._model = model

    def getModel(self):
        return self._model

    # Following two definitions set and return the Tech variable

    def setTech(self, tech="LED"):
        self._tech = tech

    def getTech(self):
        return self._tech

    # Following two definitions set and return the Wattage variable (as a Float number)

    def setWatts(self, watts=60):
        self._watts = float(watts)

    def getWatts(self):
        return self._watts

    # Following two definitions set and return Price (price set as a Float number)

    def setPrice(self, price=0.00):
        self._price = float(price)

    def getPrice(self):
        return "$" + str(self._price)

    # Following two definitions set and return Expected Lifetime Variable (expLife set as Float)

    def setExpLife(self, expLife=0):
        self._expLife = float(expLife)

    def getExpLife(self):
        return str(self._expLife) + "Hours"

    # Following two definitions set and return Efficiency Variable (efficiency set as Float)

    def setEff(self, eff=0):
        self._eff = float(eff)

    def getEff(self):
        return self._eff

    # Following definition returns string of all variables for reading

    def __repr__(self):
        return "Manufacturer: " + self._manufacturer + ",  Model: " + self._model + ", Tech: " \
               + self._tech + ", Watts in: " + str(self._watts) + ",  Price: $" + \
               str(self._price) + ",  Expected Life: " + str(self._expLife) + \
               " Hours,  Efficiency: " + str(self._eff) + " Watts"


if __name__ == "__main__":
    def main():
        # Starts class (no manufacturer)
        bulb = Lightbulb()
        # set manufacturer
        print(bulb.getMan())
        bulb.setMan("LG")
        print(bulb.getMan())
        # set model (no model)
        bulb.setModel()
        print(bulb.getModel())
        # set model (actual variable)
        bulb.setModel("2550")
        # set Tech (uses default)
        bulb.setTech()
        print(bulb.getTech())
        # set wattage
        bulb.setWatts(60)
        print(bulb.getWatts())
        # set price
        bulb.setPrice(2.99)
        print(bulb.getPrice())
        # set exp life
        bulb.setExpLife(10000)
        print(bulb.getExpLife())
        # set efficiency
        bulb.setEff(8)
        print(bulb.getEff())
        # print all variables
        print(bulb)
    main()
        
        
