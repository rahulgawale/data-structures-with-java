package src.com.rsg.dataStructures;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> intQueue = new Queue<Integer>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        System.out.println("Queue data " + intQueue.toString());

        intQueue.dequeue();
        System.out.println("Queue data " + intQueue.toString());

        intQueue.dequeue();
        System.out.println("Queue data " + intQueue.toString());
    }
}
