class Queue:

    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def size(self):
        return len(self.items)

    def enqueue(self, item):
        self.items.insert(0,item)

    def dequeue(self):
        if len(self.items) == 0:
            return "No items to return"
        return self.items.pop()

    def first(self):
        if len(self.items) == 0:
            return "No items to return"
        return self.items[-1]

q = Queue();
q.enqueue(5)
q.enqueue(3)
print(q.size())
q.dequeue()
print(q.isEmpty())
q.dequeue()
print(q.isEmpty())
q.dequeue()
q.enqueue(7)
q.enqueue(9)
print(q.first())
q.enqueue(4)
print(q.size())
q.dequeue()
