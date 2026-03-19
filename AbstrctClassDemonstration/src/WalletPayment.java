public class WalletPayment extends Payment{
    private String walletName;
    public WalletPayment(double amount, String customerName, String transactionId,String walletName) {
        super(amount, customerName, transactionId);
        this.walletName=walletName;
    }

    @Override
    public void validatePayment() {
    System.out.println(" Checking the wallet Account "+walletName);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing payment through wallet...");
    }

}
