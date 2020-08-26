class slist:
    class Node:
        def __init__(self,item,next):
                self.item = item
                self.next = next
    
    def __init__(self):
        self.head = None   
        self.size = 0
    
    def size(self)
        retrun self.size
    
    def is_empty(self)
        return self.size == 0
    
    def insert_front(self, item):
        if self.is_empty():
            self.head = self.Node(item, None)
        else:
            self.head = self.Node(item, self.head)
        self.size += 1