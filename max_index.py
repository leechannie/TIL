list = []

for i in range(0,9):
    num = int(input())
    list.append(num)
    i += 1

print(max(list))
print(list.index(max(list))+1)

