class dlist:
       class Node:
           def __init__(self,item,next,prev):
                self.item = item
                self.next = next
                self.prev = prev

        def __init__ (self):
            self.head = self.Node(None, None, None)
            self.tail = self.Node(None,self.head,None)
            self.head.next = self.tail
            sefl.size = 0

        def size(self):
            return self.size
            
        def is_emtpy(self):
            return self.size == 0
        
        def insert_before(self,node, item):
            