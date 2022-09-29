from Equation import*
import numpy as np
from matplotlib import projections, pyplot as plt

points = []
w = int(input("Dimension? "))
z = 0

while z==0: 
    a = np.zeros(w)
    for i in range(w):
        x = input(f"Enter coordinate {i+1}: ")
        if (x == 'b'):
            z += 1
            break
        a[i] = int(x)
    points.append(a)
    print("NEXT\n")
    
points.pop()

modPoints = []

for i in range(len(points)-1):
    m = Equation(points[i], points[i+1]-points[i])

    modPoints.append(m)

for i in modPoints:
    print(i, " r(0) = ", i.getPoint(0), " r(1) = ", i.getPoint(1))
print()

if(input("Define Line Points?: ") == "y"):
    cList = []
    for i in range(len(modPoints)):
        for j in range(11):
            cList.append(modPoints[i].getPoint(j/10))

    if(w == 3 and input("Show?: ") == "y"):
        x, y, z= zip(*cList)
        graph = plt.axes(projection="3d")
        graph.scatter(x,y,z)
        graph.plot(x,y,z)
        plt.show()
    
    elif(w == 2 and input("Show?: ") == "y"):
        x, y= zip(*cList)  
        plt.scatter(x,y)
        plt.plot(x,y)
        plt.show()
