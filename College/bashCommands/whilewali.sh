#!/bin/bash

counter=1

# until [ $counter -gt 10 ]; do
while [ $counter -lt 10 ]; do
    echo "Counter: $counter"
    counter=$((counter + 1))
done
