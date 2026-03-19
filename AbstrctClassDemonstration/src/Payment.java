abstract class Payment {
    protected String transactionId;
    protected double amount;
    protected  String customerName;

    public Payment(double amount, String customerName, String transactionId) {
        this.amount = amount;
        this.customerName = customerName;
        this.transactionId = transactionId;
    }

     static  void sampleMethod(){
        System.out.println("sampleMethod from abstract class");
    }

    public void generateReceipt(){
        System.out.println("Receipt generated for transaction : "+transactionId);
    }
    public void printBasicDetail(){
        System.out.println("Transaction Id : "+transactionId);
        System.out.println("Customer Name : "+customerName);
        System.out.println("Amount : "+amount);
    }

    public abstract  void validatePayment();
    public abstract  void processPayment();
}
