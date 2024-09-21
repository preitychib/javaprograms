#!/bin/bash


echo "enter side 1"
read s1
echo "enter side 1"
read s2
echo "enter side 1"
read s3

s=$(echo "scale=2; ($s1+$s2+$s3)/2"|bc)
# echo "sqrt $area"|bc
area= $(echo "scale; sqrt($s*($s-$s1)*($s-$s2)*($s-$s3))"|bc)
# area=$(echo "scale=2; sqrt($s * ($s - $side1) * ($s - $side2) * ($s - $side3))" | bc)

echo "area of triangle is $area"
