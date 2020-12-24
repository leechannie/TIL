#백준 알고리즘 1152번

l = list(map(str, input().split()))
num = 0

for i in l:
    if i != "":
        num += 1

print(num)