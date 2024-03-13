#!/bin/bash

echo "Enter radius:"
read r
area=$(echo "scale=2; 3.14 * $r * $r" | bc)
echo "Area is" $area
