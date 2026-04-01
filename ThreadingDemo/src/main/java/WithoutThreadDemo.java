public class WithoutThreadDemo {
    public static void generateInvoice(){
        System.out.println("Generating the Invoice");
    }
    public static void sendSMS(){
        System.out.println("Sending SMS....");
    }
    public static void updateStatus(){
        System.out.println("Updating Delivery status...");
    }

    public static   void main(String[]  args){
        generateInvoice();
        sendSMS();
        updateStatus();

    }
}
