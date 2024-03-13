#!/bin/bash

custom_function(){
echo $0
res=$(($1*$2*$3/100))
return $res
}

custom_function 450 3 5
echo $?
