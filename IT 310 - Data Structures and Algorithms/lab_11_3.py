class HashTable:
    def __init__(self):
        self.size = 11 # Hash table will be the size here
        self.slots = [None] * self.size # all slots are empty
        self.data = [None] * self.size # all slots are occupied by None values

    def put(self,key,data):
        hashvalue = self.hashfunction(key,len(self.slots))

        if self.slots[hashvalue] == None: # If the slot is empty, inserts a key and the data associated with it
            self.slots[hashvalue] = key
            self.data[hashvalue] = data
        else:
            if self.slots[hashvalue] == key:
                self.data[hashvalue] = data  #replaces Data if key is the same
            else:
                nextslot = self.rehash(hashvalue,len(self.slots)) # Checks the next slot in line and repeats
                while self.slots[nextslot] != None and \
                    self.slots[nextslot] != key:
                    nextslot = self.rehash(nextslot,len(self.slots))

                if self.slots[nextslot] == None: # If the slot is empty, inserts a keya nd the data associated
                    self.slots[nextslot]=key
                    self.data[nextslot]=data
                else:
                    self.data[nextslot] = data #replaces data if key is the same

    def hashfunction(self,key,size):
        return key%size # returns list position

    def rehash(self,oldhash,size):
        return (oldhash+1)%size # Returns old hash size mod list size to return new position
    
    def get(self,key):
        startslot = self.hashfunction(key,len(self.slots))

        data = None
        stop = False
        found = False
        position = startslot
        while self.slots[position] != None and  \
              not found and not stop:
            if self.slots[position] == key:
                found = True
                data = self.data[position]
            else:
                position=self.rehash(position,len(self.slots))
                if position == startslot:
                    stop = True
        return data

    def __getitem__(self,key):
        return self.get(key)

    def __setitem__(self,key,data):
        self.put(key,data)

H=HashTable()
H[54]="cat"
H[26]="dog"
H[93]="lion"
H[17]="tiger"
H[77]="bird"
H[31]="cow"
H[44]="goat"
H[55]="pig"
H[20]="chicken"
print(H.slots)
print(H.data)

print(H[20])

print(H[17])
H[20]='duck'
print(H[20])
print(H[99])
print(H.data)
