#백준 알고리즘 10039번

num = 0
for i in range(5):
    a = int(input(""))
    if a < 40:
        a = 40
    num += a
    i = i + 1

print (num//5)
