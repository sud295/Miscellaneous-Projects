import sklearn
from sklearn.ensemble import RandomForestClassifier
from sklearn import svm
from sklearn.model_selection import train_test_split
import pandas as pd
import numpy as np
from sklearn import preprocessing
from sklearn import metrics, linear_model,gaussian_process, isotonic,neural_network
import matplotlib.pyplot as plt


#clf = RandomForestClassifier(n_estimators=2)
#clf = svm.SVC(gamma=0.001, C=100)
#clf = linear_model.LinearRegression()
clf = neural_network.MLPRegressor()
print("Created Model\n")

data = pd.read_csv("House_2_ALL.csv")
data = (data-data.min())/(data.max()-data.min())
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

clf.fit(X_train, Y_train)
print("Fit model\n")

print("Attempting to predict\n")
pred = clf.predict(X_test)
print(pred)
pred_list = []
act_list = []
x_list = []
couter = 0
for i in range(len(pred)):
    couter +=1
    print(pred[i], Y_test[i])
    pred_list.append(pred[i])
    act_list.append(Y_test[i])
    x_list.append(couter)



print((clf.score(X_test, Y_test))*100)


plt.plot(x_list,act_list, label = "Target")
plt.plot(x_list,pred_list, label = "Prediction", linewidth = 0.4)
plt.legend()
plt.show()

