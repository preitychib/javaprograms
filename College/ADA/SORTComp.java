import java.util.Arrays;
import java.util.Random;

public class SORTComp {
    public static void main(String[] args) {
        int[] arraySizes = {100, 1000, 10000, 100000, 200000};
        String[] sortAlgorithms = {"Insertion Sort", "Quick Sort", "Bubble Sort", "Merge Sort", "Selection Sort", "Shell Sort"};
        long[][] executionTimes = new long[sortAlgorithms.length][arraySizes.length];

        for (int i = 0; i < arraySizes.length; i++) {
            int[] arr = generateRandomArray(arraySizes[i]);

            long startTime = System.nanoTime();
            insertionSort(arr.clone());
            long endTime = System.nanoTime();
            executionTimes[0][i] = endTime - startTime;

            startTime = System.nanoTime();
            QuickSort(arr.clone());
            endTime = System.nanoTime();
            executionTimes[1][i] = endTime - startTime;

            startTime = System.nanoTime();
            BubbleSort(arr.clone());
            endTime = System.nanoTime();
            executionTimes[2][i] = endTime - startTime;

            startTime = System.nanoTime();
            MergeSort(arr.clone());
            endTime = System.nanoTime();
            executionTimes[3][i] = endTime - startTime;

            startTime = System.nanoTime();
            SelectionSort(arr.clone());
            endTime = System.nanoTime();
            executionTimes[4][i] = endTime - startTime;

            startTime = System.nanoTime();
            ShellSort(arr.clone());
            endTime = System.nanoTime();
            executionTimes[5][i] = endTime - startTime;
        }

        for (int i = 0; i < sortAlgorithms.length; i++) {
            System.out.println(sortAlgorithms[i] + " execution times (ns):");
            for (int j = 0; j < arraySizes.length; j++) {
                System.out.println("Array size " + arraySizes[j] + ": " + executionTimes[i][j]);
            }
            System.out.println();
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }

    public static void QuickSort(int[] arr) {
        QuickSort(arr, 0, arr.length - 1);
    }

    public static void BubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void MergeSort(int arr[], int l, int m, int r){
        int n1=m-l+1;
        int n2=r-m;

        int L[]=new int[n1];
        int R[]=new int[n2];

        for(int i=0; i<n1; i++){
            L[i]=arr[l+i];
        }
        for(int j=0; j<n2; j++){
            R[j]=arr[m+1+j];
        }

        int i=0, j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }
    public static void MergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    public static void sort(int arr[], int l, int r){
        if(l<r){
            int m=l+(r-l)/2;
            sort(arr, l, m);
            sort(arr, m+1, r);

            MergeSort(arr, l, m, r);
        }
    }

    public static void SelectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; 
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
        }
      }
      if (minIndex != i) { 
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
      }
    }
    }

    public static void ShellSort(int[] arr){
        int n = arr.length;

        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return arr;
    }
}