import java.util.*;

class Subset {
    // This uses backtracking
    static List<List<Integer>> result;
    static void  helper(List<Integer> list,int[] nums,int index){
        if(nums.length==index){
            result.add(new ArrayList<>(list));
            return;
        }
        
        helper(list,nums,index+1);
        list.add(nums[index]);
        helper(list,nums,index+1);
        list.remove(list.size()-1);
       
    }

    public static List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        helper(new ArrayList<Integer>() {
        }, nums, 0);
        return result;
    }
    
    public static void main(String[] args) {
        subsets(new int[] { 1, 2, 3 });
        System.out.println("ls");
    }
}