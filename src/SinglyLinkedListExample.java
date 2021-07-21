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

        System.out.println("remove 2 : " + list.remove(2));
        System.out.println("remove 4 : " + list.remove(4));
        System.out.println("remove 1 : " + list.remove(1));
        System.out.println("list : " + list.toString());
    }
}
