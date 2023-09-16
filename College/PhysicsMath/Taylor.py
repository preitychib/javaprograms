# For Alka di
import math

# Define a function to calculate the Taylor series approximation of e^x
def taylor_series_approximation(x, n):
    result = 0
    for i in range(n):
        result += (x ** i) / math.factorial(i)
    return result

# Prompt the user for input 
x = float(input("Enter the value of x: "))
n = int(input("Enter the number of terms (n): "))

# Calculate the approximation and the actual value of e^x
approximation = taylor_series_approximation(x, n)
actual_value = math.exp(x)

# Display the results
print(f"Approximation of e^{x} using {n} terms: {approximation}")
print(f"Actual value of e^{x}: {actual_value}")
