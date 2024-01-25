public class ArrayAssignment{
    private int[] arr;
    private int size; //? current no. of elements
    private int length; //? capacity of array

    ArrayAssignment(int n) {
        arr = new int[n];
        length = n;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }
    
    int getSize() {
        return size;
    }

    int getElement(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Invalid Index entered.");
        }
        return arr[index];
    }

    void insert(int element, int index) throws Exception {
        if (index < 0 || index >=length) {
            throw new Exception("Invalid Index entered.");
        }

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;
    }

    int delete(int element) {
        int index = indexOf(element);
        //? check if the index is valid and then remove the element at that index
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        }
        return index;
    }
    
    int indexOf(int element) {
        //? Find the element
        for (int i = 0; i < size; i++) {
            if (arr[i] == element)
                return i;
        }
        return -1;
    }
    
    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void store(int n) throws Exception {
        for (int i = 1; i <= n; i++)
            insert(i, i - 1);

    }
    
    //? needs to be optimised redundancy is there
    void insertOddFirstinRange(int n) throws Exception {

        int oddPointer=0;
        int element=1;
        for (int i = 0; i < n; i++) {
            if(element%2==0)
                insert(element, i);
            else {
                insert(element, oddPointer);
                oddPointer++;
            }
            element++;
        }
    }
    void insertEvenTwiceinRange(int n)throws Exception{
        
        if ((n + (n / 2)) >= length) {
            throw new Exception("Insertion is not valid for the given range");
        }
        int element = 1;
        for (int i = 0; i < (n + (n / 2)); i++) {

            insert(element, i);
            if (element % 2 == 0) {
                i++;
                insert(element,i);
            }
            element++; 
        }
    }
}