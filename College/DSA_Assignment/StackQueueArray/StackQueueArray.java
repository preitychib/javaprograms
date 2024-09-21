package StackQueueArray;

public class StackQueueArray {
    int[] array;
    int size;
    int stackTop;
    int queueRear;
    int queueFront;

    StackQueueArray(int m) {
        size = 2 * m;
        array = new int[size];
        stackTop=-1;
        queueRear=size;
        queueFront=size;
    }

    int getMid() {
        return (size / 2) -1;
    }
    
    void pushStack(int e) {
        try {
            if (stackTop == getMid()) {
                throw new Exception("Stack is full");
            }
            array[++stackTop] = e;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
    // insert normal queue
    void insert(int e) {

        try {

            if ((queueFront == size - 1 && queueRear - 1 == getMid()) || (queueFront == queueRear - 1))
                throw new Exception("Queue Overflow");

            if (queueRear + 1 == getMid()) {
                queueRear = size - 1;
            } else {
                queueRear--;
            }
            array[queueRear] = e;

        } catch (Exception exception) {
            // TODO: handle exception
            System.out.println(exception);
        }
    }
    
    int delete() {
        try {

            if(queueFront==queueRear){
                queueFront=queueRear=size;
            }
        
            int tempRear = queueRear;
            int deleted = array[queueRear];
            if(tempRear==size-1)
                tempRear = getMid() + 1;
            else 
                tempRear++;
            
            queueRear = tempRear;

            return deleted;
        } catch (Exception exception) {
            // TODO: handle exception
            System.out.println(exception);
        }
        return -1;
    }





}
