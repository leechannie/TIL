#백준 알고리즘 1193번

num = int(input())
up = 1 
line = 2 #분수 갯수(줄)

if num == 1:
    print("1/1")
    exit()

while(True):
    up = up + line #라인의 최고수 
    if num > up:
        line += 1
    else:
        break

num = up - num
if line%2 == 0:
    print(str(line-num) + "/" + str(num+1))  
else:
    print(str(num+1) + "/" + str(line-num)) 
    
##메모리 초과
# num = int(input())
# up = [] #분자
# down = [] #분모

# for i in range (1,10000001):
#     if i % 2 == 1: #홀수일 때,
#         for j in range(1, i+1):
#             up.append(j)
#         for f in range (i+1,0, -1):
#             down.append(f)
#     else: #짝수일 때,
#         for j in range(1, i+1):
#             up.append(j)
#         for f in range (i+1,0, -1):
#             down.append(f)
#     if len(up) >= num:
#         print(str(up[num-1]) + "/" + str(down[num-1]))
#         break 