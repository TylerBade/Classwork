class ArrayQueue:
    DEF_CAP = 10;

    def __init__(self):
        self._data = [None] * ArrayQueue.DEF_CAP;
        self._size = 0;
        self._front = 0;

    def __len__(self):
        return self._size;

    def isEmpty(self):
        return self._size == 0;

    def first(self):
        if self.isEmpty():
            raise Empty('Queue has nothing in it');
        return self._data[self._front]

    def dequeue(self):
        if self.isEmpty():
            raise Empty('Queue has nothing in it');
        answer = self._data[self._front];
        self._data[self._front] = None;
        self._front = (self._front + 1) % len(self._data);
        self._size -= 1;
        return answer;

    def enqueue(self, e):
        if self._size == len(self._data):
            self._resize(2*len(self._data));
        avail = (self._front + self._size) % len(self._data);
        self._data[avail] = e;
        self._size += 1;

    def _resize(self, cap):
        old = self._data;
        self._data = [None] * cap;
        walk = self._front;
        for k in range(self._size):
            self._data[k] = old[walk];
            walk = (1 + walk) % len(old);
        self._front = 0;

# For queue labwork part 2
