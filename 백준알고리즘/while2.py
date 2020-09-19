#백준 알고리즘 10951번

list = []

while True:
    try:
        a,b = input("").split()
        a = int(a)
        b = int(b)
        list.append(a + b)
    except:
        break

for i in list:
    print(i)