//? leetcode ka question hai konsa yaad nhi

import java.util.Arrays;

public class BuildPermutationArray {

    static public int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i] + (nums.length) * (nums[nums[i]]%nums.length);
                nums[i] = a;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] /= nums.length;
        }

        return nums;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildArray(new int[] {0,2,1,5,3,4})));
    }
}