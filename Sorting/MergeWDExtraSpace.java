//! 88. Merge Sorted Array
//? You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//? Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//? The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

// Example 1:
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

// Example 2:
// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]
// Explanation: The arrays we are merging are [1] and [].
// The result of the merge is [1].

import java.util.Arrays;

public class MergeWDExtraSpace {
    
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        int i,j;
        i=a.length-1;
        j=0;
        while(b[j]<a[i]){
            long temp = b[j];
            b[j]=a[i];
            a[i]=temp;
            i--; j++;
        }

        Arrays.sort(a);
        Arrays.sort(b);

    }
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0) {
            nums1=nums2;
            return;
        }
        if(n==0){
            return;
        }

        int i=0;
        int j=0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]) i++;
            else if(nums1[i]>nums2[j]){
                int temp= nums1[i];
                nums1[i]=nums2[j];
                nums2[j]=temp;
                i++;
            }else{
                int temp= nums1[i+1];
                nums1[i+1]=nums2[j];
                nums2[j]=temp;
                i++; 
            }

        }
        System.out.println(Arrays.toString(nums2));
        // j=0;
        while(j<n){
            nums1[i]=nums2[j];
            j++; i++;
        }

        
    }

    public static void main(String[] args) {
        int[] arr1={1,2,3,0,0,0};
        int[] arr2={2,5,6};
        merge(arr1,3,arr2,3);
        System.out.println(Arrays.toString(arr1));
    }
}