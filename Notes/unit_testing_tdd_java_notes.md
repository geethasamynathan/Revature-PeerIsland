# Unit Testing and Test-Driven Development (TDD) in Java

## 1. What is Unit Testing?
Unit Testing is a software testing method where we test the smallest testable part of an application, usually a method or a class, independently.

In Java, a unit is often:
- one method
- one class
- one small business logic component

Example:
```java
public int add(int a, int b) {
    return a + b;
}
```
Testing whether `add(2, 3)` returns `5` is a unit test.

## 2. Why Unit Testing is needed
Unit testing is used to make sure each small piece of code works correctly before the full application is integrated.

### Importance
- Finds bugs early
- Improves code quality
- Reduces manual testing effort
- Helps during code changes
- Gives confidence during refactoring

## 3. Real-world meaning of Unit Testing
Imagine you are building an E-Commerce Order System.

You may want to test:
- calculate total amount
- apply discount
- validate quantity
- check tax calculation

Instead of testing the whole website, payment, database, and UI together, you first test each method independently.

## 4. What is a Unit?
A unit is the smallest independently testable piece of code.

Example:
```java
public double calculateDiscount(double amount) {
    if (amount >= 5000) {
        return amount * 0.10;
    }
    return 0;
}
```

## 5. Characteristics of a good unit test
A good unit test should be:
- Fast
- Independent
- Repeatable
- Clear
- Focused

## 6. Tools used for Unit Testing in Java
Most commonly used tools are:
- JUnit
- Mockito
- AssertJ / Hamcrest

The most common starting point is:
- JUnit 5
- Mockito

## 7. What is JUnit?
JUnit is a Java testing framework used to write and run test cases.

Example:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }
}
```

## 8. Important JUnit annotations
- `@Test` - Marks a method as a test case
- `@BeforeEach` - Runs before every test method
- `@AfterEach` - Runs after every test method
- `@BeforeAll` - Runs once before all tests
- `@AfterAll` - Runs once after all tests

## 9. What are Assertions?
Assertions are used to verify whether the output is correct.

Common assertions:
- `assertEquals(expected, actual)`
- `assertNotEquals(expected, actual)`
- `assertTrue(condition)`
- `assertFalse(condition)`
- `assertNull(value)`
- `assertNotNull(value)`
- `assertThrows(...)`

## 10. Real-world example of Unit Testing in Java
### Production code
```java
public class OrderService {

    public double calculateTotal(double price, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        return price * quantity;
    }

    public double applyDiscount(double total) {
        if (total >= 5000) {
            return total - (total * 0.10);
        }
        return total;
    }
}
```

### Unit test code
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    OrderService service = new OrderService();

    @Test
    void shouldCalculateTotalCorrectly() {
        double result = service.calculateTotal(1000, 3);
        assertEquals(3000, result);
    }

    @Test
    void shouldApplyDiscountForLargeOrders() {
        double result = service.applyDiscount(6000);
        assertEquals(5400, result);
    }

    @Test
    void shouldNotApplyDiscountForSmallOrders() {
        double result = service.applyDiscount(3000);
        assertEquals(3000, result);
    }

    @Test
    void shouldThrowExceptionForInvalidQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateTotal(1000, 0);
        });
    }
}
```

## 11. What is Test-Driven Development (TDD)?
TDD is a development approach where:
1. first you write the test
2. then you write the actual code
3. then you improve the code

So in TDD, tests are written before implementation.

## 12. TDD cycle
TDD follows the famous cycle:
- Red
- Green
- Refactor

### Red
Write a test for a feature that does not yet exist. The test fails.

### Green
Write minimum code needed to pass the test.

### Refactor
Improve the code without breaking functionality.

## 13. TDD example
Requirement: If cart amount is above ₹5000, give 10% discount.

### Step 1: Write failing test first
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountServiceTest {

    @Test
    void shouldApplyTenPercentDiscountForAmountAbove5000() {
        DiscountService service = new DiscountService();
        assertEquals(5400, service.applyDiscount(6000));
    }
}
```

### Step 2: Write minimum code
```java
public class DiscountService {

    public double applyDiscount(double amount) {
        return 5400;
    }
}
```

### Step 3: Refactor properly
```java
public class DiscountService {

    public double applyDiscount(double amount) {
        if (amount > 5000) {
            return amount - (amount * 0.10);
        }
        return amount;
    }
}
```

## 14. Difference between Unit Testing and TDD
| Feature | Unit Testing | TDD |
|---|---|---|
| Meaning | Tests small units of code | Development process driven by tests |
| When tests are written | Usually after code | Before code |
| Goal | Verify correctness | Drive design and development |
| Main focus | Testing code | Building code through tests |
| Output | Test cases | Better design + test coverage |

## 15. Real-world TDD use case in Java
### ATM Withdrawal example
Requirement:
- customer can withdraw amount
- withdrawal should fail if amount is less than or equal to 0
- withdrawal should fail if balance is insufficient
- successful withdrawal should reduce balance

### Test first
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void shouldReduceBalanceAfterSuccessfulWithdrawal() {
        BankAccount account = new BankAccount(10000);
        account.withdraw(2000);
        assertEquals(8000, account.getBalance());
    }

    @Test
    void shouldThrowExceptionIfWithdrawalAmountIsInvalid() {
        BankAccount account = new BankAccount(10000);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }

    @Test
    void shouldThrowExceptionIfInsufficientBalance() {
        BankAccount account = new BankAccount(1000);
        assertThrows(IllegalStateException.class, () -> account.withdraw(5000));
    }
}
```

### Production code
```java
public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

## 16. What is Mocking?
Sometimes one class depends on another class. In unit testing, we may not want to call real external systems like email, database, or payment gateway.

That is where Mockito is used.

### Example
```java
public class NotificationService {
    public String sendEmail(String email) {
        return "Email sent to " + email;
    }
}
```

```java
public class RegistrationService {

    private NotificationService notificationService;

    public RegistrationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public String registerUser(String email) {
        String result = notificationService.sendEmail(email);
        return "User registered. " + result;
    }
}
```

### Test with Mockito
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RegistrationServiceTest {

    @Test
    void shouldRegisterUserSuccessfully() {
        NotificationService mockNotificationService = mock(NotificationService.class);

        when(mockNotificationService.sendEmail("user@gmail.com"))
                .thenReturn("Email sent to user@gmail.com");

        RegistrationService service = new RegistrationService(mockNotificationService);

        String result = service.registerUser("user@gmail.com");

        assertEquals("User registered. Email sent to user@gmail.com", result);
    }
}
```

## 17. Best practices
- Test one behavior at a time
- Use meaningful test method names
- Keep tests independent
- Keep tests simple and readable
- Use Arrange-Act-Assert pattern

Example:
```java
@Test
void shouldCalculateFinalAmount() {
    // Arrange
    OrderService service = new OrderService();

    // Act
    double result = service.calculateTotal(500, 2);

    // Assert
    assertEquals(1000, result);
}
```

## 18. Maven dependencies for JUnit and Mockito
```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.11.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 19. Summary
### Unit Testing
Unit testing means checking whether one small part of code works correctly.

### TDD
TDD means writing the test first, then writing code to make it pass.

### TDD cycle
- Red
- Green
- Refactor

## 20. Conclusion
Unit Testing and TDD are very important in Java projects because they help build:
- reliable code
- maintainable code
- bug-free business logic
- confident refactoring culture

Unit Testing ensures that each small part works correctly.
TDD ensures that development itself is driven by expected behavior.
