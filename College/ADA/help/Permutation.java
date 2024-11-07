public class Permutation {
    static void permutation(int[] arr, int k, int n){
        if(k==n-1){
            for(int i =0;i<n;i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
        }
        else{
            for(int i =k;i<n;i++){
                int t = arr[k];
                arr[k] = arr[i];
                arr[i] = t;
                permutation(arr, k+1, n);
                t =arr[k];
                arr[k] = arr[i];
                arr[i] = t;
            }
        }
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] arr = {1,2,3,4};
        int n = arr.length;
        permutation(arr, 0, n);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime)/1000000000;
        System.out.println("Total execution time is: " +executionTime);
    }
}
        

