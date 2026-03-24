package com.example.service;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DiscountServiceTest {

    private DiscountService service;
    @BeforeAll
    static  void beforeAllTests(){
        System.out.println(" ==== Starting DiscountService Test Suite ======");
    }

    @AfterAll
    static  void afterallTests(){
        System.out.println(" ====  Finished DiscountService Test Suite =====");
    }

    @BeforeEach
    void  setup(){
        service=new DiscountService();
        System.out.println(" Creating fresh DiscountService object before each test");
    }
    @AfterEach
    void teardown(){
        System.out.println("Test Completed");
    }
    @Test
    @Order(1)
    @DisplayName("Should Apply 10% discount when amount is >=5000")
    void ShouldApplyDiscountForLargeAmount(){
        double result=service.applyDiscount(6000);
        assertEquals(5400,result);
        assertNotEquals(6000,result);
        assertTrue(result<6000);
    }

    @Test
    @Order(2)
    @DisplayName("Should not  Apply 1discount when amount is below 5000")
    void shouldNotApplyDiscountForSmallAmount(){
        DiscountService service=new DiscountService();
        double result=service.applyDiscount(3000);
       assertEquals(3000,result);
   }
    @Test
    @Order(3)
    @DisplayName("Should calculate final amount after discount and coupon")
    void shouldCalculateFinalAmountCorrectly(){
        double result=service.calculateFinalAmount(6000,200);
        assertAll("Final amount Checks",
                () -> assertNotNull(result),
                () -> assertTrue(result >0),
                () -> assertEquals(5200,result));

    }
    @Test
    @Order(4)
    @DisplayName("Should return true for free delivery eligibility ")
    void shouldReturnTrueForFreeDelivery(){
        boolean result=service.isEligibleForFreeDelivery(2500);
           assertTrue(result);
    }

    @Test
    @Order(5)
    @DisplayName("Should return false for free delivery eligibility ")
    void shouldReturnFalseForFreeDelivery(){
        boolean result=service.isEligibleForFreeDelivery(1500);
        assertFalse(result);
    }

    @Test
    @Order(6)
    @DisplayName("Should return GOLD category for amount 5000 and above")
    void shouldReturnGoldCategory(){
        String category=service.getCustomerCategory(6000);
        assertEquals("GOLD",category);
        assertNotNull(category);
        assertInstanceOf(String.class,category);

    }
    @Test
    @Order(7)
    @DisplayName("Should return PLATINUM category for amount 10000 and above")
    void shouldReturnPlatinumCategory(){
        String category=service.getCustomerCategory(16000);
        assertEquals("GOLD",category);
        assertNotNull(category);
        assertInstanceOf(String.class,category);

    }
    @Test
    @Order(8)
    @DisplayName("Should calculate reward points correctly")
    void shouldCalculateRewardPoints() {
        int points = service.calculateRewardPoints(2500);
        assertEquals(25, points);
        assertTrue(points > 0);
    }

    @Test
    @Order(9)
    @DisplayName("Should throw exception for zero amount")
    void shouldThrowExceptionForZeroAmount() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.applyDiscount(0)
        );

        assertEquals("Amount must be greater than zero", exception.getMessage());
    }
    @Test
    @Order(10)
    @DisplayName("Should throw exception for negative coupon")
    void shouldThrowExceptionForNegativeCoupon() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.calculateFinalAmount(6000, -100)
        );

        assertEquals("Coupon amount cannot be negative", exception.getMessage());
    }
    @Test
    @Order(11)
    @DisplayName("Should not throw exception for valid amount")
    void shouldNotThrowExceptionForValidAmount() {
        assertDoesNotThrow(() -> service.validateAmount(1000));
    }
    @Test
    @Order(12)
    @DisplayName("Assumption example using environment")
    void shouldRunOnlyInExpectedEnvironment() {
        assumeTrue("dev".equals(System.getProperty("app.env", "dev")),
                "Skipping test because environment is not dev");

        double result = service.applyDiscount(7000);
        assertEquals(6300, result);
    }

    @Test
    @Order(13)
    @DisplayName("Assumption example using amount check")
    void shouldRunBasedOnAssumption() {
        double amount = 8000;

        assumingThat(amount > 5000, () -> {
            double discounted = service.applyDiscount(amount);
            assertEquals(7200, discounted);
        });

        assertTrue(amount > 0);
    }

    @Disabled("Temporarily disabled for demo purpose")
    @Test
    @Order(14)
    @DisplayName("Disabled test example")
    void disabledTestExample() {
        fail("This test is disabled and should not run");
    }

    @RepeatedTest(3)
    @DisplayName("Repeated test example for reward points")
    void repeatedTestExample() {
        int points = service.calculateRewardPoints(1000);
        assertEquals(10, points);
    }
//    void shouldApplyTenPercentDiscountWhenAmountIsAbove5000OrMore() {
//        DiscountService service = new DiscountService();
//        double result = service.applyDiscount(6000);
//        assertEquals(5400, result);
//    }
//
//
//
//    @Test
//    void shouldThrowExceptionWhenAmountIsZeroOrNegative(){
//        DiscountService service=new DiscountService();
//        double result=service.applyDiscount(3000);
//        assertThrows(IllegalArgumentException.class,() -> service.applyDiscount(0));
//    }
}
