package src;

import java.util.*;

public class PriorityQueue<T extends Comparable<T>> {

    private List<T> heap;
    private int heapSize = 0;

    @Override
    public String toString() {
        return heap.toString();
    }

    public PriorityQueue() {
        this(1);
    }

    public PriorityQueue(int size) {
        heap = new ArrayList<>(size);
    }

    /*
     * insert the element at the last position of the tree and then call
     * adjustHeapUp
     */
    public void add(T item) {
        heap.add(heapSize, item);
        adjustHeapUp(heapSize++);
    }

    /*
     * remove the element at specified index and adjust the heap to satisfy heap
     * invariant criteria
     */
    public T removeAt(int index) {
        if (heap.isEmpty()) {
            return null;
        }
        if (index >= heapSize) {
            throw new IllegalArgumentException("Index out of bounds: " + index);
        }
        --heapSize;
        T removedItem = heap.get(index);
        swap(index, heapSize);

        heap.set(heapSize, null);

        if (heapSize == index) {
            return removedItem;
        }

        T elem = heap.get(index);
        adjustHeapUp(index);

        if (heap.get(index).equals(elem))
            adjustHeapDown(index);

        return removedItem;
    }

    /*
     * check if the new insertion satisfies the heap invariant of the tree, and the
     * each node is greater than its parent, swap the nodes if this condition is
     * false. this method recursively adjusts the tree to satisfy heap invariant.
     * from the last added node up to the root of the tree
     */
    private void adjustHeapUp(int index) {
        if (index > 0) {
            int parent;
            if (index % 2 == 0) {
                parent = (index - 2) / 2;
            } else {
                parent = (index - 1) / 2;
            }
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(parent, index);
                adjustHeapUp(parent);
            }
        }
    }

    /*
     * after removal if the node value is greater than its child then swim down and
     * swap with the smaller children recursively until heap invairant is not
     * satisfied.
     */
    private void adjustHeapDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = left;

            if (right < heapSize && less(right, left)) {
                smallest = right;
            }

            if (left >= heapSize) {
                break;
            }

            if (less(smallest, index)) {
                swap(smallest, index);
            }
            index = smallest;
        }
    }

    private boolean less(int i, int j) {
        return heap.get(i).compareTo(heap.get(j)) <= 0;
    }

    public int size() {
        return heapSize;
    }

    public T peek() {
        if (heapSize == 0) {
            return null;
        }
        return heap.get(0);
    }

    /* remove and return the first element */
    public T poll() {
        return removeAt(0);
    }

    private void swap(int index, int oldIndex) {
        T temp = heap.get(index);
        heap.set(index, heap.get(oldIndex));
        heap.set(oldIndex, temp);
    }

    public boolean find(T item) {
        for (T node : heap) {
            if (node == item) {
                return true;
            }
        }
        return false;
    }

    /* find index of the specified element in the tree */
    public int findIndex(T item) {
        if (heap.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < heapSize; i++) {
            if (heap.get(i) == item) {
                return i;
            }
        }
        return -1;
    }

    /* try and test the PriorityQueue with examples */

    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        pQueue.add(4);
        pQueue.add(2);
        pQueue.add(3);
        pQueue.add(9);

        pQueue.add(8);
        pQueue.add(1);
        pQueue.add(5);
        pQueue.add(10);
        pQueue.add(-1);
        System.out.println("Queue: " + pQueue.toString());
        System.out.println("index of 4: " + pQueue.findIndex(4));

        pQueue.removeAt(2);
        System.out.println("Queue after removal at 2: " + pQueue.toString());

        pQueue.removeAt(pQueue.findIndex(4));
        System.out.println("Queue after removal 4: " + pQueue.toString());
        System.out.println("Queue size: " + pQueue.size());

        pQueue.add(3);
        pQueue.add(7);
        pQueue.add(12);
        pQueue.removeAt(6);

        System.out.println("Queue: " + pQueue.toString());
        System.out.println("poll: " + pQueue.poll());
        System.out.println("Queue: " + pQueue.toString());
        System.out.println("");

        System.out.println("Poll: " + pQueue.poll());
        System.out.println("Queue: " + pQueue.toString());
        System.out.println("");

        System.out.println("Poll: " + pQueue.poll());
        System.out.println("Queue: " + pQueue.toString());
        System.out.println("");

        System.out.println("Poll: " + pQueue.poll());
        System.out.println("Queue: " + pQueue.toString());
        System.out.println("");

        System.out.println("Poll: " + pQueue.poll());
        System.out.println("Queue: " + pQueue.toString());
        System.out.println("");

        System.out.println("Poll: " + pQueue.poll());
        System.out.println("Queue: " + pQueue.toString());
        System.out.println("");
    }
}