//* Write a multithreading program to demonstrate synchronization in a Reader-Writer problem for a shared limited buffer. */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// A class representing a shared limited buffer with read and write operations
class LimitedBuffer {
    private List<Integer> buffer = new ArrayList<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // Method for a writer to add a value to the buffer
    public void write(int value) {
        lock.writeLock().lock(); // Acquire write lock to ensure exclusive access for writing
        try {
            buffer.add(value);
            System.out.println("Writer wrote: " + value);
        } finally {
            lock.writeLock().unlock(); // Release write lock after writing
        }
    }

    // Method for a reader to read a value from the buffer
    public int read() {
        lock.readLock().lock(); // Acquire read lock to allow multiple readers simultaneously
        try {
            if (!buffer.isEmpty()) {
                int value = buffer.get(0);
                System.out.println("Reader read: " + value);
                return value;
            } else {
                System.out.println("Buffer is empty.");
                return -1;
            }

        } finally {
            lock.readLock().unlock(); // Release read lock after reading
        }
    }
}

// Class representing a writer thread that writes to the shared buffer
class Writer implements Runnable {
    private LimitedBuffer buffer;

    public Writer(LimitedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            buffer.write(i);
            try {
                Thread.sleep(500); // Simulate some writing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//? Class representing a reader thread that reads from the shared buffer
class Reader implements Runnable {
    private LimitedBuffer buffer;

    public Reader(LimitedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            buffer.read();
            try {
                Thread.sleep(300); // Simulate some reading time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class to demonstrate the Reader-Writer problem with a shared limited buffer
public class ReaderWriterExample {
    public static void main(String[] args) {
        LimitedBuffer sharedBuffer = new LimitedBuffer();
        // Create and start the writer and reader threads
        Thread writerThread = new Thread(new Writer(sharedBuffer));
        Thread readerThread1 = new Thread(new Reader(sharedBuffer));
        Thread readerThread2 = new Thread(new Reader(sharedBuffer));
        writerThread.start();
        readerThread1.start();
        readerThread2.start();
    }
}
