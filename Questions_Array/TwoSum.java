//! Two Sum : Check if a pair with given sum exists in Array
//? Problem Statement: Given an array of integers arr[] and an integer target.

//? 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

//? 2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

//? Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // Version 1 solution (optimal) 
    static String twoSum(int[] nums, int target) {

        int p1 = 0, p2 = nums.length - 1;
        Arrays.sort(nums);
        while (p1 < p2) {
            if (nums[p1] + nums[p2] > target)
                p2--;
            else if (nums[p1] + nums[p2] < target)
                p1++;
            else
                return "YES";
        }
        return "NO";
    }
    // Version 2 solution (brute force) N^2
    static int[] twoSumV2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
    // Version 2 solution (Optimal) NlogN
    static int[] twoSumV3(int[] nums, int target) {

        HashMap<Integer,Integer>hashMap= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int element=target-nums[i];
            if(hashMap.containsKey(element))
                return new int[] {i,hashMap.get(element)};
            
            hashMap.put(nums[i],i);
        }
        return new int[] {};
    }
}
