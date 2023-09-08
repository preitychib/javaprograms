import java.util.Scanner;

public class MainClass{
    public static void main(String[] args) {
        
        //  int[] arr={4,5,6,7,8,9};
        //  int[] arr={3,5};
         int[] arr={3,1,1,1,1};
        Scanner sc = new Scanner(System.in);
        SearchRotateArrWD b = new SearchRotateArrWD();
         System.out.println("Enter the number");
         int n= sc.nextInt();
        // boolean found=false;
        // int e = arr.length - 1, m, s = 0;
        sc.close();
        System.out.println("1 element found at index:"+ b.search(arr,n));
        //  while(s<=e){
        //     m= (s+e)/2;
        //     if(n>arr[m]){
        //         s=m+1;
        //     } else if(n<arr[m]){
        //         e=m-1;
        //     } else{
        //         found=true;
        //         System.out.println("element found at index:"+ (m+1));
        //         break;
        //     }

        //  }
        //  if(!found) System.out.println("Given number doesn't exist!");

    }
}

//  public int binary(int[] arr,int n){
//         int s=0,e,m;
//         e=arr.length-1;
//         m=(e+s)/2;
//         if(arr[s]<arr[e]){
//             while(s<=e){
//                 if(arr[m]>target) e=m-1;
//                 else if(arr[m]<target) s=m+1;
//                 else {
//                     return m;
//                 }
//             }
//         }else{
//             while(s<=e){
//                 if(arr[m]>target) s=m+1;
//                 else if(arr[m]<target) e=m-1;
//                 else {
//                     return m;
//                 }
//             }
//         }
//     }
