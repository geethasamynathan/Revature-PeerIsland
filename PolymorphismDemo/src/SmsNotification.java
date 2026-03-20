public class SmsNotification extends Notification{
    @Override
public void sendNotification(String customerName, String message){
    System.out.println("SMS  Sent to "+customerName + ": "+message);
}
}
