# For Alka di
def f(x):
    # Define the function for which you want to find the root.
    return x**3 - 4*x**2 + 3*x

def bisection_method(f, a, b, tolerance):
    if f(a) * f(b) >= 0:
        print("Bisection method cannot guarantee a root in this interval.")
        return None

    while (b - a) / 2.0 > tolerance:
        midpoint = (a + b) / 2.0
        if f(midpoint) == 0:
            return midpoint
        elif f(a) * f(midpoint) < 0:
            b = midpoint
        else:
            a = midpoint

    return (a + b) / 2.0

# Input interval [a, b] and tolerance
a = float(input("Enter the left endpoint (a) of the interval: "))
b = float(input("Enter the right endpoint (b) of the interval: "))
tolerance = float(input("Enter the tolerance (e.g., 0.0001): "))

# Find the root using the bisection method
root = bisection_method(f, a, b, tolerance)

if root is not None:
    print(f"Approximate root found: {root}")
