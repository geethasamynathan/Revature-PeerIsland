
class TicketCounter {
    int availableSeats = 1;

    synchronized void bookTicket(String userName, int seatsRequested) {
        if (availableSeats >= seatsRequested) {
            System.out.println(userName + " booked " + seatsRequested + " seat(s).");
            availableSeats = availableSeats - seatsRequested;
        } else {
            System.out.println(userName + " could not book ticket. No seats available.");
        }
    }
}

class UserThread extends Thread {
    TicketCounter counter;
    String userName;
    int seatsRequested;

    UserThread(TicketCounter counter, String userName, int seatsRequested) {
        this.counter = counter;
        this.userName = userName;
        this.seatsRequested = seatsRequested;
    }

    public void run() {
        counter.bookTicket(userName, seatsRequested);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args)
    {
        TicketCounter counter=new TicketCounter();

        UserThread user1=new UserThread(counter,"Sam",1);
        UserThread user2=new UserThread(counter,"Irfan",1);

        user1.start();
        user2.start();

    }
}
