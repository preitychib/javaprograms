public class TestMatrix {
    public static void main(String[] args) {
        //? Create matrix A
        Matrix aMatrix = new Matrix();
        aMatrix.populate();
        System.out.println("The matrix A is: \n" + aMatrix);
        //? Finds determinant of A matrix
        System.out.println("The determinant of A matrix is: " + aMatrix.matDeterminant());
        
        //? Create matrix B
        Matrix bMatrix = new Matrix();
        bMatrix.populate();
        System.out.println("The matrix B is \n" + bMatrix);
        //? Finds determinant of B matrix
        System.out.println("The determinant of B matrix is: " + bMatrix.matDeterminant());
        
        //? Create matrix C containg sum of A and B
        Matrix cMatrix = aMatrix.addMatrix(bMatrix);
        if(cMatrix!=null)
            System.out.println("The addition of two matrix is: \n" + cMatrix);
        
        //? Create matrix D containg difference of A and B
        Matrix dMatrix = aMatrix.subMatrix(bMatrix);
        if(dMatrix!=null)
            System.out.println("The subtraction of two matrix is: \n" + dMatrix);
        
        //? Create matrix E containg product of A and B
        Matrix eMatrix = aMatrix.mulMatrix(bMatrix);
        if(eMatrix!=null)
            System.out.println("The product of two matrix is: \n" + eMatrix);

    }
}