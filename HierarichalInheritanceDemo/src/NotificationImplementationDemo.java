public class NotificationImplementationDemo {
    public static void main(String[] args){
        EmailNotification emailNotification=new EmailNotification();
        emailNotification.setNotification("Your order has been placed successfully","customer1@mail.com");
        emailNotification.sendEmail();

    }
}
