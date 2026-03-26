# Java Non-Access Modifiers

**Project: Java FS**

In Java, **non-access modifiers** are keywords that do **not control visibility** like `public`, `private`, `protected`, but instead control **behavior, lifecycle, inheritance, memory, implementation style, or compilation rules**.

## 1. What are non-access modifiers in Java?

Non-access modifiers are used to define things like:

- whether a variable or method belongs to the class or object
- whether a class or method can be inherited
- whether a method must be overridden
- whether a value cannot be changed
- whether multiple threads can safely access a method
- whether a field is not part of serialization
- whether a variable can change unexpectedly due to external factors

---

## 2. List of non-access modifiers in Java

The common non-access modifiers in Java are:

1. `static`
2. `final`
3. `abstract`
4. `synchronized`
5. `volatile`
6. `transient`


Now let us understand each one with a **real-world use case**, explanation, and example.

---

## 3. `static`

### What it is
`static` means the member belongs to the **class itself**, not to individual objects.

### Where it is used
- variables
- methods
- blocks
- nested classes

### Real-world use case
Suppose you are building an **employee management system**.
Every employee has a different name and id, but the **company name** is same for all employees.

So `companyName` should be `static`.

### Example code

```java
class Employee {
    int employeeId;
    String employeeName;
    static String companyName = "TechGenie Solutions";

    Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    void display() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Company: " + companyName);
        System.out.println("----------------------");
    }
}

public class StaticExample {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Arun");
        Employee emp2 = new Employee(102, "Meena");

        emp1.display();
        emp2.display();

        Employee.companyName = "ItTechGenie Pvt Ltd";

        emp1.display();
        emp2.display();
    }
}
```

### Why to use
Use `static` when the value or method is common for all objects.

---

## 4. `final`

### What it is
`final` means something cannot be changed further.

It can be used with:
- variable
- method
- class

### 4A. `final` variable

A `final` variable value cannot be changed after assignment.

### Real-world use case
In a **banking application**, the account opening charge may be fixed.

```java
class BankRules {
    final double MINIMUM_BALANCE = 1000.0;

    void showRule() {
        System.out.println("Minimum Balance: " + MINIMUM_BALANCE);
    }
}

public class FinalVariableExample {
    public static void main(String[] args) {
        BankRules rule = new BankRules();
        rule.showRule();
    }
}
```

If you try to change `MINIMUM_BALANCE`, Java gives error.

### 4B. `final` method

A `final` method cannot be overridden.

### Real-world use case
In an **online exam system**, the formula used to calculate final score should not be modified by child classes.

```java
class ExamEvaluator {
    final void calculateFinalScore(int marks, int bonus) {
        int total = marks + bonus;
        System.out.println("Final Score: " + total);
    }
}

class OnlineExamEvaluator extends ExamEvaluator {
    // cannot override calculateFinalScore()
}

public class FinalMethodExample {
    public static void main(String[] args) {
        OnlineExamEvaluator obj = new OnlineExamEvaluator();
        obj.calculateFinalScore(80, 5);
    }
}
```

### 4C. `final` class

A `final` class cannot be extended.

### Real-world use case
Suppose in a **payment verification module**, you do not want anyone to change the logic through inheritance.

```java
final class PaymentSecurity {
    void verifyTransaction() {
        System.out.println("Transaction verified with secure rules.");
    }
}

public class FinalClassExample {
    public static void main(String[] args) {
        PaymentSecurity security = new PaymentSecurity();
        security.verifyTransaction();
    }
}
```

---

## 5. `abstract`

### What it is
`abstract` means incomplete.
It is used when you want to define a base structure, but some behavior must be implemented by child classes.

It can be used with:
- class
- method

### Real-world use case
In an **e-commerce delivery system**, every delivery has:
- tracking id
- status display

But delivery charge calculation differs for:
- bike delivery
- express delivery
- international delivery

So use abstract class.

### Example code

```java
abstract class DeliveryService {
    String trackingId;

    DeliveryService(String trackingId) {
        this.trackingId = trackingId;
    }

    void showTrackingId() {
        System.out.println("Tracking ID: " + trackingId);
    }

    abstract void calculateDeliveryCharge(double distance);
}

class BikeDelivery extends DeliveryService {
    BikeDelivery(String trackingId) {
        super(trackingId);
    }

    void calculateDeliveryCharge(double distance) {
        System.out.println("Bike Delivery Charge: " + (distance * 8));
    }
}

class ExpressDelivery extends DeliveryService {
    ExpressDelivery(String trackingId) {
        super(trackingId);
    }

    void calculateDeliveryCharge(double distance) {
        System.out.println("Express Delivery Charge: " + (distance * 15));
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        DeliveryService d1 = new BikeDelivery("TRK1001");
        d1.showTrackingId();
        d1.calculateDeliveryCharge(10);

        DeliveryService d2 = new ExpressDelivery("TRK1002");
        d2.showTrackingId();
        d2.calculateDeliveryCharge(10);
    }
}
```

### Why to use
Use `abstract` when some common structure exists, but implementation differs.

---

## 6. `synchronized`

### What it is
`synchronized` is used to control access when multiple threads use the same resource.

### Real-world use case
In a **ticket booking system**, if two users book the last seat at the same time, the system must prevent duplicate booking.

### Example code

```java
class TicketCounter {
    int availableSeats = 1;

    synchronized void bookTicket(String userName, int seatsRequested) {
        if (availableSeats >= seatsRequested) {
            System.out.println(userName + " booked " + seatsRequested + " seat(s).");
            availableSeats = availableSeats - seatsRequested;
        } else {
            System.out.println(userName + " could not book ticket. No seats available.");
        }
    }
}

class UserThread extends Thread {
    TicketCounter counter;
    String userName;
    int seatsRequested;

    UserThread(TicketCounter counter, String userName, int seatsRequested) {
        this.counter = counter;
        this.userName = userName;
        this.seatsRequested = seatsRequested;
    }

    public void run() {
        counter.bookTicket(userName, seatsRequested);
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        UserThread user1 = new UserThread(counter, "Arun", 1);
        UserThread user2 = new UserThread(counter, "Meena", 1);

        user1.start();
        user2.start();
    }
}
```

### Why to use
Use `synchronized` when multiple threads share same data and data consistency is important.

---

## 7. `volatile`

### What it is
`volatile` tells Java that the variable value may be changed by multiple threads, so always read the latest value from memory.

### Real-world use case
In a **live notification service**, a background thread may update a flag when a new message arrives, and another thread must immediately see the latest value.

### Example code

```java
class NotificationService {
    volatile boolean newMessageAvailable = false;

    void receiveMessage() {
        newMessageAvailable = true;
        System.out.println("New message received.");
    }

    void checkMessage() {
        if (newMessageAvailable) {
            System.out.println("Displaying new message notification.");
        } else {
            System.out.println("No new message.");
        }
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.checkMessage();
        service.receiveMessage();
        service.checkMessage();
    }
}
```

### Why to use
Use `volatile` when one thread updates a variable and another thread must get the latest value immediately.

---

## 8. `transient`

### What it is
`transient` means a variable should not be saved during serialization.

### Real-world use case
In a **user login system**, password should not be stored when the object is serialized.

### Example code

```java
import java.io.Serializable;

class UserAccount implements Serializable {
    String username;
    transient String password;

    UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    void display() {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}

public class TransientExample {
    public static void main(String[] args) {
        UserAccount user = new UserAccount("gopinath", "Secret@123");
        user.display();
    }
}
```

### Why to use
Use `transient` for sensitive or temporary data that must not be serialized.

---

#
## 11. Summary table

| Modifier | Used With | Purpose | Real Use Case |
|---|---|---|---|
| `static` | variable, method, block, nested class | common for all objects | company name, common counter |
| `final` | variable, method, class | cannot be changed/overridden/inherited | fixed rules, constants, secure class |
| `abstract` | class, method | incomplete design to be implemented by child class | delivery, employee roles, reports |
| `synchronized` | method, block | thread-safe access | ticket booking, seat reservation |
| `volatile` | variable | latest value visible across threads | notification flag, server status |
| `transient` | variable | do not serialize field | password, OTP, session token |


---

## 12. Difference between access and non-access modifiers

### Access modifiers
These control visibility:
- `public`
- `private`
- `protected`
- default

### Non-access modifiers
These control behavior:
- `static`
- `final`
- `abstract`
- `synchronized`
- `volatile`
- `transient`
---

## 13. Real mini combined example

This example uses multiple non-access modifiers together.

```java
abstract class EmployeePortal {
    static String companyName = "ItTechGenie";
    final String portalVersion = "v1.0";

    abstract void login();

    final void showPortalRules() {
        System.out.println("Portal Rules cannot be changed.");
    }
}

class TrainerPortal extends EmployeePortal {
    void login() {
        System.out.println("Trainer logged into " + companyName);
    }
}

public class CombinedModifierExample {
    public static void main(String[] args) {
        TrainerPortal trainer = new TrainerPortal();
        trainer.login();
        trainer.showPortalRules();
        System.out.println("Version: " + trainer.portalVersion);
    }
}
```

---

## 14. Interview-friendly definition

**Non-access modifiers in Java are keywords that do not define visibility, but define the behavior and characteristics of classes, variables, and methods such as inheritance control, shared memory, thread safety, immutability, incomplete implementation, serialization behavior, and native linking.**

---

## 15. When to use which one

- Use `static` when data is common to all objects
- Use `final` when value or logic must not change
- Use `abstract` when base rule is common but implementation differs
- Use `synchronized` when multiple threads use the same resource
- Use `volatile` for thread visibility of a variable
- Use `transient` for sensitive data during serialization
