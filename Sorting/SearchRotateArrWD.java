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
        while(s<e){
            m=(e+s)/2;
            if(m<e && arr[m]>arr[m+1]) return m;
            if(m>s && arr[m-1]>arr[m]) return m-1;

            if((arr[s]==arr[m]) && (arr[m]==arr[e])){
                
                if(s<e && arr[s]>arr[s+1]) return s;
                 s++;
                if(e>s && arr[e]<arr[e-1]) return e-1;
                e--;

            }else if((arr[m]<arr[s]) ||( arr[m]==arr[s] && arr[m]<arr[e])) s=m+1;
            else e=m-1 ;

        }
        return arr.length-1;
    }
    public boolean search(int[] nums, int target) {
        int p;
        p= findPivot(nums);
        System.out.println("p= "+p);
        if(nums[p]==target) return true;
        int t;
        if (target < nums[p]) {
             t = binarySearch(nums, 0, p - 1, target);
             System.out.println(t);
        }
        else{
            t = binarySearch(nums, p + 1, nums.length - 1, target);
            System.out.println(t);
        }
        
        if(t!=-1) return true;
        else return false;

        
    }
}