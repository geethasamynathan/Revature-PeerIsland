# MySQL Triggers – Complete End-to-End Tutorial

## 1) What is a Trigger?

A **trigger** in MySQL is a **stored program** that automatically executes when an event occurs on a table.

### Events:
- INSERT
- UPDATE
- DELETE

---

## 2) Why Do We Use Triggers?

- Auditing
- Validation
- Logging
- Business rules
- Data consistency

---

## 3) Types of Triggers

### Based on Timing
- BEFORE
- AFTER

### Based on Events
- BEFORE INSERT
- AFTER INSERT
- BEFORE UPDATE
- AFTER UPDATE
- BEFORE DELETE
- AFTER DELETE

---

## 4) Create Database

```sql
CREATE DATABASE TriggerDemo;
USE TriggerDemo;
```

---

## 5) Create Tables

### Orders Table

```sql
CREATE TABLE Orders
(
    OrderId INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(100),
    ProductName VARCHAR(100),
    Quantity INT,
    Price DECIMAL(10,2),
    TotalAmount DECIMAL(10,2),
    CreatedDate DATETIME
);
```

### Audit Table

```sql
CREATE TABLE OrderAudit
(
    AuditId INT PRIMARY KEY AUTO_INCREMENT,
    OrderId INT,
    ActionType VARCHAR(50),
    OldValue VARCHAR(255),
    NewValue VARCHAR(255),
    ActionDate DATETIME
);
```

---

## 6) BEFORE INSERT Trigger

```sql
DELIMITER $$

CREATE TRIGGER before_order_insert
BEFORE INSERT ON Orders
FOR EACH ROW
BEGIN
    IF NEW.Quantity <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Quantity must be greater than 0';
    END IF;

    SET NEW.TotalAmount = NEW.Quantity * NEW.Price;
    SET NEW.CreatedDate = NOW();
END$$

DELIMITER ;
```

---

## 7) AFTER INSERT Trigger

```sql
DELIMITER $$

CREATE TRIGGER after_order_insert
AFTER INSERT ON Orders
FOR EACH ROW
BEGIN
    INSERT INTO OrderAudit(OrderId, ActionType, NewValue, ActionDate)
    VALUES (NEW.OrderId, 'INSERT',
            CONCAT('Inserted Order for ', NEW.CustomerName),
            NOW());
END$$

DELIMITER ;
```

---

## 8) BEFORE UPDATE Trigger

```sql
DELIMITER $$

CREATE TRIGGER before_order_update
BEFORE UPDATE ON Orders
FOR EACH ROW
BEGIN
    IF NEW.Price < 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Price cannot be negative';
    END IF;

    SET NEW.TotalAmount = NEW.Quantity * NEW.Price;
END$$

DELIMITER ;
```

---

## 9) AFTER UPDATE Trigger

```sql
DELIMITER $$

CREATE TRIGGER after_order_update
AFTER UPDATE ON Orders
FOR EACH ROW
BEGIN
    INSERT INTO OrderAudit(OrderId, ActionType, OldValue, NewValue, ActionDate)
    VALUES (
        NEW.OrderId,
        'UPDATE',
        CONCAT('Old Price: ', OLD.Price),
        CONCAT('New Price: ', NEW.Price),
        NOW()
    );
END$$

DELIMITER ;
```

---

## 10) BEFORE DELETE Trigger

```sql
DELIMITER $$

CREATE TRIGGER before_order_delete
BEFORE DELETE ON Orders
FOR EACH ROW
BEGIN
    IF OLD.TotalAmount > 100000 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete high-value order';
    END IF;
END$$

DELIMITER ;
```

---

## 11) AFTER DELETE Trigger

```sql
DELIMITER $$

CREATE TRIGGER after_order_delete
AFTER DELETE ON Orders
FOR EACH ROW
BEGIN
    INSERT INTO OrderAudit(OrderId, ActionType, OldValue, ActionDate)
    VALUES (
        OLD.OrderId,
        'DELETE',
        CONCAT('Deleted Order of ', OLD.CustomerName),
        NOW()
    );
END$$

DELIMITER ;
```

---

## 12) Sample Data

```sql
INSERT INTO Orders (CustomerName, ProductName, Quantity, Price)
VALUES ('Amit', 'Laptop', 2, 50000);

INSERT INTO Orders (CustomerName, ProductName, Quantity, Price)
VALUES ('Priya', 'Mobile', 1, 20000);
```

---

## 13) Test Queries

```sql
UPDATE Orders SET Price = 60000 WHERE OrderId = 1;
DELETE FROM Orders WHERE OrderId = 2;

SELECT * FROM Orders;
SELECT * FROM OrderAudit;
```

---

## 14) Drop Triggers

```sql
DROP TRIGGER before_order_insert;
DROP TRIGGER after_order_insert;
DROP TRIGGER before_order_update;
DROP TRIGGER after_order_update;
DROP TRIGGER before_order_delete;
DROP TRIGGER after_order_delete;
```

---

## 15) Summary

| Trigger | Purpose |
|--------|--------|
| BEFORE INSERT | Validate + calculate |
| AFTER INSERT | Log insert |
| BEFORE UPDATE | Validate update |
| AFTER UPDATE | Track changes |
| BEFORE DELETE | Prevent delete |
| AFTER DELETE | Log delete |

---

## Final Conclusion

Triggers automate database actions and ensure consistency, validation, and auditing.
