package com.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiscountServiceTest {
    @Test
    void shouldApplyTenPercentDiscountWhenAmountIsAbove5000OrMore() {
        DiscountService service = new DiscountService();
        double result = service.applyDiscount(6000);
        assertEquals(5400, result);
    }

    @Test
    void shouldNotApplyDiscountWhenAmpountIsLessThan5000(){
        DiscountService service=new DiscountService();
        double result=service.applyDiscount(3000);
        assertEquals(3000,result);
    }

    @Test
    void shouldThrowExceptionWhenAmountIsZeroOrNegative(){
        DiscountService service=new DiscountService();
        double result=service.applyDiscount(3000);
        assertThrows(IllegalArgumentException.class,() -> service.applyDiscount(0));
    }
}
