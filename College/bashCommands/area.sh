#!/bin/bash

echo "Enter radius:"
read r
area=`echo 3.14*$r*$r |bc`
sq=`echo $(sqrt area) | bc`
# let area=3.14\*$r\*$r
# area=$(echo "scale=2; 3.14 * $r * $r" | bc)
# area=$(echo "scale=2; 3.14 * $r * $r" | bc)
echo "Area is" $sq
