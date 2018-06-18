class SodaCan:

    def __init__(self, height=1, radius=1):
        self._radius = radius
        self._height = height
        self._volume = 0
        self._surfaceArea = 0

    def getVolume(self):
        self._volume =  (3.14 * (self._radius ** 2) * self._height)
        return self._volume

    def getSurfaceArea(self):
         self._surfaceArea =(2 * 3.14 * self._radius * self._height) +\
               (2 * 3.14 * (self._radius ** 2))
         return self._surfaceArea


if __name__ == "__main__":
    def main():
        coke = SodaCan(5,4)
        print("Expected: 251.20")
        print("%.2f" % coke.getVolume())
        print("Expected: 226.08")
        print("%.2f" % coke.getSurfaceArea())
    main()
        
