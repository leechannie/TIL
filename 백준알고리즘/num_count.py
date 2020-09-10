def low(item):
    if item < 100 or item > 1000:
        print("다시 입력")
        item = low(int(input()))
    else:
        item = item
    return item

total = 1
for i in range (3):
    a = low(int(input()))
    total *= a

st = list(str(total))

for i in range(10):
    print(st.count(str(i)))



    