### Problem: [check if two chessboard squares have the same color](https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/)

```java
class Solution {
    public boolean checkTwoChessboards(String c1, String c2) {
        
        int a=c1.charAt(0) -'a';
        int b=c2.charAt(0) -'a';
        int c=c1.charAt(1) -'1';
        int d=c2.charAt(1) -'1';
        
        if(a%2==b%2){
                if(c%2==d%2)
                    return true;
                return false;
        }else{

            if(c%2!=d%2)
                    return true;
                return false;
        }
    }
}
```

### Problem: [find the key of the numbers](https://leetcode.com/problems/find-the-key-of-the-numbers/)

```java
class Solution {
    public int generateKey(int num1, int num2, int num3) {
        
        int key=0;
        int power=1;
        for(int i=0;i<4;i++){
            int a= num1%10;
            int b= num2%10;
            int c= num3%10;
            
            num1/=10;
            num2/=10;
            num3/=10;
            
            key+= power* (Math.min(Math.min(a,b),c)) ;
            power*=10;
        }
        return key;
    }
}
```

### Problem: [check if two chessboard squares have the same color](https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/)

```java
class Solution {
    public boolean checkTwoChessboards(String c1, String c2) {
        
        int a=c1.charAt(0) -'a' +1;
        int b=c2.charAt(0) -'a' +1;
        int c=c1.charAt(1) -'1' +1;
        int d=c2.charAt(1) -'1' +1;
        
        if(a%2==b%2){
                if(c%2==d%2)
                    return true;
                return false;
        }else{

            if(c%2!=d%2)
                    return true;
                return false;
        }
    }
}
```

### Problem: [find the maximum achievable number](https://leetcode.com/problems/find-the-maximum-achievable-number/)

```java
class Solution {
    public int theMaximumAchievableX(int num, int t) {
        return num+ (t*2);
    }
}
```

### Problem: [count substrings that satisfy k constraint i](https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/)

```java
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int zero=0; int one=0;
            for(int j=i;j<n;j++){
                if(s.charAt(j)=='0') zero++;
                else one++;
                if(zero<=k || one<=k) ans++;
                else break;
            }
        }

        return ans;
    }
}
```

### Problem: [count substrings that satisfy k constraint i](https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/)

```java
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n=s.length();
        int ans=1;
        for(int i=0;i<n-1;i++){
            int zero=0; int one=0;
            for(int j=i;j<n;j++){
                if(s.charAt(j)=='0') zero++;
                else one++;
                if(zero<=k || one<=k) ans++;
                else break;
            }
        }
        return ans;
    }
}
```

### Problem: [remove nth node from end of list](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=new ListNode(0,head);
        ListNode fast=head;

        for(int i=0;i<n;i++)
            fast=fast.next; // move n time forward

        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if(slow.next==head){
            slow.next=slow.next.next;
            return slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
```

### Problem: [word break](https://leetcode.com/problems/word-break/)

```java
class Solution {
    boolean check(String s, int start, HashSet<String> set, HashMap<Integer, Boolean> dp) {
        if (start == s.length()) {
            return true;
        }
        if (dp.containsKey(start)) {
            return dp.get(start);
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && check(s, end, set, dp)) {
                dp.put(start, true);
                return true;
            }
        }
        
        dp.put(start, false);
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<Integer, Boolean> dp = new HashMap<>();
        return check(s, 0, set, dp);
    }
}
```

### Problem: [invert binary tree](https://leetcode.com/problems/invert-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;

        
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);

        root.left=right;
        root.right=left;
        return root;
    }
}
```

### Problem: [maximum depth of binary tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int helper(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(helper(node.left)+1, helper(node.right)+1);
    }
    public int maxDepth(TreeNode root) {
        return helper(root);
    }
}
```

### Problem: [snake in matrix](https://leetcode.com/problems/snake-in-matrix/)

```java
class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x=0;
        for(String s: commands){

            if(s.equals("UP")){
                x-=n;
            }else if(s.equals("RIGHT")){
                x+=1;

            }else if(s.equals("DOWN")){
                x+=n;
            }
            else if(s.equals("LEFT")){
                x+=-1;
            }
        }
        return x;
    }
}
```

### Problem: [longest palindromic substring](https://leetcode.com/problems/longest-palindromic-substring/)

```java
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <= s.length(); j++) {
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
```

### Problem: [longest substring without repeating characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int n=s.length();
        int maxlength=0;
        HashSet<Character> set = new HashSet();
        for(int right=0;right < n;right++ ){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlength= Math.max(maxlength,right-left+1);
        }
        return maxlength;
        
            }
           
        }
    
       
```

### Problem: [3sum](https://leetcode.com/problems/3sum/)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int p1=i+1;
            int p2=n-1;
            while(p1<p2){
                int sum=nums[i]+nums[p1]+nums[p2];
                if(sum==0){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[p1],nums[p2])));
                    p2--; p1++;

                    while(p1<p2 && nums[p1-1]==nums[p1]){
                    p1++;
                    }
                    while(p1<p2 && nums[p2]==nums[p2+1]){
                        p2--;
                    }
                }else if(sum>0){
                    p2--;
                }else
                    p1++;
            }
        }
        return ans;
    }
}
```

### Problem: [3sum](https://leetcode.com/problems/3sum/)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int p1=i+1;
            int p2=n-1;
            while(p1<p2){
                int sum=nums[i]+nums[p1]+nums[p2];
                if(sum==0){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[p1],nums[p2])));
                    p2--; p1++;
                }else if(sum>0){
                    p2--;
                }else
                    p1++;
            }
        }

        return new ArrayList<>(ans);
    }
}
```

### Problem: [3sum](https://leetcode.com/problems/3sum/)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int p1=i+1;
            int p2=n-1;
            while(p1<p2){
                int sum=nums[i]+nums[p1]+nums[p2];
                if(sum==0){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[p1],nums[p2])));
                    p2--;
                }else if(sum>0){
                    p2--;
                }else
                    p1++;
            }
        }

        return new ArrayList<>(ans);
    }
}
```

### Problem: [maximum subarray](https://leetcode.com/problems/maximum-subarray/)

```java
class Solution {
    public int maxSubArray(int[] nums) {
       
       int largest_sum=nums[0];
       int sum=nums[0];

       for(int i=1;i<nums.length;i++){

        sum = Math.max(sum+nums[i],nums[i]);
        largest_sum= Math.max(largest_sum,sum);
       }

       return largest_sum;
    }
}
```

### Problem: [find if digit game can be won](https://leetcode.com/problems/find-if-digit-game-can-be-won/)

```java
class Solution {
    public boolean canAliceWin(int[] nums) {
        int s=0,d=0;
        for(int i: nums){
            if(i>=0&&i<=9) s+=i;
            else d+=i;
        }
        if(s==d) return false;
        return  true;
    }
}
```

### Problem: [add two numbers](https://leetcode.com/problems/add-two-numbers/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode sum= new ListNode();
        ListNode ans=sum;
        int carry=0;
        while((l1!=null)  && (l2!=null)){
            int x= l1.val + l2.val+carry;
            ans.next=new ListNode(x%10);
            ans=ans.next;
            carry=x/10;
            l1=l1.next; l2=l2.next;
        }

        while(l1!=null){
            int x=l1.val+carry;
            ans.next= new ListNode(x%10);
            carry=x/10;
            l1=l1.next;ans=ans.next;
        }
        while(l2!=null){
            int x=l2.val+carry;
            ans.next= new ListNode(x%10);
            carry=x/10;
            l2=l2.next; ans=ans.next;
        }

        if(carry>0){
            ans.next= new ListNode(carry%10);
        }
        return sum.next;

    }
}
```

### Problem: [word break](https://leetcode.com/problems/word-break/)

```java
class Solution {
    boolean check(String s, int start, HashSet<String> set, HashMap<Integer, Boolean> dp) {
        if (start == s.length()) {
            return true;
        }
        if (dp.containsKey(start)) {
            return dp.get(start);
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && check(s, end, set, dp)) {
                dp.put(start, true);
                return true;
            }
        }
        
        dp.put(start, false);
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<Integer, Boolean> dp = new HashMap<>();
        return check(s, 0, set, dp);
    }
}
```

### Problem: [find the original array of prefix xor](https://leetcode.com/problems/find-the-original-array-of-prefix-xor/)

```java
class Solution {
    public int[] findArray(int[] pref) {
        // int n=pref.length;
        // int ans[] = new int[n];
        // ans[0]=pref[0];
        // for(int i=1;i<n;i++){
        //     ans[i]= pref[i]^pref[i-1];
        // }
        // return ans;

        for(int i = pref.length - 1; i > 0; i--) {
            pref[i] = pref[i] ^ pref[i - 1];
        }
        return pref;
    }
}
```

### Problem: [find the original array of prefix xor](https://leetcode.com/problems/find-the-original-array-of-prefix-xor/)

```java
class Solution {
    public int[] findArray(int[] pref) {
        int n=pref.length;
        int ans[] = new int[n];
        ans[0]=pref[0];
        for(int i=1;i<n;i++){
            ans[i]= pref[i]^pref[i-1];
        }
        return ans;
    }
}
```

### Problem: [minimum flips to make a or b equal to c](https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/)

```java
class Solution {
    public int minFlips(int a, int b, int c) {
        
        int count=0;
        while(a > 0 || b > 0 || c > 0){
            int lastc=c&1;
            int lasta=a&1;
            int lastb=b&1;
            System.out.println(lastc+" "+lasta+" "+lastb);
            if(lastc==1){
                if(lasta==0 && lastb==0)
                    count++;
            }else{
                if(lasta!=lastb)
                    count++;
                else if(lasta==1) count+=2;
            }
            c=c>>1;
            a=a>>1;
            b=b>>1;
        }

        return count;
    }
}
```

### Problem: [invert binary tree](https://leetcode.com/problems/invert-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;

        
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);

        root.left=right;
        root.right=left;
        return root;
    }
}
```

### Problem: [kth smallest element in a bst](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    void helper(TreeNode temp, int k, Stack<Integer> s){
        if(temp==null){
            return;
        }

        helper(temp.left,k,s);
        if(s.size()==k){
            return;
        }
        s.push(temp.val);
        helper(temp.right,k,s);
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> s= new Stack<>();
        helper(root,k,s);
        return s.peek();
    }
}
```

### Problem: [kth smallest element in a bst](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    void helper(TreeNode temp, int k, Stack<Integer> s){
        if(temp==null || s.size()==k){
            return;
        }

        helper(temp.left,k,s);
        if(s.size()==k){
            return;
        }
        s.push(temp.val);
        helper(temp.right,k,s);
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> s= new Stack<>();

        helper(root,k,s);
        return s.peek();
    }
}
```

### Problem: [number of bit changes to make two integers equal](https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/)

```java
class Solution {
    public int minChanges(int n, int k) {
      if((n&k)!=k)
        return -1;
            
      int x= (k^n);

      int oneBitsCount = Integer.bitCount(x);
      return oneBitsCount;

    }
}
```

### Problem: [vowels game in a string](https://leetcode.com/problems/vowels-game-in-a-string/)

```java
class Solution {
    public boolean doesAliceWin(String s) {

        for(char c: s.toCharArray()){
            if(c=='a'|| c=='e'||c=='i'|| c=='o'||c=='u')
                return true;
        }
        return false;
    }
}
```

### Problem: [course schedule](https://leetcode.com/problems/course-schedule/)

```java
class Solution {

    boolean checkcycle(HashMap<Integer, ArrayList<Integer>> adj,HashSet<Integer> visit,HashSet<Integer> dfs,int i){
        if(dfs.contains(i))
            return true;

        if(visit.contains(i))
            return false;

        visit.add(i); dfs.add(i);
        boolean flag=false;
        if(adj.containsKey(i)){
            for(int x: adj.get(i)){
                flag|=checkcycle(adj,visit,dfs,x);
            }
        }

        dfs.remove(i);
        return flag;
        
    }

    public boolean canFinish(int n, int[][] prereq) {
        int m=prereq.length;
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for (int i = 0; i < m; i++) {
            adj.putIfAbsent(prereq[i][0], new ArrayList<>());
            adj.get(prereq[i][0]).add(prereq[i][1]);
            // System.out.println(prereq[i][0]);
        }

        HashSet<Integer> visit= new HashSet<Integer>();
        HashSet<Integer> dfs= new HashSet<Integer>();

        for (int i=0;i<n;i++)  {
            if(!visit.contains(i) && checkcycle(adj,visit,dfs,i)){
                return false;
            }
        }
        return true;
    }
}
```

### Problem: [subarray sum equals k](https://leetcode.com/problems/subarray-sum-equals-k/)

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; 
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1); 
            }
        
        return count;
    }
}
```

### Problem: [invert binary tree](https://leetcode.com/problems/invert-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;

        
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);

        root.left=right;
        root.right=left;
        return root;
    }
}
```

### Problem: [invert binary tree](https://leetcode.com/problems/invert-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode x= q.poll();
            if(x.right!=null) q.offer(x.right);
            if(x.left!=null) q.offer(x.left);
            TreeNode temp=x.right!=null? x.right:null;
            x.right=x.left!=null?x.left:null;
            x.left=temp;
        }
        return root;
    }
}
```

### Problem: [remove nth node from end of list](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=new ListNode(0,head);
        ListNode fast=head;

        for(int i=0;i<n;i++)
            fast=fast.next; // move n time forward

        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if(slow.next==head){
            slow.next=slow.next.next;
            return slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
```

### Problem: [remove nth node from end of list](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=new ListNode(0,head);
        ListNode fast=head;

        for(int i=0;i<n;i++)
            fast=fast.next; // move n time forward

        
        System.out.println(fast==null);
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if(slow.next==head){
            slow.next=slow.next.next;
            return slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
```

### Problem: [unique paths](https://leetcode.com/problems/unique-paths/)

```java
class Solution {
    int helper(int m,int n,int i, int j,int[][] dp){
        if(i==m && j==n)
            return 1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=0;
        if(i+1<=m){
            ans+=helper(m,n,i+1,j,dp);
        }
        if(j+1<=n){
            ans+=helper(m,n,i,j+1,dp);
        }

        return dp[i][j]=ans;
    }
    public int uniquePaths(int m, int n) {
        
        // down or right
        // down is [m+1][n]
        // right is [m][n+1]
        int[][] dp= new int[m][n];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        return helper(m-1,n-1,0,0,dp);
    }
}

```

### Problem: [add two numbers](https://leetcode.com/problems/add-two-numbers/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode sum= new ListNode();
        ListNode ans=sum;
        int carry=0;
        while((l1!=null)  && (l2!=null)){
            int x= l1.val + l2.val+carry;
            ans.next=new ListNode(x%10);
            ans=ans.next;
            carry=x/10;
            l1=l1.next; l2=l2.next;
        }

        while(l1!=null){
            int x=l1.val+carry;
            ans.next= new ListNode(x%10);
            carry=x/10;
            l1=l1.next;ans=ans.next;
        }
        while(l2!=null){
            int x=l2.val+carry;
            ans.next= new ListNode(x%10);
            carry=x/10;
            l2=l2.next; ans=ans.next;
        }

        if(carry>0){
            ans.next= new ListNode(carry%10);
        }
        return sum.next;

    }
}
```

### Problem: [add two numbers](https://leetcode.com/problems/add-two-numbers/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode sum= new ListNode();
        ListNode ans=sum;
        int carry=0;
        while((l1!=null)  && (l2!=null)){
            int x= l1.val + l2.val+carry;
            ans.next=new ListNode(x%10);
            ans=ans.next;
            carry=x/10;
            l1=l1.next; l2=l2.next;
        }

        while(l1!=null){
            int x=l1.val+carry;
            ans.next= new ListNode(x%10);
            carry=x/10;
            l1=l1.next;ans=ans.next;
        }
        while(l2!=null){
            int x=l2.val+carry;
            ans.next= new ListNode(x%10);
            carry=x/10;
            l2=l2.next; ans=ans.next;
        }

        while(carry!=0){
            int x=carry;
            ans.next= new ListNode(x%10);
            carry=x/10;
            ans=ans.next;
        }
        return sum.next;

    }
}
```

### Problem: [linked list cycle](https://leetcode.com/problems/linked-list-cycle/)

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;


        while(fast!=null && fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;

        }
        return false;
    }
}
```

### Problem: [linked list cycle](https://leetcode.com/problems/linked-list-cycle/)

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;


        while(fast!=null && fast.next!=null ){

            slow=slow.next;
            if(fast!=null && fast.next!=null)
            fast=fast.next.next;
            else return false;

            if(slow==fast)
                return true;

        }
        return false;
    }
}
```

### Problem: [longest common prefix](https://leetcode.com/problems/longest-common-prefix/)

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder s= new StringBuilder();
        int n=strs.length;
        char last=' ';
        int j=0;
       while(j<strs[0].length()){
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(i==0)
                    last=strs[i].charAt(j); 
                else
                    if(strs[i].length()<=j || strs[i].charAt(j)!=last){
                        flag=false;
                        break;
                    }
            }

            if(!flag) 
                return s.toString();
            else s.append(last);

            j++;
       }
       return s.toString();
    }
}
```

### Problem: [maximal rectangle](https://leetcode.com/problems/maximal-rectangle/)

```java
class Solution {

    public int largestRectangleArea(int[] heights) {
        // lowest element to the left of all
        int n= heights.length;
        Stack<Integer> s= new Stack<>();
        int[] left= new int[n]; // smaller to the left
        Arrays.fill(left,-1);
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(!s.isEmpty()) left[i]=s.peek()+1;
            s.push(i);
        }

        s= new Stack<>();
        int[] right= new int[n]; // smaller to the right
        Arrays.fill(right,-1);
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(!s.isEmpty()) right[i]=s.peek()-1;
            s.push(i);
        }

        int maxarea=heights[0];
        for(int i=0;i<n;i++){
            int l = left[i]==-1?0:left[i];
            int r = right[i]==-1?n-1:right[i];
            maxarea= Math.max(maxarea, heights[i]*(r-l+1));
        }
        
        return maxarea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length; //row
        int m=matrix[0].length; //column
        int arr[] = new int[m];
        int ans=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1')
                    arr[j]+=1;
                else arr[j]=0;
            }
        ans=Math.max(ans,largestRectangleArea(arr));
        }
        return ans;
    }
}
```

### Problem: [delete nodes from linked list present in array](https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set= new HashSet<>();

        for(int i:nums) set.add(i);

        ListNode x=new ListNode(0,head);
        ListNode temp=x;
        while(temp.next!=null){
            if(set.contains(temp.next.val)){
                temp.next=temp.next.next;
            }else
                temp=temp.next;
        }

        return x.next;
        
    }
}
```

### Problem: [delete nodes from linked list present in array](https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set= new HashSet<>();

        for(int i:nums) set.add(i);

        ListNode tempHead= new ListNode(0);
        tempHead.next=head;

        ListNode prev=tempHead;
        ListNode current=head;

        while(current!=null){

            if(set.contains(current.val)){
                prev.next=current.next;
            }else{
                prev=current;
            }
            current=current.next;
        }
        return tempHead.next;
    }
}
```

### Problem: [lexicographically smallest string after a swap](https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/)

```java
class Solution {
    public String getSmallestString(String s) {
        boolean parity=(s.charAt(0)-'0')%2==0?true:false;
        for(int i=1;i<s.length();i++){
            boolean newparity=(s.charAt(i)-'0')%2==0?true:false;
            if(parity==newparity && (s.charAt(i-1)-'0')>(s.charAt(i)-'0')){
                StringBuilder sb = new StringBuilder(s);
                char temp = sb.charAt(i-1);
                sb.setCharAt(i-1, sb.charAt(i));
                sb.setCharAt(i, temp);
                return sb.toString();
            }
            parity=newparity;
        }
        return s;

    }
}
```

### Problem: [number of provinces](https://leetcode.com/problems/number-of-provinces/)

```java
class Solution {

    void dfs(int[] visited, int i,int[][] isConnected){
        visited[i]=1;
        for(int j=0;j<visited.length;j++){
            if(isConnected[i][j]==1 && visited[j]==0){
                dfs(visited,j,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       
        int m=isConnected.length;
        int n= isConnected[0].length;
        int[] visited= new int[n];
        int count=0;
        for(int i=0;i<m;i++)
            if(visited[i]==0){
                dfs(visited,i,isConnected);
                count++;
            }

        return count;
            
                
    }
}
```

### Problem: [trapping rain water](https://leetcode.com/problems/trapping-rain-water/)

```java
class Solution {
    public int trap(int[] height) {
        // need greatest element to the left and right of each element
        int n=height.length;
        if(n<2) return 0;
        int[] left= new int[n];
        left[0]=-1;
        for(int i=1;i<n;i++){
            if(height[i-1]>left[i-1]){
                left[i]=height[i-1];
            }else left[i]=left[i-1];
        }

        int[] right= new int[n];
        right[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            if(height[i+1]>right[i+1]){
                right[i]=height[i+1];
            }else right[i]=right[i+1];
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        // now i want to add up the area till i find any index whose 

        int maxarea=0;
        int area=0;
        int x= Math.min(left[1],right[1]);
        for(int i=1;i<n-1;i++){
            x= Math.min(left[i],right[i]);
            // System.out.println(x+" "+area+" "+left[i]+" "+right[i]);
            if(x<=height[i]){
                maxarea=Math.max(maxarea,area);
                continue;
            }
            area+= (x-height[i]);
        }
        return area;
    }
}
```

### Problem: [count submatrices with equal frequency of x and y](https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/)

```java
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        int[][][] count= new int[m][n][2]; // count occurence of x,y in each prefix sum  
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[j][i]=='X')
                    count[j][i][0]++;
                if(grid[j][i]=='Y')
                    count[j][i][1]++;
                
                if(j>0){
                    count[j][i][0]+=count[j-1][i][0];
                    count[j][i][1]+=count[j-1][i][1];
                }

                if(i>0){
                count[j][i][0]+=count[j][i-1][0];
                count[j][i][1]+=count[j][i-1][1];
                }
                
                if(i>0 && j>0){
                    count[j][i][0]-=count[j-1][i-1][0];
                    count[j][i][1]-=count[j-1][i-1][1];
                }
                 if(count[j][i][0]>0 && count[j][i][0]==count[j][i][1])
                    ans++;

            }
        }
        return ans;
    }
    
}
```

### Problem: [count submatrices with equal frequency of x and y](https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/)

```java
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] count= new int[m][n][2]; // count occurence of x,y in each prefix sum  
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[j][i]=='X')
                    count[j][i][0]++;
                if(grid[j][i]=='Y')
                    count[j][i][1]++;
                
                if(j>0){
                    count[j][i][0]+=count[j-1][i][0];
                    count[j][i][1]+=count[j-1][i][1];
                }

            }
        }

        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j>0){
                count[i][j][0]+=count[i][j-1][0];
                count[i][j][1]+=count[i][j-1][1];
                }

                if(count[i][j][0]>0 && count[i][j][0]==count[i][j][1])
                    ans++;
            }
        }
        return ans;
    }
    
}
```

### Problem: [partition equal subset sum](https://leetcode.com/problems/partition-equal-subset-sum/)

```java
class Solution {
    static Boolean helper(int[] arr, int n,int sum,Boolean[][] dp){
        if(sum==0)
            return true;
        if(n==0){
            return false;
        }
        
        if(dp[n][sum]!=null)
            return dp[n][sum];
        
        Boolean notpick= helper(arr,n-1,sum,dp);
        Boolean pick= false;
        if(arr[n-1]<=sum) {
           pick=helper(arr,n-1,sum-arr[n-1],dp);
        }
        return dp[n][sum]=pick||notpick;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums) sum+=i;

        if(sum%2==1) return false;
        int n= nums.length;
        sum/=2;
        Boolean[][] dp = new Boolean[n+1][sum+1];
        for(Boolean[] d:dp) Arrays.fill(d,null);
        return helper(nums,n,sum,dp);
    }
}
```

### Problem: [valid parentheses](https://leetcode.com/problems/valid-parentheses/)

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                } else if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}

```

### Problem: [alternating groups i](https://leetcode.com/problems/alternating-groups-i/)

```java
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int ans=0;
        int n=colors.length;
        for(int i=0;i<n;i++){
            if(colors[i%n]!=colors[(i+1)%n] && colors[i%n]==colors[(i+2)%n]) 
                ans++;
        }
        return ans;
    }
}
```

### Problem: [generate binary strings without adjacent zeros](https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/)

```java
class Solution {
    
    void helper(List<String> ans,int n,StringBuilder s){
        if(n==0){
            ans.add(s.toString());
            return;
        }
        if(s.length()<1 || s.charAt(s.length()-1)!='0'){
            s.append('0');
            helper(ans,n-1,s); 
            s.setLength(s.length() - 1);
        }
        s.append('1');
        helper(ans,n-1,s);
        s.setLength(s.length() - 1);
        
    }
    
        
    public List<String> validStrings(int n) {
        
        List<String> ans= new ArrayList<String>();
        helper(ans,n,new StringBuilder());
        return ans;
    }
}
```

### Problem: [find the encrypted string](https://leetcode.com/problems/find-the-encrypted-string/)

```java
class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder ans= new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            ans.append(s.charAt((i+k)%n));
        }
        return ans.toString();
    }
}
```

### Problem: [alternating groups ii](https://leetcode.com/problems/alternating-groups-ii/)

```java
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int ans=0;
        int n=colors.length;
        int count=1;
        // this n+k-2 is because
        // for the n-1 we need to check for k-1 more element
        for(int i=0;i<n+k-2;i++){
            // sliding window 
            // of k set is valid for (i,j) then check for (i+1,j+1) 
            if(colors[i%n]!=colors[(i+1)%n]) count++;
            else count=1;
            if(count>=k) ans++;
        }
        return ans;
    }
}
```

### Problem: [alternating groups ii](https://leetcode.com/problems/alternating-groups-ii/)

```java
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int ans=0;
        int n=colors.length;
        int count=1;
        for(int i=0;i<n+k-2;i++){
            // sliding window 
            // of k set is valid for (i,j) then check for (i+1,j+1) 
            if(colors[i%n]!=colors[(i+1)%n]) count++;
            else count=1;
            if(count>=k) ans++;
        }
        return ans;
    }
}
```

### Problem: [alternating groups i](https://leetcode.com/problems/alternating-groups-i/)

```java
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int ans=0;
        int n=colors.length;
        int i=0;
        do{
            if(colors[i]!=colors[(i+1)%n] && colors[i]==colors[(i+2)%n]) 
                ans++;
           // System.out.println(colors[i]+" "+colors[(i+1)%n]+" "+colors[(i+2)%n]+" "+i);
            i= (i+1)%n;
        }while(i!=0);
        return ans;
    }
}
```

### Problem: [maximum points after enemy battles](https://leetcode.com/problems/maximum-points-after-enemy-battles/)

```java
class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        int ind=0;
        int n=enemyEnergies.length;
        for(int i=1;i<n;i++){
            if(enemyEnergies[i]<enemyEnergies[ind]){
                ind=i;
            }
        }   
        if(enemyEnergies[ind]>currentEnergy) return 0;
        long total=currentEnergy;
        for(int i=0;i<n;i++){
            if(i==ind) continue;
            total+=enemyEnergies[i];
        }
        // System.out.println(total+" "+ind);
        return (long)(total/enemyEnergies[ind]);
    }
}
```

### Problem: [largest rectangle in histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        // lowest element to the left of all
        int n= heights.length;
        Stack<Integer> s= new Stack<>();
        int[] left= new int[n]; // smaller to the left
        Arrays.fill(left,-1);
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(!s.isEmpty()) left[i]=s.peek()+1;
            s.push(i);
        }

        s= new Stack<>();
        int[] right= new int[n]; // smaller to the right
        Arrays.fill(right,-1);
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(!s.isEmpty()) right[i]=s.peek()-1;
            s.push(i);
        }

        int maxarea=heights[0];
        for(int i=0;i<n;i++){
            int l = left[i]==-1?0:left[i];
            int r = right[i]==-1?n-1:right[i];
            maxarea= Math.max(maxarea, heights[i]*(r-l+1));
        }
        
        return maxarea;
    }
}
```

### Problem: [largest rectangle in histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        // lowest element to the left of all
        int n= heights.length;
        Stack<Integer> s= new Stack<>();
        int[] left= new int[n]; // smaller to the left
        Arrays.fill(left,-1);
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(!s.isEmpty()) left[i]=s.peek()+1;
            s.push(i);
        }

        s= new Stack<>();
        int[] right= new int[n]; // smaller to the right
        Arrays.fill(right,-1);
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(!s.isEmpty()) right[i]=s.peek()-1;
            s.push(i);
        }

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int maxarea=heights[0];
        for(int i=0;i<n;i++){
            int l = left[i]==-1?0:left[i];
            int r = right[i]==-1?n-1:right[i];
            maxarea= Math.max(maxarea, heights[i]*(r-l+1));
        }


        return maxarea;
    }
}
```

### Problem: [next greater element i](https://leetcode.com/problems/next-greater-element-i/)

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m=nums1.length; int n=nums2.length;
        int[] ans = new int[m];
        
        HashMap<Integer,Integer> ht = new HashMap<>();

        for(int i=0;i<m;i++){
            ht.put(nums1[i],-1);
        }
        Stack<Integer> s = new Stack<>();

        for(int i=n-1;i>=0;i--){
            
            while(!s.isEmpty() && s.peek()<=nums2[i]){
                s.pop();
            }

            if(!s.isEmpty() && ht.containsKey(nums2[i])){
                ht.put(nums2[i],s.peek());
            } 
            s.push(nums2[i]);
        }

        for(int i=0;i<m;i++){
            ans[i]=ht.get(nums1[i]);

        }

        return ans;
    }
}
```

### Problem: [binary tree zigzag level order traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
        helper(result,0,root);
        return result;
    }
    // for better understanding create a recursion tree. (kinda love the intuition)
    void helper(List<List<Integer>> result, int level,TreeNode temp){
        if(temp==null){
            return;
        }

        // for first call of every level add the list
        // this statement will be excuted first and is capabale to 
        // create list in the correct sequence thanks to recursion
        if(level==result.size()){
            result.add(new ArrayList<Integer>());
        }

        // add the value to result at the current level.
        if(level%2==0){
        result.get(level).add(temp.val);
        }else{
            result.get(level).addFirst(temp.val);
        }
        helper(result,level+1,temp.left);
        helper(result,level+1,temp.right);
    }
}
```

### Problem: [maximum height of a triangle](https://leetcode.com/problems/maximum-height-of-a-triangle/)

```java
class Solution {

    int helper(int red, int blue, int ans,int last){
        if((last==1 && red<ans) || (last==0 && blue<ans))
            return ans-1;

        if(last==1)
            return helper(red-ans,blue,ans+1,0);
        else
            return helper(red,blue-ans,ans+1,1);
       
    }
    public int maxHeightOfTriangle(int red, int blue) {
        // 0 red 1 blue
        return Math.max(helper(red,blue,1,1),helper(red,blue,1,0));
    }
}
```

### Problem: [maximum height of a triangle](https://leetcode.com/problems/maximum-height-of-a-triangle/)

```java
class Solution {

    int helper(int red, int blue, int ans,int last){
        System.out.println((last==0?"red":"blue")+" "+ans+" "+red+" "+blue);
        if((last==1 && red<ans) || (last==0 && blue<ans))
            return ans-1;

        if(last==1)
            return helper(red-ans,blue,ans+1,0);
        else
            return helper(red,blue-ans,ans+1,1);
       
    }
    public int maxHeightOfTriangle(int red, int blue) {
        // 0 red 1 blue
        return Math.max(helper(red,blue,1,1),helper(red,blue,1,0));
    }
}
```

### Problem: [merge intervals](https://leetcode.com/problems/merge-intervals/)

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        int n= intervals.length;
        int prev1=intervals[0][0];
        int prev2=intervals[0][1];
        ans.add(new int[]{prev1,prev2});
        for(int i=1;i<n;i++){
            int index=ans.size()-1;
            int[] arr=ans.get(index);
            
            if(intervals[i][0]>arr[1]){
                ans.add(intervals[i]);
            }else{
                if(intervals[i][1]>arr[1])
                    ans.set(index,new int[]{arr[0],intervals[i][1]});
            }
        } 
        
        int[][] ansArr = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++)
            ansArr[i] = ans.get(i);

        return ansArr;
    }
}
```

### Problem: [merge intervals](https://leetcode.com/problems/merge-intervals/)

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ans = new ArrayList<>();

        int n= intervals.length;
        int prev1=intervals[0][0];
        int prev2=intervals[0][1];
        ans.add(new int[]{prev1,prev2});
        for(int i=1;i<n;i++){
            int index=ans.size()-1;
            int[] arr=ans.get(index);
            
            if(intervals[i][0]>arr[1]){
                ans.add(intervals[i]);
            }else{
                ans.set(index,new int[]{arr[0],Math.max(intervals[i][1],arr[1])});
            }


        } 
        
        int[][] ansArr = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++)
            ansArr[i] = ans.get(i);

        return ansArr;
    }
}
```

### Problem: [next greater element ii](https://leetcode.com/problems/next-greater-element-ii/)

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int n=nums.length;
        for(int i=1;i<=n;i++){
            map.put(i,nums[i-1]);
        }

        int[] ans= new int[n];
        Arrays.fill(ans,-1);

        for(int i=0;i<n;i++){

            int j=(i+1)%n;
            while(j!=i){
                if(nums[j]>nums[i]){
                    ans[i]=nums[j];
                    break;
                }

                j= (j+1)%n;
            }
        }
        return ans;
    }
}
```

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
           }
           
        }

        return root;
    }
}
```

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

### Problem: [generate parentheses](https://leetcode.com/problems/generate-parentheses/)

```java
class Solution {
    void helper(List<String> ans, int open,int close,StringBuilder bal){
        if(close==0){
            ans.add(bal.toString());
            return;
        }

        if(open<close){
            helper(ans,open,close-1,bal.append(")"));
            bal.setLength(bal.length() - 1);
        }
        if(open>0){
            helper(ans,open-1,close,bal.append("("));
            bal.setLength(bal.length() - 1);
        }


    }
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        helper(ans,n,n,new StringBuilder(""));
        return ans;
    }
}
```

### Problem: [generate parentheses](https://leetcode.com/problems/generate-parentheses/)

```java
class Solution {
    void helper(List<String> ans, int open,int close,String bal){
        if(close==0){
            ans.add(bal);
            return;
        }

        if(open<close){
            helper(ans,open,close-1,bal+")");
        }
        if(open>0)
            helper(ans,open-1,close,bal+"(");


    }
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        helper(ans,n,n,"");
        return ans;
    }
}
```

### Problem: [letter case permutation](https://leetcode.com/problems/letter-case-permutation/)

```java
class Solution {
    void helper(List<String> ans,String out, String in, int i){
        if(i==in.length()){
            ans.add(out);
            return;
        }


        if(in.charAt(i)>='0' && in.charAt(i)<='9'){
            helper(ans,out+""+in.charAt(i),in,i+1); // not take in case of digit
        }
        else{
            //not take
               char ch=in.charAt(i);
                helper(ans,out+""+ch,in,i+1);

            // take
                if(in.charAt(i)>='a' && in.charAt(i)<='z'){
                    ch-=32;
                    helper(ans,out+""+ch,in,i+1);
                }
                if(in.charAt(i)>='A' && in.charAt(i)<='Z'){
                    ch+=32;
                    helper(ans,out+""+ch,in,i+1);}
        }
        
    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans= new ArrayList<>();
        helper(ans,"",s,0);
        return ans;
    }
}
```

### Problem: [find the n th value after k seconds](https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/)

```java
class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int MOD = 1000000007;
        int[] cur=new int[n];
        Arrays.fill(cur,1);
        for(int j=0;j<k;j++){
            cur[0]=1;
            for(int i=1;i<n;i++)
                cur[i]=(cur[i-1]+cur[i])%MOD;
        }
        return cur[n-1]%MOD;
        
    }
}
```

### Problem: [find the n th value after k seconds](https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/)

```java
class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int MOD = 1000000007;
        int[] cur=new int[n];
        Arrays.fill(cur,1);
        for(int j=0;j<k;j++){
            cur[0]=1;
            for(int i=1;i<n;i++)
                cur[i]=(cur[i-1]+cur[i])%MOD;
        }
        return cur[n-1]%MOD;
        
    }
}
```

### Problem: [find the n th value after k seconds](https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/)

```java
class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int MOD = 1000000007;
        int[] prev=new int[n];
        Arrays.fill(prev,1);
        for(int j=0;j<k;j++){
            int[] cur=new int[n];
            cur[0]=1;
            for(int i=1;i<n;i++)
                cur[i]=(cur[i-1]+prev[i])%MOD;
            prev=cur;
        }
        return prev[n-1]%MOD;
        
    }
}
```

### Problem: [find the child who has the ball after k seconds](https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/)

```java
class Solution {
    public int numberOfChild(int n, int k) {
        int i=0;
        boolean pass=true;
        int sec=1;
        while(sec<=k){

            
            if(pass){
                i++;
                if(i==n-1) pass=false;
            }else{
                i--;
                if(i==0)
                    pass=true;
            }
            sec++;
            // System.out.println("i: "+i);
            // System.out.println("k: "+k);
            
        }
        
        return i;
    }
}
```

### Problem: [find the first player to win k games in a row](https://leetcode.com/problems/find-the-first-player-to-win-k-games-in-a-row/)

```java
class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = skills.length;
        int row = 0;
        int index = -1;
        int prev = -1;

        for (int i = 0; i < n; i++) {
            dq.offer(i);
        }
        
        // k%=n;
        // System.out.println(k);
        int j=0;
        while (j <n) {
            int first = dq.poll();
            int second = dq.poll();

            if (skills[first] < skills[second]) {
                dq.offer(first);  
                dq.addFirst(second);  
                index = second;
            } else {
                dq.offer(second);  
                dq.addFirst(first);  
                index = first;
            }

            // System.out.println(index + " " + prev);

            if (prev == -1 || index == prev)
                row++;
            else
                row = 1;

            prev = index;
            j++;
            
            if(row==k)
                break;
        }

        return dq.peek();
    }
}

```

### Problem: [clear digits](https://leetcode.com/problems/clear-digits/)

```java
class Solution {
    public String clearDigits(String s) {
    StringBuilder sb = new StringBuilder(s);
    Stack<Integer> ind = new Stack<>();
    int n = sb.length();

    for (int i = 0; i < n; i++) {
        if (sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') {
            ind.push(i);
        } else {
            sb.deleteCharAt(i);
            i--; 
            n--;
            // System.out.println(ind.peek()+ " "+i+" "+n);
            if(!ind.isEmpty()) {
                // System.out.println(ind.peek()+ " "+i);
                sb.deleteCharAt(ind.pop());
                n--;
                i--; 
            }
        }
        
    }

    return sb.toString();
    }
}
```

### Problem: [top k frequent elements](https://leetcode.com/problems/top-k-frequent-elements/)

```java
class Solution {
    class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();

        for(int x:nums){

            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else
                map.put(x,1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(Pair::getFirst));

        for( Map.Entry<Integer,Integer> entry : map.entrySet()){
            
            minHeap.offer(new Pair(entry.getValue(),entry.getKey()));

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] ans= new int[k];
        int i=0;
        for(Pair p: minHeap){
            ans[i++]=p.second;
        }
        return ans;
    }
}
```

### Problem: [count days without meetings](https://leetcode.com/problems/count-days-without-meetings/)

```java
class Solution {
    public int countDays(int days, int[][] meets) {
        Arrays.sort(meets,(a,b)->a[0]-b[0]);
        int n=meets.length;
        int count=0;
        int j=0; int i=1;
        while(i<=days){
            // System.out.println(i);
            
            if(j<meets.length && i>=meets[j][0]){
                    if(i<=meets[j][1])
                     i=meets[j][1]+1;
                j++;
                continue;
            }
            i++;
            count++;
        }
        return count;
    }
}
```

### Problem: [minimum number of chairs in a waiting room](https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/)

```java
class Solution {
    public int minimumChairs(String s) {
        
        int n=s.length();
        int max=0;
        int count=0;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='E')
                count++;
            else
                count--;

            max=Math.max(count,max);
            
        }
        return max;

    }
}
```

### Problem: [spiral matrix](https://leetcode.com/problems/spiral-matrix/)

```java
class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        
        List<Integer> ans = new ArrayList<>();

        int row=mat[0].length;
        int col=mat.length;

        int top,bottom, down, up;

        top=0;
        down=row-1;
        bottom=col-1;
        up=0;
        while(top<=bottom && up<=down){

            for(int i=up;i<=down;i++){
                ans.add(mat[top][i]);
                System.out.println(mat[top][i] +"top "+ top +" "+i);
            }
            top++;
            System.out.println("new top "+top);
            for(int i=top;i<=bottom;i++){
                ans.add(mat[i][down]);
                System.out.println(mat[i][down]+"down "+down+" "+i);
            }
            down--;
            System.out.println("new down "+down);
            if(bottom<top)
                break;
            for(int i=down;i>=up;i--){
                ans.add(mat[bottom][i]);
                System.out.println(mat[bottom][i]+"bottom "+bottom+" "+i);
            }
            bottom--;
            System.out.println("new bottom "+bottom);
            if(up>down)
                break;
            for(int i=bottom;i>=top;i--){
                ans.add(mat[i][up]);
                System.out.println(mat[i][up]+"up "+up+" "+i);
            }
            up++;
            System.out.println("new up "+up);
        } 
        
        return ans;
    }
}
```

### Problem: [middle of the linked list](https://leetcode.com/problems/middle-of-the-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        if(head.next==null)
            return head;

        ListNode slow,fast;
        slow=head;
        fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}
```

### Problem: [3sum](https://leetcode.com/problems/3sum/)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-2;i++){

            if(i!=0 && nums[i]==nums[i-1]) continue;
            int start=i+1;
            int end=n-1;
            int first=nums[i];
            while(start<end){
                int total=first+nums[start]+nums[end];

                if(total==0){
                    ans.add(new ArrayList<>(
                        Arrays.asList(first,nums[start],nums[end])
                        ));
                    start++;
                    end--;
                    while(start<end && nums[start-1]==nums[start]){
                    start++;
                    }
                    while(start<end && nums[end]==nums[end+1]){
                        end--;
                    }

                }else if(total<0){
                    start++;
                }else {
                    end--;
                }
            }
        }

        return ans;
    }
}
```

### Problem: [next permutation](https://leetcode.com/problems/next-permutation/)

```java
class Solution {

    void swap(int[] nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int[] nums,int i, int j){
        while(i<j){
            swap(nums,i,j);
            i++; j--;
        }
    }
   
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                    index=i-1;
                break;

            }
        }
        
        if(index==-1){
            reverse(nums,0,n-1);
            return;
        }
        int minIndex=-1;

        for(int i=n-1;i>index;i--){
            if(nums[index]<nums[i]){
                minIndex=i; break;
            }
        }
        
        swap(nums,index,minIndex);
        reverse(nums,index+1,n-1);

    }
}
```

### Problem: [next permutation](https://leetcode.com/problems/next-permutation/)

```java
class Solution {

    void swap(int[] nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int[] nums,int i, int j){
        while(i<j){
            swap(nums,i,j);
            i++; j--;
        }
    }
   
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                    index=i-1;
                break;

            }
        }
        
        if(index==-1){
            reverse(nums,0,n-1);
            return;
        }
        int minIndex=-1;

        for(int i=n-1;i>index;i--){
            if(nums[index]<nums[i]){
                minIndex=i; break;
            }
        }
        if(minIndex!=-1)
            swap(nums,index,minIndex);
        reverse(nums,index+1,n-1);

    }
}
```

### Problem: [next permutation](https://leetcode.com/problems/next-permutation/)

```java
class Solution {
   
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                    index=i-1;
                break;

            }
        }
        
        if(index==-1){
            Arrays.sort(nums);
            return;
        }
        
        int minIndex=index+1;
        for(int i=n-1;i>index;i--){
            if(nums[index]<nums[i] && nums[minIndex]>nums[i]){
                minIndex=i;
            }
        }
        int temp=nums[index];
        nums[index]=nums[minIndex];
        nums[minIndex]=temp;
        Arrays.sort(nums,index+1,n);

    }
}
```

### Problem: [string compression iii](https://leetcode.com/problems/string-compression-iii/)

```java
class Solution {
    public String compressedString(String word) {
        String comp="";
        int n=word.length();
        char prev= word.charAt(0);
        int t=1; // times

        
        for(int i=1;i<n;i++){
            char ch =word.charAt(i);
            if(ch==prev && t<9)
                t++;
            else{
                comp+= ""+t+prev;
                t=1;
            }
            prev=ch;
        }

        comp+=""+t+prev;
        return comp;
    }
}
```

### Problem: [find the number of good pairs i](https://leetcode.com/problems/find-the-number-of-good-pairs-i/)

```java
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;

        int gp=0;
        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){
                if(nums1[i]%(nums2[j]*k)==0) gp++;
            }
        }

        return gp;
    }
}
```

### Problem: [find the number of distinct colors among the balls](https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/)

```java
class Solution {
    public int[] queryResults(int limit, int[][] que) {

        // HashMap<Integer,Integer> ht = new HashMap<>();
        // HashMap<Integer,Integer> color = new HashMap<>();
        // int n= que.length;
        // int[] result = new int[n];
        // for(int i=0;i<n;i++){
        //     if(ht.containsKey(que[i][0])){

        //         if(color.getOrDefault(que[i][1], 0)==1)
        //             color.remove(que[i][1]);
        //         else
        //             color.put(que[i][1],color.get(que[i][1]-1));

        //         System.out.println("removed "+ht.get(que[i][0]));
        //     }
        //     color.put(que[i][1],color.getOrDefault(que[i][1], 0)+1);
        //     ht.put(que[i][0],que[i][1]);
        //     System.out.println(que[i][1] +" "+ color.size());
        //     result[i]=color.size();
        // }

        // return result;

        HashMap<Integer, Integer> ht = new HashMap<>();
        HashMap<Integer, Integer> color = new HashMap<>();
        int n = que.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int key = que[i][0];
            int value = que[i][1];

            if (ht.containsKey(key)) {
                int oldColor = ht.get(key);
                int oldColorCount = color.get(oldColor);

                if (oldColorCount == 1) {
                    color.remove(oldColor);
                } else {
                    color.put(oldColor, oldColorCount - 1);
                }

                // System.out.println("removed " + oldColor);
            }

            // Update the color map for the new value
            color.put(value, color.getOrDefault(value, 0) + 1);
            ht.put(key, value);

            // System.out.println(value + " " + color.size());
            result[i] = color.size();
        }

        return result;
    }
}
```

### Problem: [find the xor of numbers which appear twice](https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/)

```java
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer,Integer> ht = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(ht.containsKey(nums[i]))
                ht.put(nums[i],ht.get(nums[i])+1);
            else
                ht.put(nums[i],1);
        }

        int ans=0; int i=0;
        for(int x : ht.keySet()){
            // int a;
            if(ht.get(x)==2 && i==0){
                ans=x;
                i++;
                System.out.println("i1 "+ x);
            }else if(ht.get(x)==2){
                ans^=x;
                System.out.println("i "+ x);
            }
        }

        return ans;
    }
}
```

### Problem: [find occurrences of an element in an array](https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/)

```java
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] que, int x) {
        int n=nums.length;
        int j=1;
        int[] occ = new int[n+1];
        Arrays.fill(occ,-1);
        for(int i=0;i<n;i++){
            if(nums[i]==x){
                occ[j]=i;
                j++;
            }
        }
        System.out.println(Arrays.toString(occ));
        int m=que.length;
        int[] out = new int[m];
        for(int q=0;q<m;q++){
            if(que[q]>n || occ[que[q]]==-1){
                out[q]=-1;
            }else{
                out[q]=occ[que[q]];
            }
        }
        System.out.println(Arrays.toString(out));

        return out;
    }
}
```

### Problem: [frequency of the most frequent element](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)

```java
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n=nums.length;
        if(n<=1) return n;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int maxfreq=1;
        
        for(int i=n-1;i>0;i--){
            int inc=k; int freq=1;
            if(i<maxfreq) break;
            if (i<n-1 &&nums[i + 1] == nums[i])
                continue;
            for(int j=i-1;j>=0;j--){
                int dif=nums[i]-nums[j];
                if(dif>inc){
                    break;
                }
                inc-=dif;
                freq++;
            }
            maxfreq=Math.max(freq,maxfreq);
        }

        return maxfreq;
    }
}
```

### Problem: [valid palindrome](https://leetcode.com/problems/valid-palindrome/)

```java
class Solution {
    public boolean isPalindrome(String s) {
    
       int i = 0, j = s.length()-1;
        while(i < j){
            char ch1 = s.charAt(i), ch2 = s.charAt(j);
            if(ch1 >= 'A' && ch1 <= 'Z') ch1 = (char)(ch1+32);
            if(ch2 >= 'A' && ch2 <= 'Z') ch2 = (char)(ch2+32);
            boolean c1 = (ch1 >= 'a' && ch1 <= 'z') || (ch1 >= '0' && ch1 <= '9');
            boolean c2 = (ch2 >= 'a' && ch2 <= 'z') || (ch2 >= '0' && ch2 <= '9');
            if(!c1){
                i++;
                continue;
            }
            if(!c2){
                j--;
                continue;
            }
            if(ch1 != ch2) return false;
            i++;
            j--;
        }
        return true;
    }

}
```

### Problem: [valid palindrome](https://leetcode.com/problems/valid-palindrome/)

```java

    class Solution {

    boolean helper(String s,int i,int j){
        if(i>=j)
        {
            return true;
        }

        if(!Character.isLetterOrDigit(s.charAt(i))){
            return helper(s,i+1,j);}
        else if(!Character.isLetterOrDigit(s.charAt(j))){
            return helper(s,i,j-1);}
        else if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
            return helper(s,i+1,j-1);}
        
        return false;


    }
    public boolean isPalindrome(String s) {
    
       return helper(s,0,s.length()-1);
    }

}
```

### Problem: [valid palindrome](https://leetcode.com/problems/valid-palindrome/)

```java

    class Solution {

    boolean helper(String s,int i,int j){
        if(i>=j)
        {
            return true;
        }

        if(!Character.isLetterOrDigit(s.charAt(i))){
            return helper(s,i+1,j);}
        else if(!Character.isLetterOrDigit(s.charAt(j))){
            return helper(s,i,j-1);}
        else if(s.charAt(i)==s.charAt(j)){
            return helper(s,i+1,j-1);}
        
        return false;


    }
    public boolean isPalindrome(String s) {
    
       return helper(s.toLowerCase(),0,s.length()-1);
    }

}
```

### Problem: [reverse string](https://leetcode.com/problems/reverse-string/)

```java
class Solution {
    void helper(char[] s,int i, int j){
        if(i>=j){
            return;
        }

        char temp = s[i];
        s[i]=s[j];
        s[j]=temp;

        helper(s,i+1,j-1);
    }
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
}
```

### Problem: [binary search](https://leetcode.com/problems/binary-search/)

```java
class Solution {

    int helper(int[] nums,int target, int high, int low){
        int mid= (high+low)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(high<=low){
            return -1;
        }

        if(target>nums[mid])
            return helper(nums,target,high,mid+1);
        
        return helper(nums,target,mid,low);

    }
    public int search(int[] nums, int target) {
        return helper(nums,target,nums.length-1,0);
    }
}
```

### Problem: [number of steps to reduce a number to zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)

```java
class Solution {
    public int numberOfSteps(int num) {
       if(num==0){
            return 0;
       }

       if(num%2==0)
        return 1 + numberOfSteps(num/2);
    
        return 1 + numberOfSteps(num-1);
    }
}
```

### Problem: [number of steps to reduce a number to zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)

```java
class Solution {
    public int numberOfSteps(int num) {
        int steps=0;
        while(num>0){
            if(num%2==0){
                num/=2;
            }else{
                num--;
            }

            steps++;
        }

        return steps;
    }
}
```

### Problem: [palindrome partitioning](https://leetcode.com/problems/palindrome-partitioning/)

```java
class Solution {
    boolean ispalindrome(String str,int i,int j){
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    void helper(List<List<String>> ans,List<String> inner,int start, String s ){

        if(start==s.length()){
            ans.add(new ArrayList<>(inner));
        }

        for(int i=start;i<s.length();i++){
            String substr=s.substring(start,i+1);
            if(ispalindrome(s,start,i)){
                inner.add(substr);
                helper(ans,inner,i+1,s);
                inner.remove(inner.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        
        List<List<String>> ans= new ArrayList<>();
        helper(ans,new ArrayList<>(),0,s);
        return ans;
    }
}
```

### Problem: [palindrome partitioning](https://leetcode.com/problems/palindrome-partitioning/)

```java
class Solution {
    boolean ispalindrome(String str,int i,int j){
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    void helper(List<List<String>> ans,List<String> inner,int start, String s ){

        if(start==s.length()){
            ans.add(new ArrayList<>(inner));
        }

        for(int i=start;i<s.length();i++){
            String substr=s.substring(start,i+1);
            if(ispalindrome(s,start,i)){
                inner.add(substr);
                helper(ans,inner,i+1,s);
                inner.remove(inner.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        
        List<List<String>> ans= new ArrayList<>();
        helper(ans,new ArrayList<>(),0,s);
        return ans;
    }
}
```

### Problem: [reverse linked list](https://leetcode.com/problems/reverse-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next== null) return head;
        ListNode temp=head;
        ListNode cur=head;
        ListNode left=null;
        while(cur!=null){
            temp=cur;
            cur=cur.next;
            temp.next=left;
            left=temp;
        }

        head=temp;
        return head;

    }
}
```

### Problem: [combination sum ii](https://leetcode.com/problems/combination-sum-ii/)

```java
class Solution {
    void helper1(List<List<Integer>> ans, List<Integer> inner, int[] nums, int target, int index) {
        if (index == nums.length) {
            if(target==0)
                ans.add(new ArrayList<>(inner));
                
            return;
        }

        if(nums[index]<=target){
            // Pick the current element
            inner.add(nums[index]);
            helper1(ans, inner, nums, target- nums[index],index + 1);
            inner.remove(inner.size() - 1); // Backtrack
        }
        // Not pick the current *element
        // Skip all the duplicates
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        helper1(ans, inner, nums, target,index + 1);
    }
    
    void helper(List<List<Integer>> ans, List<Integer> inner, int[] nums, int target, int start) {
        if(target==0)
            ans.add(new ArrayList<>(inner));
        
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i - 1] == nums[i]) continue;
            if(nums[i]>target) break;
            
            inner.add(nums[i]);
            helper(ans, inner, nums, target-nums[i],i + 1);
            inner.remove(inner.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
         List<List<Integer>> ans = new ArrayList<>();
        helper1(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }
} 
```

### Problem: [combination sum ii](https://leetcode.com/problems/combination-sum-ii/)

```java
class Solution {
    void helper1(List<List<Integer>> ans, List<Integer> inner, int[] nums, int target, int index) {
        if (index == nums.length) {
            if(target==0)
                ans.add(new ArrayList<>(inner));
                
            return;
        }

        // Pick the current element
        inner.add(nums[index]);
        helper1(ans, inner, nums, target- nums[index],index + 1);
        inner.remove(inner.size() - 1); // Backtrack

        // Not pick the current *element
        // Skip all the duplicates
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        helper1(ans, inner, nums, target,index + 1);
    }
    
    void helper(List<List<Integer>> ans, List<Integer> inner, int[] nums, int target, int start) {
        if(target==0)
            ans.add(new ArrayList<>(inner));
        
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i - 1] == nums[i]) continue;
            if(nums[i]>target) break;
            
            inner.add(nums[i]);
            helper(ans, inner, nums, target-nums[i],i + 1);
            inner.remove(inner.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
         List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }
} 
```

### Problem: [subsets ii](https://leetcode.com/problems/subsets-ii/)

```java
class Solution {
    void helper1(List<List<Integer>> ans, List<Integer> inner, int[] nums, int index) {
        // Base case: if we have considered all elements
        if (index == nums.length) {
            ans.add(new ArrayList<>(inner));
            return;
        }
        
        // Pick the current element
        inner.add(nums[index]);
        helper1(ans, inner, nums, index + 1);
        inner.remove(inner.size() - 1); // Backtrack
        
        // Not pick the current element
        // Skip all the duplicates
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        helper1(ans, inner, nums, index + 1);
    }
    void helper(List<List<Integer>> ans, List<Integer> inner,int[] nums, int start){
        ans.add(new ArrayList<>(inner));

        for(int i=start;i<nums.length;i++){
            if(i!=start && nums[i-1]==nums[i]) continue;

            inner.add(nums[i]);
            helper(ans,inner,nums,i+1);
            inner.remove(inner.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();

        helper1(ans,new ArrayList<>(),nums,0);
        return ans;
    }
}
```

### Problem: [combination sum](https://leetcode.com/problems/combination-sum/)

```java
class Solution {
    void helper(List<List<Integer>> ans,List<Integer> inner,int[] cand,int target,int index){
      
        if(index==cand.length){
            if(target==0){
                ans.add(new ArrayList<>(inner));
            }
            return;
        }
        
        if(cand[index]<=target){
            inner.add(cand[index]);
            helper(ans,inner,cand,target-cand[index],index);
            inner.remove(inner.size()-1);
        }
        helper(ans,inner,cand,target,index+1);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }

    
}
```

### Problem: [subsets ii](https://leetcode.com/problems/subsets-ii/)

```java
class Solution {

    void helper(List<List<Integer>> ans, List<Integer> inner,int[] nums, int start){
        ans.add(new ArrayList<>(inner));

        for(int i=start;i<nums.length;i++){
            if(i!=start && nums[i-1]==nums[i]) continue;

            inner.add(nums[i]);
            helper(ans,inner,nums,i+1);
            inner.remove(inner.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();

        helper(ans,new ArrayList<>(),nums,0);
        return ans;
    }
}
```

### Problem: [subsets ii](https://leetcode.com/problems/subsets-ii/)

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> outer= new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        outer.add(new ArrayList<Integer>());
        int start; int end=0;
        for(int i=0;i<n;i++){
            start=0;
            if(i>0 && nums[i-1]==nums[i])
                start=end+1;
            end=outer.size()-1;
            for(int j=start;j<=end;j++){
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
```

### Problem: [sum of digit differences of all pairs](https://leetcode.com/problems/sum-of-digit-differences-of-all-pairs/)

```java
class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n=nums.length;
        long sum=0;
        int m= (int) Math.log10(nums[0]) +1;

        for(int i=0;i<m;i++){

            int[] occu= new int[10];
            for(int j=0;j<n;j++){
                int x=nums[j]%10;
                occu[x]++;
                nums[j]/=10;
            }

            for(int j=0;j<10;j++){
                if(occu[j]>0)
                sum+= (long)( n - (occu[j]))*occu[j];
            }
        }

        return sum/2;
    }
}
```

### Problem: [special array ii](https://leetcode.com/problems/special-array-ii/)

```java
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n= nums.length;
            
        int[] inv= new int[n];
        boolean[] sp= new boolean[n];
        
        inv[0]=-1;
        sp[0]=true;
        for(int i=1;i<n;i++){
            if(nums[i]%2!=nums[i-1]%2){
                sp[i]=sp[i-1];
                inv[i]=inv[i-1];
            }else{
                sp[i]=false;
                inv[i]=i-1;
            }
            
        }
        int m=queries.length;
        boolean[] ans= new boolean[m];
        for(int i=0;i<m;i++){
            
            int s= queries[i][0];
            int e=queries[i][1];
            if(s==e){
                ans[i]=true;
            }else if(inv[e]<s){
                ans[i]=true;   
            }else{
                ans[i]=false;
            }
        }
        
        return ans;
    }
}
```

### Problem: [special array i](https://leetcode.com/problems/special-array-i/)

```java
class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n=nums.length;
        if (n==1) return true;

        for(int i=1;i<n;i++){
            if(nums[i-1]%2==0 && nums[i]%2==0)
                return false;
            if(nums[i-1]%2==1 && nums[i]%2==1)
                return false;
        }

        return true;
    }
}
```

### Problem: [count substrings starting and ending with given character](https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/)

```java
class Solution {
    public long countSubstrings(String s, char c) {
         int n = s.length();
        long a=0;
        for(int i=0;i<n;i++){
                if(s.charAt(i)==c)
                    a++;
        }
        return a*(a+1)/2;
        
    }
}
```

### Problem: [existence of a substring in a string and its reverse](https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/)

```java
class Solution {
    public boolean isSubstringPresent(String s) {
        int n=s.length();
        Set<String> hash_set = new HashSet<String>(); 
        
        for (int i = 0; i < n - 1; i++) {
            
            String str=s.charAt(i)+""+s.charAt(i+1);
            if(hash_set.contains(s.charAt(i+1)+""+s.charAt(i)) || s.charAt(i+1)==s.charAt(i)){
                return true;
            }else{
                hash_set.add(str);
                
            }
        }
        return false;
    }
}
```

### Problem: [find the sum of encrypted integers](https://leetcode.com/problems/find-the-sum-of-encrypted-integers/)

```java
class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int n=nums.length; 
        for(int i=0;i<n;i++){
            int maxnum=-1; int digitcount=0;
            while(nums[i]!=0){
                int rem= nums[i]%10;
                if(rem>maxnum){
                    maxnum=rem;
                }
                digitcount++;
                nums[i]/=10;
            }
            
            int x=0;
            
            for(int d=0;d<digitcount;d++){
                x= x*10 + maxnum;
            }
            nums[i]=x;
        }
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
```

### Problem: [longest increasing subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

```java
class Solution {
    int helper(int[] nums, int prev, int cur,int[][] dp){

        if(prev==nums.length || cur==nums.length+1){
            return 0;
        }

        if(dp[prev][cur]!=-1)
            return dp[prev][cur];

        // picking current
        int pick = Integer.MIN_VALUE;
        if(prev==0 || nums[prev-1]<nums[cur-1]){
            pick = 1+ helper(nums,cur,cur+1,dp);
        }
        // not picking current
        int notpick = helper(nums,prev,cur+1,dp);

        return dp[prev][cur]=Math.max(pick,notpick);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        return helper(nums,0,1,dp);
    }
}
```

### Problem: [wildcard matching](https://leetcode.com/problems/wildcard-matching/)

```java
class Solution {
    boolean helper(String s,String p,int i,int j, int[][] dp){
        if(i<0){
            while(j>=0){
                if(p.charAt(j)!='*')
                    return false;
                j--;
            }
            return true;
        }

        if(j<0){
            if(i>=0) 
            return false;
            return true;
        }
        if(dp[i][j]!=-1)
            return dp[i][j]==1?true:false;
        
        boolean ans=false;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            ans=helper(s,p,i-1,j-1,dp);
        }else if(p.charAt(j)=='*'){
            ans=helper(s,p,i,j-1,dp) || helper(s,p,i-1,j,dp);
        }

        dp[i][j]=ans?1:0;
        return ans;
    } 
    public boolean isMatch(String s, String p) {
        int m=s.length(); int n=p.length();
        int[][] dp= new int[m][n];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        return helper(s,p,m-1,n-1,dp);
    }
}
```

### Problem: [edit distance](https://leetcode.com/problems/edit-distance/)

```java
class Solution {
    int helper(String word1,String word2, int s,int t,int[][] dp){

        // string matched only deletion is need for remaining
        if(t<1){
            return s;
        }
        // string have not matched, insertion is needed for t remaining
        if(s<1){
            return t;
        }

        if(dp[s][t]!=-1)
            return dp[s][t];
        if(word1.charAt(s-1)==word2.charAt(t-1)){
            return dp[s][t]= helper(word1,word2,s-1,t-1,dp);
        }
        // delete
        int delete= 1+ helper(word1,word2,s-1,t,dp); 
        // Insert
        int insert= 1+ helper(word1,word2,s,t-1,dp); 
        // Replace
        int replace= 1+ helper(word1,word2,s-1,t-1,dp); 

        return dp[s][t]= Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int s= word1.length();
        int t=word2.length();
        int[] prev= new int[t+1];
        
        for(int i=0;i<=t;i++) prev[i]= i;


        for(int i=1;i<=s;i++){
            int[] cur= new int[t+1];
            cur[0]=i;
            for(int j=1;j<=t;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    cur[j]= prev[j-1];
                }
                else{
                    // delete
                    int delete= prev[j]; 
                    // Insert
                    int insert= cur[j-1]; 
                    // Replace
                    int replace= prev[j-1]; 
                    cur[j]= Math.min(insert,Math.min(delete,replace))+1;
                }
                
            }
            prev=cur;
            
        }
        return prev[t];
    }
}


```

### Problem: [edit distance](https://leetcode.com/problems/edit-distance/)

```java
class Solution {
    int helper(String word1,String word2, int s,int t,int[][] dp){

        // string matched only deletion is need for remaining
        if(t<1){
            return s;
        }
        // string have not matched, insertion is needed for t remaining
        if(s<1){
            return t;
        }

        if(dp[s][t]!=-1)
            return dp[s][t];
        if(word1.charAt(s-1)==word2.charAt(t-1)){
            return dp[s][t]= helper(word1,word2,s-1,t-1,dp);
        }
        // delete
        int delete= 1+ helper(word1,word2,s-1,t,dp); 
        // Insert
        int insert= 1+ helper(word1,word2,s,t-1,dp); 
        // Replace
        int replace= 1+ helper(word1,word2,s-1,t-1,dp); 

        return dp[s][t]= Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int s= word1.length();
        int t=word2.length();
        int[][] dp= new int[s+1][t+1];
        
        for(int i=0;i<=t;i++) dp[0][i]= i;
        for(int i=0;i<=s;i++) dp[i][0]= i;


        for(int i=1;i<=s;i++){
            for(int j=1;j<=t;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1];
                }
                else{
                    // delete
                    int delete= dp[i-1][j]; 
                    // Insert
                    int insert= dp[i][j-1]; 
                    // Replace
                    int replace= dp[i-1][j-1]; 

                    dp[i][j]= Math.min(insert,Math.min(delete,replace))+1;
                }
                
            }
        }
        return dp[s][t];
    }
}


```

### Problem: [edit distance](https://leetcode.com/problems/edit-distance/)

```java
class Solution {
    int helper(String word1,String word2, int s,int t,int[][] dp){

        // string matched only deletion is need for remaining
        if(t<1 && s>=1){
            return s;
        }
        // string have not matched, insertion is needed for t remaining
        if(s<1 && t>=1){
            return t;
        }

        if(s<1&& t<1){
            return 0;
        }
        if(dp[s][t]!=-1)
            return dp[s][t];
        if(word1.charAt(s-1)==word2.charAt(t-1)){
            return dp[s][t]= helper(word1,word2,s-1,t-1,dp);
        }
        // delete
        int delete= 1+ helper(word1,word2,s-1,t,dp); 
        // Insert
        int insert= 1+ helper(word1,word2,s,t-1,dp); 
        // Replace
        int replace= 1+ helper(word1,word2,s-1,t-1,dp); 

        return dp[s][t]= Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int s= word1.length();
        int t=word2.length();
        int[][] dp= new int[s+1][t+1];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        
        return helper(word1,word2,s,t,dp);
    }
}


```

### Problem: [distinct subsequences](https://leetcode.com/problems/distinct-subsequences/)

```java
class Solution {
    // for babgbag
    // '' b a g
    //  1 0 0 0
    //  1 1 0 0
    //  1 1 1 0
    //  1 2 1 0
    //  1 2 1 1
    //  1 3 1 1
    //  1 3 4 1
    //  1 3 4 5
    public int numDistinct(String s, String t) {
        int m=s.length(); int n=t.length();

        int[] dp= new int[n+1];
        dp[0]=1;

        for(int i=1;i<=m;i++){
            for(int j=n;j>0;j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[j]+= dp[j-1];
                } 
            }
        }

        return dp[n];
    } 
}
```

### Problem: [distinct subsequences](https://leetcode.com/problems/distinct-subsequences/)

```java
class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length(); int n=t.length();

        int[] dp= new int[n+1];
        dp[0]=1;

        for(int i=1;i<=m;i++){
            for(int j=n;j>0;j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[j]+= dp[j-1];
                } 
            }
        }

        return dp[n];
    } 
}
```

### Problem: [distinct subsequences](https://leetcode.com/problems/distinct-subsequences/)

```java
class Solution {
    int helper(String s,String t,int m,int n,int[][] dp){
        if(n<1)
            return 1;
        if(m<1)
            return 0;
        
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        if(s.charAt(m-1)==t.charAt(n-1)){
            return dp[m][n]= helper(s,t,m-1,n-1,dp) + helper(s,t,m-1,n,dp);
        }
        return dp[m][n] = helper(s,t,m-1,n,dp);

    }
    public int numDistinct(String s, String t) {
        int m=s.length(); int n=t.length();

        int[][] dp= new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][0]=1;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1] + dp[i-1][j];
                } else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    } 
}
```

### Problem: [distinct subsequences](https://leetcode.com/problems/distinct-subsequences/)

```java
class Solution {
    int helper(String s,String t,int m,int n,int[][] dp){
        if(n<1)
            return 1;
        if(m<1)
            return 0;
        
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        if(s.charAt(m-1)==t.charAt(n-1)){
            return dp[m][n]= helper(s,t,m-1,n-1,dp) + helper(s,t,m-1,n,dp);
        }
        return dp[m][n] = helper(s,t,m-1,n,dp);

    }
    public int numDistinct(String s, String t) {
        int m=s.length(); int n=t.length();

        int[][] dp= new int[m+1][n+1];
        for(int[] d:dp)
            Arrays.fill(d,-1);

        return helper(s,t,m,n,dp); 
    } 
}
```

### Problem: [shortest common supersequence](https://leetcode.com/problems/shortest-common-supersequence/)

```java
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=n;i++) dp[0][i]=0;
        for(int i=0;i<=m;i++) dp[i][0]=0;



        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        StringBuilder str= new StringBuilder();
        int i=m; int j=n;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                str.append(str1.charAt(i-1)+"");
                i--; j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                str.append(str1.charAt(i-1)+"");
                i--;
            }else{
                str.append(str2.charAt(j-1)+"");
                j--;
            }
        }


        while(i>0){
            str.append(str1.charAt(i-1)); i--;
        }
        while(j>0){
            str.append(str2.charAt(j-1)); j--;
        }

        return str.reverse().toString();
    }
}
```

### Problem: [maximize happiness of selected children](https://leetcode.com/problems/maximize-happiness-of-selected-children/)

```java
public class Solution {
//     void decby1(int[] arr){
//         for(int i = 0; i < arr.length; i++){
//             if(arr[i] > 0)
//                 arr[i] -= 1;
//         }
//     }
    
//     int maxinarr(int[] arr){
//         int maxi = 0;
//         for(int i = 1; i < arr.length; i++){
//             if(arr[i] > arr[maxi])
//                 maxi = i;
//         }
//         return maxi;
//     }

    public long maximumHappinessSum(int[] h, int k) {
        if (h == null || h.length == 0 || k <= 0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap

        for (int happiness : h) {
            maxHeap.offer(happiness);
        }
        long sum = 0; int redby=0;
        for(int i = 0; i < k; i++){
            int maxHappiness = maxHeap.poll() -redby;
            if(maxHappiness>0){
                sum += maxHappiness;
                redby++;}
        }
        return sum;
    }
}


```

### Problem: [apple redistribution into boxes](https://leetcode.com/problems/apple-redistribution-into-boxes/)

```java
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int alen=apple.length;
        int clen=capacity.length;
        int suma=0;
        for(int i=0;i<alen;i++){
            suma+=apple[i];
        }
        int sum=0;  
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap

        for (int c : capacity) {
            maxHeap.offer(c);
        }
        
        int ans=0;
        for (int i = 0; i < clen; i++) {
            int maxcap = maxHeap.poll();
            suma-=maxcap;
            ans++;
            if(suma<=0){
                break;
            }
        }

        return ans;
    }
}
```

### Problem: [delete operation for two strings](https://leetcode.com/problems/delete-operation-for-two-strings/)

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[] prev= new int[n+1];
        for(int i=1;i<=m;i++){
            int[] cur= new int[n+1];
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    cur[j]=prev[j-1] +1;
                else 
                    cur[j]=Math.max(prev[j],cur[j-1]);

            }
            prev=cur;
        }
        int x=prev[n];
        return m-x +n-x;
    }
}
```

### Problem: [minimum insertion steps to make a string palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)

```java
class Solution {
    public int minInsertions(String s) {
        // logic is to subtract longest palindromic subsequence from the length

        int n=s.length();
        String rev= new StringBuilder(s).reverse().toString();
        int[] prev= new int[n+1];

        for(int i=1;i<=n;i++){
            int[] cur= new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1))
                    cur[j]=prev[j-1] +1;
                else
                    cur[j]=Math.max(prev[j],cur[j-1]);
            }
            prev=cur;
        }

        return n-prev[n];
    }
}
```

### Problem: [longest palindromic subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev= new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[] prev= new int[n+1];

        for(int i=1;i<=n;i++){
            int[] cur= new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                }else
                    cur[j]= Math.max(prev[j],cur[j-1]);
            }
            prev=cur;
        }
        return prev[n];
    }
}
```

### Problem: [longest common subsequence](https://leetcode.com/problems/longest-common-subsequence/)

```java
class Solution {
    public int longestCommonSubsequence(String t1, String t2) {

        int n1=t1.length();
        int n2=t2.length();
        int[] prev= new int[n2+1];
        
        
        for(int i=1;i<=n1;i++){
            int[] cur= new int[n2+1];
            for(int j=1;j<=n2;j++){
                // If the characters match, 
                // update cur[j] to be one plus the LCS length 
                // found by moving diagonally (i.e., from prev[j - 1]).
                if(t1.charAt(i-1)==t2.charAt(j-1)){
                    cur[j]=1+ prev[j-1];
                }
                else 
                // If the characters don't match, 
                // you take the maximum LCS length from 
                // either the top (prev[j]) or the left (cur[j - 1]).
                    cur[j]= Math.max(cur[j-1],prev[j]);
            }
            prev=cur;
        }

        return prev[n2];
    }

    
}
```

### Problem: [longest common subsequence](https://leetcode.com/problems/longest-common-subsequence/)

```java
class Solution {
    int helper(String t1,int n1,String t2,int n2,int[][] dp){
        if(n1==0 || n2==0){
            return 0;
        }
        if(dp[n1][n2]!=-1)  
            return dp[n1][n2];
        if(t1.charAt(n1-1)==t2.charAt(n2-1)){
            return dp[n1][n2]=1+ helper(t1,n1-1,t2,n2-1,dp);
        }

        return dp[n1][n2]=Math.max(
            helper(t1,n1-1,t2,n2,dp),helper(t1,n1,t2,n2-1,dp)
        );
    }
    public int longestCommonSubsequence(String t1, String t2) {

        int n1=t1.length();
        int n2=t2.length();
        int[][] dp= new int[n1+1][n2+1];
        
        
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(t1.charAt(i-1)==t2.charAt(j-1)){
                    dp[i][j]=1+ dp[i-1][j-1];
                }
                else
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n1][n2];

        // for(int[] d:dp)
        //     Arrays.fill(d,-1);
        // return helper(text1,n1,text2,n2,dp);
    
    }

    // wrong approach (does not work for subsequences)
    // public int longestCommonSubsequence(String text1, String text2) {
    //     boolean[] txt1= new boolean[26];
    //     boolean[] txt2= new boolean[26];

    //     for(int i=0;i<text1.length();i++){
    //         int index = text1.charAt(i) - 'a';
    //         txt1[index]=true;
    //     }

    //     for(int i=0;i<text2.length();i++){
    //          int index = text2.charAt(i) - 'a';
    //          txt2[index]=true;
    //     }

    //     int count=0;
    //     boolean prev=true;
    //     for(int i=0;i<text1.length();i++){
    //         int index = text1.charAt(i) - 'a';
    //         if(txt1[index] && txt2[index]){
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}
```

### Problem: [longest common subsequence](https://leetcode.com/problems/longest-common-subsequence/)

```java
class Solution {
    int helper(String t1,int n1,String t2,int n2,int[][] dp){
        if(n1<0 || n2<0){
            return 0;
        }
        if(dp[n1][n2]!=-1)  
            return dp[n1][n2];
        if(t1.charAt(n1)==t2.charAt(n2)){
            return dp[n1][n2]=1+ helper(t1,n1-1,t2,n2-1,dp);
        }

        return dp[n1][n2]=Math.max(
            helper(t1,n1-1,t2,n2,dp),helper(t1,n1,t2,n2-1,dp)
        );
    }
    public int longestCommonSubsequence(String text1, String text2) {

        int n1=text1.length();
        int n2=text2.length();
        int[][] dp= new int[n1][n2];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        return helper(text1,n1-1,text2,n2-1,dp);
    
    }

    // wrong approach (does not work for subsequences)
    // public int longestCommonSubsequence(String text1, String text2) {
    //     boolean[] txt1= new boolean[26];
    //     boolean[] txt2= new boolean[26];

    //     for(int i=0;i<text1.length();i++){
    //         int index = text1.charAt(i) - 'a';
    //         txt1[index]=true;
    //     }

    //     for(int i=0;i<text2.length();i++){
    //          int index = text2.charAt(i) - 'a';
    //          txt2[index]=true;
    //     }

    //     int count=0;
    //     boolean prev=true;
    //     for(int i=0;i<text1.length();i++){
    //         int index = text1.charAt(i) - 'a';
    //         if(txt1[index] && txt2[index]){
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}
```

### Problem: [count square submatrices with all ones](https://leetcode.com/problems/count-square-submatrices-with-all-ones/)

```java
class Solution {
    public int countSquares(int[][] mat) {
       int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++)
            dp[0][i] = mat[0][i];

        for (int i = 0; i < m; i++)
            dp[i][0] = mat[i][0];


        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(mat[i][j]==0){
                    dp[i][j]=0;
                }else{
                    dp[i][j]= 1+ Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }
        }


        int sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum+= dp[i][j];
            }
        }

        return sum;
    }
}
```

### Problem: [maximal rectangle](https://leetcode.com/problems/maximal-rectangle/)

```java
class Solution {
    int largestarea(int arr[]) {
        int n=arr.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }


    public int maximalRectangle(char[][] mat) {
        int m=mat[0].length;
        int n=mat.length;
        int[] heights= new int[m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]=='1')
                    heights[j]++;
                else heights[j]=0;
            }

            int area= largestarea(heights);
            ans=Math.max(area,ans);
        }
        return ans;
    }
}
```

### Problem: [partition array for maximum sum](https://leetcode.com/problems/partition-array-for-maximum-sum/)

```java
class Solution {
    int helper(int ind, int[] arr,int k,int[] dp){
        int n=arr.length;
        if(ind==n)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int maxi= Integer.MIN_VALUE;
        int maxsum= Integer.MIN_VALUE;
        int len=0;
        for(int i=ind;i<Math.min(n,ind+k);i++){
            len++;
            maxi=Math.max(maxi,arr[i]);
            int sum= (len*maxi) + helper(i+1,arr,k,dp);
            maxsum=Math.max(sum,maxsum);
        }

        return dp[ind]=maxsum;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);

        return helper(0,arr,k,dp);
    }
}
```

### Problem: [palindrome partitioning ii](https://leetcode.com/problems/palindrome-partitioning-ii/)

```java
class Solution {
    boolean ispalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) 
                return false;
            i++;
            j--;
        }
        return true;
    }
    public int minCut(String s) {

        int n=s.length();
        int[] dp = new int[n+1];

        dp[n]=0;

        int result= Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            result = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(ispalindrome(i,j,s)){
                    int localcuts= 1 + dp[j+1];
                    result= Math.min(result,localcuts);
                }
            }
            dp[i]=result;
        } 

        return result-1;

    }
}
```

### Problem: [burst balloons](https://leetcode.com/problems/burst-balloons/)

```java
class Solution {
    int helper(int l,int r,int[] temp,int[][] dp){
        if(l>r)
            return 0;
        if(dp[l][r]!=-1)
            return dp[l][r];
        
        int ans= Integer.MIN_VALUE;
        for(int i=l;i<=r;i++){
            int coins = temp[l-1]*temp[i]*temp[r+1] 
            + helper(l,i-1,temp,dp) + helper(i+1,r,temp,dp);
            ans= Math.max(ans,coins);
        }

        return dp[l][r]=ans;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n+2];
        temp[0]=1;
        temp[n+1]=1;
        for(int i=1;i<n+1;i++)
            temp[i]=nums[i-1];

        int[][] dp = new int[n+2][n+2];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        return helper(1,n,temp,dp);
    }
}
```

### Problem: [minimum cost to cut a stick](https://leetcode.com/problems/minimum-cost-to-cut-a-stick/)

```java
class Solution {
    // interesting one need revist
    int helper(int left,int right,int[] temp,int[][] dp){
        if(left>right)
            return 0;
        if(dp[left][right]!=-1)
            return dp[left][right];
        int result=Integer.MAX_VALUE;
        for(int i=left;i<=right;i++){
            int cost = temp[right+1] -temp[left-1] + helper(left,i-1,temp,dp) + helper(i+1,right,temp,dp);
            result= Math.min(result,cost);
        }
        return dp[left][right]=result;
    }
    public int minCost(int len, int[] cuts) {
        int n=cuts.length;
        int[] temp= new int[n+2];
        temp[n]=0;
        temp[n+1]=len;
        for(int i=0;i<n;i++)
            temp[i]=cuts[i];
        // sorted temp with 0 to len elements
        Arrays.sort(temp);

        int[][] dp = new int[n+2][n+2];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        
        return helper(1,n,temp,dp);

    }
} 
```

### Problem: [coin change ii](https://leetcode.com/problems/coin-change-ii/)

```java
class Solution {
    public int change(int amount, int[] coins) { 

        int n=coins.length;
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<amount+1;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }

        return dp[amount];
    }
}
```

### Problem: [coin change ii](https://leetcode.com/problems/coin-change-ii/)

```java
class Solution {


    int helper(int[] coins, int amount, int index,int[][] dp){
        if(index==0){
            if(amount%coins[0]==0){
                return 1;
            }else return 0;
        }

        if(dp[index][amount]!=-1)
            return dp[index][amount];
        int nottake=  helper(coins,amount,index-1,dp);
        int take=0;
        if(coins[index]<=amount){
            take = helper(coins,amount-coins[index],index,dp);
        }

        return dp[index][amount]=take + nottake;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] d: dp)
            Arrays.fill(d,-1);
        return helper(coins,amount,n-1,dp);
    }
}
```

### Problem: [coin change](https://leetcode.com/problems/coin-change/)

```java
class Solution {
     
    public int coinChange(int[] coins, int amount) {
     int[] dp = new int[amount+1];

     Arrays.fill(dp,amount+1);
     int n = coins.length;
     dp[0]=0;
     for(int i=1;i<amount+1;i++){
         for(int j=0;j<n;j++){
             if(coins[j]<=i){
                 dp[i]= Math.min(dp[i], 1+ dp[i-coins[j]]);
             }
         }
     }
     if(dp[amount]>amount)
        return -1;
     return dp[amount];
    }
}
```

### Problem: [coin change](https://leetcode.com/problems/coin-change/)

```java
class Solution {
     int helper(int[] coins, int amount,int index,int[][] dp){
        if(index==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            return (int) Math.pow(10, 9);
        }

        if(dp[index][amount]!=-1)
            return dp[index][amount];


        int notpick= 0 + helper(coins,amount,index-1,dp);
        int pick= (int) Math.pow(10, 9);
        if(coins[index]<=amount){
            pick= 1 + helper(coins,amount-coins[index],index,dp);
        }

        return dp[index][amount]=Math.min(pick,notpick);
       
    }
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        // int[][] dp = new int[n][amount+1];
        // for(int[] d: dp)
        //     Arrays.fill(d,-1);
        // int ans=helper(coins,amount,n-1,dp);
        // if (ans >=(int) Math.pow(10, 9))
        //     return -1;
        // return ans;

        int[] prev= new int[amount+1];
        for(int i=0;i<amount+1;i++){
            if(i%coins[0]==0)
                prev[i]= i/coins[0];
            else prev[i]=(int) Math.pow(10, 9);
        }
            
        for(int i=1;i<n;i++){
            int[] cur= new int[amount+1];
            for(int j=0;j<amount+1;j++){
                int notpick=0 + prev[j];
                int pick= (int) Math.pow(10, 9);
                if(coins[i]<=j){
                    pick= 1 + cur[j-coins[i]];
                }

                cur[j]= Math.min(notpick,pick);
            }
            prev=cur;
        }
        
        int ans= prev[amount];
        if (ans >=(int) Math.pow(10, 9))
            return -1;
        return ans;

    }
}
```

### Problem: [coin change](https://leetcode.com/problems/coin-change/)

```java
class Solution {
     int helper(int[] coins, int amount,int index,int[][] dp){
        if(index==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            return (int) Math.pow(10, 9);
        }

        if(dp[index][amount]!=-1)
            return dp[index][amount];


        int notpick= 0 + helper(coins,amount,index-1,dp);
        int pick= (int) Math.pow(10, 9);
        if(coins[index]<=amount){
            pick= 1 + helper(coins,amount-coins[index],index,dp);
        }

        return dp[index][amount]=Math.min(pick,notpick);
       
    }
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] d: dp)
            Arrays.fill(d,-1);
        int ans=helper(coins,amount,n-1,dp);
        if (ans >=(int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}
```

### Problem: [apply operations to make string empty](https://leetcode.com/problems/apply-operations-to-make-string-empty/)

```java
class Solution {
    public String lastNonEmptyString(String s) {
        
       StringBuilder lastStr = new StringBuilder();
        char[] carr = s.toCharArray();
        int n = carr.length;
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : carr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int highest = Integer.MIN_VALUE;
        for (int count : map.values()) {
            highest = Math.max(highest, count);
        }
        
        Set<Character> encountered = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            char c = carr[i];
            if (map.get(c) == highest && !encountered.contains(c)) {
                lastStr.insert(0, c);
                encountered.add(c);
            }
        }
        
        return lastStr.toString();
    }
}
```

### Problem: [maximum number of operations with the same score i](https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/)

```java
class Solution {
    public int maxOperations(int[] nums) {
        int n=nums.length;
        if(n==0)
                return 0;
        if(n==1)
            return nums[0];
        int op=1;
        int sum=nums[0] + nums[1];
        if(n%2!=0)
            n--;
        for(int i=2;i<n;i+=2){
                if(sum==nums[i]+nums[i+1])
                    op++;
                else 
                    break;
            
                
            
        }
        return op;
    }
}
```

### Problem: [best time to buy and sell stock iv](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

```java
class Solution {
     // sell -> 1 you can sell
    // buy -> 0 you cant sell
    int helper(int[] prices,int index,int buy,int transactionNum, int[][][] dp){
        if(transactionNum==0){
            return 0;
        }
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy][transactionNum]!=-1)
            return dp[index][buy][transactionNum];
        int profit=Integer.MIN_VALUE;
        if(buy==0){
            profit= Math.max(
                -prices[index] + helper(prices,index+1,1,transactionNum,dp),
                0 + helper(prices,index+1,0,transactionNum,dp)
            );
        }else{
            profit= Math.max(
                prices[index] + helper(prices,index+1,0,transactionNum-1,dp),
                0 + helper(prices,index+1,1,transactionNum,dp)
            );
        }

        return dp[index][buy][transactionNum]=profit;

    }
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        // n prices * buy or sell (2) * 0,1,2 transactions rn
        // these are the combinations that we can have hence the 3d dp.
        int[][][] dp = new int[n][2][k+1];

        for(int a[][]:dp)
            for(int b[]:a)
                Arrays.fill(b,-1);

        return helper(prices,0,0,k,dp);
    }
}
```

### Problem: [best time to buy and sell stock with cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

```java
class Solution {
        // 0 -> you can buy
    // 1-> you can't buy

    int helper(int[] prices,int index,int buy, int[][] dp){
        if(index>=prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1)
            return dp[index][buy];
        int profit=Integer.MIN_VALUE;
        if(buy==0){
            profit= Math.max(
                -prices[index] + helper(prices,index+1,1,dp),
                0 + helper(prices,index+1,0,dp)
            );
        }else{
            profit= Math.max(
                prices[index] + helper(prices,index+2,0,dp),
                0 + helper(prices,index+1,1,dp)
            );
        }

        return dp[index][buy]=profit;

    }

    public int maxProfit(int[] prices) {
       int n= prices.length;
        int[][] dp= new int[n][2];

        for(int[] d: dp)
            Arrays.fill(d,-1);
        
        return helper(prices,0,0,dp);

    }
}
```

### Problem: [best time to buy and sell stock with transaction fee](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

```java
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n= prices.length;
        // either i've bought the stock or not 
        // btw its future ^-^
        int[] next= new int[2];
        //base case for n
        next[0]=next[1]=0;
        for(int i=n-1;i>=0;--i){
            // i can buy or not buy
            int[] cur = new int[2];

            // i won't buy, sell
            cur[0]= Math.max(
                prices[i]+next[1], // if i have bought it then i can sell it
                0+next[0]);       // otherwise i cant sell it so i cant add it
            // i will buy
            cur[1]= Math.max(
                -prices[i] - fee +next[0], // if i have sold so i can buy hence my profit will detuct
                0+next[1]);         // if i have bought (in future) i can't buy again so nothing to add


            next= cur;
        }
        return next[1];

    }
}
```

### Problem: [best time to buy and sell stock iii](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)

```java
class Solution {
    // sell -> 1 you can sell
    // buy -> 0 you cant sell
    int helper(int[] prices,int index,int buy,int transactionNum, int[][][] dp){
        if(transactionNum==0){
            return 0;
        }
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy][transactionNum]!=-1)
            return dp[index][buy][transactionNum];
        int profit=Integer.MIN_VALUE;
        if(buy==0){
            profit= Math.max(
                -prices[index] + helper(prices,index+1,1,transactionNum,dp),
                0 + helper(prices,index+1,0,transactionNum,dp)
            );
        }else{
            profit= Math.max(
                prices[index] + helper(prices,index+1,0,transactionNum-1,dp),
                0 + helper(prices,index+1,1,transactionNum,dp)
            );
        }

        return dp[index][buy][transactionNum]=profit;

    }
    public int maxProfit(int[] prices) {
        int n= prices.length;
        // n prices * buy or sell (2) * 0,1,2 transactions rn
        // these are the combinations that we can have hence the 3d dp.
        int[][][] dp = new int[n][2][3];

        for(int a[][]:dp)
            for(int b[]:a)
                Arrays.fill(b,-1);

        return helper(prices,0,0,2,dp);
    }
}
```

### Problem: [best time to buy and sell stock ii](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int n=prices.length;
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1])
                profit+= prices[i] - prices[i-1];
        }
        return profit;
    }
}
```

### Problem: [best time to buy and sell stock ii](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

```java
class Solution {
    // 1 -> you can buy
    // 0-> you can't buy

    public int maxProfit(int[] prices) {
        int n= prices.length;
        // either i've bought the stock or not 
        // btw its future ^-^
        int[] next= new int[2];
        //base case for n
        next[0]=next[1]=0;
        for(int i=n-1;i>=0;--i){
            // i can buy or not buy
            int[] cur = new int[2];

            // i won't buy, sell
            cur[0]= Math.max(
                prices[i]+next[1], // if i have bought it then i can sell it
                0+next[0]);       // otherwise i cant sell it so i cant add it
            // i will buy
            cur[1]= Math.max(
                -prices[i]+next[0], // if i have sold so i can buy hence my profit will detuct
                0+next[1]);         // if i have bought (in future) i can't buy again so nothing to add


            next= cur;
        }
        return next[1];
    }
}
```

### Problem: [best time to buy and sell stock ii](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

```java
class Solution {
    // 0 -> you can buy
    // 1-> you can't buy

    int helper(int[] prices,int index,int buy, int[][] dp){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1)
            return dp[index][buy];
        int profit=Integer.MIN_VALUE;
        if(buy==0){
            profit= Math.max(
                -prices[index] + helper(prices,index+1,1,dp),
                0 + helper(prices,index+1,0,dp)
            );
        }else{
            profit= Math.max(
                prices[index] + helper(prices,index+1,0,dp),
                0 + helper(prices,index+1,1,dp)
            );
        }

        return dp[index][buy]=profit;

    }

    public int maxProfit(int[] prices) {
        int n= prices.length;
        // either i've bought the stock or not 
        // btw its future ^-^
        int[] next= new int[2];
        //base case for n
        next[0]=next[1]=0;
        for(int i=n-1;i>=0;--i){
            // i can buy or not buy
            int[] cur = new int[2];

            // i won't buy, sell
            cur[0]= Math.max(
                prices[i]+next[1],
                0+next[0]);
            // i will buy
            cur[1]= Math.max(
                -prices[i]+next[0],
                0+next[1]);


            next= cur;
        }
        return next[1];


        // for(int[] d: dp)
        //     Arrays.fill(d,-1);
        
        // return helper(prices,0,0,dp);
    }
}
```

### Problem: [best time to buy and sell stock ii](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

```java
class Solution {
    // 0 -> you can buy
    // 1-> you can't buy

    int helper(int[] prices,int index,int buy, int[][] dp){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1)
            return dp[index][buy];
        int profit=Integer.MIN_VALUE;
        if(buy==0){
            profit= Math.max(
                -prices[index] + helper(prices,index+1,1,dp),
                0 + helper(prices,index+1,0,dp)
            );
        }else{
            profit= Math.max(
                prices[index] + helper(prices,index+1,0,dp),
                0 + helper(prices,index+1,1,dp)
            );
        }

        return dp[index][buy]=profit;

    }

    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[][] dp= new int[n][2];

        for(int[] d: dp)
            Arrays.fill(d,-1);
        
        return helper(prices,0,0,dp);
    }
}
```

### Problem: [rotate image](https://leetcode.com/problems/rotate-image/)

```java
class Solution {
    void swap(int[][] mat,int a,int b,int x,int y){

        int temp=mat[a][b];
        mat[a][b]=mat[x][y];
        mat[x][y]=temp;
    }
    public void rotate(int[][] mat) {
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                // mat[i][j] <-> mat[j][i]
                swap(mat,i,j,j,i);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                // mat[i][j] <-> mat[i][n-1-j]
                swap(mat,i,j,i,n-1-j);
            }
        }


    }
}
```

### Problem: [maximum subarray](https://leetcode.com/problems/maximum-subarray/)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int sum=0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            maxsum=Math.max(maxsum,sum);
            if(sum<0)
                sum=0;
        }
        return maxsum;
    }
}
```

### Problem: [best time to buy and sell stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int minprice=prices[0];

        for(int i=1;i<prices.length;i++){
            minprice= Math.min(minprice,prices[i]);
            maxprofit= Math.max(maxprofit,prices[i]-minprice);
        }

        return maxprofit;
    }
}
```

### Problem: [sort colors](https://leetcode.com/problems/sort-colors/)

```java
class Solution {
    void swap(int i,int j, int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(mid,low,nums);
                low++;
                mid++;
            }else if(nums[mid]==2){
                swap(mid,high,nums);
                high--;
            }else{
                mid++;
            }
        }
    }
}
```

### Problem: [next permutation](https://leetcode.com/problems/next-permutation/)

```java
class Solution {
    public void nextPermutation(int[] nums) {
        
        int index=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }

        if(index==-1){
            for(int i=0;i<n/2;i++){
                int temp =nums[i];
                nums[i]=nums[n-i-1];
                nums[n-i-1]=temp;
            }
            return;
        }

        
        for(int i=n-1;i>index;i--){
            if(nums[i]>nums[index]){
                int temp =nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                break;
            }
            
        }
        
        for(int i=index+1,j=n-1;i<j;i++,j--){
                int temp =nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
        }
    }

}
```

### Problem: [find triangular sum of an array](https://leetcode.com/problems/find-triangular-sum-of-an-array/)

```java
class Solution {
    public int triangularSum(int[] nums) {

        int n = nums.length;
        for (int i = n; i >= 0; --i) {
            for (int j = 0; j < i - 1; ++j) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}
```

### Problem: [find triangular sum of an array](https://leetcode.com/problems/find-triangular-sum-of-an-array/)

```java
class Solution {
    public int triangularSum(int[] nums) {

        int n= nums.length;
        // base case
        List<Integer> temp = new ArrayList<>();
        for(int i: nums)
            temp.add(i);


        for(int i=1;i<n;i++){
            
            List<Integer> next = new ArrayList<>();
            for(int j=0;j<n-i;j++)
            {
                int summ = (temp.get(j) + temp.get(j+1))%10;
                next.add(summ);
            }
            temp=next;
        }
        return temp.get(0);
    }
}
```

### Problem: [pascals triangle ii](https://leetcode.com/problems/pascals-triangle-ii/)

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> ans= new ArrayList<Integer>();
        long res=1;
        ans.add((int)res);
        for(int i=1;i<rowIndex;i++){
            res*= rowIndex-i;
            res/= i;
            ans.add((int)res);
        }
        
        return ans;
    }
}
```

### Problem: [pascals triangle](https://leetcode.com/problems/pascals-triangle/)

```java
class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans= new ArrayList<>();

        for(int i=0;i<n;i++){
            List<Integer> row= new ArrayList<>();
            if(i==0)
                row.add(1);
            else
                for(int j=0;j<i+1;j++){
                    
                    if(j==0 || j==i )
                        row.add(1);
                    else{
                        int side= ans.get(i-1).get(j-1);
                        int up= ans.get(i-1).get(j);
                        row.add(side+up);
                    }
                }

            ans.add(row);
        }

        return ans;
    }
}
```

### Problem: [set matrix zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

```java
class Solution {
    public void setZeroes(int[][] mat) {
        int firstrow=-1;
        int r= mat.length;
        int c=mat[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    mat[i][0]=0;
                    if(j==0)
                        firstrow=0;
                    else
                        mat[0][j]=0;
                }
            }
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(mat[0][j]==0 || mat[i][0]==0){
                    mat[i][j]=0;
                }
            }
        }

        if(mat[0][0]==0)
        for(int i=0;i<c;i++)
            mat[0][i]=0;
        

        if(firstrow==0)
        for(int j=0;j<r;j++)
            mat[j][0]=0;

    }
}
```

### Problem: [set matrix zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

```java
class Solution {
    public void setZeroes(int[][] mat) {
        int r= mat.length;
        int c=mat[0].length;
        boolean[] row= new boolean[r];
        boolean[] col= new boolean[c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(row[i]==true || col[j]==true){
                   mat[i][j]=0;
                }
            }
        }
    }
}
```

### Problem: [partition equal subset sum](https://leetcode.com/problems/partition-equal-subset-sum/)

```java
class Solution {
    //revist needed
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n= nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target=sum/2;
        if(sum%2!=0)
            return false;
        boolean[] prev= new boolean[target+1];
        
        prev[0]=true;
        if(nums[0]<=target)
            prev[nums[0]]=true;

        for(int i=1;i<n;i++){
            boolean[] cur= new boolean[target+1];
            cur[0]=true;
            for(int j=1;j<=target;j++){
                boolean notpick= prev[j];
                boolean pick=false;
                if(nums[i]<=j)
                   pick= prev[j-nums[i]];

                cur[j]= pick || notpick;
          
            }

            prev=cur;
        }

        return prev[target];
    }
}
```

### Problem: [minimum falling path sum](https://leetcode.com/problems/minimum-falling-path-sum/)

```java
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row= matrix.length;
        int col= matrix[0].length;
        int[] prev= new int[row];
        for(int i=0;i<row;i++)
            prev[i]=matrix[0][i];
        
        for(int m=1;m<row;m++){
            int[] cur= new int[row];
            for(int n=0;n<col;n++){
                int val=Integer.MAX_VALUE;
                for(int j=-1;j<=1;j++){
                    if(n+j>=0 && n+j<col)
                        val= Math.min(
                            matrix[m][n]+prev[n+j], val);
                }
                cur[n]=val;
            }
            prev=cur;
        }
        int minval=Integer.MAX_VALUE;
        for(int i=0;i<col;i++){
            minval=Math.min(prev[i],minval);
        }
        return minval;
    }
}
```

### Problem: [minimum falling path sum](https://leetcode.com/problems/minimum-falling-path-sum/)

```java
class Solution {
    int helper(int[][] mat, int m,int n,int[][] dp){
        if(m<0 || m>= mat.length || n<0 || n>= mat[0].length){
            return Integer.MAX_VALUE;
        }
        if(m==0){
            return mat[m][n];
        }
        if(dp[m][n]!=-1)
            return dp[m][n];

        int ans=Integer.MAX_VALUE;
        
        for(int j=-1;j<=1;j++){
                if(m-1>=0 && n+j>=0 && n+j<mat[0].length)
                    ans= Math.min(
                        mat[m][n]+helper(mat,m-1,n+j,dp), ans
                    );
        }

        return dp[m][n]=ans;
    }
    public int minFallingPathSum(int[][] matrix) {
        int row= matrix.length;
        int col= matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++)
            dp[0][i]=matrix[0][i];

        for(int m=1;m<row;m++){
            for(int n=0;n<col;n++){
                int val=Integer.MAX_VALUE;
                for(int j=-1;j<=1;j++){
                    if(n+j>=0 && n+j<col)
                        val= Math.min(
                            matrix[m][n]+dp[m-1][n+j], val);
                }
                dp[m][n]=val;
            }
        }
        int minval=Integer.MAX_VALUE;
        for(int i=0;i<col;i++){
            minval=Math.min(dp[row-1][i],minval);
        }
        return minval;
    }
}
```

### Problem: [minimum falling path sum](https://leetcode.com/problems/minimum-falling-path-sum/)

```java
class Solution {
    int helper(int[][] mat, int m,int n,int[][] dp){
        if(m<0 || m>= mat.length || n<0 || n>= mat[0].length){
            return Integer.MAX_VALUE;
        }
        if(m==0){
            return mat[m][n];
        }
        if(dp[m][n]!=-1)
            return dp[m][n];

        int ans=Integer.MAX_VALUE;
        
        for(int j=-1;j<=1;j++){
                if(m-1>=0 && n+j>=0 && n+j<mat[0].length)
                    ans= Math.min(
                        mat[m][n]+helper(mat,m-1,n+j,dp), ans
                    );
        }

        return dp[m][n]=ans;
    }
    public int minFallingPathSum(int[][] matrix) {
        int row= matrix.length;
        int col= matrix[0].length;
        int[][] dp = new int[row][col];
        // for(int[] d:dp)
        //     Arrays.fill(d,-1);

        for(int i=0;i<row;i++)
            dp[0][i]=matrix[0][i];
        
        // for(int i=0;i<matrix[0].length;i++){
        // int val=helper(matrix,matrix.length-1,i,dp);
        //  for(int j=-1;j<=1;j++){
        //         if(m-1>=0 && n+j>=0 && n+j<mat[0].length)
        //             ans= Math.min(
        //                 mat[m][n]+helper(mat,m-1,n+j,dp), ans
        //             );
        // }
        // minval=Math.min(minval,val);
        // }


        for(int m=1;m<row;m++){
            for(int n=0;n<col;n++){
                int val=Integer.MAX_VALUE;
                for(int j=-1;j<=1;j++){
                    if(n+j>=0 && n+j<col)
                        val= Math.min(
                            matrix[m][n]+dp[m-1][n+j], val);
                }
                dp[m][n]=val;
            }
        }
        int minval=Integer.MAX_VALUE;
        for(int i=0;i<col;i++){
            minval=Math.min(dp[row-1][i],minval);
        }
        return minval;
    }
}
```

### Problem: [partition equal subset sum](https://leetcode.com/problems/partition-equal-subset-sum/)

```java
class Solution {
    //revist needed
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n= nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target=sum/2;
        if(sum%2!=0)
            return false;
        boolean[] prev= new boolean[target+1];
        
        prev[0]=true;
        if(nums[0]<=target)
            prev[nums[0]]=true;

        for(int i=1;i<n;i++){
            boolean[] cur= new boolean[target+1];
            cur[0]=true;
            for(int j=1;j<=target;j++){
                boolean notpick= prev[j];
                boolean pick=false;
                if(nums[i]<=j)
                   pick= prev[j-nums[i]];

                cur[j]= pick || notpick;
          
            }

            prev=cur;
        }

        return prev[target];
    }
}
```

### Problem: [partition equal subset sum](https://leetcode.com/problems/partition-equal-subset-sum/)

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n= nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target=sum/2;
        if(sum%2!=0)
            return false;
        boolean[][] dp = new boolean[n][target+1];
        
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        
        if(nums[0]<=target)
            dp[0][nums[0]]=true;

        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                boolean notpick= dp[i-1][j];
                boolean pick=false;
                if(nums[i]<=j)
                   pick= dp[i-1][j-nums[i]];

                dp[i][j]= pick || notpick;
          
            }
        }

        return dp[n-1][target];
    }
}
```

### Problem: [partition equal subset sum](https://leetcode.com/problems/partition-equal-subset-sum/)

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n= nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target=sum/2;
        if(sum%2!=0)
            return false;
        boolean[][] dp = new boolean[n][target+1];
        
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        
        if(nums[0]<=target)
            dp[0][nums[0]]=true;

        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                boolean notpick= dp[i-1][j];
                boolean pick=false;
                if(nums[i]<=j)
                   pick= dp[i-1][j-nums[i]];

                dp[i][j]= pick || notpick;
          
            }
        }

        return dp[n-1][target];
    }
}
```

### Problem: [partition equal subset sum](https://leetcode.com/problems/partition-equal-subset-sum/)

```java
class Solution {
    boolean helper(int[] arr,int i,int target,int[][] dp){
        if(target==0)
            return true;
        if(i==0)
            return arr[0]==target;
        if(dp[i][target]!=-1)
            return dp[i][target]==0?false:true;
        
        boolean notpick = helper(arr,i-1,target,dp);
        boolean pick = false;
        if(arr[i]<=target)
            pick=helper(arr,i-1,target-arr[i],dp);
        
        dp[i][target] = notpick || pick ? 1 : 0;

        return notpick || pick;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n= nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target=sum/2;
        if(sum%2!=0)
            return false;
        int[][] dp = new int[n][target+1];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        return helper(nums,n-1,target,dp);
        // boolean[][] dp = new boolean[n][target+1];
        
        // for(int i=0;i<target+1;i++){
        //     dp[0][i]=true;
        // }
        
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<=target;j++){
        //         boolean notpick= dp[i-1][j];
        //         boolean pick=false;
        //         if(nums[i]<=j)
        //            pick= dp[i-1][j-nums[i]];

        //         dp[i][j]= pick | notpick;            
        //     }
        // }

        // return dp[n-1][target];
    }
}
```

### Problem: [minimum path sum](https://leetcode.com/problems/minimum-path-sum/)

```java
class Solution {
    int helper(int[][] grid,int m,int n,int cursum,int[][] dp){

        
        if(m==0 && n==0){
            return grid[m][n];
        }

        if(m<0 || n< 0){
            // return any large number to negelect it
            return Integer.MAX_VALUE;
        }

        if(dp[m][n]!=-1)
            return dp[m][n];

        int up= helper(grid,m-1,n,cursum,dp);
        int right= helper(grid,m,n-1,cursum,dp);
        return dp[m][n]=Math.min(up,right)+ grid[m][n];
    }
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int[][] dp= new int[m][n];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        return helper(grid,m-1,n-1,0,dp);
        
    }
}
```

### Problem: [triangle](https://leetcode.com/problems/triangle/)

```java
class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==0)
            return 0;
        int[][] dp= new int[n][];
        for(int i=0;i<n;i++){
            dp[i]= new int[i+1];
            // Arrays.fill(dp[i],-1);
        }
        dp[0][0]= triangle.get(0).get(0);

        for(int i=1;i<n;i++){

            for(int j=0;j<i+1;j++){
                if(j==0){
                    //up add.
                    dp[i][j]= triangle.get(i).get(j) + dp[i-1][j];
                }else{
                    int side=dp[i-1][j-1];
                    int up=Integer.MAX_VALUE;
                    if(dp[i-1].length>j)
                        up=dp[i-1][j];

                    dp[i][j]= triangle.get(i).get(j) + Math.min(up,side);
                }
            }
        }
        
        int sum= Integer.MAX_VALUE;
        for(int i=0;i<dp[n-1].length;i++){
            sum= Math.min(sum,dp[n-1][i]);
        }
        return sum;
    }
}
```

### Problem: [triangle](https://leetcode.com/problems/triangle/)

```java
class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==0)
            return 0;
        int[][] dp= new int[n][];
        for(int i=0;i<n;i++){
            dp[i]= new int[i+1];
            // Arrays.fill(dp[i],-1);
        }
        dp[0][0]= triangle.get(0).get(0);

        for(int i=1;i<n;i++){

            for(int j=0;j<i+1;j++){
                if(j==0){
                    //up add.
                    dp[i][j]= triangle.get(i).get(j) + dp[i-1][j];
                }else{
                    int side=dp[i-1][j-1];
                    int up=Integer.MAX_VALUE;
                    if(dp[i-1].length>j)
                        up=dp[i-1][j];

                    dp[i][j]= triangle.get(i).get(j) + Math.min(up,side);
                }
            }
        }
        
        int sum= Integer.MAX_VALUE;
        for(int i=0;i<dp[n-1].length;i++){
            sum= Math.min(sum,dp[n-1][i]);
        }
        return sum;
    }
}
```

### Problem: [minimum path sum](https://leetcode.com/problems/minimum-path-sum/)

```java
class Solution {
    int helper(int[][] grid,int m,int n,int cursum,int[][] dp){

        
        if(m==0 && n==0){
            return grid[m][n];
        }

        if(m<0 || n< 0){
            // return any large number to negelect it
            return Integer.MAX_VALUE;
        }

        if(dp[m][n]!=-1)
            return dp[m][n];

        int up= helper(grid,m-1,n,cursum,dp);
        int right= helper(grid,m,n-1,cursum,dp);
        return dp[m][n]=Math.min(up,right)+ grid[m][n];
    }
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int[][] dp= new int[m][n];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        return helper(grid,m-1,n-1,0,dp);
        
    }
}
```

### Problem: [unique paths ii](https://leetcode.com/problems/unique-paths-ii/)

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n =obstacleGrid[0].length;
         int[][] dp = new int[m][n];

        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
         
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else if(i==0 && j==0)
                    dp[0][0]=1;
                else{
                    int up=0,right=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) right=dp[i][j-1];
                    dp[i][j]= up + right;
                }
            }
        }

        return dp[m-1][n-1];
    }
}
```

### Problem: [unique paths](https://leetcode.com/problems/unique-paths/)

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)
                    dp[0][0]=1;
                else{
                    int up=0,right=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) right=dp[i][j-1];
                    dp[i][j]= up + right;
                }
            }
        }

        return dp[m-1][n-1];
    }
}
```

### Problem: [unique paths](https://leetcode.com/problems/unique-paths/)

```java
class Solution {
    int helper(int[][] dp,int m,int n){
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        int up = helper(dp,m,n-1);
        int right= helper(dp,m-1,n);

        return dp[m][n]= up+right;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        
        
        return helper(dp,m-1,n-1);
    }
}
```

### Problem: [house robber ii](https://leetcode.com/problems/house-robber-ii/)

```java
class Solution {
    int helper(int[] nums,int start,int end){
          int prev2=0; // i-2
        int prev1=nums[start]; //i-1
        for(int i=start+1;i<=end;i++){
            int pick= nums[i] + prev2;
            int notpick= prev1;
            int max=Math.max(pick,notpick);
            prev2=prev1;
            prev1=max;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
       return Math.max(
           helper(nums,0,n-2),helper(nums,1,n-1)
        );
    }
}
```

### Problem: [house robber](https://leetcode.com/problems/house-robber/)

```java
class Solution {
    public int rob(int[] nums) {
        int prev2=0; // i-2
        int prev1=nums[0]; //i-1
        for(int i=1;i<nums.length;i++){
            int pick= nums[i] + prev2;
            int notpick= prev1;

            int max=Math.max(pick,notpick);
            prev2=prev1;
            prev1=max;
        }
        return prev1;
    }
}
```

### Problem: [vertical order traversal of a binary tree](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static void helper(TreeNode temp,int level, int vertical,
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map){
        if(temp==null){
            return;
        }

        // if vertical does not exist create one
        if(!map.containsKey(vertical))
            map.put(vertical,new TreeMap<>());
        // check if the current level exist in the map
        if(!map.get(vertical).containsKey(level)){
            map.get(vertical).put(level,new PriorityQueue<>());
        }

        map.get(vertical).get(level).offer(temp.val);

        helper(temp.left,level+1,vertical-1,map);
        helper(temp.right,level+1,vertical+1,map);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        // using tree map to store values in ascending order of the verticals
        // using priority queue to poll elements in ascending order of the level and if its same then ascending order of val
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        helper(root,0,0,map);
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> outerVal: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > innerVal: outerVal.values()) {
                while (!innerVal.isEmpty()) {
                    // add elements in the last 'list' of list
                    list.get(list.size() - 1).add(innerVal.poll());
                }
            }
        }
        return list;
    }
}

// ArrayList<Integer> valueList=hm.get(level);
        // if(valueList==null)
        //     valueList= new ArrayList<>();
        // valueList.add(temp.val);
        // hm.put(level,valueList);
```

### Problem: [binary tree zigzag level order traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // dfs method and not so obvious but interesting
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> result = new ArrayList<>();
        helper(result,0,root);
        return result;
    }
    // for better understanding create a recursion tree. 
    void helper(List<List<Integer>> result, int level,TreeNode temp){
        if(temp==null){
            return;
        }

        // for first call of every level add the list
        // this statement will be excuted first and is capabale to 
        // create list in the correct sequence thanks to recursion
        if(level==result.size()){
            result.add(new ArrayList<Integer>());
        }

        // add the value to result at the current level.
        // if odd then add at the start (to inverse)
        if(level%2==0)
            result.get(level).add(temp.val);
        else
            result.get(level).add(0,temp.val);


        helper(result,level+1,temp.left);
        helper(result,level+1,temp.right);
    }
}
```

### Problem: [binary tree level order traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result,0,root);
        return result;
    }
    // for better understanding create a recursion tree. (kinda love the intuition)
    void helper(List<List<Integer>> result, int level,TreeNode temp){
        if(temp==null){
            return;
        }

        // for first call of every level add the list
        // this statement will be excuted first and is capabale to 
        // create list in the correct sequence thanks to recursion
        if(level==result.size()){
            result.add(new ArrayList<Integer>());
        }

        // add the value to result at the current level.
        result.get(level).add(temp.val);

        helper(result,level+1,temp.left);
        helper(result,level+1,temp.right);
    }
}
```

### Problem: [binary tree zigzag level order traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // simpler method and obvious one
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> f = new ArrayList<>();
    if (root == null) {
      return f;
    }
    TreeNode curr = root;
    q.add(root);
    int c = 0, sz = 0;
    while (!q.isEmpty()) 
    {
      
      sz = q.size();
      List<Integer> ans = new ArrayList<>();
      for (int i = 0; i < sz; i++) 
      {
        q.poll();
        ans.add(curr.val);
        
          if (curr.left != null)
            q.add(curr.left);
          if (curr.right != null)
            q.add(curr.right);
          curr=q.peek();
      }
        if(c%2!=0)
        {
          Collections.reverse(ans);
        }
      f.add(ans);
      c++;
    }
    return f;
  }
}
```

### Problem: [binary tree zigzag level order traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode>  leftFirstStack = new Stack<TreeNode>();
        Stack<TreeNode>  rightFirstStack = new Stack<TreeNode>();
        boolean direction=true; // true for left first insertion
        if(root!=null)
            rightFirstStack.push(root);
        
        while(!rightFirstStack.isEmpty() || !leftFirstStack.isEmpty()){
            if(direction){
                List<Integer> ls = new ArrayList<>();
                while(!rightFirstStack.isEmpty()){
                    TreeNode node = rightFirstStack.pop();
                    ls.add(node.val);
                    if(node.left!=null)
                        leftFirstStack.push(node.left);
                    if(node.right!=null)
                        leftFirstStack.push(node.right);
                }
                result.add(ls);
            }else{
                List<Integer> ls = new ArrayList<>();
                while(!leftFirstStack.isEmpty()){
                    TreeNode node = leftFirstStack.pop();
                    ls.add(node.val);
                    if(node.right!=null)
                        rightFirstStack.push(node.right);
                    if(node.left!=null)
                        rightFirstStack.push(node.left);
                }
                result.add(ls);
            }

            direction = !direction;
        }

        return result;
    }
}
```

### Problem: [binary tree maximum path sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxsum;
    int helper(TreeNode temp) {
        if(temp==null){
            return 0;
        }

        int left = Math.max(0,helper(temp.left));
        int right = Math.max(0,helper(temp.right));
        int sum= left+right+temp.val;
        maxsum= Math.max(sum,maxsum);
        
       return Math.max(left,right)+temp.val;
    }
    public int maxPathSum(TreeNode root) {
        maxsum=root.val;
        helper(root);
        return maxsum;
    }
}
```

### Problem: [diameter of binary tree](https://leetcode.com/problems/diameter-of-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxdia=0;
    int helper(TreeNode root){
        if(root==null)
            return 0;


        int left = helper(root.left);
        int right = helper(root.right);
        int dia = left +right;
        maxdia= Math.max(dia,maxdia);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxdia;
    }
}
```

### Problem: [same tree](https://leetcode.com/problems/same-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }

        if(p.val!= q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
```

### Problem: [majority element](https://leetcode.com/problems/majority-element/)

```java
class Solution {
    public int majorityElement(int[] nums) {
       int num=nums[0];
       int count=1;
       for(int i=1;i<nums.length;i++){
           if(num==nums[i]){
               count++;
           }
           else count--;

           if(count==0){
               num=nums[i];
               count=1;
           }
       }
       return num;
    }
}
```

### Problem: [maximum length of a concatenated string with unique characters](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/)

```java
class Solution {
    //? first solution
    int helper(String str, List<String> arr,int index){
        if(arr.size()==index){
            return str.length(); 
        }
        boolean possibleConcat=true;
        for(int i=0;i<arr.get(index).length();i++){
            if(str.contains(arr.get(index).charAt(i) +""))
                possibleConcat=false;
            
        }

        if(!possibleConcat){
            return helper(str,arr,index+1);
        }
        int with=helper(str+arr.get(index),arr,index+1);
        int without=helper(str,arr,index+1);
        return Math.max(with,without);
        
    }
    public int maxLength(List<String> arr) {
        
        Iterator<String> iterator = arr.iterator();

        while (iterator.hasNext()) {
        String str = iterator.next();
        boolean[] alpha = new boolean[26];
        
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';
                if (alpha[index]) {
                    iterator.remove();
                    break; 
                } else {
                    alpha[index] = true;
                }
            }
        }
        if(arr.size()==0)
            return 0;
        return helper("",arr,0);

    }
}
```

### Problem: [majority element](https://leetcode.com/problems/majority-element/)

```java
class Solution {
    public int majorityElement(int[] nums) {
       Arrays.sort(nums);
       int num=nums[0];
       int maxNumInd=0;
        int maxNum=nums[0];
       int numInd=1;
    
        for(int i=1;i<nums.length;i++){
            if(nums[i]==num){
                numInd++;
            }else{
               numInd=1;
                num=nums[i];
            }

            if(numInd>maxNumInd){
                    maxNumInd=numInd;
                    maxNum=num;
            }
        }
        return maxNum;
    }
}
```

### Problem: [sort colors](https://leetcode.com/problems/sort-colors/)

```java
class Solution {
    public void sortColors(int[] nums) {
        
        int start=0;
        int end= nums.length-1;
        while(start<end){
            if(nums[start]!=2){
                start++;
                continue;
            }
            if(nums[end]==2){
                end--; continue;
            }
            int temp= nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++; end--;
        }

        start=0;
        while(start<=end){
            if(nums[end]!=0){
                end--;
                continue;
            }
            if(nums[start]==0){
                start++; continue;
            }
            int temp= nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++; end--;
        }
    }
}
```

### Problem: [binary tree level order traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         if (root == null) 
            return new LinkedList<List<Integer>>(); 
        
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);

        List<List<Integer>> outer= new LinkedList<List<Integer>>();
        while(!q.isEmpty()){
            int n= q.size();
            List<Integer> inner = new LinkedList<Integer>();

            for(int i=0;i<n;i++){
                TreeNode node = q.peek();
                inner.add(q.poll().val);
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            outer.add(inner);
        }
        return outer;
    }
}
```

### Problem: [reverse linked list](https://leetcode.com/problems/reverse-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode helper(ListNode prev,ListNode temp){
        if(temp.next==null){
            temp.next=prev;
            return temp;
        }
        ListNode nextNode=temp.next;
        temp.next=prev;
        return helper(temp,nextNode);
    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        return helper(null,head);
    }
}
```

### Problem: [validate binary search tree](https://leetcode.com/problems/validate-binary-search-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private boolean helper(TreeNode temp,long left_range, long right_range) {
         if(temp==null)
            return true;
        
        if(temp.val<=left_range || temp.val>=right_range)
            return false;
        
        return helper(temp.left,left_range,temp.val) && 
        helper(temp.right,temp.val,right_range);
    }
    public boolean isValidBST(TreeNode root) {
       return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
```

### Problem: [insert into a binary search tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void helper(TreeNode temp, int val) {
         if(temp==null)
            return;
        
        if(temp.val>val){
            if(temp.left==null){
                TreeNode newNode = new TreeNode(val);
                temp.left=newNode;
            }else
                helper(temp.left,val);
            
        }else if(temp.val<val){
            if(temp.right==null){
                TreeNode newNode = new TreeNode(val);
                temp.right=newNode;
            }else
                helper(temp.right,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            root = new TreeNode(val);
        else
            helper(root,val);
       return root;
    }
}
```

### Problem: [balanced binary tree](https://leetcode.com/problems/balanced-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    // height belong to {-1,0,1}
    public int helper(TreeNode node,int height) {
        if(node==null){
            return height;
        }
        int left_height=helper(node.left,height+1);
        int right_height=helper(node.right,height+1);
        if(left_height-right_height>=-1 && left_height-right_height<=1) 
            return Math.max(left_height,right_height);
        return -1 ;
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root,0)==-1?false:true;
    }
}
```

### Problem: [subsets](https://leetcode.com/problems/subsets/)

```java
class Solution {
    // This uses backtracking
    
    void helper(List<Integer> list,int[] nums,int index,List<List<Integer>> result){
        if(nums.length==index){
            result.add(new ArrayList<>(list));
            return;
        }
        
        helper(list,nums,index+1,result);
        list.add(nums[index]);
        helper(list,nums,index+1,result);
        list.remove(list.size()-1);
       
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        helper(new ArrayList<Integer>(){},nums,0,result);
        return result;
    }
}
```

### Problem: [subsets](https://leetcode.com/problems/subsets/)

```java
class Solution {
    // This uses backtracking
    List<List<Integer>> result;
    void helper(List<Integer> list,int[] nums,int index){
        if(nums.length==index){
            result.add(new ArrayList<>(list));
            return;
        }
        
        helper(list,nums,index+1);
        list.add(nums[index]);
        helper(list,nums,index+1);
        list.remove(list.size()-1);
       
    }
    public List<List<Integer>> subsets(int[] nums) {
        result= new ArrayList<List<Integer>>();
        helper(new ArrayList<Integer>(){},nums,0);
        return result;
    }
}
```

### Problem: [subsets](https://leetcode.com/problems/subsets/)

```java
class Solution {
    List<List<Integer>> result;
    void helper(List<Integer> list,int[] nums){
        if(nums.length==0){
            result.add(list);
            return;
        }
        
        helper(list, Arrays.copyOfRange(nums,1,nums.length));
        List<Integer> newList= new ArrayList<>(list);
        newList.add(nums[0]);
        helper(newList, Arrays.copyOfRange(nums,1,nums.length));
        
       
    }
    public List<List<Integer>> subsets(int[] nums) {
        result= new ArrayList<List<Integer>>();
        helper(new ArrayList<Integer>(){},nums);
        return result;
    }
}
```

### Problem: [merge sorted array](https://leetcode.com/problems/merge-sorted-array/)

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] mix=new int[m+n];

        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                mix[k]=nums1[i];
                i++;
            }else{
                mix[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i < m){
            mix[k]=nums1[i];
            i++;
            k++;
        }
        while(j< n){
            mix[k]=nums2[j];
            j++;
            k++;
        }
        for(int l=0;l<mix.length;l++){
            nums1[l]=mix[l];
        }
    }
}
```

### Problem: [remove duplicates from sorted array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[index++]= nums[i];
            }
        }
        return index;
    }
}
```

### Problem: [remove element](https://leetcode.com/problems/remove-element/)

```java
class Solution {                        
    public int removeElement(int[] nums, int val) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[index]= nums[i];
                index++;
            }
        }
        
        return index;
    }
}
```

### Problem: [remove element](https://leetcode.com/problems/remove-element/)

```java
class Solution {
    // brute force
    public int removeElement(int[] nums, int val) {
        int counter=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                nums[i]= -1;
                counter++;
            }
        }

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]==-1){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums.length-counter;
    }
}
```

### Problem: [climbing stairs](https://leetcode.com/problems/climbing-stairs/)

```java
class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int a=1; //ways for 1
        int b=2; //ways for 2
        int sum_next=a+b;
        for(int i=3;i<=n;i++){
            sum_next=a+b;
            a=b;
            b=sum_next;
        }

        return sum_next;
    }
}
```

### Problem: [kth smallest element in a bst](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int count=0;
    public TreeNode helper(TreeNode temp, int k) {


        if(temp==null){
            return null;
        }

        TreeNode left_right = helper(temp.left,k);
        if(left_right!=null)
            return left_right;
        
        count++;
        if(k==count)
            return temp;

        return helper(temp.right,k);  
    }

    public int kthSmallest(TreeNode root, int k) {

        TreeNode node = helper(root,k);
        return node.val;

    }
}
```

### Problem: [insert into a binary search tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void helper(TreeNode temp, int val) {
         if(temp==null)
            return;
        
        if(temp.val>val){
            if(temp.left==null){
                TreeNode newNode = new TreeNode(val);
                temp.left=newNode;
            }else
                helper(temp.left,val);
            
        }else if(temp.val<val){
            if(temp.right==null){
                TreeNode newNode = new TreeNode(val);
                temp.right=newNode;
            }else
                helper(temp.right,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            root = new TreeNode(val);
        else
            helper(root,val);
       return root;
    }
}
```

### Problem: [search in a binary search tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
            return null;
        

        if(root.val==val)
            return root;
        else if(root.val>val)
            return searchBST(root.left,val);
        
        return searchBST(root.right,val);
    }
}
```

### Problem: [maximum depth of binary tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int helper(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(helper(node.left)+1, helper(node.right)+1);
    }
    public int maxDepth(TreeNode root) {
        return helper(root);
    }
}
```

### Problem: [maximum depth of binary tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int helper(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(node.left!=null? helper(node.left)+1:0, 
        node.right!=null? helper(node.right)+1:0 );
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return helper(root)+1;
    }
}
```

### Problem: [construct binary tree from preorder and inorder traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int i=0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }

    
    return helper(preOrder, inOrder, 0, preOrder.length-1, map);
  }

  public TreeNode helper(int[] preOrder, int[] inOrder, int left, int right, HashMap<Integer, Integer> map) {
    if (left > right) {
      return null;
    }

    int current = preOrder[index];
    index++;

    TreeNode node = new TreeNode(current);

    if (left == right) {
      return node;
    }
    int currentIndex= map.get(current);
    node.left = helper(preOrder, inOrder, left, currentIndex - 1, map);
    node.right = helper(preOrder, inOrder, currentIndex + 1, right, map);

    return node;
  }
}
```

### Problem: [binary tree postorder traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> postorder = new ArrayList<Integer>();
        postorderHelper(root, postorder);
        return postorder;
    }


    void postorderHelper(TreeNode node, List<Integer> postorder){

        if(node==null){
            return;
        }

        postorderHelper(node.left,postorder);
        postorderHelper(node.right,postorder);
        postorder.add(node.val);
    }
}
```

### Problem: [binary tree inorder traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> inorder = new ArrayList<Integer>();
        inorderHelper(root, inorder);
        return inorder;
    }


    void inorderHelper(TreeNode node, List<Integer> inorder){

        if(node==null){
            return;
        }

        inorderHelper(node.left,inorder);
        inorder.add(node.val);
        inorderHelper(node.right,inorder);
    }
}
```

### Problem: [binary tree preorder traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        preorderHelper(root, preorder);
        return preorder;
    }


    void preorderHelper(TreeNode node, List<Integer> preorder){

        if(node==null){
            return;
        }

        preorder.add(node.val);
        preorderHelper(node.left,preorder);
        preorderHelper(node.right,preorder);
    }
}
```

### Problem: [counting bits](https://leetcode.com/problems/counting-bits/)

```java
class Solution {
    public int[] countBits(int n) {
        int[] ans= new int[n+1];
        ans[0]=0;
        for(int i=1;i<=n;i++){
            ans[i]= ans[i>>1] + (i&1);
        }
        return ans;
    }
}
```

### Problem: [combination sum](https://leetcode.com/problems/combination-sum/)

```java
import java.util.*;

class Solution {
    private HashSet<List<Integer>> helper(int[] original, List<Integer> combo, int sum, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();

        if (sum == target) {
            // Sort the combo before adding it to the HashSet
            Collections.sort(combo);
            ans.add(new ArrayList<>(combo));
        } else if (sum < target) {
            for (int i = 0; i < original.length; i++) {
                List<Integer> newCombo = new ArrayList<>(combo);
                newCombo.add(original[i]);
                HashSet<List<Integer>> recursiveResult = helper(original, newCombo, sum + original[i], target);

                if (recursiveResult != null) {
                    ans.addAll(recursiveResult);
                }
            }
        }

        return ans.isEmpty() ? null : ans;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> ans = helper(candidates, new ArrayList<>(), 0, target);
         if(ans==null) return new ArrayList<>();
        return new ArrayList<>(ans);
    }
}

  
```

### Problem: [merge strings alternately](https://leetcode.com/problems/merge-strings-alternately/)

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        StringBuilder sb=new StringBuilder(word2);
        int i=0; int j=0;
        while(i<m){   
            if(i>n){
                sb.append(word1.substring(i));
                break;
            }else
                sb.insert(j,word1.charAt(i));
            i++; j+=2;
        }
        return sb.toString();
    }
}
```

### Problem: [defanging an ip address](https://leetcode.com/problems/defanging-an-ip-address/)

```java
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder s= new StringBuilder(address);

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='.'){
                s.insert(i,"["); 
                i=i+2;
                s.insert(i,"]"); 
            }
        }

        return s.toString();
    }
}
```

### Problem: [build array from permutation](https://leetcode.com/problems/build-array-from-permutation/)

```java
class Solution {
    public int[] buildArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
           int a= nums[i] + (1001)*(nums[nums[i]]%1001);
           nums[i]=a;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]/=1001;
        }

        return nums;
    }
}
```

### Problem: [move zeroes](https://leetcode.com/problems/move-zeroes/)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        // pointer in array 
        int i=0;
        // now we will traverse all the elements and if we will find any non zero element 
        // we will set value to nums[i] to num.

        //Eg 1,2,0,0,1,2,0,0,3,4 -> 1,2,1,2,3,4,0,0,3,4
        for(int num:nums){
            if(num!=0){
                nums[i]=num;
                i++;
            }
        }

        // now we will set the remaining elements to zero
        while(i<nums.length){
            nums[i]=0;
            i++;
        }
    }
}
```

### Problem: [move zeroes](https://leetcode.com/problems/move-zeroes/)

```java
//* This uses 2 pointer approach */
// j pointer is at first zero index and i at j+1. 
class Solution {
    public static void swap(int[] a, int i, int j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
    }
    public void moveZeroes(int[] nums) {

        //? First we will find the position where j is non zero
        int j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                // we found our first non zero element so break here
                j=i;
                break;
            }
        }

        // if zero is not presesnt in the array we dont need to perform further steps
        if(j==-1) return;


        // if we found a non zero element the we will it with j and the increament j by one.
        // This is process all our non zero elements are visited and when j is increament it 
        // this j+1 element contains a zero element 
        for(int i=j+1;i<nums.length;i++){

            if(nums[i]!=0){
                swap(nums,i,j);
                j++;
            }
        }
    }
}
```

### Problem: [valid palindrome](https://leetcode.com/problems/valid-palindrome/)

```java

    class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append((char)(s.charAt(i)+32));
            }
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(s.charAt(i));
            }
        }
        boolean check = true;
        int start = 0;
        int end = sb.length()-1;
        while(start<end){
            char char1 = sb.charAt(start);
            char char2 = sb.charAt(end);
            if(char1 != char2){
                check = false;
                break;
            }
            start++;
            end--;
        }
        return check;
    }

}
```

### Problem: [valid palindrome](https://leetcode.com/problems/valid-palindrome/)

```java
class Solution {
    boolean helper(String str, int i){
        if(i>=str.length()/2) return true;

        return str.charAt(i)== str.charAt(str.length()-i-1) && helper(str,i+1);
    }
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]", "");
        s=s.replace(" ","");
        return helper(s.toLowerCase(),0);
    }
}
```

### Problem: [fibonacci number](https://leetcode.com/problems/fibonacci-number/)

```java
class Solution {
    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n <= 2){
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }
}
```

### Problem: [fibonacci number](https://leetcode.com/problems/fibonacci-number/)

```java
class Solution {
    public int fib(int n) {
        if(n==0|| n==1)
            return n;

        return fib(n-1)+fib(n-2);
    }
}
```

### Problem: [rotate image](https://leetcode.com/problems/rotate-image/)

```java
class Solution {
    public void rotate(int[][] mat) {
       int m=mat.length;
       
       int[][] mat2= new int[m][m];
       for(int i=0;i<m;i++)
        for(int j=0;j<m;j++)
            mat2[i][j]=mat[i][j];

        for(int i=0;i<m;i++)
            for(int j=m-1,k=0;j>=0;j--,k++)
                mat[i][k]=mat2[j][i];
    }
}
```

### Problem: [best time to buy and sell stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

```java
class Solution {
    public int maxProfit(int[] prices) {
        
        int min = prices[0], max = 0;
        for(int i = 1;i<prices.length;i++){
            max = Math.max(max, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
```

### Problem: [best time to buy and sell stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

```java
class Solution {
    public int maxProfit(int[] prices) {
        
        //? minimum stock
        int buyStock= Integer.MAX_VALUE;
        //? max stock - min stock
        int profit=0;

        for(int i=0;i<prices.length;i++){
            if(buyStock>prices[i]){
                buyStock=prices[i];
            }else{
                profit= Math.max(profit,prices[i]-buyStock);
            }
        }
        return profit;
    }
}
```

### Problem: [majority element](https://leetcode.com/problems/majority-element/)

```java
class Solution {
    public int majorityElement(int[] nums) {
       int count=1;
       int result=nums[0];

       for(int i=1;i<nums.length;i++){
           if(count==0) 
               result=nums[i];
           if(nums[i]==result) count++;
           else count--;
       }
       return result;

    }
}
```

### Problem: [majority element](https://leetcode.com/problems/majority-element/)

```java
import java.util.Arrays;
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
        // int p1=0,p2=0;
        // int count=0;
        // while(p2!=nums.length){
        //     if(nums[p1]==nums[p2]){
        //         count++;
        //         p2++;

        //         if(count>nums.length/2) {
        //             return nums[p1];
        //         }
        //     }
        //     else{
        //         p1=p2;
        //         p2++;
        //     }
            
        // }
        // return -1;

    }
}
```

### Problem: [majority element](https://leetcode.com/problems/majority-element/)

```java
import java.util.Arrays;
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int p1=0,p2=0;
        int count=0;
        while(p2!=nums.length){
            if(nums[p1]==nums[p2]){
                count++;
                p2++;

                if(count>nums.length/2) {
                    return nums[p1];
                }
            }
            else{
                p1=p2;
                p2++;
            }
            
        }
        return -1;

    }
}
```

### Problem: [copy list with random pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)

```java
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:

  Node* copyRandomList(Node* head) {
    if (!head) return nullptr;

    // First pass: create new nodes and link them to the original list
    Node* temp = head;
    while (temp) {
        Node* copy = new Node(temp->val);
        copy->next = temp->next;
        temp->next = copy;
        temp = copy->next;
    }

    // Second pass: set random pointers for the new nodes
    temp = head;
    while (temp) {
        if (temp->random) {
            temp->next->random = temp->random->next;
        }
        temp = temp->next ? temp->next->next : nullptr;
    }

    // Third pass: restore the original list and extract the copy list
    temp = head;
    Node* copyHead = head->next;
    Node* copy = copyHead;
    while (temp) {
        temp->next = temp->next ? temp->next->next : nullptr;
        copy->next = copy->next ? copy->next->next : nullptr;
        temp = temp->next;
        copy = copy->next;
    }

    return copyHead;
}

};
```

### Problem: [rotate list](https://leetcode.com/problems/rotate-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    
    ListNode* rotateRight(ListNode* head, int k) {
    if(!head || !head->next) return head;
    ListNode* temp=head;
    int length=1;  
     while(temp->next){
          length++;
          temp=temp->next;
     }
     temp->next=head;
     k%=length;
     k=length-k;

     while(k--){
          temp=temp->next;
     }
     head=temp->next;
     temp->next=nullptr;
     return head;
    }
};
```

### Problem: [rotate list](https://leetcode.com/problems/rotate-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int getLength(ListNode* head){
     ListNode* temp=head;
     int length=0;  
     while(temp){
          length++;
          temp=temp->next;
     }
     return length;
    }
    ListNode* rotateRight(ListNode* head, int k) {
    if(!head || !head->next) return head;
    ListNode* temp;
    ListNode* start;
    int length=getLength(head);
     for(int i=0;i<k%length;i++){
          temp=head;
          while(temp->next->next!=nullptr) temp=temp->next;
          start=temp->next;
          temp->next=nullptr;
          start->next=head;
          head=start;
     }
     return head;
    }
};
```

### Problem: [reverse nodes in k group](https://leetcode.com/problems/reverse-nodes-in-k-group/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
// class Solution {
// public:
//     //  void reverseGroup(ListNode *head,int k){
//     //     ListNode* kNode=head;
//     //     ListNode* previous= head;
//     //     ListNode* nextNode= head->next;
//     //     ListNode* temp= head;

//     //     for(int i=0;i<k-1 && kNode->next ;i++) kNode=kNode->next;
//     //     temp->next=kNode->next;

//     //     for(int i=0;i<k-1;i++){
//     //         temp=nextNode;
//     //         nextNode=nextNode->next;
//     //         temp->next=previous;
//     //         previous=temp;
//     //     }
//     // }
//     // ListNode* reverseKGroup(ListNode* head, int k) {
//     //     // reverse the linked list
//     //     ListNode* kNode=head;
//     //     ListNode* previous= head;
//     //     ListNode* nextNode= head->next;
//     //     ListNode* temp= head;

//     //     for(int i=0;i<k-1 && kNode->next ;i++) kNode=kNode->next;
//     //     temp->next=kNode->next;

//     //     for(int i=0;i<k-1;i++){
//     //         temp=nextNode;
//     //         nextNode=nextNode->next;
//     //         temp->next=previous;
//     //         previous=temp;
//     //     }
//     //     head=temp;
//     //     return head;
//     // }
// };

class Solution {
    
public:
int lengthOfLinkedList(ListNode *head) {
    ListNode* temp=head;
    int length=0;
    while(temp){
        temp=temp->next;
        length++;
    }
    return length;
}

 ListNode* reverseKGroup(ListNode* head, int k) {
    if(head == NULL||head->next == NULL) return head;
    
    int length = lengthOfLinkedList(head);
    
    ListNode* dummyHead = new ListNode(0);
    dummyHead->next = head;
    
    ListNode* pre = dummyHead;
    ListNode* cur;
    ListNode* nex;
    
    while(length >= k) {
        cur = pre->next;
        nex = cur->next;
        for(int i=1;i<k;i++) {
            cur->next = nex->next;
            nex->next = pre->next;
            pre->next = nex;
            nex = cur->next;
        }
        pre = cur;
        length -= k;
    }
    return dummyHead->next;
    }
};
```

### Problem: [monotonic array](https://leetcode.com/problems/monotonic-array/)

```java
class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length==1) return true;
        if(nums[0]>nums[nums.length-1]){
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]<nums[i+1]) return false;
            }
        }
        else if(nums[0]<nums[nums.length-1]){
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]) return false;
            }
        }
        else {
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]!=nums[i+1]) return false;
            }
        }
        
        return true;
    }
}
```

### Problem: [intersection of two linked lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* tempA=headA;
        ListNode* tempB= headB;

        while(tempA!=tempB){
            tempA=tempA==NULL?headB:tempA->next;
            tempB=tempB==NULL?headA:tempB->next;
        }

        return tempA;
    }
};
```

### Problem: [intersection of two linked lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int size1=0;
        int size2=0;
        ListNode* temp=headA;
        while(temp){
            temp=temp->next;
            size1++;
        }
        temp=headB;
        while(temp){
            temp=temp->next;
            size2++;
        }

        if(size1>size2){
            temp=headA;
            for(int i=0;(i<size1-size2) && temp;i++) temp=temp->next;
            headA=temp;
        }
        else if(size2>size1) {
            temp=headB;
            for(int i=0;(i<size2-size1) && temp;i++) temp=temp->next;
            headB=temp;
        }
        if(headA==headB) return headA;
        while(headA && headB){
            if(headA->next==headB->next) return headA->next;
            headA=headA->next;
            headB=headB->next;
        }
        return nullptr;
    }
};
```

### Problem: [sort list](https://leetcode.com/problems/sort-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* a, ListNode* b) {
        if(!a)
            return b;
        if(!b) 
        return a;
        ListNode* sorted= new ListNode();
        ListNode* headNode=sorted;
        while(a && b){
            if(a->val<=b->val){
                sorted->next=a;
                a=a->next;
                sorted=sorted->next;
            }
            else{
                sorted->next=b;
                b=b->next;
                sorted=sorted->next;
            }
        }
        if(a) sorted->next=a;
        if(b) sorted->next=b;
        return headNode->next;
    }

    ListNode* midList(ListNode* head) {
        ListNode *slow=head;
        ListNode *temp=slow;
        ListNode *fast=head;
        while(fast && fast->next){
            temp=slow;
            slow=slow->next;
            fast=fast->next->next;
        }
        return temp;
    }
    ListNode* sortList(ListNode* head) {
        if(!head || !head->next) return head;

        ListNode* mid= midList(head);
        ListNode* midNext= mid->next;
        mid->next=nullptr;
        ListNode* list1= sortList(head);
        ListNode* list2= sortList(midNext);
        return mergeTwoLists(list1,list2);

    }

};
```

### Problem: [merge two sorted lists](https://leetcode.com/problems/merge-two-sorted-lists/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* a, ListNode* b) {
         if(!a)
            return b;
        if(!b) 
        return a;
        ListNode* sorted= new ListNode();
        ListNode* headNode=sorted;
        while(a && b){
            if(a->val<=b->val){
                sorted->next=a;
                a=a->next;
                sorted=sorted->next;
            }
            else{
                sorted->next=b;
                b=b->next;
                sorted=sorted->next;
            }
        }
        if(a) sorted->next=a;
        if(b) sorted->next=b;
        return headNode->next;
    }
};
```

### Problem: [sort array by parity](https://leetcode.com/problems/sort-array-by-parity/)

```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
       int start=0;
       int end=nums.length-1;
        if(end==0) return nums;
       while(start<end){
           if(nums[start]%2==0) start++;
            else if(nums[end]%2!=0) end--;
           else {
               int temp=nums[end];
               nums[end]=nums[start];
               nums[start]=temp;
               end--;
               start++;
           }
       }
       return nums;


    }
}
```

### Problem: [sort array by parity](https://leetcode.com/problems/sort-array-by-parity/)

```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
       int start=0;
       int end=nums.length-1;
        if(end==0) return nums;
       while(start<end){
           if(nums[start]%2==0) start++;
            else if(nums[end]%2!=0) end--;
           else {
               int temp=nums[end];
               nums[end]=nums[start];
               nums[start]=temp;
               end--;
           }
       }
       return nums;


    }
}
```

### Problem: [sort array by parity](https://leetcode.com/problems/sort-array-by-parity/)

```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        boolean swapped=false;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]%2!=0){
                    int temp= nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped) return nums;
        }
        return nums;
    }
}
```

### Problem: [remove nth node from end of list](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head || !head->next) return nullptr;
        ListNode* fast=head;
        ListNode* slow=head;

        for(int i=0;i<n;i++)
            fast=fast->next;

        if(!fast){
            slow=slow->next;
            return slow;
        }
        while(fast->next){
            slow=slow->next;
            fast=fast->next;
        }
        slow->next= slow->next->next;
        return head;
    }
};
```

### Problem: [odd even linked list](https://leetcode.com/problems/odd-even-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
    if(!head || !head->next) return head;
    ListNode* even=nullptr;
    ListNode* odd=nullptr;
    ListNode* evenHead=nullptr;
    ListNode* temp=head;
    int index=1;
    
    while(temp){
        // temp_next=temp->next;
        if(index%2==0){
            if(!even){
            even=temp;
            evenHead=even;
            }
            else{
                even->next=temp;
                even=temp;
            }
        }else{
            if(!odd){
                odd=temp;
                head=odd;
            }
            else{
                odd->next=temp;
                odd=temp;
            }
        }
        temp=temp->next;
        index++;
    }
    odd->next=evenHead;
    even->next=nullptr;
    return head;

    }
};
```

### Problem: [reverse linked list](https://leetcode.com/problems/reverse-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
       ListNode *newHead = NULL;
        while (head != NULL) {
            ListNode *next = head->next;
            head->next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
};
```

### Problem: [palindrome linked list](https://leetcode.com/problems/palindrome-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(NULL) {}
 *     ListNode(int x) : val(x), next(NULL) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow=head;
        ListNode* fast=head;

        while(fast && fast->next){
            slow=slow->next;
            fast=fast->next->next;
        }

        if(fast && fast->next)
            slow=slow->next;

        ListNode* temp=NULL;
        ListNode* previous=NULL;

        while(slow!=NULL && slow->next!=NULL){
            temp=slow->next;
            slow->next=previous;
            previous=slow;
            slow=temp;
        }

        if(slow!=NULL) slow->next=previous;
        fast=head;
        while(slow!=NULL){
            if(slow->val!=fast->val) return false;
            slow=slow->next;
            fast=fast->next;    
        }
        return true;
    }
};
```

### Problem: [palindrome linked list](https://leetcode.com/problems/palindrome-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow=head;
        ListNode* fast=head;

        while(fast && fast->next){
            slow=slow->next;
            fast=fast->next->next;
        }

        if(fast && fast->next)
            slow=slow->next;

        ListNode* temp=nullptr;
        ListNode* previous=nullptr;

        while(slow!=nullptr && slow->next!=nullptr){
            temp=slow->next;
            slow->next=previous;
            previous=slow;
            slow=temp;
        }

        if(slow!=nullptr) slow->next=previous;
        fast=head;
        while(slow!=nullptr){
            if(slow->val!=fast->val) return false;
            slow=slow->next;
            fast=fast->next;    
        }
        return true;
    }
};
```

### Problem: [linked list cycle ii](https://leetcode.com/problems/linked-list-cycle-ii/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        // if(!head || !head->next) return nullptr;
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast && fast->next ){
            fast=fast->next->next;
            slow=slow->next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow->next;
                    fast=fast->next;
                }
                return slow;
            }
        }
        return nullptr;
    }
};
```

### Problem: [linked list cycle ii](https://leetcode.com/problems/linked-list-cycle-ii/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        // if(!head || !head->next) return nullptr;
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast && fast->next ){
            fast=fast->next->next;
            slow=slow->next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow->next;
                    fast=fast->next;
                }
                return slow;
            }
        }
        return nullptr;
    }
};
```

### Problem: [linked list cycle ii](https://leetcode.com/problems/linked-list-cycle-ii/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if(!head || !head->next) return nullptr;
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast && fast->next ){
            fast=fast->next->next;
            slow=slow->next;
            if(slow && fast && slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow->next;
                    fast=fast->next;
                }
                return slow;
            }
        }
        return nullptr;
    }
};
```

### Problem: [linked list cycle](https://leetcode.com/problems/linked-list-cycle/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(!head || !head->next) return false;
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast && fast->next ){
            fast=fast->next->next;
            if(slow && fast && slow->next==fast->next) return true;
            if(fast==head) return false;
            slow=slow->next;
        }
        return false;

    }
};
```

### Problem: [delete the middle node of a linked list](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteMiddle(ListNode* head) {
        if(head==nullptr || head->next==nullptr) return nullptr;
        ListNode* fast= head;
        ListNode* slow= head;
        ListNode* beforeSlow= nullptr;
        while(fast!=nullptr && fast->next!=nullptr){
            beforeSlow=slow;
            slow=slow->next;
            fast=fast->next->next;
        }
        beforeSlow->next=slow->next;
        return head;
    }
};
```

### Problem: [delete the middle node of a linked list](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteMiddle(ListNode* head) {
        if(!head || !head->next) return nullptr;
        ListNode* fast= head;
        ListNode* slow= head;
        ListNode* beforeSlow= nullptr;
        while(fast && fast->next){
            beforeSlow=slow;
            slow=slow->next;
            fast=fast->next->next;
        }

        beforeSlow->next=slow->next;
        return head;
    }
};
```

### Problem: [delete the middle node of a linked list](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteMiddle(ListNode* head) {
        if(!head || !head->next) return nullptr;
        ListNode* fast= head;
        ListNode* slow= head;
        ListNode* beforeSlow= nullptr;
        while(fast && fast->next){
            fast=fast->next->next;

            beforeSlow=slow;
            slow=slow->next;
        }

        beforeSlow->next=slow->next;
        return head;
    }
};
```

### Problem: [delete the middle node of a linked list](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteMiddle(ListNode* head) {
        if(!head || !head->next) return nullptr;
        ListNode* fast= head;
        ListNode* slow= head;
        ListNode* beforeSlow= head;
        while(fast && fast->next){
            fast=fast->next->next;

            beforeSlow=slow;
            slow=slow->next;
        }

        beforeSlow->next=slow->next;
        return head;
    }
};
```

### Problem: [middle of the linked list](https://leetcode.com/problems/middle-of-the-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode* fast= head;
        ListNode* slow =head;
        while(fast && fast->next){
            fast=fast->next->next;

            slow=slow->next;
        }
        return slow;
    }
};
```

### Problem: [middle of the linked list](https://leetcode.com/problems/middle-of-the-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode* fast= head;
        ListNode* slow =head;
        while(fast && fast->next){
            fast=fast->next->next;

            slow=slow->next;
        }
        return slow;
    }
};
```

### Problem: [middle of the linked list](https://leetcode.com/problems/middle-of-the-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        if(head==nullptr || head->next==nullptr) return head;
        ListNode* temp=head;
        int length=1;
        while(temp->next!=nullptr){
            length++;
            temp=temp->next;
        }

        temp=head;
        for(int i=0;i<length/2;i++){
            temp=temp->next;
        }
        
        return temp;
    }
};
```

### Problem: [reverse linked list](https://leetcode.com/problems/reverse-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head==nullptr || head->next==nullptr) return head;
       
    ListNode* saveHead=head;
    ListNode* temp= head->next;
    ListNode* previous= head;
    
    while(temp->next!=nullptr){
        head=temp;
        temp=temp->next;
        head->next=previous;
        previous=head;
    }

    head=temp;
    head->next=previous;
    saveHead->next=nullptr;
    return head;
    }
};
```

### Problem: [delete node in a linked list](https://leetcode.com/problems/delete-node-in-a-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
    ListNode *temp = node;
    while(temp->next->next!=nullptr)
    {   temp->val= temp->next->val;
        temp= temp->next;
        
    }
    temp->val= temp->next->val;
    temp->next=nullptr;
   
    }
};
```

### Problem: [rotate string](https://leetcode.com/problems/rotate-string/)

```java
class Solution {
public:
    bool rotateString(string p, string q) {
        queue<char> q1, q2;
    for(int i=0;i<p.size();i++){
          q1.push(p[i]);
          q2.push(q[i]);
    }
      int k = q2.size() -1;
    while(k>0){
          if(q1==q2) return 1;
          char ch= q2.front();
          q2.pop();
          q2.push(ch);
          k--;
    }
    return 0;
    }
};
```

### Problem: [rotate string](https://leetcode.com/problems/rotate-string/)

```java
class Solution {
    public boolean rotateString(String s, String goal) {
        s= s+s;
        return s.contains(goal) && (s.length()/2==goal.length());
    }
}
```

### Problem: [remove outermost parentheses](https://leetcode.com/problems/remove-outermost-parentheses/)

```java
class Solution {
public:
    string removeOuterParentheses(string s) {
        string ansStr="";
        int count=0;
        for(int i=0;i<s.length();i++){

            if('(' == s[i] ){
                count++;
                if(count!=1)
                    ansStr += s[i];
            }
            else {
                count--;
                if(count!=0)
                    ansStr += s[i];
                }
                
            if(!count) continue;

        }
        return ansStr;
    }
};
```

### Problem: [valid anagram](https://leetcode.com/problems/valid-anagram/)

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}
```

### Problem: [reverse words in a string](https://leetcode.com/problems/reverse-words-in-a-string/)

```java
class Solution {
    public String reverseWords(String s) {
       // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }
}
```

### Problem: [rearrange array elements by sign](https://leetcode.com/problems/rearrange-array-elements-by-sign/)

```java
class Solution {
    public int[] rearrangeArray(int[] nums) {
       int one=0;
       int two =1;

       int[] answer = new int[nums.length];
       int i=0;
       while(i<nums.length)
        {   


            if(nums[i]>0){ 
                answer[one]=nums[i];
                one+=2;
            }else{
                answer[two]=nums[i];
                two+=2;
            }
            i++;
        }
        return answer;
    }
}
```

### Problem: [rearrange array elements by sign](https://leetcode.com/problems/rearrange-array-elements-by-sign/)

```java
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int even=0,odd=0;
        int[] answer = new int[nums.length];
        int index=0;
        while(index<nums.length ){
            if( even<nums.length && nums[even]<0 ){
                even++; continue;
            }
            if( odd<nums.length && nums[odd]>0){
                odd++; continue;
            }

            if(index%2==0){ 
                answer[index]=nums[even];
                even++;
            }else{ 
                answer[index]=nums[odd];
                odd++;
            }
            index++;

        }
        return answer;
    }
}
```

### Problem: [sort colors](https://leetcode.com/problems/sort-colors/)

```java
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
```

### Problem: [two sum](https://leetcode.com/problems/two-sum/)

```java
class Solution {
  
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>hashMap= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int sum=target-nums[i];
            if(hashMap.containsKey(sum)){
                return new int[] {i,hashMap.get(sum)};
            }
            hashMap.put(nums[i],i);
        }
        return new int[] {};
  }
}
```

### Problem: [two sum](https://leetcode.com/problems/two-sum/)

```java
class Solution {

  
    
    public int[] twoSum(int[] nums, int target) {
    
       int[][] numsWithIndex = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
        numsWithIndex[i][0] = nums[i];
        numsWithIndex[i][1] = i;
    }


    Arrays.sort(numsWithIndex, Comparator.comparingInt(arr -> arr[0]));
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
        if (sum == target) {
            return new int[] {numsWithIndex[left][1], numsWithIndex[right][1]};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return new int[]{}; // No solution found!
    }
}
```

### Problem: [kth missing positive number](https://leetcode.com/problems/kth-missing-positive-number/)

```java
class Solution {
   
    public int findKthPositive(int[] arr, int k) {
       int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            int missingNumbers = arr[mid] - (mid + 1);
            if (missingNumbers < k)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        //?  at the end of the while loop the answer will be arr[high] + k - missing number and start = high +1
        //? but since for  [4,5,6] k=3 high will point to -1 which will result in error
        //? missingNumber = arr[high]-(high +1) = arr[high] -start
        //? ans =  arr[high] + k -(arr[high] - start) =  start+k 
        return start+k; 
    }
}
```

### Problem: [kth missing positive number](https://leetcode.com/problems/kth-missing-positive-number/)

```java
class Solution {
    public static boolean binarySearch(int[] arr,int target){
        int start=0,end=arr.length-1;
        int mid;
        while(start<=end){
            mid=(start+end)/2;

            if(arr[mid]==target)
                return true;
            else if(target>arr[mid])
                start=mid+1;
            else end= mid-1;
        }
        return false;
    }
    public int findKthPositive(int[] arr, int k) {
        int i=0;
        int j=1;
        int num=j;
        while(i<k){
            if(!binarySearch(arr,j)){
                num=j;
                i++;             
              }
            
            j++;
            
        }
        return num;
    }
}
```

### Problem: [single element in a sorted array](https://leetcode.com/problems/single-element-in-a-sorted-array/)

```java
class Solution {
    
        public int singleNonDuplicate(int[] nums) {
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
}
```

### Problem: [single element in a sorted array](https://leetcode.com/problems/single-element-in-a-sorted-array/)

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int start=0,end=nums.length-1,mid;
        if(end==0) return nums[0];
        while(start<=end){
            mid = (end+start)/2;
            boolean isNotEqualPrevious=mid == 0 || nums[mid]!=nums[mid-1];
            boolean isNotEqualNext=mid == nums.length-1 || nums[mid]!=nums[mid+1];
            if(isNotEqualPrevious&&isNotEqualNext)
                return nums[mid];
            else if(!isNotEqualPrevious){
                if((mid-1-start)%2==0)
                    start=mid+1;
                else end=mid-2;
                // else start=mid+1;
            }
            else {
                if((mid-start)%2==0)
                 start=mid+2;
                else end=mid-1;
            }
        }
        return -1;
    }
}
```

### Problem: [merge sorted array](https://leetcode.com/problems/merge-sorted-array/)

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] mix=new int[m+n];

        int i = 0;
        int j = 0;
        int k = 0;
        //int p = m+n;
        
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                mix[k]=nums1[i];
                i++;
            }else{
                mix[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i < m){
            mix[k]=nums1[i];
            i++;
            k++;
        }
        while(j< n){
            mix[k]=nums2[j];
            j++;
            k++;
        }
        for(int l=0;l<mix.length;l++){
            nums1[l]=mix[l];
        }
    }
}
```

### Problem: [merge sorted array](https://leetcode.com/problems/merge-sorted-array/)

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // if(m==0) {
        //     nums1=nums2;
        //     return;
        // }
        // if(n==0){
        //     return;
        // }

        // int i=0;
        // int j=0;

        // while(i<m && j<n){
        //     if(nums1[i]<nums2[j]) i++;
        //     else if(nums1[i]>nums2[j]){
        //         int temp= nums1[i];
        //         nums1[i]=nums2[j];
        //         nums2[j]=temp;
        //         i++;
        //     }else{
        //         int temp= nums1[i+1];
        //         nums1[i+1]=nums2[j];
        //         nums2[j]=temp;
        //         i++; 
        //     }

        // }
        
        // while(j<n){
        //     nums1[i]=nums2[j];
        //     j++;
        // }
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
        
    }
}
```

### Problem: [palindrome number](https://leetcode.com/problems/palindrome-number/)

```java
class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int num=0;
        int rem=0;
        while(x>0){
            rem=x%10;
            num= num*10 +rem;
            x/=10;
        }
        if(temp==num) return true;
        return false;
    }
}
```

