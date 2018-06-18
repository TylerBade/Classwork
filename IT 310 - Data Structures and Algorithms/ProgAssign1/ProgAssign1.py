# Sources:
    # StackOverflow for random functions (mostly lookup of things I forgot) used in the program
    # Stack ppt for the stack class and function implementation

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

def Delim(string):
    delim = True
    front = '({[<';
    back = ')}]>';
    delims = Stack();
    for char in string:
        if char in front:
            delims.push(char);
        elif char in back:
            if delims.isEmpty():
                delim = False;
                return "Delimiters have front side missing."
            if back.index(char) != front.index(delims.pop()):
                delim = False;
                return "Delimiters do not match.";
    if delim == True & delims.isEmpty():
        return "Delimiters match";
    else:
        return "Delimiters have back side missing";

def Postfix(string):
    postfStack = Stack();
    functs = '+-*/'
    for char in string:
        if char in functs:
            second = int(postfStack.pop());
            first = int(postfStack.pop());
            if char == '+':
                replace = first + second;
            if char == '-':
                replace = first - second;
            if char == '*':
                replace = first * second;
            if char == '/':
                replace = first / second;
            postfStack.push(replace);
        elif char.isdigit():
            postfStack.push(char);
    return postfStack.pop();

def Prefix(string):
    prefStack = Stack();
    functs = '+-*/'
    for char in string[::-1]:
        if char in functs:
            first = int(prefStack.pop());

            second = int(prefStack.pop());
            if char == '+':
                replace = first + second;
            if char == '-':
                replace = first - second;
            if char == '*':
                replace = first * second;
            if char == '/':
                replace = first / second;
            prefStack.push(replace);
        elif char.isdigit():
            prefStack.push(char);
    return prefStack.pop();

print(Delim("(3)"));
print(Delim("(3[4]{3)}"));
print(Delim("(3 4)]"));
print(Delim("(3"));
# both prefix and postfix use 8 / 2 + 4 * 3 - 9 for calculations
print(Postfix("8 2 / 4 3 * + 9 -"));
print(Prefix("- + / 8 2 * 4 3 9"));
