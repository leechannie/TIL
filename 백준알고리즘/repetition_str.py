#백준 알고리즘 2675번

n = int(input())

for i in range(n):
    l = list(map(str, input().split()))
    a = ""
    for k in l[1]:
        a += k * int(l[0])
    print(a)