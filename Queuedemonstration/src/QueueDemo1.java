import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo1 {
    public static void main(String[] args) {
        Queue<String> supportQueue = new LinkedList<>();

        // Insert
        supportQueue.add("TKT1001");
        supportQueue.offer("TKT1002");
        supportQueue.offer("TKT1003");

        System.out.println("Queue: " + supportQueue);

        // Peek (see the next ticket without removing)
        System.out.println("peek(): " + supportQueue.peek());
        System.out.println("element(): " + supportQueue.element());

        // Remove head
        System.out.println("poll(): " + supportQueue.poll());
        System.out.println("remove(): " + supportQueue.remove());

        System.out.println("After removals: " + supportQueue);

        // Other useful methods
        System.out.println("size(): " + supportQueue.size());
        System.out.println("contains TKT1003? " + supportQueue.contains("TKT1003"));
        System.out.println("isEmpty(): " + supportQueue.isEmpty());

        // Traverse
        for (String t : supportQueue) {
            System.out.println("Ticket -> " + t);
        }

        supportQueue.clear();
        System.out.println("After clear(): " + supportQueue);

    }
}
