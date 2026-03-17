public class Customer {
    private String customerName;
    private int customerId;
    private String location;

//    public Customer(String customerName, int customerId, String location) {
//        this.customerName = customerName;
//        this.customerId = customerId;
//        this.location = location;
//    }


    public void displayCustomerInfo(int id, String name, String location) {
        this.customerId = id;
        this.customerName = name;
        this.location = location;
        System.out.println("Id " + customerId);
        System.out.println("Name " + customerName);
        System.out.println("Location " + location);


    }

    public double[]  CalculatetheDiscount(int price) {
        double discountPrice = 0,profit=100;
        discountPrice = price - 500;
        return new double[] {discountPrice, profit};
    }
}
