def d():
    change = []
    for i in range(1,10001):
        if i <10:
            change.append(i+i)
        elif i <100:
            change.append(i+(i//10)+(i%10))
        elif i < 1000:
            change.append(i+(i//100)+((i%100)//10)+((i%100)%10))
        elif i < 10000:
            change.append(i+(i//1000)+((i%1000)//100)+(((i%1000)%100)//10)+(((i%1000)%100)%10))
    
    return change

list = []

change = d()

for i in range(1,10001):
    if i not in change:
        list.append(i)

for i in list:
    print(i)