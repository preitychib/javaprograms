
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