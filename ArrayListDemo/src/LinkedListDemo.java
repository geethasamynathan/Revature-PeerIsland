import java.util.LinkedList;

public class LinkedListDemo {
    public static  void main(String[] args){
        LinkedList<SupportTicket> tickets= new LinkedList();
        System.out.println(" ----- Add elements ------");
        tickets.add(new SupportTicket(101,"Ajay","Laptop is nt working","Medium"));
        tickets.add(new SupportTicket(102,"Priya","Payment failed","High"));
        tickets.add(new SupportTicket(103,"Uma","Report downloaded issue","Low"));

        System.out.println(tickets);

        tickets.addFirst(new SupportTicket(100,"Admin Team","Server down issue","Critical"));
        tickets.addLast(new SupportTicket(104,"Sneha","Profile update issue","Medium"));
        System.out.println(tickets);

        tickets.offer(new SupportTicket(105,"Vikram","OTP  issue","High"));
        tickets.offerFirst(new SupportTicket(99,"CEO Office","Dashborad unailable","High"));
        tickets.offerLast(new SupportTicket(106,"Kiran","Invoice is missing","Low"));

        System.out.println(tickets);

        System.out.println("First Ticket : " + tickets.getFirst());
        System.out.println("Last Ticket  : " + tickets.getLast());

        System.out.println("peek : " + tickets.peek());
        System.out.println("peekFirst  : " + tickets.peekFirst());
        System.out.println("peekLast  : " + tickets.peekLast());


        tickets.add(2, new SupportTicket(107, "Meena", "Password reset issue", "Medium"));

        System.out.println("\n========== GET BY INDEX ==========");
        System.out.println("Ticket at index 2 : " + tickets.get(2));

        System.out.println("\n========== SET (UPDATE ELEMENT) ==========");
        tickets.set(2, new SupportTicket(107, "Meena", "Password reset mail delayed", "High"));
        System.out.println("After update : " + tickets.get(2));

        System.out.println("\n========== CONTAINS ==========");
        SupportTicket tempTicket = tickets.get(3);
        System.out.println("Contains selected object? " + tickets.contains(tempTicket));

        System.out.println("\n========== SIZE ==========");
        System.out.println("Total tickets : " + tickets.size());

        System.out.println("\n========== INDEX OF / LAST INDEX OF ==========");
        LinkedList<String> courseList = new LinkedList<>();
        courseList.add("Java");
        courseList.add("Python");
        courseList.add("SQL");
        courseList.add("Java");
        System.out.println("Course List          : " + courseList);
        System.out.println("First index of Java  : " + courseList.indexOf("Java"));
        System.out.println("Last index of Java   : " + courseList.lastIndexOf("Java"));

        System.out.println("\n========== REMOVE FIRST / REMOVE LAST ==========");
        System.out.println("Removed First : " + tickets.removeFirst());
        System.out.println("Removed Last  : " + tickets.removeLast());
        System.out.println(tickets);

        System.out.println("\n========== POLL / POLL FIRST / POLL LAST ==========");
        System.out.println("Poll        : " + tickets.poll());
        System.out.println("Poll First  : " + tickets.pollFirst());
        System.out.println("Poll Last   : " + tickets.pollLast());
        System.out.println(tickets);

        System.out.println("\n========== PUSH / POP ==========");
        tickets.push(new SupportTicket(108, "Support Lead", "Escalated customer complaint", "Critical"));
        System.out.println("After push : " + tickets);
        System.out.println("Pop item   : " + tickets.pop());
        System.out.println("After pop  : " + tickets);
    }
}

class SupportTicket
{
     int ticketId;
     String customerName;
     String issue;
     String priority;

    public SupportTicket( int ticketId,String customerName, String issue, String priority) {
        this.customerName = customerName;
        this.issue = issue;
        this.priority = priority;
        this.ticketId = ticketId;
    }

    public String toString(){
        return "Ticket{id=" + ticketId +
                ", customer='" + customerName + '\'' +
                ", issue='" + issue + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
