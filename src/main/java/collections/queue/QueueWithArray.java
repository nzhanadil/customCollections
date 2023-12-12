package collections.queue;

public class QueueWithArray {

    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public QueueWithArray(int size) {
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
    }

    public boolean isEmpty() {
        return topOfQueue == -1;
    }

    public boolean isFull() {
        return (beginningOfQueue == 0 && topOfQueue + 1 == arr.length) || topOfQueue + 1 == beginningOfQueue;
    }

    public void enqueue(int e) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            beginningOfQueue = topOfQueue = 0;
            arr[topOfQueue] = e;
        } else {
            if (topOfQueue == arr.length - 1 && beginningOfQueue != 0) {
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            arr[topOfQueue] = e;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int result = arr[beginningOfQueue];

        if (beginningOfQueue == topOfQueue) {
            beginningOfQueue = topOfQueue = -1;
        } else if (beginningOfQueue == arr.length - 1) {
            beginningOfQueue = 0;
        } else {
            beginningOfQueue++;
        }
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[beginningOfQueue];
    }

    public void delete() {
        arr = null;
        beginningOfQueue = topOfQueue = -1;
    }

}
