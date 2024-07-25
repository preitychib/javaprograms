import java.util.Scanner;

public class BubblePartition{

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();
        int[] arr= new int[n];
        // int[] arr= {9,3,7,5,1,4,6,12};
        // int n=arr.length;
        read(arr,n,sc);

        bubblePartitionSort(arr,n);

        print(arr,n);

        sc.close();
        
    }

    private static void print(int[] a, int n) {
        System.out.print("[ ");
        for(int i=0;i<n;i++){
            System.out.print(a[i]);
            if(i<n-1)
            System.out.print(", ");
        }
        System.out.print(" ]");
    }

    private static void bubblePartitionSort(int[] a, int n) {
       for(int i=0;i<n;i++){
        boolean swapped=false;
        for(int j=0;j<n-i-1;j++){
             if((a[j]%2==0 && ((a[j+1]%2==0 && a[j+1]>a[j]))) || (a[j]%2==1 && ((a[j+1]%2==1 && a[j]>a[j+1])|| a[j+1]%2==0))){
                int temp= a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                swapped=true;
                // System.out.println("Swapped "+a[j]+" "+a[j+1]+" i:"+i+" j:"+j);
            }
        }
        if(!swapped)
            break;
        // System.out.println(Arrays.to  String(a));
       }
    }

    private static void read(int[] a, int n,Scanner sc) {
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
    }
}