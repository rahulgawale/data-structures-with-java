package src.com.rsg.dataStructures;

public class ArrayExample {

    public static void main(String argv[]) {
        System.out.println("First java program!");
        Array<Integer> array = new Array<Integer>(3);
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(40);

        System.out.println("index of 10: " + array.indexOf(10));
        System.out.println("removed at index 2: " + array.removeAt(2));

        // below line throws index out of bound exception
        // System.out.println("removed at index 2: " + array.removeAt(5));

        System.out.println("index of 30: " + array.indexOf(30)); // -1
        System.out.println("index of 40: " + array.indexOf(40)); // 3
        array.add(50);
        System.out.println("removed 50: " + array.remove(50)); // true
        System.out.println("removed 50: " + array.contains(50)); // false
        System.out.println("removed 10: " + array.contains(10)); // true
        System.out.println("toString: " + array.toString()); // [10, 20, 40]
        System.out.println("size of an array: " + array.size()); // 3
        array.set(1, 2);
        System.out.println("size of an array: " + array.size()); // 3
        System.out.println("toString: " + array.toString()); // [10, 20, 40]
        System.out.println("get element at 0: " + array.get(array.size() - 1)); // 1

        for (Integer num : array) {
            System.out.println("num " + num);
        }

        array.clear();
        System.out.println("toString: " + array.toString()); // []
    }
}