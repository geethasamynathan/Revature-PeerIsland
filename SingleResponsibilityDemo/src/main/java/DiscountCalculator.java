//public class DiscountCalculator {
//    public double calculateDiscount(String customerType,double amount){
//        if(customerType.equals("REGULAR")){
//            return  amount*0.10;
//        }else if(customerType.equals("PREMIUM")){
//            return amount*0.20;
//        }
//        return 0 ;
//
//    }
//}


interface DiscountStrategy{
    double applyDiscount(double amount);
}

class RegularCustomerDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double amount) {
        return amount*0.10;
    }
}

class PremiumCustomerDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double amount) {
        return amount*0.20;
    }
}
class GoldCustomerDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double amount) {
        return amount*0.30;
    }
}

class DiscountCalculator{

      public double calculateDiscount(DiscountStrategy strategy,double amount) {
        return strategy.applyDiscount(amount);
    }
}

 class OpenCloseMain{
    public static void main(String[] args){
        DiscountCalculator calculator=new DiscountCalculator();

        double amount=1000;
        DiscountStrategy regular=new RegularCustomerDiscount();
        DiscountStrategy premium=new PremiumCustomerDiscount();
        DiscountStrategy gold=new GoldCustomerDiscount();

        double regularDiscount=calculator.calculateDiscount(regular,amount);
        double premiumDiscount=calculator.calculateDiscount(premium,amount);
        double goldDiscount=calculator.calculateDiscount(gold,amount);

        System.out.println("Amount :"+amount);
        System.out.println(" Regular Customer Discount : "+regularDiscount);
        System.out.println(" Premium Customer Discount : "+premiumDiscount);
        System.out.println(" Gold Customer Discount : "+goldDiscount);
    }
}

