import matplotlib.pyplot as plt
import numpy as np

# x_point=np.array([0,6])
# y_point=np.array([0,250])
# plt.plot(x_point,y_point)
# plt.show()

x_point=np.array([0,1,2,2])
y_point=np.array([2,2,12,13])
x1_point=np.array([1,2,3,4])
y1_point=np.array([8,12,2,10])

plt.plot(x_point,y_point)
plt.plot(x1_point,y1_point)
plt.xlabel("X-axis")
plt.ylabel("y-axis")
plt.grid()
plt.show()