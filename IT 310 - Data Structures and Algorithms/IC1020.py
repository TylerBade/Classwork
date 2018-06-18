# initialize mytree, root a, b root of left subtree, c root of right subree, d,e,f, subtrees below
myTree = ['a', ['b', ['d', [],[]], ['e', [],[]]], ['c', ['f',[],[]], []]]

#prints whole tree
print(myTree)
#prints subtree root b
print('left subtree = ', myTree[1])
# prints root a
print('root = ', myTree[0])
# prints root of right subtree c
print('right subtree = ', myTree[2])

# Initializes tree
def BinaryTree(r):

	return [r, [], []]

# Inserts item at next open left node
def insertLeft(root,newBranch):

	t = root.pop(1)

	if len(t) > 1:

		root.insert(1,[newBranch,t,[]])

	else:

		root.insert(1,[newBranch, [], []])

	return root

# inserts item at next open right node
def insertRight(root,newBranch):

	t = root.pop(2)

	if len(t) > 1:

		root.insert(2,[newBranch,[],t])

	else:

		root.insert(2,[newBranch,[],[]])

	return root

# returns tree root
def getRootVal(root):

	return root[0]

# sets a new root
def setRootVal(root,newVal):

	root[0] = newVal

# gets the left leaf value
def getLeftChild(root):

	return root[1]

# returns right leaf value
def getRightChild(root):

	return root[2]

# Creates tree with 3 as root value
r = BinaryTree(3)

# inserts 4 on left
insertLeft(r,4)

insertLeft(r,5)

insertRight(r,6)

insertRight(r,7)

l = getLeftChild(r)

print(l)

setRootVal(l,9)

print(r)

insertLeft(l,11)

print(r)

print(getRightChild(getRightChild(r)))
