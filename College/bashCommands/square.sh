#!/bin/bash

# Function to calculate the square of a number
square() {
    local num=$1
    echo $((num * num))
}

echo "Enter a number:"
read num

result=$(square $num)
echo "Square of $num is: $result"
