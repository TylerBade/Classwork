class Stack:
    def __init__( self ):
        self._items = list();

    def isEmpty( self ):
        return len( self ) == 0;

    def __len__ (self):
        return len(self._items);

    def peek(self):
        if self.isEmpty():
            return "No values to peek at.";
        else:
            return self._items[-1];

    def pop (self):
        if self.isEmpty():
            return "No values to pop.";
        else:
            return self._items.pop()

    def push(self, item):
        self._items.append(item);

    def __str__(self):
        return repr(self._items);

newStack = Stack()
newStack.push(4)
newStack.push(5)
newStack.push(6)
newStack.push(10)
print(newStack)
revStack = Stack()
while not newStack.isEmpty():
    revStack.push(newStack.pop());
print(revStack)
