import java.util.*;


class NQueens {
    
    
    private boolean isSafe(int row, int col, char[][] board, int n){
        
        
        for(int i=0;i<n;i++){
            if(board[row][i]=='Q'){
                return false;
            }
            
            if(board[i][col]=='Q'){
                return false;
            }
            
            
        }
        int rr=row;int c=col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row=rr;col=c;
        while (row <n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        
        return true;
        
    }
    
    
    
    private void arrange(int col, char[][] board, List<List<String>> ans, int n){
        
        if(col==n){
            ans.add(construct(board));
            return;
        }
        
        for(int row=0;row<n;row++){
            if(isSafe(row, col, board,n )){
                board[row][col]='Q';
                arrange(col+1,board,ans,n);
                board[row][col]='.';
            }
        }
        
    }
    
    
    public List<String> construct(char[][] board){
        List<String> res=new ArrayList<>();
        String s="";
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                s+=board[i][j];
            }
            res.add(s);
            s="";
        }
        return res;
        
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='.';
            }
        }
        arrange(0,board,ans,n);
        
        return  ans;
        
    }

    public static void main(String[] args) {
        int n;
        System.out.print("\nEnter the value of n: ");
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        NQueens obj= new NQueens();
        List<List<String>> lst= obj.solveNQueens(n);
        System.out.println("\n");
        for(List<String> ls: lst){
            System.out.println(ls);
            System.out.println("\n");
        }
    }
}