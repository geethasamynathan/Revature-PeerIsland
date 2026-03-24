package com.example.service;

public class DiscountService {

    private static final double DISCOUNT_RATE=0.10;
    private static final double DISCOUNT_LIMIT=5000;
    private static final double FREE_DELIVERY_LIMIT=2000;


    public double applyDiscount(double amount){
      if(amount<=0){
          throw new IllegalArgumentException("Amount must be greater than zero");
      }
      if(amount>=5000){
          return amount-(amount*0.10);
      }
      return  amount;

    }

    public double calculateFinalAmount(double amount, double couponAmount){
        validateAmount(amount);
        if(couponAmount<0){
            throw new IllegalArgumentException("Coupon amount cannot be negative");
        }
        double discountAmount=applyDiscount(amount);
        double finalAmount=discountAmount-couponAmount;
        if(finalAmount<0)
        {
            throw  new IllegalArgumentException("Final amount cannot be negative");
        }
        return finalAmount;

    }

    public boolean isEligibleForFreeDelivery(double amount){
        validateAmount(amount);
        return  amount >= FREE_DELIVERY_LIMIT;
    }

    public String getCustomerCategory(double amount){
        validateAmount(amount);
        if(amount>=10000){
            return "PLATINUM";
        }else if(amount>=5000){
            return "GOLD";
        }else if(amount>=2000) {
            return "SILVER";
        }else{
            return "BRONZE";
        }
    }

    public int calculateRewardPoints(double amount){
        validateAmount(amount);
        return (int) (amount/100);
    }
    public  boolean validateAmount(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        return  true;
    }
}
