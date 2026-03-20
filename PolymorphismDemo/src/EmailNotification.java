 class EmailNotification extends Notification{

@Override
    public void sendNotification(String customerName, String message){
    super.sendNotification(customerName,message);
        System.out.println("Email  Sent to "+customerName + ": "+message);
    }
}
