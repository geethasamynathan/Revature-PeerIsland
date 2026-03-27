public class Main {

    public  static  void main(String[]  args){
        OrderService orderService=new OrderService();
        InvoiceService invoiceService=new InvoiceService();
        orderService.createOrder();
        invoiceService.generatInvoice();
    }

}
