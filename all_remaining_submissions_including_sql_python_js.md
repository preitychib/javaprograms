### Problem: [two sum](https://leetcode.com/problems/two-sum/)

```java
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return {i, j};
                }
            }
        }
        return {}; 
    }
};
```

### Problem: [binary search](https://leetcode.com/problems/binary-search/)

```java
class Solution {
    public int search(int[] nums, int target) {
       int start=0;
       int end=nums.length-1;
       int mid;
        while(start<=end){
            mid=(start+end)/2;
            if(nums[mid]<target)
                start=mid+1;
            else if(nums[mid]>target)
                end=mid-1;
            else 
                return mid;
        }
        return -1;
    }
}
```

### Problem: [single number](https://leetcode.com/problems/single-number/)

```java
class Solution {
    public int singleNumber(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++)
            ans^=nums[i];
        return ans;
    }
}
```

### Problem: [power of two](https://leetcode.com/problems/power-of-two/)

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
      if(n<1) return false;
       if((n&(n-1))==0) return true;
       
       return false;
    }
}
```

### Problem: [max consecutive ones](https://leetcode.com/problems/max-consecutive-ones/)

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int countMax=0;
        for(int i=0;i<nums.length;i++){
               if(nums[i]==1 )
               {
                  count++;
               }else {

                if(countMax<count) countMax=count;

                   count=0;
                }
        }
        if(countMax<count) countMax=count;
        return countMax;
    }
}
```

### Problem: [rotate array](https://leetcode.com/problems/rotate-array/)

```java
class Solution {

    public void reverse(int[] a,int l,int u){
        while(l<u){
            int temp = a[l];
            a[l]=a[u];
            a[u]=temp;
            l++;
            u--;
        }
    }
    public void rotate(int[] nums, int k) { 
        k%=nums.length;
        int n =nums.length-1;
        reverse(nums,0,n);
        reverse(nums,0,k-1);
        reverse(nums,k,n);
    }
}
```

### Problem: [move zeroes](https://leetcode.com/problems/move-zeroes/)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]==0)
                  {  int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;}
            }
        }
    }
}
```

### Problem: [move zeroes](https://leetcode.com/problems/move-zeroes/)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]==0)
                  {  int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;}
            }
        }
    }
}
```

### Problem: [reverse integer](https://leetcode.com/problems/reverse-integer/)

```java
class Solution {
    public int reverse(int x) {
        
        int temp=x;
        int rev=0;
        int mod=0;
        int max= (int)Math.pow(2,31)-1;
        int min= (int)Math.pow(2,31);
        while(temp!=0){
            if(rev>max/10 || rev< -min/10)
                return 0;
            mod=x>0?temp%10:temp%-10;
            rev= rev*10+ mod;
            temp/=10;
        }
        return rev;
    }
}
```

### Problem: [reverse integer](https://leetcode.com/problems/reverse-integer/)

```java
class Solution {
    public int reverse(int x) {
        
        int temp=x;
        int rev=0;
        int mod=0;
        while(temp!=0){
            if(rev>2147483647/10 || rev< -2147483648/10)
                return 0;
            mod=x>0?temp%10:temp%-10;
            rev= rev*10+ mod;
            temp/=10;
        }
        return rev;
    }
}
```

### Problem: [remove duplicates from sorted array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
       
        int p1=0;
        for(int p2=1;p2<nums.length;p2++){
            if(nums[p1]!=nums[p2]) {
                nums[p1+1]=nums[p2];
                p1++;
            }
        }
        return p1+1;
    }
}
```

### Problem: [flipping an image](https://leetcode.com/problems/flipping-an-image/)

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for(int i=0;i<image.length;i++){
            for(int j=0;j<(image[i].length+1)/2;j++){
                int temp = image[i][j]^1;
                image[i][j]=image[i][image[i].length-j-1]^1;
                image[i][image[i].length-j-1]= temp;
            }
            
        }

        return image;
    }
}
```

### Problem: [flipping an image](https://leetcode.com/problems/flipping-an-image/)

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for(int i=0;i<image.length;i++){
            for(int j=0;j<(image[i].length+1)/2;j++){
                int temp = image[i][j]^1;
                image[i][j]=image[i][image[i].length-j-1]^1;
                image[i][image[i].length-j-1]= temp;
            }
            // if(image[i].length/2 %2!=0)
            //  image[i][image[i].length/2]^=1;
        }

        return image;
    }
}
```

### Problem: [search in rotated sorted array ii](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

```java
class Solution {

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
```

### Problem: [search in rotated sorted array ii](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

```java
class Solution {

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
```

### Problem: [search in rotated sorted array ii](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

```java
class Solution {

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
                // if(arr[m]arr[s]) 
            

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
```

### Problem: [search in rotated sorted array ii](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

```java
class Solution {

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
          int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
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
```

### Problem: [split array largest sum](https://leetcode.com/problems/split-array-largest-sum/)

```java
class Solution {
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
```

### Problem: [split array largest sum](https://leetcode.com/problems/split-array-largest-sum/)

```java
class Solution {
    int[] nums;
    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        int low = 0, high = 0, min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while(low <= high) {
            int mid = (low + high) / 2;
            if(required_no_of_chunks(mid, m)){
               min = Math.min(min, mid);
               high = mid - 1;
            }
            else low = mid + 1;
        }
        return min;
    }
    
    private boolean required_no_of_chunks(int mid, int m){
        int chunks = 0, i=0;
        while(i < nums.length){
            int val = 0;
            while(i < nums.length && nums[i] + val <= mid) val += nums[i++];
            chunks++;
        }
        return chunks <= m;
    }
}
```

### Problem: [split array largest sum](https://leetcode.com/problems/split-array-largest-sum/)

```java
class Solution {
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
```

### Problem: [search in rotated sorted array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

```java
class Solution { 
     int binarySearch(int[] arr, int s, int e, int t){

        int m;
        while(s<=e){
            m=(e+s)/2;
            if (t > arr[m])
                s = m + 1;
            else if(t<arr[m]) e=m-1;
            else return m;
        }
        return -1;
    }
     int findPivot(int[] nums){
        int st = 0;
        int end = nums.length-1;

        while(st<end){
            int mid = st + (end-st)/2;

            if(nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] > nums[0])
                st = mid+1;
            else end = mid;
        }
        return nums.length-1;
    }      
    public int search(int[] nums, int target) {
        
        int pivot = findPivot(nums);
        
        int t = 0;
        t=binarySearch(nums,0,pivot,target);
        if(t==-1)
         t=binarySearch(nums,pivot+1,nums.length-1,target);
        return t;
        
    }
}

```

### Problem: [search in rotated sorted array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

```java
class Solution { 
     int binarySearch(int[] arr, int s, int e, int t){

        int m;
        while(s<=e){
            m=(e+s)/2;
            if (t > arr[m])
                s = m + 1;
            else if(t<arr[m]) e=m-1;
            else return m;
        }
        return -1;
    }
     int findPivot(int[] nums){
        int st = 0;
        int end = nums.length-1;

        while(st<end){
            int mid = st + (end-st)/2;

            if(nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] > nums[0])
                st = mid+1;
            else end = mid;
        }
        return nums.length-1;
    }      
    public int search(int[] nums, int target) {
        
        int pivot = findPivot(nums);
        
        int t = 0;
        t=binarySearch(nums,0,pivot,target);
        if(t==-1)
         t=binarySearch(nums,pivot+1,nums.length-1,target);
        return t;
        
    }
}

```

### Problem: [search in rotated sorted array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

```java
class Solution { 
     int binarySearch(int[] arr, int s, int e, int t){

        int m;
        while(s<=e){
            m=(e+s)/2;
            if (t > arr[m])
                s = m + 1;
            else if(t<arr[m]) e=m-1;
            else return m;
        }
        return -1;
    }
     int findPivot(int[] nums){
        int st = 0;
        int end = nums.length-1;

        while(st<end){
            int mid = st + (end-st)/2;

            if(nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] > nums[0])
                st = mid+1;
            else end = mid;
        }
        return nums.length-1;
    }      
    public int search(int[] nums, int target) {
        // int s=0,e,m;
        //     e=arr.length-1;
        //     while(s<=e){
        //         m=(e+s)/2;
        //         if(arr[m]>t){
        //             if(t<arr[s]) s=m+1;
        //             else e=m-1;
        //         } else if(arr[m]<t){
        //             if(t>arr[e]) e=m-1;
        //             else s=m+1;
        //         }
        //         else return m;
        //     }
        //     return -1;
        int pivot = findPivot(nums);
        
        int t = 0;
        // System.out.println(pivot);
        t=binarySearch(nums,0,pivot,target);
        if(t==-1)
         t=binarySearch(nums,pivot+1,nums.length-1,target);
        return t;
        
    }
    }

```

### Problem: [find in mountain array](https://leetcode.com/problems/find-in-mountain-array/)

```java
 /**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int binary(MountainArray arr,int target,int s,int e,boolean condition){
        int m;
        // e=arr.length()-1;
       
        if(condition){
            while(s<=e){ 
                 m=(e+s)/2;
                if(arr.get(m)>target) e=m-1;
                else if(arr.get(m)<target) s=m+1;
                else {
                    return m;
                }
            }
        }else{
            while(s<=e){
                 m=(e+s)/2;
                if(arr.get(m)>target) s=m+1;
                else if(arr.get(m)<target) e=m-1;
                else {
                    return m;
                }
            }
        }
        return -1;
    }
    public int peakIndexInMountainArray(MountainArray arr) {
        int s=0,e,m;
        e=arr.length()-1;
        while(s<e){
            m=(e+s)/2;
            if(arr.get(m)>arr.get(m+1)) e=m;
            else s=m+1;
        }
        return s;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak=peakIndexInMountainArray(mountainArr); 
        int t= binary(mountainArr,target,0,peak,true);
        if(t==-1){
            t= binary(mountainArr,target,peak+1,mountainArr.length()-1,false);
            
        }
        return t;
    }
}
```

### Problem: [peak index in a mountain array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)

```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int s=0,e,m;
        e=arr.length-1;
        while(s<e){
            m=(e+s)/2;
            if(arr[m]>arr[m+1]) e=m;
            else s=m+1;
        }
        return s;
    }
}
```

### Problem: [find peak element](https://leetcode.com/problems/find-peak-element/)

```java
class Solution {
    public int findPeakElement(int[] arr) {
        int s=0,e,m;
        e=arr.length-1;
        while(s<e){
            m=(e+s)/2;
            if(arr[m]>arr[m+1]) e=m;
            else s=m+1;
        }
        return s;
    }
}
```

### Problem: [peak index in a mountain array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)

```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int s=0,e,m;
        e=arr.length-1;
        while(s<=e){
            m=(e+s)/2;
            if(arr[m]>arr[m+1]) e=m-1;
            else s=m+1;
        }
        return s;
    }
}
```

### Problem: [find first and last position of element in sorted array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

```java
class Solution {
    public int search(int[] nums, int target, boolean findStart) {
        int s=0,m,e;
        int ans=-1;
        e=nums.length-1;
        while(s<=e){
            m=s+ (e-s)/2;

            if(target>nums[m]) s=m+1;
            else if(target<nums[m]) e=m-1;
            else{
                ans=m;
                if(findStart) e=m-1;
                else s=m+1;    
            }
            
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
       
        // int[] arr=new int[2];
        // arr[0]=search(nums,target,true);
        // arr[0]=search(nums,target,false);
        // return arr;

        return new int[]{search(nums,target,true),search(nums,target,false)};
    }
}
```

### Problem: [find smallest letter greater than target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)

```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
       int s,e,m;
       s=0; e=letters.length-1; 
       while(s<=e){
           m=s+(e-s)/2;
           if(letters[m]>target) e=m-1;
           else s=m+1;
       }
       return letters[s%letters.length];
    }
}
```

### Problem: [search insert position](https://leetcode.com/problems/search-insert-position/)

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int s,e,m;
        s=0; e=nums.length-1;
        while(s<=e){
            m=(s+e)/2;
            if(nums[m]==target) return m;
            else if(nums[m]<target){
                s=m+1;
            }
            else{
                e=m-1;
            }

           
        }
        return s;
    }
}
```

### Problem: [richest customer wealth](https://leetcode.com/problems/richest-customer-wealth/)

```java
class Solution {
    public int maximumWealth(int[][] accounts) {
        int wealth=0;
        int maxWealth=0;
        for(int i=0;i<accounts.length;i++){
            wealth=0;
            for(int j=0;j<accounts[i].length;j++){
                wealth+=accounts[i][j];
            }
            if(wealth>maxWealth) maxWealth=wealth;
        }
        return maxWealth;
    }
}
```

### Problem: [first missing positive](https://leetcode.com/problems/first-missing-positive/)

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
      int i=0;
      while(i<nums.length){
          int correct = nums[i]-1;
          if(nums[i]<=nums.length && nums[i]>0 && nums[i]!=nums[correct]){
              int temp = nums[i];
              nums[i]=nums[correct];
              nums[correct]=temp;
          }
          else i++;
      }  

     for(int j = 0; j < nums.length; j++) {

            if(nums[j] != j + 1) {
                return j + 1;
            }
        }
      return nums.length+1;
    }
}
```

### Problem: [set mismatch](https://leetcode.com/problems/set-mismatch/)

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int a[]=new int[2];
        int i=0;
        while(i<nums.length){
            int correct =nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else i++;
        }

        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){a[0]=nums[i];a[1]=i+1;} ; 
        }
        return a;
        
    }
}
```

### Problem: [find all duplicates in an array](https://leetcode.com/problems/find-all-duplicates-in-an-array/)

```java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> list = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int correct =nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else i++;
        }

        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1) list.add(nums[i]); 
        }
        return list;
    }
}
```

### Problem: [find the duplicate number](https://leetcode.com/problems/find-the-duplicate-number/)

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct =nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else i++;
        }

        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return nums[i];
        }
        return 0;
    }
}
```

### Problem: [find all numbers disappeared in an array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int correct =nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else i++;
        }

        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1) list.add(i+1);
        }
        return list;
    }
}
```

### Problem: [find all numbers disappeared in an array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }else i++;
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1) ans.add(i+1);
        }
        return ans;
    
    }
}
```

### Problem: [missing number](https://leetcode.com/problems/missing-number/)

```java
class Solution {
    
    public int missingNumber(int[] nums) {
       int n = nums.length, sum = n*(n+1)/2;
        for(int i : nums) sum -= i;
        return sum;
    }
}
```

### Problem: [missing number](https://leetcode.com/problems/missing-number/)

```java
class Solution {
    public void swap(int[] nums, int i, int correct){
        int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
    }
    public int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct = nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct] ){
                swap(nums,i,correct);
            }
            else i++;
        }

        for(i=0;i<nums.length;i++){
            if(nums[i]!=i) return i;
        }
        return nums.length;
    }
}
```

### Problem: [pascals triangle](https://leetcode.com/problems/pascals-triangle/)

```java
class Solution {
public:
    vector<int> addRow(int n){
        vector<int> row;
        int res=1;
        row.push_back(res);
        for(int i=0;i<n;i++){
            // res=1;
            res*=n-i;
            res/=i+1;
            row.push_back(res);
        }
        return row;
    }
    vector<vector<int>> generate(int numRows) {
        
        vector<vector<int>> mat;
        int n=numRows;
        if(n<=0) return mat;
        mat.push_back({1});
        if(n==1) return mat;
        for(int i=1;i<n;i++){
            mat.push_back(addRow(i));
        }

        // number of elements are 1 , 2, 3, 4 ...
        // half is same after n/2 +1 for odd and n/2 for even
        // 1,2 ; 1,3 ; 4 ,5 ,6 ... it is like that for 2nd element.
        //

        


        return mat;
    }
};
```

### Problem: [set matrix zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

```java
class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {

       int col_0=1;
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix[i].size();j++){
                if(matrix[i][j]==0){
                   matrix[i][0]=0;
                   if(j==0) col_0=0;
                   else matrix[0][j]=0;   
                }

            }
        }

        for(int i=1;i<matrix.size();i++){
            for(int j=1;j<matrix[i].size();j++){

             if(!matrix[i][0] || !matrix[0][j])   
                matrix[i][j]=0;
            }
        }

		if(!matrix[0][0])
			for(int i =0;i<matrix[0].size();i++)
				matrix[0][i]=0;

		if(!col_0)
			for(int i =0;i<matrix.size();i++)
				matrix[i][0]=0;	
        
    }
};
```

### Problem: [set matrix zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

```java
class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        // for(int i=0;i<matrix.size();i++){
        //     for(int j=0;j<matrix[i].size;j++){
        //         if(matrix[i][j]==0){
        //             for(int k=0;k<matrix[0].size();k++){
        //                 matrix[i][k]=0;
        //             }
        //         }

        //     }
        // }
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix[i].size();j++){

                if(matrix[i][j]==0){

                    for(int k=0;k<matrix[0].size();k++)
                        matrix[i][k]=matrix[i][k]?-1000:0;

                    for(int k=0;k<matrix.size();k++)
                        matrix[k][j]=matrix[k][j]?-1000:0;
                }

            }
        }

        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix[i].size();j++){
                
                matrix[i][j]=matrix[i][j]==-1000?0:matrix[i][j];

            }
        }
        

    }
};
```

