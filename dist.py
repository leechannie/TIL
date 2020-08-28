import math

def main():
    
    x1, y1 = eval(input("첫 번째 점에 대한 x1과 y1을 입력하세요: "))    
    x2, y2 = eval(input("두 번째 점에 대한 x2와 y2를 입력하세요: "))   
    x3, y3 = eval(input("세 번째 점에 대한 x3와 y3를 입력하세요: "))

    
    
    dist1 = distance(x1,x2,y1,y2)
    dist2 = distance(x2,x3,y2,y3)
    dist3 = distance(x3,x1,y3,y1)
       
    print("삼각형의 세점은 :", "(",x1,y1,")", "(",x2,y2,")", "(",x3,y3,")" )
    print("세점 사이의 거리는 : ", sortedNumbers(dist1,dist2,dist3))
    print("세점에 의한 삼각형의 면적은 : ", getTriArea(dist1, dist2, dist3))

    
def distance(x1,x2,y1,y2) :

    dist = math.sqrt((x1 - x2)**2 + (y1 - y2)**2)
    return dist


def sortedNumbers(dist1,dist2,dist3) :

    if dist1 > dist2:
        dist1,dist2 = dist2,dist1
        if dist2 > dist3:
            dist2,dist3 = dist3,dist2
    elif dist2 > dist3:
        dist2,dist3 = dist3,dist2
        if dist1 > dist2:
            dist1,dist2 = dist2,dist1
    
    return dist1,dist2,dist3    
   
def getTriArea(dist1,dist2,dist3) :
    
    s = (dist1+dist2+dist3)/2
    area = (s*(s-dist1)*(s-dist2)*(s-dist3))**0.5
    
    return area
    
    
main()