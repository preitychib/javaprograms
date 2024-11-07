import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import classification_report, confusion_matrix


train=pd.read_csv('mnist_train.csv')
test=pd.read_csv('mnist_test.csv')

X_train=train[1:]
y_train=train['label']
X_test=test[1:]
y_test=test['label']


scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
X_test = scaler.transform(X_test)
