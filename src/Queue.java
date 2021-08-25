package src;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    public Queue() {
    }

    public Queue(T firstItem) {
        enqueue(firstItem);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public void enqueue(T firstItem) {
        list.addLast(firstItem);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.peekFirst();
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}