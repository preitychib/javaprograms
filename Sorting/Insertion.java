
import java.util.Arrays;
public class Insertion{
    public static void main(String[] args){
        int[] arr={4,5,6,7,3,1,2,9};
        int c=0,a=0; //? Comparision and assignment k liye
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                c++;
                if(arr[j]<arr[j-1]){ 
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    a+=3;
                }
                else break;
            }
        }
        
        System.out.println(a+" & "+c); // 42 & 19
        System.out.println(Arrays.toString(arr));
    }
}