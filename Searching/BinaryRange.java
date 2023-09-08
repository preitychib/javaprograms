//! 34. Find First and Last Position of Element in Sorted Array
//? Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//? If target is not found in the array, return [-1, -1].
//? You must write an algorithm with O(log n) runtime complexity. 

import java.util.Scanner;
public class BinaryRange {
    public static int search(int[] nums, int target, boolean findStart) {
        int s=0,m,e;
        int ans=-1;
        e=nums.length-1;
        while(s<=e){
            m=s+ (e-s)/2;

            if(target>nums[m]) s=m+1; //? this sequence of conditions matters.
            else if(target<nums[m]) e=m-1;
            else{
                ans=m;
                if(findStart) e=m-1;
                else s=m+1;    
            }
            
        }
        return ans;
    }

    public static void main(String[] args){

        int[] arr={5,7,7,8,8,10,20,20,20,20,20,20,20,45,56,56,77,88,88,99};
        // int[] arr={5,7,7,7,8,8,10,20,20,20,99};
        //  int[] arr={4,3,2,1,0,-3};
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the number");
         int n= sc.nextInt();
        sc.close();
    //    int[]{search(nums,target,true),search(nums,target,false)};
         System.out.println("The index is:"+ search(arr,n,true)+" "+search(arr,n,false));
    }
}