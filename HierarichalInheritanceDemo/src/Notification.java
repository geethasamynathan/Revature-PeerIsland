public class Notification {

    protected String message;
    protected String reciepient;

    public void setNotification(String message, String reciepient){
        this.message=message;
        this.reciepient=reciepient;
    }
    public void logNotification(){
        System.out.println("Logging Notification for :"+reciepient);
    }
}
