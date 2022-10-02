import csv
import pandas as pd

lis = []
with open("House_2_TS copy/channel_1(TimeStamp).csv", 'r') as csvfile:
    for row in csvfile:
        row = row[:10]
        row.replace(" ", "")
        row.replace("\n", "")
        lis.append(row)

lis2 = []
with open("House_2_Power copy/channel_2(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis2.append(row)

lis3 = []
with open("House_2_Power copy/channel_3(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis3.append(row)

lis4 = []
with open("House_2_Power copy/channel_4(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis4.append(row)

lis5 = []
with open("House_2_Power copy/channel_5(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis5.append(row)

lis6 = []
with open("House_2_Power copy/channel_6(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis6.append(row)

lis7 = []
with open("House_2_Power copy/channel_7(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis7.append(row)

lis8 = []
with open("House_2_Power copy/channel_8(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis8.append(row)

lis9 = []
with open("House_2_Power copy/channel_9(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis9.append(row)

lis10 = []
with open("House_2_Power copy/channel_10(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis10.append(row)

lis11 = []
with open("House_2_Power copy/channel_11(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis11.append(row)

lis12 = []
with open("House_2_Power copy/channel_12(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis12.append(row)

lis13 = []
with open("House_2_Power copy/channel_13(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis13.append(row)

lis14 = []
with open("House_2_Power copy/channel_14(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis14.append(row)

lis15 = []
with open("House_2_Power copy/channel_15(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis15.append(row)

lis16 = []
with open("House_2_Power copy/channel_16(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis16.append(row)

lis17 = []
with open("House_2_Power copy/channel_17(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis17.append(row)

lis18 = []
with open("House_2_Power copy/channel_18(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        #row.zfill(4)
        row = row[:-1]
        lis18.append(row)

lis19 = []
with open("House_2_Power copy/channel_19(Power).csv", 'r') as csvfile:
    for row in csvfile:
        
        row.replace(" ", "")
        row.replace("\n", "")
        row = row[:-1]
        lis19.append(row)

output = open("House_2_ALLN.csv", 'a')
writer = csv.writer(output)
for i in range(len(lis)):
    a = ([lis2[i]])
    a += ([lis3[i]])
    a += ([lis4[i]])
    a += ([lis5[i]])
    a += ([lis6[i]])
    a += ([lis7[i]])
    a += ([lis8[i]])
    a += ([lis9[i]])
    a += ([lis10[i]])
    a += ([lis11[i]])
    a += ([lis12[i]])
    a += ([lis13[i]])
    a += ([lis14[i]])
    a += ([lis15[i]])
    a += ([lis16[i]])
    a += ([lis17[i]])
    a += ([lis18[i]])
    a += ([lis19[i]])
    print(i)
    writer.writerow(a)
output.close()
