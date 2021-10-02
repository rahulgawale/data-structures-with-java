package src.com.rsg.dataStructures;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;

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
            head = newNode;
        } else {
            Node traverseHead = head;
            Node previousNode = null;
            int currentIndex = 0;
            while (currentIndex < index) {
                previousNode = traverseHead;
                traverseHead = traverseHead.next;
                currentIndex++;
            }
            Node newNode = new Node(data);
            newNode.next = traverseHead;
            previousNode.next = newNode;
        }
        size++;
    }

    public boolean remove(T data) {
        if (isEmpty()) {
            return false;
        }

        Node traverseHead = head;
        Node previousNode = null;

        while (traverseHead != null) {
            if (traverseHead.data == data) {
                if (previousNode == null) {
                    head = traverseHead.next;
                } else {
                    previousNode.next = traverseHead.next;
                }
                if (traverseHead == tail) {
                    tail = previousNode;
                }
                traverseHead = null;
                --size;
                return true;
            }
            previousNode = traverseHead;
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
            Node traverseHead = head;
            while (traverseHead.next != null) {
                traverseHead = traverseHead.next;
            }
            tail = traverseHead;
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
            Node previousNode = null;
            int currentIndex = 0;
            while (currentIndex < index) {
                previousNode = traverseHead;
                traverseHead = traverseHead.next;
                currentIndex++;
            }
            T data = traverseHead.data;
            previousNode.next = traverseHead.next;
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

    public void reverse() {
        if (size() < 2) {
            return;
        }
        tail = head;
        Node traverseHead = head;
        Node previousNode = null;
        while (traverseHead != null) {
            Node next = traverseHead.next;
            traverseHead.next = previousNode;
            previousNode = traverseHead;
            traverseHead = next;
        }
        head = previousNode;
    }
}
