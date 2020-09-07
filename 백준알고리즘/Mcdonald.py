#백준 알고리즘 5543번 

def low(item):
    if item > 2000 or item < 100:
        print("가격은 100원 이상 2000원 이하 입니다.")
        item = low(int(input("상덕버거의 가격을 입력해주세요: ")))
    else:
        item = item
    return item

def b_compare(s,j,h): 
    return min(s,j,h)

def d_compare(c,cd):
    return min(c,cd)

s = low(int(input()))
j = low(int(input()))
h = low(int(input()))
c = low(int(input()))
cd = low(int(input()))

print(b_compare(s,j,h)+d_compare(c,cd)-50)
