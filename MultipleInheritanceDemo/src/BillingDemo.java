public class BillingDemo {
    public static void main(String[] args) {
        InvoiceService invoice = new InvoiceService();
        double billAmount = 5000.00;
        double tax = invoice.calculateTax(billAmount);
        double discount = invoice.calculateDiscount(billAmount);
        double finalAmount = invoice.calculateFinalAmount(billAmount);

        invoice.generateInvoiceHeader();
        System.out.println("Original Amount = " + billAmount);
        System.out.println("Tax Amount = " + tax);
        System.out.println("Discount Amount = " + discount);
        System.out.println("Final Amount = " + finalAmount);


    }
}
