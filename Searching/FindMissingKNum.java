public class FindMissingKNum {
    public static boolean binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == target)
                return true;
            else if (target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
    //? nlog(n) solution.
    public static int missingK(int[] vec, int n, int k) {
        int i = 0;
        int j = 1;
        int num = j;
        while (i < k) {
            if (!binarySearch(vec, j)) {
                num = j;
                i++;
            }

            j++;

        }
        return num;
    }
    
    //? Simple and O(n) approach
    public static int missingK2(int[] arr, int n, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k)
                k++;
            else
                break;
        }
        return k;
    }

    public static int missingK3(int[] arr, int n, int k) {
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
