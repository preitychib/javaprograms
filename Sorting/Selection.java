
import java.util.Arrays;
public class Selection{
    public static void main(String[] args){
        int[] arr={4,5,6,7,3,1,2,9};
        int c=0,a=0; //? Comparision and assignment k liye
            
        for(int i=0;i<arr.length;i++){
            int last = arr.length-1-i;
            int max=0;
            for(int j=0;j<arr.length-i;j++){
                c++;
                if (arr[max]<arr[j]) max=j;
                
            }
                
                int temp=arr[max];
                arr[max]=arr[last];
                arr[last]=temp;
                a+=3;
                
        }
        
        System.out.println(a+" & "+c); // 24 and 36
        System.out.println(Arrays.toString(arr));
    }
}