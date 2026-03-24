package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class OrderService {

    private static  final Logger logger= LoggerFactory.getLogger(OrderService.class);


    public void placeOrder(int orderId, int quantity){
        logger.trace("Entered placeOrder() with orderId= {} and qunatity = {}",orderId,quantity);
        logger.debug("Validating order details for orderId= {}",orderId);

        if(quantity<=0){
            logger.warn(" Invalid Quantity {}  for orderId = {}",quantity,orderId);
            return;
        }

        try{
            logger.info("Order Processing started for orderId ={}",orderId);
            if(quantity>3){
                logger.warn(" Large quantity order detected for orderId = {}",orderId);
            }
            logger.info("Order placed successfully for orderid = {}",orderId);
        }catch(Exception e){
            logger.error("Order processing Failed for orderId = {}",orderId,e);
        }
    }

    public static  void main(String[] args){
        OrderService service=new OrderService();
        service.placeOrder(100,4);
        service.placeOrder(1002,-10);
        service.placeOrder(1003,3);
    }
}
