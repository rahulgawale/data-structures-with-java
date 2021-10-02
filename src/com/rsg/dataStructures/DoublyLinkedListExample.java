package src.com.rsg.dataStructures;

public class DoublyLinkedListExample {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dLL = new DoublyLinkedList<Integer>();
        // test add, insertAt, addFirst
        dLL.add(1);
        System.out.println("dLL : " + dLL.toString());
        dLL.add(2);
        dLL.add(3);
        dLL.addFirst(0);
        dLL.insertAt(0, -1);
        System.out.println("dLL : " + dLL.toString());
        System.out.println("dLL size : " + dLL.size());
        dLL.insertAt(4, 5);
        System.out.println("dLL : " + dLL.toString());
        System.out.println("dLL reverse string: " + dLL.toStringReverse());
        System.out.println("");

        // test remove
        dLL.remove(5);
        System.out.println("removed 5 : " + dLL.toString());
        dLL.remove(-1);
        System.out.println("removed -1 : " + dLL.toString());
        dLL.remove(1);
        System.out.println("removed 1 : " + dLL.toString());
        System.out.println("removed 10 : " + dLL.remove(10));
        dLL.clear();
        System.out.println("after clear : " + dLL.toString());
        System.out.println("dLL reverse string: " + dLL.toStringReverse());
        System.out.println("");

        // test remove first
        DoublyLinkedList<Integer> dLL2 = new DoublyLinkedList<Integer>();
        dLL2.add(1);
        dLL2.add(2);
        dLL2.removeFirst();
        System.out.println("after removeFirst: " + dLL2.toString());
        dLL2.removeFirst();
        System.out.println("after removeFirst: " + dLL2.toString());
        System.out.println("dLL reverse string: " + dLL2.toStringReverse());
        System.out.println("");

        // Test removeLast
        dLL2.add(3);
        dLL2.add(4);
        System.out.println("last removed: " + dLL2.removeLast());
        System.out.println("after removeLast: " + dLL2.toString());
        System.out.println("last removed again: " + dLL2.removeLast());
        System.out.println("after removeLast again: " + dLL2.toString());
        System.out.println("dLL reverse string: " + dLL2.toStringReverse());
        System.out.println("");

        // Test removeAt
        DoublyLinkedList<Integer> dLL3 = new DoublyLinkedList<Integer>();
        dLL3.add(1);
        dLL3.add(2);
        dLL3.add(3);
        dLL3.add(4);
        System.out.println("removed at 0: " + dLL3.removeAt(0));
        System.out.println("after removedAt 0: " + dLL3.toString());
        System.out.println("dLL reverse string: " + dLL3.toStringReverse());
        System.out.println("");

        System.out.println("removed at 1: " + dLL3.removeAt(1));// middle
        System.out.println("after removedAt 1: " + dLL3.toString());
        System.out.println("dLL reverse string: " + dLL3.toStringReverse());
        System.out.println("");

        System.out.println("removed at 1: " + dLL3.removeAt(1));// last
        System.out.println("after removedAt 2: " + dLL3.toString());
        System.out.println("");

        // Test Reverse
        DoublyLinkedList<Integer> dLL4 = new DoublyLinkedList<Integer>();
        dLL4.add(1);
        dLL4.add(2);
        dLL4.add(3);
        dLL4.add(4);
        System.out.println("before reverse: " + dLL4.toString());
        dLL4.reverse();
        System.out.println("after reverse: " + dLL4.toString());
    }
}
