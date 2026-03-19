public class InvoiceService extends BillingBase  implements  Taxable,Discountable
{
    //@Override
    public double calculateTax(double amount) {
        return amount*0.18;
    }

    public double calculateDiscount(double amount)
    {
        return amount*0.10;
    }

    public double calculateFinalAmount(double amount){
        return amount+calculateTax(amount)-calculateDiscount(amount);
    }


}
