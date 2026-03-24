package com.example.service;

public class DiscountApp {
    public static  void main(String[] args){
        DiscountService service=new DiscountService();
        double amount1=6000;
        double amount2=3000;

        System.out.println(" Original amount : "+amount1);
        System.out.println(" Final amount : "+service.applyDiscount(amount1));

        System.out.println(" Original amount : "+amount2);
        System.out.println(" Final amount : "+service.applyDiscount(amount2));


    }
}
