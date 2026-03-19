public interface NotificationService {

    String company_Name="ABC Technologies";
//abstract method
    void sendNotification(String message);

    default void logNotification()
    {
        System.out.println("Notification logged succeesfully");;
    }

    static void showServiceName(){
        System.out.println("Notification service belongs to"+company_Name);
    }
}


class EmailNotification implements NotificationService
{
    @Override
    public void sendNotification(String msg){
        System.out.println("Email Sent "+msg);
    }
}

class Demo{
    public static  void main(String[] args){
        EmailNotification email=new EmailNotification();
        email.sendNotification("Your order delivered");
        email.logNotification();
        NotificationService.showServiceName();

        System.out.println("Company :" +NotificationService.company_Name);
    }
}