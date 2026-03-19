public class BillingBase {
    protected  String companyName="My Shopping cart";
    public void generateInvoiceHeader(){
        System.out.println("================================");
        System.out.println("           "+companyName);
        System.out.println("   CUSTOMER INVOICE      ");
        System.out.println("================================");
    }
}
