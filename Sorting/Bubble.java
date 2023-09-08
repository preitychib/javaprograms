
import java.util.Arrays;
public class Bubble{
    public static void main(String[] args){
        int[] arr={4,5,6,7,3,1,2,9};
        int c=0,a=0; //? Comparision and assignment k liye
        boolean swap=false;
        for(int i=0;i<arr.length-1;i++){
            swap=false;
            for(int j=0;j<arr.length-1-i;j++){
                c++;
                if(arr[j]>arr[j+1]){ 
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    a+=3;
                    swap=true;
                }
                
            }
            if(!swap) break;
        }
        
        System.out.println(a+" & "+c); // 42 & 27
        System.out.println(Arrays.toString(arr));
    }
}