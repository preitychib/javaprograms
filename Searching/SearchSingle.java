class SearchSingle {
    // what i came up with 
    // public static int singleNonDuplicate(int[] nums) {
    //     int start=0,end=nums.length-1,mid;
    //     if(end==0) return nums[0];
    //     while(start<=end){
    //         mid = (end+start)/2;
    //         boolean isNotEqualPrevious=mid == 0 || nums[mid]!=nums[mid-1];
    //         boolean isNotEqualNext=mid == nums.length-1 || nums[mid]!=nums[mid+1];
    //         if(isNotEqualPrevious&&isNotEqualNext)
    //             return nums[mid];
    //         else if(!isNotEqualPrevious){
    //             if((mid-1-start)%2==0)
    //                 start=mid+1;
    //             else end=mid-2;
    //         }
    //         else {
    //             if((mid-start)%2==0)
    //              start=mid+2;
    //             else end=mid-1;
    //         }
    //     }
    //     return -1;
    // }

    //?clear and better approach
    static int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            // Check if mid is even and the next element is the same.
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                start = mid + 2; // Move two steps to the right.
            } 
            // Check if mid is odd and the previous element is the same.
            else if (mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                start = mid + 1; // Move one step to the right.
            } 
            // Otherwise, the single element must be to the left of mid.
            else {
                end = mid;
            }
        }
        
        return nums[start];
    }
    
    public static void main(String[] args) {
        int[] arr = { 3, 3, 7, 7, 10, 11, 11 };
        System.out.println(singleNonDuplicate(arr));
    }
}