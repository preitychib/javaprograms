//! 852. Peak Index in a Mountain Array
//? You must solve it in O(log(arr.length)) time complexity.
// import java.util.Scanner;
public class Mountain{
    public static int peakIndexInMountainArray(int[] arr) {
        int s=0,e,m;
        e=arr.length-1;
        while(s<e){
            m=(e+s)/2;
            if(arr[m]>arr[m+1]) e=m;
            else s=m+1;
        }
        return s;
    }
    public static void main(String[] args){

       int[] arr= {3,5,3,2,0};
       System.out.println(arr[peakIndexInMountainArray(arr)]);
    }
}