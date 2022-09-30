import tensorflow as tf
import pandas as pd
import csv
import numpy as np
import matplotlib.pyplot as plt
from tensorflow import keras
from tensorflow.keras import layers
from tensorflow.keras.layers.experimental import preprocessing
import seaborn

np.set_printoptions(precision=3, suppress=True)

url = "House_2_ALN.csv"
column_names = ["Aggregate_Power", "Channel2", "Channel3", "Channel4", "Channel5",
                "Channel6", "Channel7", "Channel8", "Channel9", "Channel10", "Channel11",
                "Channel12", "Channel13", "Channel14", "Channel15", "Channel16", "Channel17", 
                "Channel18", "Channel19"]

raw_dataset = pd.read_csv(url, names= column_names,
                          na_values='?', comment='\t',
                          sep=' ', skipinitialspace=True)

dataset = raw_dataset.copy()
dataset.isna().sum()
dataset = dataset.dropna()

train_dataset = dataset.sample(frac=0.9, random_state=0)
test_dataset = dataset.drop(train_dataset.index)

train_features = train_dataset.copy()
test_features = test_dataset.copy()

train_labels = train_features.pop("Aggregate_Power")
test_labels = test_features.pop("Aggregate_Power")

print(dataset.tail())

train_dataset.describe().transpose()[['mean', 'std']]

normalizer = preprocessing.Normalization(axis=-1)
normalizer.adapt(np.array(train_features))
# print(normalizer.mean.numpy())
first = np.array(train_features[:1])

with np.printoptions(precision=2, suppress=True):
  print('First example:', first)
  print()
  print('Normalized:', normalizer(first).numpy())

def build_and_compile_model(norm):
  model = keras.Sequential([
      norm,
      layers.Dense(64, activation='relu'),
      layers.Dense(64, activation='relu'),
      layers.Dense(1)
      
  ])

  model.compile(loss='mean_absolute_error',
                optimizer=tf.keras.optimizers.Adam(0.001))
  return model

dnn_model = build_and_compile_model(normalizer)
dnn_model.summary()


history = dnn_model.fit(
    train_features, train_labels,
    validation_split=0.2,
    verbose=0, epochs=100)

# test_results['dnn_model'] = dnn_model.evaluate(test_features, test_labels, verbose=0)
# pd.DataFrame(test_results, index=['Mean absolute error [MPG]'])

test_predictions = dnn_model.predict(test_features).flatten()

a = plt.axes(aspect='equal')
plt.scatter(test_labels, test_predictions)
plt.xlabel('True Values [MPG]')
plt.ylabel('Predictions [MPG]')
lims = [0, 50]
plt.xlim(lims)
plt.ylim(lims)
_ = plt.plot(lims, lims)




