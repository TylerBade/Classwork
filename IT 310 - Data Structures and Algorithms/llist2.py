class Node(object):

    # Defines nodes and the methods it encapsulates
    def __init__(self, data = None, next_node = None):
        self.data = data
        self.next_node = next_node
    def get_data(self):
        return self.data
    def get_next(self):
        return self.next_node
    def set_next(self, new_next):
        self.next_node = new_next


class LinkedList(object):
    #Defines the methods of a linked list
    def __init__(self, head = None):
        self.head = head

    def insert(self, data):
        new_node = Node(data)
        new_node.set_next(self.head)
        self.head = new_node

    def size(self):
        current = self.head
        count = 0
        while current:
            count += 1
            current = current.get_next()
        return count

    def search(self, data):
        current = self.head
        found = False
        while current and found is False:
            if current.get_data() == data:
                found = True
            else:
                current = current.get_next()
        if current is None:
            raise ValueError("Data not in list")
        return current

    def delete(self, data):
        current = self.head
        previous = None
        found = False
        while current and found is False:
            if current.get_data() == data:
                found = True
            else:
                previous = current
                current = current.get_next()
        if current is None:
            raise ValueError("Data not in list")
        if previous is None:
            self.head = current.get_next()
        else:
            previous.set_next(current.get_next())


import unittest

class TestLinkedList(unittest.TestCase):
    def setUp(self):
        self.list = LinkedList()
        print("Done")

    def tearDown(self):
        self.list = None
        print("Done")

    def test_insert(self):
        self.setUp()
        self.list.insert("David")

        self.assertTrue(self.list.head.get_data() == "David")
        self.assertTrue(self.list.head.get_next() is None)
        print("Done")

    def test_insert_two(self):
        self.setUp()
        self.list.insert("David")
        self.list.insert("Thomas")

        self.assertTrue(self.list.head.get_data() == "Thomas")

        head_next = self.list.head.get_next()
        self.assertTrue(head_next.get_data() == "David")
        print("Done")

    def test_nextNode(self):
        self.setUp()
        self.list.insert("Jacob")
        self.list.insert("Pallymay")
        self.list.insert("Rasmus")

        self.assertTrue(self.list.head.get_data() == "Rasmus")

        head_next = self.list.head.get_next()
        self.assertTrue(head_next.get_data() == "Pallymay")

        last = head_next.get_next()
        self.assertTrue(last.get_data() == "Jacob")
        print("Done")

    def test_positive_search(self):
        self.setUp()
        self.list.insert("Jacob")
        self.list.insert("Pallymay")
        self.list.insert("Rasmus")

        found = self.list.search("Jacob")
        self.assertTrue(found.get_data() == "Jacob")

        found = self.list.search("Pallymay")
        self.assertTrue(found.get_data() == "Pallymay")

        found = self.list.search("Jacob")
        self.assertTrue(found.get_data() == "Jacob")
        print("Done")

    def test_searchNone(self):
        self.setUp()
        self.list.insert("Jacob")
        self.list.insert("Pallymay")

        # make sure reg search works
        found = self.list.search("Jacob")

        self.assertTrue(found.get_data() == "Jacob")

        with self.assertRaises(ValueError):
            self.list.search("Vincent")
        print("Done")

    def test_delete(self):
        self.setUp()
        self.list.insert("Jacob")
        self.list.insert("Pallymay")
        self.list.insert("Rasmus")

        # Delete the list head
        self.list.delete("Rasmus")
        self.assertTrue(self.list.head.get_data() == "Pallymay")

        # Delete the list tail
        self.list.delete("Jacob")
        self.assertTrue(self.list.head.get_next() is None)
        print("Done")

    def test_delete_value_not_in_list(self):
        self.setUp()
        self.list.insert("Jacob")
        self.list.insert("Pallymay")
        self.list.insert("Rasmus")

        with self.assertRaises(ValueError):
            self.list.delete("Sunny")
        print("Done")

    def test_delete_empty_list(self):
        self.setUp()
        with self.assertRaises(ValueError):
            self.list.delete("Sunny")

    def test_delete_next_reassignment(self):
        self.setUp()
        self.list.insert("Jacob")
        self.list.insert("Cid")
        self.list.insert("Pallymay")
        self.list.insert("Rasmus")

        self.list.delete("Pallymay")
        self.list.delete("Cid")

        self.assertTrue(self.list.head.next_node.get_data() == "Jacob")
        print("Done")

testing = TestLinkedList()
testing.setUp()
testing.tearDown()
testing.test_insert()
testing.test_insert_two()
testing.test_nextNode()
testing.test_positive_search()
testing.test_searchNone()
testing.test_delete()
testing.test_delete_value_not_in_list()
testing.test_delete_empty_list()
testing.test_delete_next_reassignment()
