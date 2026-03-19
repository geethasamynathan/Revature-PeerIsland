public class UpiPaymentDummy {
    double amount;
    String transactionId;
    void validate(){
        System.out.println(" Validating Card Payment");
    }
    void printReceipt(){
        System.out.println("Receipt for transaction"+transactionId);
    }
}
