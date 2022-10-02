'''
This file converts the .dat UKDALE files to a more easily manageable .CSV format
'''
#Power
for j in range(16,20):
    output = open(f"House_2_Power/channel_{j}(POWER).csv", 'a')
    with open(f"ukdale/house_2/channel_{j}.dat", buffering = 20000000) as f:
        for i in f:
            line = i[11:]
            print(line)
            output.write(line)
    output.close()

#TimeStamp
for j in range(16,20):
    output = open(f"House_2_TS/channel_{j}(TimeStamp).csv", 'a')
    with open(f"ukdale/house_2/channel_{j}.dat", buffering = 20000000) as f:
        for i in f:
            line = i[:11] +"\n"
            print(line)
            output.write(line)
    output.close()

#BOTH
for j in range(16,20):
    output = open(f"House_2_BOTH/channel_{j}(BOTH).csv", 'a')
    with open(f"ukdale/house_2/channel_{j}.dat", buffering = 20000000) as f:
        for i in f:
            line = i[:11] + "," + i[10:]
            print(line)
            output.write(line)
    output.close()
