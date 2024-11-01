
### Problem: [populating next right pointers in each node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null || root.left==null) return root;
        Queue<Node> q=  new LinkedList<>();

        q.offer(root.left);
        q.offer(root.right);
        int count=0;
        int pow=1;
        Node pre=root.left;
        while(!q.isEmpty()){
           Node nextOne=q.poll();
           if(nextOne.left!=null){
            q.offer(nextOne.left);
            q.offer(nextOne.right);
           }
           count++;
           if(count==1) { 
            pre=nextOne;
            continue;
            }
           pre.next=nextOne;
           pre=nextOne;
           
           if(count==Math.pow(2,pow)){
            count=0;
            pow++;
            // pre=q.isEmpty()?null:q.pop();
           }
           
        }

        return root;
    }
}
```

### Problem: [single element in a sorted array](https://leetcode.com/problems/single-element-in-a-sorted-array/)

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int start=0, end=n-1;

        while(start<=end){
            int mid= (start + end)/2;

            if(mid>0&& nums[mid-1]!=nums[mid] && mid<n-1 && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            else if((mid>0&& nums[mid-1]==nums[mid])){
                if(mid%2==1){
                    start=mid+1;
                }else end=mid-1;
            }else if(mid<n-1 && nums[mid]==nums[mid+1]){
                if(mid%2==0){
                    start=mid+1;
                }else end=mid-1;
            }else if(mid==0 && mid<n-1 ){
                if(nums[mid+1]==nums[mid])
                    start=mid+1;
                else return nums[mid];
            }else if(mid==n-1 && mid-1>0){
                if(nums[mid-1]==nums[mid])
                    end=mid-1;
                else return nums[mid];
            }

            // System.out.println(start+" "+mid+" "+end);
        }

        return nums[start];
    }
}
```

### Problem: [find minimum operations to make all elements divisible by three](https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/)

```java
class Solution {
    public int minimumOperations(int[] nums) {
        int op=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%3==1 || nums[i]%3==2) op++;
        }
        return op;
    }
}
```

### Problem: [minimum operations to make binary array elements equal to one i](https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/)

```java
class Solution {

    public void flip(int i, int j, int[] nums){
        for(int k=i;k<=j;k++){
            nums[k]= nums[k]==0?1:0;
        }
    }
    public int minOperations(int[] nums) {
        
        int op=0; int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(nums[i]==0){
                flip(i,i+2,nums);
                op++;
            }
        }

        for(int i:nums){
            if(i==0) return -1;
        }
        return op;
    }
}
```

### Problem: [permutation sequence](https://leetcode.com/problems/permutation-sequence/)

```java
class Solution {
    int fact(int n){
        if(n<1) return 1;
        int f=1;
        for(int i=2;i<=n;i++){
            f*=i;
        }
        return f;
    }


    String helper(int d, int k,TreeSet<Integer> set){
        if(d<1) return "";
        int inc= fact(d-1);

        int index= k/inc;

        Iterator<Integer> iterator = set.iterator();
        int currentIndex = 0;
        int element = 0;

        while (iterator.hasNext()) {
            element = iterator.next();
            if (currentIndex == index) {
                break;
            }
            currentIndex++;
        }

        int nextK= k%inc;
        set.remove(element);

        return (""+ element) + helper(d-1,nextK,set);

    }
    public String getPermutation(int n, int k) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i=1;i<=n;i++)
            set.add(i);

        
        return helper(n,k-1,set);
    }
}
```

### Problem: [permutation sequence](https://leetcode.com/problems/permutation-sequence/)

```java
class Solution {
    int fact(int n){
        if(n<1) return 1;
        int f=1;
        for(int i=2;i<=n;i++){
            f*=i;
        }
        return f;
    }


    String helper(int d, int k,TreeSet<Integer> set){
        if(d<1) return "";
        int inc= fact(d-1);

        int index= k/inc;

        Iterator<Integer> iterator = set.iterator();
        int currentIndex = 0;
        int element = 0;

        while (iterator.hasNext()) {
            element = iterator.next();
            if (currentIndex == index) {
                break;
            }
            currentIndex++;
        }

        int nextK= k%inc;
        System.out.println(k+" "+inc+" "+index + " "+ element + " "+nextK);
        set.remove(element);

        return (""+ element) + helper(d-1,nextK,set);

    }
    public String getPermutation(int n, int k) {
        // return "";
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i=1;i<=n;i++)
            set.add(i);

        
        return helper(n,k-1,set);
    }
}
```

### Problem: [single element in a sorted array](https://leetcode.com/problems/single-element-in-a-sorted-array/)

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int start=0, end=n-1;

        while(start<=end){
            int mid= (start + end)/2;

            if(mid>0&& nums[mid-1]!=nums[mid] && mid<n-1 && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            else if((mid>0&& nums[mid-1]==nums[mid])){
                if(mid%2==1){
                    start=mid+1;
                }else end=mid-1;
            }else if(mid<n-1 && nums[mid]==nums[mid+1]){
                if(mid%2==0){
                    start=mid+1;
                }else end=mid-1;
            }else if(mid==0 && mid<n-1 ){
                if(nums[mid+1]==nums[mid])
                    start=mid+1;
                else return nums[mid];
            }else if(mid==n-1 && mid-1>0){
                if(nums[mid-1]==nums[mid])
                    end=mid-1;
                else return nums[mid];
            }

            // System.out.println(start+" "+mid+" "+end);
        }

        return nums[start];
    }
}
```

### Problem: [single element in a sorted array](https://leetcode.com/problems/single-element-in-a-sorted-array/)

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int ans=nums[0];
        for(int i=1;i<n;i++){
            ans^=nums[i];
        }

        return ans;
    }
}
```

### Problem: [search a 2d matrix](https://leetcode.com/problems/search-a-2d-matrix/)

```java
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m=mat.length;
        int n=mat[0].length;
        int start=0,end=m-1; 
     
        while(start<=end){
            int mid=(start+end)/2;
            if(target<mat[mid][0])
                end=mid-1;
            else if(mid+1<m && target>=mat[mid+1][0])
                start=mid+1;
            else{

                int row=mid;
                start=0; end=n-1; 
                while(start<=end){
                    mid=(start+end)/2;

                    if(mat[row][mid]==target)
                        return true;
                    else if(mat[row][mid]>target)
                        end=mid-1;
                    else start=mid+1;
                }
                return false;
            }
        }
        return false;
    }
}
```

### Problem: [search a 2d matrix](https://leetcode.com/problems/search-a-2d-matrix/)

```java
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m=mat.length;
        int n=mat[0].length;
        int start=0,end=m-1; 
     
        while(start<=end){
            int mid=(start+end)/2;
            if(target<mat[mid][0])
                end=mid-1;
            else if(mid+1<m && target>=mat[mid+1][0])
                start=mid+1;
            else{
                for(int i=0;i<n;i++){
                    if(mat[mid][i]==target)
                        return true;
                }
                return false;
            }
                // System.out.println(start+" "+mid+ " "+end);
        }
        return false;
    }
}
```

### Problem: [container with most water](https://leetcode.com/problems/container-with-most-water/)

```java
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int start=0;
        int end=n-1;
        int maxarea=0;
        int i=1; int j=1;
        while(start<end){
            int h=Math.min(height[start],height[end]);
            int area= (end-start)*h;
            maxarea=Math.max(area,maxarea);
            while(start<end && height[start]<=h)
                start++;
            while(start<end && height[end]<=h)
             end--;
        }

        return maxarea;
    }
}
```

### Problem: [container with most water](https://leetcode.com/problems/container-with-most-water/)

```java
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int start=0;
        int end=n-1;
        int maxarea=0;
        int i=1; int j=1;
        while(start<end){
            int area= (end-start)*Math.min(height[start],height[end]);
            maxarea=Math.max(area,maxarea);
            if(height[start]<height[end]){
                start++;
            }else end--;
        }

        return maxarea;
    }
}
```

### Problem: [kth largest element in an array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        for(int x: nums){
            pQueue.offer(x);
            if(pQueue.size()>k){
                pQueue.poll();
            }
        }

        return pQueue.poll();

    }
}
```