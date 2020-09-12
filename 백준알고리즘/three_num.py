#백준 알고리즘 10817번

a,b,c = input("").split()

a = int(a)
b = int(b)
c = int(c)

print (a+b+c-max(a,b,c)-min(a,b,c))
