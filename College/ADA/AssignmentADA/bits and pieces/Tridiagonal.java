import java.util.*;
import java.lang.*;
import java.io.*;

//class Codechef
class TriDiagonal

{
    
    static Scanner sc= new Scanner(System.in);
    public void input(int[][]mat){
        
        int n= mat.length;
        for(int i=0;i<n;i++){
		    for(int j=0;j<3;j++){

                if((i==0 && j==2) || (i==n-1 && j==2)){
                    continue;
                }

                mat[i][j]=sc.nextInt();

            }
		}
        
    }
    
    public int[][] multiply(int[][]mat1,int[][]mat2){
        int n= mat1.length;
        int[][]mat= new int[n][];
        mat[0]= new int[Math.min(n,3)];
        mat[1]= new int[Math.min(n,4)];
        mat[n-2]= new int[Math.min(n,4)];
        mat[n-1]= new int[Math.min(n,3)];
        
        for(int i=2;i<n-2;i++){
            mat[i]=new int[5];
        }
        
        for(int i=0;i<n;i++){
            
            for(int j=Math.max(0,i-2);j<=Math.min(n-1,i+2);j++){
                
                //now we need to find the ans[i][j], all other left untouched element will be zero 
                
                int y; // y will store the index to which we have to map the calculated values
                int temp=0;
                y=j-i+2;
                y-= Math.max((2-i),0);
                
                
                //usually for calulating aij we need to multiply, the ith row with jth col
                
                for(int k=Math.max(0,i-1);k<=Math.min(n-1,i+1);k++){
                    
                    // we need to check that what is the target index of both matrix
                    int x1,x2,y1,y2;
                    x1=i;
                    y1=k-i+1;
                    y1-= Math.max((1-i),0);
                    
                    x2= k;
                    y2= j-k+1;
                    y2-= Math.max((1-k),0);
                    
                    
                    if(y1>=0 && y2>=0 && y1<mat1[x1].length && y2<mat2[x2].length){
                        //System.out.println("i= "+i+" y= "+y+" x1= "+x1+" y1= "+y1+" x2= "+x2+" y2= "+y2+ " ele1= "+ mat1[x1][y1]+" ele2= "+mat2[x2][y2]);
                    temp+= mat1[x1][y1]*mat2[x2][y2];}
                    
                }
                
                mat[i][y]=temp;
            }
        }
        return mat;
    }
    
    
    
    public void display(int[][]mat){
        System.out.println("\n\nPrinting the matrix: ");
        int n= mat.length;
        //mat is a five diagonal matrix
        for(int i=0;i<n;i++){
		    
		    for(int j=0;j<n;j++){
                
                if(Math.abs(i-j)<=2){
                    
                    int y;//y will represent the respective index in mat
                    y=j-i+2;
                    y-= Math.max((2-i),0);
                    
                    System.out.print(mat[i][y]);
                }
                else 
		        System.out.print(0);
		        System.out.print(", ");
		        
		    }
		    System.out.println();
		}
		System.out.println();
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// making program for tridiagonal matrix mutiplication
		
		
	    System.out.print("\nEnter the dimensions of matrix: ");
		
		
        int[][]mat1;int[][]mat2;
        // Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        mat1= new int[n][];
        mat2= new int[n][];
        mat1[0]= new int[Math.min(n,2)];
        mat1[n-1]= new int[Math.min(n,2)];
        mat2[0]= new int[Math.min(n,2)];
        mat2[n-1]= new int[Math.min(n,2)];
        
        for(int i=1;i<n-1;i++){
            mat1[i]= new int[Math.min(n,3)];
            mat2[i]= new int[Math.min(n,3)];
        }
		TriDiagonal obj= new TriDiagonal();
		
		obj.input(mat1);
		obj.input(mat2);
		int[][]mat_ans= obj.multiply(mat1,mat2);
		obj.display(mat_ans);
		
	}
}