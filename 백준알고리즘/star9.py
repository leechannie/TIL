#백준 알고리즘 2446번

num = int(input(""))

for i in range(0,num-1):
    print(" "*i + "*"*(2*(num-i)-1))
for i in range(num-1, -1, -1):
    print(" "*i + "*"*(2*(num-i)-1))
    