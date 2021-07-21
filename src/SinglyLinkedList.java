package src;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;
    }

    private Node head;
    private Node tail;

    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if (tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }

        Node traverseHead = head;
        Node previousNode = null;

        while (traverseHead != null) {
            if (traverseHead.data == data) {
                System.out.println("previous node : " + previousNode);
                if (previousNode == null) {
                    head = traverseHead.next;
                } else {
                    previousNode.next = traverseHead.next;
                }
                if (traverseHead == tail) {
                    tail = previousNode;
                }
                traverseHead = null;
                return true;
            }
            previousNode = traverseHead;
            traverseHead = traverseHead.next;
        }
        return false;
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
        if (head == null) {
            return "[]";
        }
        Node next = head;
        String value = "[";
        while (next != tail) {
            value += next.data + ", ";
            next = next.next;
        }
        value += next.data + "]";
        return value;
    }
}
