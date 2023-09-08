import java.util.Scanner;
public class Linear{
    public static void main(String[] args){
         int[] arr={4,5,6,7,3,1,2,9};
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the number");
         int n= sc.nextInt();
         sc.close();
        boolean found=false;
         for(int i=0;i<arr.length;i++){
            if(arr[i]==n) { 
             System.out.println("The number is found at index: "+i);
             found=true;  
             break;
            }
         }
         if(!found) System.out.println("Given number doesn't exist!");

    }
}