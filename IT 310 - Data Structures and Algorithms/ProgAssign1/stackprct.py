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
    
if __name__ == "__main__":
    testStack = Stack();
    print(testStack.isEmpty());
    testStack.push(4);
    print(testStack)
    testStack.pop();
    print(testStack);
    print(len(testStack));
    testStack.push(5);
    print(testStack);
    print(testStack.peek());
