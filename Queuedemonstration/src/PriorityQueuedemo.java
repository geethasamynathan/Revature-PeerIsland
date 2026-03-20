import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueuedemo {
    public static  void main(String[] args)
    {
        // Lower number => higher priority
        Queue<Integer> taskPriority = new PriorityQueue<>();

        taskPriority.offer(2); // low
        taskPriority.offer(3); // high
        taskPriority.offer(1);

        System.out.println("PriorityQueue (internal view): " + taskPriority);
        System.out.println("peek(): " + taskPriority.peek()); // next task


        System.out.println("Processing order:");
        while (!taskPriority.isEmpty()) {
            System.out.println("poll(): " + taskPriority.poll());
        }

        // Safe behavior on empty
        System.out.println("poll() on empty: " + taskPriority.poll());
        System.out.println("peek() on empty: " + taskPriority.peek());


    }

}
