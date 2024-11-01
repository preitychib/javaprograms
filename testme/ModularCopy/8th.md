
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
