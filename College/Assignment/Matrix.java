// import java.util.Arrays;

public class Matrix {
    int[][] mat;

    Matrix(int m, int n) {
        mat = new int[m][n];
    }
    
    void populate(int max,int min)
    {
        for (int i = 0; i < this.mat.length; i++) {
            for (int j = 0; j < this.mat[0].length; j++) {
                mat[i][j] = (int) ((Math.random() * (max - min)) + min);
            }
        }

    }
    
    Matrix add(Matrix matObj2) {
        if (this.mat[0].length != matObj2.mat[0].length && this.mat.length != matObj2.mat.length) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for addition");
            // return new Matrix(0, 0);
        }
        
        Matrix matObj3 = new Matrix(this.mat.length, this.mat[0].length);

        for (int i = 0; i < this.mat.length; i++) {
            for (int j = 0; j < this.mat[i].length; j++) {
                matObj3.mat[i][j] = this.mat[i][j] + matObj2.mat[i][j];
            }
        }
        return matObj3;
    }

    @Override
    public String toString()
    {
        String matString = new String();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
               matString+= (mat[i][j] + " ");
            }
            matString+="\n";
        }
        return matString;
    }

}