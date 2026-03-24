package com.example.service;

public class DiscountService {

    public double applyDiscount(double amount){
      if(amount<=0){
          throw new IllegalArgumentException("Amount must be greater than zero");
      }
      if(amount>=5000){
          return amount-(amount*0.10);
      }
      return  amount;

    }
}
