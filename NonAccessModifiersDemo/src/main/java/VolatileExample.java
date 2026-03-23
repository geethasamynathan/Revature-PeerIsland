class NotificationService {
    volatile boolean newMessageAvailable = false;

    void receiveMessage() {
        newMessageAvailable = true;
        System.out.println("New message received.");
    }

    void checkMessage() {
        if (newMessageAvailable) {
            System.out.println("Displaying new message notification.");
        } else {
            System.out.println("No new message.");
        }
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.checkMessage();
        service.receiveMessage();
        service.checkMessage();
    }
}