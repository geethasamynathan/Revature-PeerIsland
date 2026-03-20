import java.util.ArrayDeque;
import java.util.Deque;

public class ArraDequeDemo {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();

        // Queue-style inserts (tail)
        history.offer("google.com");
        history.offer("youtube.com");
        history.offer("github.com");

        System.out.println("Deque: " + history);

        // Queue-style peek/poll (head)
        System.out.println("peek(): " + history.peek());
        System.out.println("poll(): " + history.poll());
        System.out.println("After poll: " + history);

        // Deque-specific methods (both ends)
        history.addFirst("startpage.com");
        history.addLast("stackoverflow.com");
        System.out.println("After addFirst/addLast: " + history);

        System.out.println("peekFirst(): " + history.peekFirst());
        System.out.println("peekLast(): " + history.peekLast());

        System.out.println("pollFirst(): " + history.pollFirst());
        System.out.println("pollLast(): " + history.pollLast());

        // Stack-like usage using push/pop
        history.push("login-page");
        System.out.println("After push: " + history);
        System.out.println("pop(): " + history.pop());
        System.out.println("Final: " + history);
    }

    }
