class LinkedQueue:

    class _Node:

        __slots__ = '_element', '_next'

        def __init__(self, element, next):
            self._element = element
            self._next = next

    def __init(self):
        self._head = None
        self._tail = None
        self._size = 0

    def __len__(self):
        return self._size

    def isEmpty(self):
        return self._size == 0

    def first(self):
        if self.isEmpty():
            raise Empty('Queue is empty')
        return self._head._element

    def dequeue(self):
        if self.isEmpty():
            raise Empty('Queue is empty')
        answer = self._head._element
        self._head = self._head._next
        self._size -= 1
        if self.isEmpty():
            self._tail = None
        return answer

    def enqueue(self, e):
        newest = self._Node(e, None)
        if self.isEmpty():
            self._head = newest
        else:
            self._tail._next = newest
        self._tail = newest
        self._size += 1


newLQ = LinkedQueue()
newLQ.enqueue(4)
newLQ.enqueue(6)
print(newLQ.first())
print(len(newLQ))
print(newLQ.dequeue())
print(newLQ.isEmpty())
