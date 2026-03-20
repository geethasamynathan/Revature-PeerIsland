import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {

        BlockingQueue<String> orders = new ArrayBlockingQueue<>(2
        ); // fixed capacity

        // Insert
        System.out.println("offer Order1: " + orders.offer("Order1"));
        System.out.println("offer Order2: " + orders.offer("Order2"));

        // Queue is full now; offer returns false
        System.out.println("offer Order3 (full): " + orders.offer("Order3"));
        System.out.println("Queue: " + orders);

        // Remove
        System.out.println("poll(): " + orders.poll());
        System.out.println("After poll: " + orders);

        // put() will block only if full; here it will succeed immediately
        orders.put("Order3");
        System.out.println("After put Order3: " + orders);

        // take() removes head; blocks only if empty
        System.out.println("take(): " + orders.take());
        System.out.println("Remaining: " + orders);

        System.out.println("remainingCapacity(): " + orders.remainingCapacity());
    }
    }
