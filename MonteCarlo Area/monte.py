import random
import cv2
import numpy as np

ArrNew = cv2.imread("Untitled.png", 0) #Load Image
ArrNewOne = cv2.bitwise_not(ArrNew) 
Arr = ArrNewOne/255.0 #Normalize values between 0 and 1

counts = []
true = 0

for i in range(len(Arr)): #Iterating through Array to calculate true area
    for j in range(len(Arr[0])):
        if(Arr[i][j]!=0):
            true+=1

print("True Area: ", true, " Pixels")

inside = 0
doubleCOunt = []
for i in range(len(Arr)): #Taking sqrt(N) random samples from the image and counting the number that lie within the shape
    index1 = random.randint(0,len(Arr)-1)
    index2 = random.randint(0,len(Arr)-1)
    if(Arr[index1][index2]!=0):
        if(f"{index1},{index2}" not in doubleCOunt):
            doubleCOunt.append(f"{index1},{index2}")
            inside+=1
counts.append(inside)

prop = ((sum(counts)/len(counts))/(len(Arr))) #Calculating the proportion of points that lie within the shape
Area = (len(Arr)**2)*prop #Finding Area from proportion

print("Calculated Area: ", int(Area), " Pixels")