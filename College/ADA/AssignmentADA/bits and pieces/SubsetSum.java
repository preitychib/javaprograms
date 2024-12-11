import java.util.*;

public class SubsetSum {
    static int[]arr;
    static int n;
    static int w;
    static int[]include;


    public static void sumOfSubset(int i, int wt, int tot){
        if(isPromising(i,tot,wt)){
            if(wt==w){
                System.out.println(Arrays.toString(include));
            }
            else{
                include[i]= 1;
                if((wt+arr[i])<=w)
                sumOfSubset(i+1, wt+arr[i], tot-arr[i]);
                include[i]=0;
                sumOfSubset(i+1, wt, tot-arr[i]);
            }
        }
        

    }

    public static boolean isPromising(int i, int tot, int wt){

        if(((wt+tot)>= w) && (wt==w || (wt) <=w )){
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of elements in set: ");
        n= sc.nextInt();
        arr= new int[n];
        System.out.println("Enter the elements of set: ");
        int total=0;

        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
            total+= arr[i];
        }

        System.out.println("Enter the final weight: ");
        w=sc.nextInt();

        include= new int[n];

        sumOfSubset(0,0,total);




    }
    
}
