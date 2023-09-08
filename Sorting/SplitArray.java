//! 410. Split Array Largest Sum
//? Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
//? Return the minimized largest sum of the split.
//? A subarray is a contiguous part of the array. 

//? Input: nums = [1,2,3,4,5], k = 2
//? Output: 9
//? Explanation: There are four ways to split nums into two subarrays.
//? The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

class SplitArray {
    public int splitArray(int[] arr, int k) {
        int s=arr[0];
        int e=arr[0];
        for(int i=1;i<arr.length;i++){
            s=Math.max(s,arr[i]);
            e+=arr[i];
        }

        int m;
        while(s<e){
            m=(e+s)/2;
            int c=1;
            int sum=0;
            for(int a : arr){
                if((a+sum)>m){ 
                    sum=a;
                    c++;
                }
                else{
                    sum+=a;
                    
                }
            }

            if(c>k)
               s= m+1;
            else e=m;
        }
        return s;
    }
}