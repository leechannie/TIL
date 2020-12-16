#백준 알고리즘 4344번

num = int(input())
l = []

for _ in range(num):
    n = list(map(int, input().split())) 
    avg = sum(n[1:])/n[0]
    count = 0
    for i in n[1:]:
        if i > avg:
            count += 1
    l.append((count/n[0])*100)

for i in l:
    print(('%.3f' % i) + "%")




