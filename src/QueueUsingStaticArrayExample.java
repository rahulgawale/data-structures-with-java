package src;

public class QueueUsingStaticArrayExample {
    public static void main(String[] args) {
        try {
            QueueUsingStaticArray queue = new QueueUsingStaticArray(5);
            queue.enqueue(10);
            queue.enqueue(5);
            queue.enqueue(4);
            System.out.println("Current Queue Size: " + queue.size());
            System.out.println("Current Queue Data: " + queue.toString());

            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            System.out.println("Current Queue Size: " + queue.size());
            System.out.println("Current Queue Data: " + queue.toString());

            queue.enqueue(10);
            queue.enqueue(5);
            queue.enqueue(4);
            queue.enqueue(2);
            queue.enqueue(1);
            System.out.println("Current Queue Size: " + queue.size());
            System.out.println("Current Queue Data: " + queue.toString());

            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            System.out.println("Current Queue Size: " + queue.size());
            System.out.println("Current Queue Data: " + queue.toString());
        } catch (Exception e) {
            System.out.println("Exception => " + e.getMessage());
        }
    }
}