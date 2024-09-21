package CircularQueueArray;
public class CircularQueue<T> {
    private T[] q;
    private int front, rear;
    private int length;

    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        length = size;
        q = (T[]) new Object[length];
        front = rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public int size() {
        if (rear == -1) {
            return 0;
        } else if (rear > front) {
            return rear - front + 1;
        } else {
            return length - front + rear + 1;
        }
    }

    public void insert(T x) throws Exception {
        if ((rear + 1) % length == front) {
            throw new Exception("Queue is full");
        }
        if (rear == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % length;
        }
        q[rear] = x;
    }

    public T delete() throws Exception {
        if (front == -1) {
            throw new Exception("Queue is empty");
        }
        T x = q[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % length;
        }
        return x;
    }

    public void display() {
        int i = front;
        while (i != rear) {
            System.out.print(q[i] + " ");
            i = (i + 1) % length;
        }
        if (rear != -1) {
            System.out.println(q[rear]);
        }
    }

    public static void main(String[] args) throws Exception {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.display(); // Output: 1 2 3
        queue.delete();
        queue.display(); // Output: 2 3
        System.out.println("Size: " + queue.size()); // Output: 2
    }
}
