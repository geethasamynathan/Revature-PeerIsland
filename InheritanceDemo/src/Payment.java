import javax.smartcardio.Card;

public class Payment {
    double amount;
    String transactionId;

    Payment(double amount, String transactionId){
        this.amount=amount;
        this.transactionId=transactionId;
    }
      void printReceipt(){
        System.out.println("Receipt for transaction"+transactionId);
          System.out.println("Amount Paid "+amount);
    }
}

class CardPayment extends Payment{
    CardPayment(double amount,String transactionId)
    {
        super(amount,transactionId);
    }
    void validate(){
        System.out.println("Validating Card Payment");
    }
}
class UpiPayment extends Payment{
    UpiPayment(double amount,String transactionId)
    {
        super(amount,transactionId);
    }
    void validate(){
        System.out.println("Validating UPI Payment");

    }
}
class PaymentDemo{
    public static void main(String[] args){
        CardPayment card=new CardPayment(34000,"CRAD1290");
        card.amount=23000.45;
        card.transactionId="CARD0001";
        card.validate();
        card.printReceipt();

        System.out.println("-----------------------------------");

        UpiPayment upi=new UpiPayment(6700,"UPI3456");
        upi.amount=9876;
        upi.transactionId="UPI00124";
        upi.validate();
        upi.printReceipt();

    }
}