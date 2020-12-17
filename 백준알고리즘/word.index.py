#백준 알고리즘 10809번

n = list(map(str, input().upper()))
alphabet = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
m = [-1 for i in range(26)] #-1로 26개 리스트 구성

for i in range(len(n)):
    for j in range(len(alphabet)):
        if n[i] == alphabet[j]:
            if m[j] == -1: #처음 순서니까 
                m[j] = i

for i in range(len(m)):
    print(m[i],end=' ')


