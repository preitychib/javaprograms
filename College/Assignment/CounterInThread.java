class SharedResource {
    private int counter = 0;

    // Synchronized method to increment the counter
    public synchronized void increment() {
        // Simulate some processing time
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counter++;
    }

    // Synchronized method to get the current counter value
    public synchronized int getCounter() {
        return counter;
    }
}

class MyThread extends Thread {
    private SharedResource sharedResource;

    public MyThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.increment();
            System.out.println(Thread.currentThread().getName() + ": Counter = " + sharedResource.getCounter());
        }
    }
}

public class CounterInThread {
    public static void main(String[] args) {
        // Create a shared resource (counter)
        SharedResource sharedResource = new SharedResource();

        // Create two threads that share the same resource
        MyThread thread1 = new MyThread(sharedResource);
        MyThread thread2 = new MyThread(sharedResource);

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
