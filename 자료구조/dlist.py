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
            tmp = node.prev
            n = self.Node(self,tmp,node)
            node.prev = n
            tmp.prev = n
            self.size += 1

        def insert_afer(self, node, itme):
            tmp = node.prev
            n = self.Node(item, tmp, node)
            node.prev = n
            node.next = n
            self.size += 1 
        
        def remove(self, node):
            node.prev.next = node.next
            node.next.prev = node.prev
            self.size -= 1

        def print_all(self, node):
            
            