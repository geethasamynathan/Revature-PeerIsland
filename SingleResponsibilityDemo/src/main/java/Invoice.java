public class Invoice {

    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double calculateTotal() {
        return amount + (amount * 0.18);
    }
}
class  InvoicePrinter {

    public void printInvoice(Invoice invoice) {
        System.out.println("Invoice amount : " +invoice.calculateTotal());

    }
}

class InvoiceRepository{
    public void saveToDatabase(){
        System.out.println("Saving invoice to database..");
    }
}
