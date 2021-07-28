package src;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next, prev;

        Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private int size = 0;
    private Node head;
    private Node tail;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        if (isEmpty()) {
            head = tail = new Node(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAt(int index, T data) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        if (index < 0) {
            throw new RuntimeException("Illegal index!");
        }

        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node traverseHead = head;
            int currentIndex = 0;
            while (currentIndex < index) {
                traverseHead = traverseHead.next;
                currentIndex++;
            }
            Node newNode = new Node(data);
            newNode.next = traverseHead;
            newNode.prev = traverseHead.prev;
            traverseHead.prev.next = newNode;
            traverseHead.prev = newNode;
        }
        size++;
    }

    public boolean remove(T data) {
        if (isEmpty()) {
            return false;
        }

        Node traverseHead = head;
        while (traverseHead != null) {
            if (traverseHead.data == data) {
                if (traverseHead.prev == null) {
                    head = traverseHead.next;
                } else {
                    traverseHead.prev.next = traverseHead.next;
                }
                if (traverseHead == tail) {
                    tail = traverseHead.prev;
                }
                traverseHead = null;
                --size;
                return true;
            }
            traverseHead = traverseHead.next;
        }
        return false;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T data = head.data;
        if (size() == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            head.prev = null;
            --size;
        }
        return data;
    }

    public T removeLast() {
        if (isEmpty())
            return null;
        T data = tail.data;
        if (size() == 1) {
            head = tail = null;
            size = 0;
        } else {
            tail = tail.prev;
            tail.next = null;
            --size;
        }
        return data;
    }

    public T removeAt(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        if (index < 0) {
            throw new RuntimeException("Illegal index!");
        }
        if (index == 0) {
            return removeFirst();
        } else {
            Node traverseHead = head;
            int currentIndex = 0;
            while (currentIndex < index) {
                traverseHead = traverseHead.next;
                currentIndex++;
            }
            T data = traverseHead.data;
            traverseHead.prev.next = traverseHead.next;
            if (traverseHead.next == null) {
                tail = traverseHead.prev;
            } else {
                traverseHead.next.prev = traverseHead.prev;
            }
            --size;
            return data;
        }
    }

    public void clear() {
        Node traverseHead = head;
        while (traverseHead != null) {
            traverseHead.next = null;
            traverseHead.data = null;
            traverseHead = traverseHead.next;
        }
        head = tail = traverseHead = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node next = head;

            public boolean hasNext() {
                return next != null;
            }

            public T next() {
                T data = next.data;
                next = next.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "{size:" + size + ", head:" + head + ", tail:" + tail + ", data:[]}";
        }
        Node traverseHead = head;
        String value = "{size:" + size + ", head:" + head + ", tail:" + tail + ", data:[";
        while (traverseHead.next != null) {
            value += traverseHead.data + ", ";
            traverseHead = traverseHead.next;
        }
        value += traverseHead.data + "]}";
        return value;
    }

    public String toStringReverse() {
        if (isEmpty()) {
            return "{size:" + size + ", head:" + head + ", tail:" + tail + ", data:[]}";
        }

        Node traverseHead = tail;
        String value = "{size:" + size + ", head:" + head + ", tail:" + tail + ", data:[";
        while (traverseHead.prev != null) {
            value += traverseHead.data + ", ";
            traverseHead = traverseHead.prev;
        }
        value += traverseHead.data + "]}";
        return value;
    }

    public void reverse() {
        if (size() < 2) {
            return;
        }
        Node traverseHead = head;
        head = tail;
        tail = traverseHead;

        while (traverseHead != null) {
            Node next = traverseHead.next;
            traverseHead.next = traverseHead.prev;
            traverseHead.prev = next;
            traverseHead = next;
        }
    }
}
