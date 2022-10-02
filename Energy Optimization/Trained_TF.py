'''
This file will execute the trained model in TENSORFLOW MODEL.py
'''
from numpy.lib.function_base import append
import tensorflow as tf
from tensorflow.keras.models import load_model
import numpy as np
from colorama import Fore, Back, Style
import time
import sklearn
from sklearn import model_selection
import matplotlib.pyplot as plt
import pandas as pd

st = time.time()

data = pd.read_csv("House_2_ALL.csv")
# data = (data-data.min())/(data.max()-data.min())
print(data.head())
print("Finished reading data\n")

data.drop("UnixTimeStamp",1)
predict = "Aggregate_Power"
print("Dropped UnixTimeStamp\n")

X = np.array(data.drop([predict],1))
Y = np.array(data[predict])
print("Created numpy Arrays\n")

X_train, X_test, Y_train, Y_test = sklearn.model_selection.train_test_split(X, Y, test_size = 0.1)
print("Assigned Testing/Training Variables\n")

new_model = load_model("e-opp.h5")

prediction = new_model.predict([X_test])
counter = 0
y_true = []
y_pred = []
x_list = []
counter = 0
n = 1500
for i in range(len(Y_test)):
    counter +=1
    x_list.append(counter)
    a = np.argmax(prediction[i])
    y_pred.append(a)
    b = Y_test[i]
    y_true.append(b)
    if a == b:
        counter+=1
        print(Fore.GREEN + f"{i}. ", "Prediction: ", np.argmax(prediction[i]), " Actual Value: ", Y_test[i],"\n")
        print(Style.RESET_ALL)
    else:
        print(Fore.RED + f"{i}. ", "Prediction: ", np.argmax(prediction[i]), " Actual Value: ", Y_test[i],"\n")
        print(Style.RESET_ALL)

fin = time.time()

plt.plot(x_list, y_true, label = "Target")
plt.plot(x_list, y_pred, label = "Predition")
plt.legend()
plt.show()
