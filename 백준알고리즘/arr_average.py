#백준 알고리즘 1546번
num = int(input())
lst = list(map(float, input().split()))
new_lst = []

for i in lst:
    num = i/max(lst)*100
    new_lst.append(num)

print(sum(new_lst)/len(new_lst))