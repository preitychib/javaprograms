import java.util.Arrays;

public class Find1in3 {
    static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i;
        System.out.println(Arrays.toString(nums));
        for (i = 2; i < nums.length; i += 3) {
            if (nums[i - 2] != nums[i])
                return nums[i - 2];
            
        }
        return i-2;
    }
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 1, 0, 1, 99 };
        System.out.println(singleNumber(arr));
    }
}
