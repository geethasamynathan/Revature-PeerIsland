public class CardPayment extends Payment {

    private String cardNumber;

    public CardPayment(double amount, String customerName, String transactionId, String cardNumber) {
        super(amount, customerName, transactionId);
        this.cardNumber = cardNumber;
    }

    @Override
    public void validatePayment() {
        System.out.println("Validating Card Number : " + cardNumber);
    }

    @Override
    public void processPayment() {
    System.out.println("Processing Payment through Credit/Debit Card....");
    }
}
