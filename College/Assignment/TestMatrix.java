public class TestMatrix {
    public static void main(String[] args) {
        //? Create matrix A
        Matrix aMatrix = new Matrix();
        aMatrix.populate();
        System.out.println("The matrix A is:" + aMatrix);
        //? Finds determinant of A matrix
        System.out.println("The determinant of A matrix is: " + aMatrix.findDeterminant(aMatrix.mat));
        
        //? Create matrix B
        Matrix bMatrix = new Matrix();
        bMatrix.populate();
        System.out.println("The matrix B is " + bMatrix);
        //? Finds determinant of B matrix
        System.out.println("The determinant of B matrix is: " + aMatrix.findDeterminant(bMatrix.mat));
        
        //? Create matrix C containg sum of A and B
        Matrix cMatrix = aMatrix.addMatrix(bMatrix);
        System.out.println("The addition of two matrix is: " + cMatrix);
        
        //? Create matrix D containg difference of A and B
        Matrix dMatrix = aMatrix.subMatrix(bMatrix);
        System.out.println("The subtraction of two matrix is: " + dMatrix);
        
        //? Create matrix E containg product of A and B
        Matrix eMatrix = aMatrix.mulMatrix(bMatrix);
        System.out.println("The addition of two matrix is: " + eMatrix);

    }
}