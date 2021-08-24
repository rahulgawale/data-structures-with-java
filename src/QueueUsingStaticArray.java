package src;

public class QueueUsingStaticArray {
    private int[] array;
    private int headIndex = -1;
    private int tailIndex = -1;

    private int size = 0;

    public QueueUsingStaticArray(int size) {
        array = new int[size];
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(int value) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Queue is full");
        }
        if (headIndex == -1) {
            headIndex = 0;
        }
        ++tailIndex;
        array[tailIndex] = value;
        size++;
    }

    public int dequeue() throws QueueEmptyException {
        if (size() == 0) {
            throw new QueueEmptyException("Queue is empty");
        }
        int data = array[headIndex];
        array[headIndex] = 0;
        headIndex++;
        size--;

        if (size == 0) {
            headIndex = tailIndex = -1;
        }
        return data;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String result = "[";
        for (int i = headIndex; i < tailIndex; i++) {
            result += array[i] + ", ";
        }
        result += array[tailIndex];
        result += "]";
        return result;
    }

    public class QueueFullException extends Exception {
        public QueueFullException(String message) {
            super(message);
        }
    }

    public class QueueEmptyException extends Exception {
        public QueueEmptyException(String message) {
            super(message);
        }
    }
}
