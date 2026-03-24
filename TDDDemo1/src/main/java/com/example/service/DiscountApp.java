package com.example.service;

public class DiscountApp {
    public static  void main(String[] args){
        DiscountService service=new DiscountService();
        double amount=6000;
        double coupon=200;

        System.out.println(" Original amount : "+amount);
        System.out.println(" Dicounted amount : "+service.applyDiscount(amount));
        System.out.println(" Final amount : "+service.calculateFinalAmount(amount,coupon));
        System.out.println(" Free Delivery Eligible : "+service.isEligibleForFreeDelivery(amount));
        System.out.println(" Customer Category : "+service.getCustomerCategory(amount));
        System.out.println(" Reward Points : "+service.calculateRewardPoints(amount));



    }
}

