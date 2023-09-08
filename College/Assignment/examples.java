import java.util.Arrays;

public class examples {
    int[][] arr;

    examples(int m, int n) {
        arr = new int[m][n];
    }
    
    void populate(int max,int min)
    {
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr[0].length; j++) {
                arr[i][j] = (int) ((Math.random() * (max - min)) + min);
            }
        }
        
    }

    @Override
    public String toString()
    {
        return Arrays.deepToString(arr);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
