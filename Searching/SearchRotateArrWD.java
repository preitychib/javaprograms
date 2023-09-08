//! 81. Search in Rotated Sorted Array II (With Dupplicates)
//? There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
//? Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
//? You must decrease the overall operation steps as much as possible.
//? Input: nums = [2,5,6,0,0,1,2], target = 0
//?  Output: true

class SearchRotateArrWD {

    public int binarySearch(int[] arr,int s, int e,int t){
        int m;
        while(s<=e){
            m=(s+e)/2;
            if(arr[m]>t) e=m-1;
            else if(arr[m]<t) s=m+1;
            else return m;
        }
        return -1;
    }
    
    public int findPivot(int[] arr){
        int s=0,m,e;
        e=arr.length-1;
        while(s<=e){
            m=(e+s)/2;
            if(m<e && arr[m]>arr[m+1]) return m;
            if(m>s && arr[m-1]>arr[m]) return m-1;

            if((arr[s]==arr[m]) && (arr[m]==arr[e])){
                
                if(s<e && arr[s]>arr[s+1]) return s;
                 s++;
                if(e>s && arr[e]<arr[e-1]) return e-1;
                e--;

            }else if((arr[m]>arr[s]) ||( arr[m]==arr[s] && arr[m]>arr[e])) s=m+1;
            else e=m-1 ;
            

        }
        return arr.length-1;
    }
    public boolean search(int[] nums, int target) {
        int p;
        p= findPivot(nums);
        if(nums[p]==target) return true;
        int t;
        
            t=binarySearch(nums,0,p-1,target);
        if(t==-1)
         t=binarySearch(nums,p+1,nums.length-1,target);
        
        if(t!=-1) return true;
        else return false;

        
    }
}