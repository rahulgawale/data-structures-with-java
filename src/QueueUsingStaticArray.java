package src;

public class QueueUsingStaticArray {
    private int[] array;
    private int capacity;
    private int headIndex = -1;
    private int tailIndex = -1;

    private int size = 0;

    public QueueUsingStaticArray(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size == capacity;
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
        tailIndex = (tailIndex + 1) % capacity;
        array[tailIndex] = value;
        size++;
    }

    public int dequeue() throws QueueEmptyException {
        if (size() == 0) {
            throw new QueueEmptyException("Queue is empty");
        }
        int data = array[headIndex];
        array[headIndex] = 0;
        headIndex = (headIndex + 1) % capacity;
        size--;

        if (size == 0) {
            headIndex = tailIndex = -1;
        }
        return data;
    }

    @Override
    public String toString() {
        System.out.println("Size: " + size + " Head: " + headIndex + " Tail: " + tailIndex);
        if (isEmpty()) {
            return "[]";
        }
        String result = "[";
        for (int i = headIndex, j = 0; j < size - 1; i = (i + 1) % capacity, j++) {
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
