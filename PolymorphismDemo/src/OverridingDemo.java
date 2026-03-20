import java.rmi.NoSuchObjectException;

public class OverridingDemo {

    public static void main(String[] args)
    {
        Notification n1=new EmailNotification();
       // Notification n2=new SmsNotification();
       // Notification n3= new Notification();
        n1.sendNotification("Harish","Payment Received successfully");
       // n2.sendNotification("Ipsita","Your order placed succeddfully");
      // n3.sendNotification("Yash","Offer valid  till 22--3-2026");

    }

}
