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