#백준 알고리즘 10952번

list = []

while True:
    a,b = input("").split()
    a = int(a)
    b = int(b)
    if a == 0 or b == 0:
        break
    else:
        list.append(a + b)

for i in list:
    print(i)