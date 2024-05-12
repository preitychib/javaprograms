import torch
import torch.nn as nn
import torch.nn.functional as F

class SOM(nn.Module):
    def __init__(self, input_size, map_size):
        super(SOM, self).__init__()
        self.input_size = input_size
        self.map_size = map_size
        self.weights = nn.Parameter(torch.randn(map_size[0], map_size[1], input_size))
        self.sigma0 = max(map_size[0], map_size[1]) / 2.0
        self.learning_rate0 = 0.1

    def forward(self, x):
        x = x.view(-1, 1, 1, self.input_size)
        x = x.expand(-1, self.map_size[0], self.map_size[1], -1)
        distances = torch.sum((x - self.weights) ** 2, dim=3)
        bmu_indices = torch.argmin(distances, dim=2)
        return bmu_indices

    def update_weights(self, x, iteration, max_iter):
        sigma = self.sigma0 * (1 - iteration / max_iter)
        learning_rate = self.learning_rate0 * (1 - iteration / max_iter)
        bmu_indices = self.forward(x)
        for i in range(self.map_size[0]):
            for j in range(self.map_size[1]):
                distance_to_bmu = torch.sqrt(torch.sum((torch.tensor([i, j]) - bmu_indices) ** 2))
                influence = torch.exp(-distance_to_bmu / (2 * sigma ** 2))
                self.weights[i, j, :] += learning_rate * influence * (x - self.weights[i, j, :])

# Example usage
input_size = 10
map_size = (5, 5)
som = SOM(input_size, map_size)

# Generate random input data
input_data = torch.randn(100, input_size)

# Training loop
max_iter = 100
for i in range(max_iter):
    for data in input_data:
        som.update_weights(data, i, max_iter)

# Get the BMU indices for some input data
bmu_indices = som.forward(input_data)
print(bmu_indices)
