import matplotlib.pyplot as plt
import numpy as np

x = np.genfromtxt("House_2_TS/channel_1(TimeStamp).csv")
y = np.genfromtxt(f'House_2_Power/channel_1(POWER).csv')
plt.plot(x,y, linewidth=1.5, label = "AGGREGATE", c = 'k')

for i in range(2,20):
    x = np.genfromtxt(f'House_2_TS/channel_{i}(TimeStamp).csv')
    y = np.genfromtxt(f'House_2_Power/channel_{i}(POWER).csv')
    plt.plot(x,y, label = f"channel {i}")

plt.xlabel("UNIX TimeStamp")
plt.ylabel("Power")

plt.legend()
plt.show()
