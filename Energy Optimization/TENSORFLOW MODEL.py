import tensorflow as tf
import numpy as np
import pandas as pd
import sklearn
from sklearn import model_selection
from tensorflow import keras
from tensorflow.keras import layers
from tensorflow.keras.layers.experimental import preprocessing

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

# Normalize Data (Into a range of 0-1)
X_train = tf.keras.utils.normalize(X_train, axis=1)
X_test = tf.keras.utils.normalize(X_test, axis=1)
print("Normalized")

# Y_train = tf.keras.utils.normalize(Y_train, axis=1)
# Y_test = tf.keras.utils.normalize(Y_test, axis=1)

# # Model type
# model = tf.keras.models.Sequential()

# # First Layer
# model.add(tf.keras.layers.Flatten())

# # Hidden Layers
# model.add(tf.keras.layers.Dense(64, activation='relu'))
# model.add(tf.keras.layers.Dense(64, activation='relu'))




# # Output layer


# model.add(tf.keras.layers.Dense(1, activation=tf.nn.softmax))

model = keras.Sequential([
      layers.Dense(64, activation='relu'),
      layers.Dense(64, activation='relu'),
      layers.Dense(1)
      
  ])

#model.compile(optimizer='adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])
#model.compile(optimizer='adam', loss='mean_squared_error', metrics=['accuracy'])

model.compile(loss='mean_squared_error',
                optimizer=tf.keras.optimizers.Adam(0.001))

# Cross-Entropy loss

model.fit(X_train, Y_train, epochs= 3)

# Evaluate and display accuracy
# val_loss, val_acc = model.evaluate(X_test, Y_test)
# print(val_acc, val_loss)

model.save('e-opp.h5')


