#백준 알고리즘 3052번

lst = []

for i in range(10):
    a = int(input())
    lst.append(a%42)
    i += 1

lst = list(set(lst)) 
print(len(lst))