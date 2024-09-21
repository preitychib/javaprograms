#!/bin/bash
# custom_function(){
# echo $0
# res=$(($1*$2*$3/100))
# return $res
# }

# custom_function 450 3 5
# echo $?

# for x in t* 
# do 
#     cat $x
# done
n=1
while [ $n -le 10 ]
do
echo $n
(( n++ ))
done