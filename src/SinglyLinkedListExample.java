package src;

public class SinglyLinkedListExample {
    public static void main(String[] args) {

        System.out.println("First java program!");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("list : " + list.toString());
        System.out.println("remove 3 : " + list.remove(3));
        System.out.println("list after removing 3: " + list.toString());
        System.out.println("");

        System.out.println("remove 5 : " + list.remove(5));
        System.out.println("list after removing 5: " + list.toString());
        System.out.println("");

        System.out.println("remove 1 : " + list.remove(1));
        System.out.println("list after removing 1: " + list.toString());
        System.out.println("");

        System.out.println("remove  : " + list.remove(5));
        System.out.println("list after removing 5: " + list.toString());
        System.out.println("");

        for (Integer i : list) {
            System.out.println("i : " + i);
        }
        System.out.println("");

        list.addFirst(10);
        System.out.println("list : " + list.toString());
        list.insertAt(1, 20);
        System.out.println("list : " + list.toString());
        list.insertAt(0, 30);
        System.out.println("list : " + list.toString());
        list.insertAt(4, 40);
        System.out.println("list : " + list.toString());

        System.out.println("remove last : " + list.removeLast());
        System.out.println("remove 4 : " + list.remove(4));
        System.out.println("remove 1 : " + list.remove(1));
        System.out.println("list : " + list.toString());

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        list2.add(12);
        list2.add(13);
        list2.add(14);
        list2.add(15);
        list2.add(16);
        list2.insertAt(4, 17);
        System.out.println("list2 : " + list2.toString());
        list2.removeAt(3);
        System.out.println("list2 : " + list2.toString());
        list2.removeFirst();
        list2.reverse();
        System.out.println("list2 : " + list2.toString());
    }
}
