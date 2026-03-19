public class PaymentGatewayDemo {
    public static void main(String[] args)
    {
     Payment card=new CardPayment(2500,"Sam",
             "TXN001","1234-1234-1234");

     Payment wallet=new WalletPayment(4000,"Tina","AMZ00234","AZ");
     System.out.println("=========  card Payment ==========");
     card.printBasicDetail();
     card.validatePayment();
     card.processPayment();
     card.generateReceipt();
        CardPayment.sampleMethod();


        System.out.println("=========  wallet Payment ==========");
        wallet.printBasicDetail();
        wallet.validatePayment();
        wallet.processPayment();
        wallet.generateReceipt();
    }

}
