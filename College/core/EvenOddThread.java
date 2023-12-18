class NumberPrinter {
    private final int max;
    private int currentNumber;

    public NumberPrinter(int max) {
        this.max = max;
        this.currentNumber = 1;
    }

    public synchronized void printEven() {
        while (currentNumber <= max) {
            if (currentNumber % 2 == 0) {
                System.out.println("Even: " + currentNumber);
                currentNumber++;
                notify(); // Notify the waiting thread (oddThread)
            } else {
                try {
                    wait(); // Wait for the other thread to print
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void printOdd() {
        while (currentNumber <= max) {
            if (currentNumber % 2 != 0) {
                System.out.println("Odd: " + currentNumber);
                currentNumber++;
                notify(); // Notify the waiting thread (evenThread)
            } else {
                try {
                    wait(); // Wait for the other thread to print
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class EvenOddThread {
    public static void main(String[] args) {
        int maxNumber = 10; // Set the maximum number

        NumberPrinter numberPrinter = new NumberPrinter(maxNumber);

        Thread evenThread = new Thread(() -> numberPrinter.printEven());
        Thread oddThread = new Thread(() -> numberPrinter.printOdd());

        evenThread.start();
        oddThread.start();
    }
}
