public class Cyclic {
    public static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] < nums.length - 1) {
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return -1;
    }
     public static void main(String[] args) {
         int[] arr = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
         System.out.println(missingNumber(arr));
     }
}