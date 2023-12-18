class Counter {
    private int count = 0;

    // Synchronized method to increment the counter
    public synchronized void increment() {
        int currentCount = getCount();
        currentCount++;
        setCount(currentCount);
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }
}

class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class AvoidRaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        IncrementThread thread1 = new IncrementThread(counter);
        IncrementThread thread2 = new IncrementThread(counter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // Print the final counter value
        System.out.println("Final Counter Value: " + counter.getCount());
    }
}
