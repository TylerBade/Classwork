class CNode:
    left , right, data = None, None, 0
    
    def __init__(self, data):
        # initializes the data members
        self.left = None
        self.right = None
        self.data = data
        
class CBOrdTree:
    def __init__(self):
        # initializes the root member
        self.root = None
        
    def addNode(self, data):
    # creates a new node and returns it
        return CNode(data)
        
    def insert(self, root, data):
        # inserts a new data
        if root == None:
            # it there isn't any data
            # adds it and returns
            return self.addNode(data)
        else:
            # enters into the tree
            if data <= root.data:
                # if the data is less than the stored one
                # goes into the left-sub-tree
                root.left = self.insert(root.left, data)
            else:
                # processes the right-sub-tree
                root.right = self.insert(root.right, data)
            return root
        
    def lookup(self, root, target):
        # looks for a value into the tree
        if root == None:
            return 0
        else:
            # if it has found it...
            if target == root.data:
                return 1
            else:
                if target < root.data:
                    # left side
                    return self.lookup(root.left, target)
                else:
                    # right side
                    return self.lookup(root.right, target)
                
    def minValue(self, root):
        # goes down into the left
        # arm and returns the last value
        while(root.left != None):
            root = root.left
        return root.data
    
    def maxDepth(self, root):
        if root == None:
            return 0
        else:
            # computes the two depths
            ldepth = self.maxDepth(root.left)
            rdepth = self.maxDepth(root.right)
            # returns the appropriate depth
            return max(ldepth, rdepth) + 1
        
    def size(self, root):
        if root == None:
            return 0
        else:
            return self.size(root.left) + 1 + self.size(root.right)

    def printTree(self, root):
        # prints the tree path
        if root == None:
            pass
        else:
            self.printTree(root.left)
            print(root.data)
            self.printTree(root.right)

    def printRevTree(self, root):
        # prints the tree path in reverse order
        if root == None:
            pass
        else:
            self.printRevTree(root.right)
            print(root.data)
            self.printRevTree(root.left)
            
if __name__ == "__main__":
    run = True
    while run == True:
        # create the binary tree
        BTree = CBOrdTree()
        # ask the user to insert values
        nodes = int(input("How many nodes do you want? "))
        charint = int(input("Do you want to use Integers(enter 0) or Characters (enter 1):"))
        if charint == 0:
        # add the root node
            root = BTree.addNode(0)
            for i in range(0, nodes):
                data = int(input("Insert value for node %d: " % i))
                while BTree.lookup(root, data) == 1:
                    data = int(input("No duplicates in the tree please, try again:)"))
                # insert values
                BTree.insert(root, data)
            print(BTree.printTree(root))
            print(BTree.printRevTree(root))
            data = int(input("What value do you want to find: "))
            if BTree.lookup(root, data):
                print("found")
            else:
                print("not found")
        if charint == 1:
            root = BTree.addNode("a")
            for i in range(0, nodes):
                data = str(input("Insert value for node %d: " % i))
                while BTree.lookup(root, data) == 1:
                    data = str(input("No duplicates in the tree please, try again:)"))
                # insert values
                BTree.insert(root, data)
            print(BTree.printTree(root))
            print(BTree.printRevTree(root))
            data = str(input("What value do you want to find: "))
            if BTree.lookup(root, data):
                print("found")
            else:
                print("not found")
        print(BTree.minValue(root))
        print(BTree.maxDepth(root))
        print(BTree.size(root))

        resp = input("Do you want to run again (Q or N to quit):")
        if resp == "N" or resp == "Q" or resp == "n" or resp == "q":
            run = False
