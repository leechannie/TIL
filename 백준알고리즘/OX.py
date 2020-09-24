#백준 알고리즘 8958번

num = int(input())
sum_lst = []

for i in range(num):
    a = input()
    lst = list(a)
    count = 1
    sum = 0

    for i in lst:
        if i == "O":
            sum += count
            count += 1
        else:
            count = 0
            sum += count
            count = 1
    sum_lst.append(sum)

for i in sum_lst:
    print(i)

