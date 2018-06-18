class Deque:

    def __init__(self):
        self.items = [];

    def isEmpty(self):
        return self.items == [];

    def addFront(self, item):
        self.items.append(item);

    def addRear(self, item):
        self.items.insert(0, item);

    def removeFront(self):
        return self.items.pop();

    def removeRear(self):
        return self.items.pop(0);

    def size(self):
        return len(self.items);

#Creates deque
deque = Deque();

#first empty test (sees if deque is empty)
print(deque.isEmpty());

#adds 4 to the rear of deque
deque.addRear(4);

#adds dog to deque at rear
deque.addRear('dog');

#adds cat at front
deque.addFront('cat');

#adds boolean true at front
deque.addFront(True);

#tells us current size
print(deque.size());

#should return false if size returns a number not 0
print(deque.isEmpty());

#adds 8.4 to rear
deque.addRear(8.4);

#prints rearmost value
print(deque.removeRear());

#prints frontmost value
print(deque.removeFront());
