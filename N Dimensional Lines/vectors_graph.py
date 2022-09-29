from Equation import*
import numpy as np

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
    print(i, " r(1) = ", i.getPoint(1))