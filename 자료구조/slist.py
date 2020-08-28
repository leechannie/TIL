class slist:
    class Node:
        def __init__(self,item,next):
                self.item = item
                self.next = next
    
    def __init__(self):
        self.head = None   
        self.size = 0
    
    def size(self):
        return self.size
    
    def is_empty(self):
        return self.size == 0
    
    def insert_front(self, item):
        if self.is_empty():
            self.head = self.Node(item, None)
        else:
            self.head = self.Node(item, self.head)
        self.size += 1

    def insert_after(self, item, node):
        node.next = slist.Node(item, node.next)
        self.size += 1
    
    def delete_front (self):
        if self.is_empty():
            return " "
        else:
            self.head = self.head.next
            self.size -= 1
    
    def delete_after(self, node):
        if self.is_empty():
            return " "
        else:
            a = node.next
            node.next = a.next
            self.size -=1

    def print_all(self):
        p = self.head
        while p:
            if p.next != None:
                print(p.item, "->", end='')
            else:
                print(p.item)
            p = p.next

        
#-----------------------------------------------------------------
list = slist()
list.insert_front("B") 
list.insert_front("A")
list.print_all()
list.insert_after("C",list.head.next)
list.print_all()
list.insert_front("E")
list.print_all()
list.delete_after(list.head.next)
list.print_all()

            
        