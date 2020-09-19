#백준 알고리즘 1110번

size = 0

n = int(input())
num = n


while True:
    one = num%10
    ten = num//10
    add = (ten + one)%10
    real = str(one) + str(add)
    size += 1
    num = int(real)
    if n == int(real):
        break

print(size)
