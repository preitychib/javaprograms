 from java.util;
public class TargetSumSlide{

	public static int[][] getSubarray(int[] arr, int t, int n){
		
		
		int i =0;
		int start=0;
		int sum=0;
		
		ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
		
		for(int i=0;i<n;i++){
		
			
			sum+= arr[i];
			
			if(sum==t){
				ArrayList<Integer> subArr= new ArrayList<Integer>();
				
				for(int j=start;j<=i;j++){
				
					subArr.add(arr[j]);
				}
				
				ans.add(subArr);
			}
			while(sum>t){
					
				sum-=arr[start];
				start++;
			}
			
			
			
		}
		
		
		int[][] arr = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            ArrayList<Integer> row = ans.get(i);
            arr[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                arr[i][j] = row.get(j);
            }
        }
        
        return arr;
	
		
		
	}	
    public static void main(String args[]) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the size of array");
	int n= sc.nextInt();
	System.out.println("Enter the array:");
	int[] arr = new int[n];
	for(int i=0;i<n;i++){ 
		arr[i] = sc.nextInt();
	}
	
	System.out.println("Enter the target sum");
	int t=sc.nextInt();
	
	int[][] ans = getSubarray(arr,t,n);
	
	for(int i=0;i<ans.length;i++){
		System.out.println(Arrays.toString(ans[i]);
	}
	
	
	

	sc.close();

    }
}
