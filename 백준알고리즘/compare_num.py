#백준 알고리즘 2908번

num = list(map(int, input().split()))
l = []

for i in num:
    tmp = ""
    tmp += str((i %100)% 10)
    tmp += str((i %100) // 10)
    tmp += str(i // 100)
    l.append(tmp)

print(max(l))