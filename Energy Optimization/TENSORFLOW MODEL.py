'''
This file creates and traines a neural network. The model can then be loaded in the Trained_TF.py file to be tested.
'''
import tensorflow as tf
import numpy as np
import pandas as pd
import sklearn
from sklearn import model_selection
from tensorflow import keras
from tensorflow.keras import layers
from tensorflow.keras.layers.experimental import preprocessing

data = pd.read_csv("House_2_ALL.csv")
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

# Normalize Data (Into a range of 0-1)
X_train = tf.keras.utils.normalize(X_train, axis=1)
X_test = tf.keras.utils.normalize(X_test, axis=1)
print("Normalized")

model = keras.Sequential([
      layers.Dense(64, activation='relu'),
      layers.Dense(64, activation='relu'),
      layers.Dense(1)
      
  ])

model.compile(loss='mean_squared_error',
                optimizer=tf.keras.optimizers.Adam(0.001))

model.fit(X_train, Y_train, epochs= 3)
model.save('e-opp.h5')


