#백준 알고리즘 1157번

n = list(map(str, input().upper()))
alphabet = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
m = []

for i in alphabet:
    y = n.count(i)
    m.append(y)

if m.count(max(m)) >= 2:
    print("?")
    
if m.count(max(m)) == 1:
    print(alphabet[m.index(max(m))])
