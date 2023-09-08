//! 35. Search Insert Position 
//? Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//? You must write an algorithm with O(log n) runtime complexity.

import java.util.Scanner;
public class Ceiling{
    public static int searchInsert(int[] nums, int target) {
        
        int s,e,m;
        s=0; e=nums.length-1;

        while(s<=e){
            m=(s+e)/2;
            if(nums[m]==target) return m;
            else if(nums[m]<target) s=m+1;
            else e=m-1;
        }

        if(s==nums.length) return -1;
        return s;
    }

    public static void main(String[] args){

        int[] arr={4,5,10,18,59};
        //  int[] arr={4,3,2,1,0,-3};
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the number");
         int n= sc.nextInt();
         System.out.println("The index is:" + searchInsert(arr, n));
         sc.close();
    }
}


//! 744. Find Smallest Letter Greater Than Target (Similar to above question)
//? You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

//? Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

// public char nextGreatestLetter(char[] letters, char target) {
//        int s,e,m;
//        s=0; e=letters.length-1; 
//        while(s<=e){
//            m=s+(e-s)/2;
//            if(letters[m]>target) e=m-1; //? sequence of these conditions matters
//            else s=m+1;
           
//        }
//        return letters[s%letters.length];
//     }