# Detailed Notes on Subquery and Its Types in MySQL

## 1) What is a Subquery?

A **subquery** is a query written **inside another SQL query**.

It means:

- First, the **inner query** executes
- Then, its result is used by the **outer query**

A subquery is also called:

- **Inner query**
- **Nested query**

### Simple Definition
A subquery is a query inside another query used to fetch intermediate data.

---

## 2) Why do we use Subqueries?

We use subqueries when:

- we need data based on the result of another query
- we want to compare values with a calculated value
- we want to check whether some records exist or not
- we want to filter rows from another table
- we want to perform multi-step data retrieval in a single SQL statement

---

## 3) Real-World Example

Suppose in an **E-Commerce database**:

- You want to find customers who placed orders above the **average order amount**
- You want to find products that were **never ordered**
- You want to find employees whose salary is greater than the **department average**

These are very common subquery use cases.

---

## 4) Create Tables for Subquery Practice

We will use 4 tables:

- Customers
- Categories
- Products
- Orders

### Create Database

```sql
CREATE DATABASE SubqueryDemo;
USE SubqueryDemo;
```

### Create Customers Table

```sql
CREATE TABLE Customers
(
    CustomerId INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(100) NOT NULL,
    City VARCHAR(50),
    Email VARCHAR(100),
    JoinDate DATE
);
```

### Create Categories Table

```sql
CREATE TABLE Categories
(
    CategoryId INT PRIMARY KEY AUTO_INCREMENT,
    CategoryName VARCHAR(100) NOT NULL
);
```

### Create Products Table

```sql
CREATE TABLE Products
(
    ProductId INT PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(100) NOT NULL,
    CategoryId INT,
    Price DECIMAL(10,2),
    Stock INT,
    FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId)
);
```

### Create Orders Table

```sql
CREATE TABLE Orders
(
    OrderId INT PRIMARY KEY AUTO_INCREMENT,
    CustomerId INT,
    ProductId INT,
    OrderDate DATE,
    Quantity INT,
    TotalAmount DECIMAL(10,2),
    FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId),
    FOREIGN KEY (ProductId) REFERENCES Products(ProductId)
);
```

---

## 5) Insert Sample Data

### Insert into Customers

```sql
INSERT INTO Customers (CustomerName, City, Email, JoinDate)
VALUES
('Amit Sharma', 'Chennai', 'amit@gmail.com', '2024-01-10'),
('Priya Nair', 'Bangalore', 'priya@gmail.com', '2024-02-15'),
('Rahul Verma', 'Hyderabad', 'rahul@gmail.com', '2024-03-05'),
('Sneha Iyer', 'Chennai', 'sneha@gmail.com', '2024-01-25'),
('Karthik Raj', 'Mumbai', 'karthik@gmail.com', '2024-04-11');
```

### Insert into Categories

```sql
INSERT INTO Categories (CategoryName)
VALUES
('Electronics'),
('Clothing'),
('Books'),
('Home Appliances');
```

### Insert into Products

```sql
INSERT INTO Products (ProductName, CategoryId, Price, Stock)
VALUES
('Laptop', 1, 75000.00, 10),
('Mobile Phone', 1, 25000.00, 25),
('T-Shirt', 2, 800.00, 100),
('Jeans', 2, 1500.00, 60),
('SQL Book', 3, 550.00, 40),
('Microwave Oven', 4, 12000.00, 8),
('Python Book', 3, 700.00, 30);
```

### Insert into Orders

```sql
INSERT INTO Orders (CustomerId, ProductId, OrderDate, Quantity, TotalAmount)
VALUES
(1, 1, '2024-05-01', 1, 75000.00),
(2, 2, '2024-05-03', 1, 25000.00),
(3, 3, '2024-05-05', 2, 1600.00),
(1, 5, '2024-05-06', 3, 1650.00),
(4, 4, '2024-05-07', 1, 1500.00),
(2, 6, '2024-05-08', 1, 12000.00),
(3, 2, '2024-05-09', 1, 25000.00),
(5, 7, '2024-05-10', 2, 1400.00);
```

### View the Data

```sql
SELECT * FROM Customers;
SELECT * FROM Categories;
SELECT * FROM Products;
SELECT * FROM Orders;
```

---

## 6) Types of Subqueries in MySQL

Main types:

1. **Single Row Subquery**
2. **Multiple Row Subquery**
3. **Multiple Column Subquery**
4. **Correlated Subquery**
5. **Nested Subquery**
6. **Subquery in SELECT clause**
7. **Subquery in FROM clause**
8. **Subquery in WHERE clause**
9. **Subquery with EXISTS**
10. **Subquery with NOT EXISTS**
11. **Subquery with IN**
12. **Subquery with ANY**
13. **Subquery with ALL**
14. **Scalar Subquery**

---

## 7) Single Row Subquery

A **single row subquery** returns **only one row**.

Usually used with operators like:

- `=`
- `>`
- `<`
- `>=`
- `<=`
- `<>`

### Example 1: Find products whose price is greater than the average product price

```sql
SELECT ProductName, Price
FROM Products
WHERE Price >
(
    SELECT AVG(Price)
    FROM Products
);
```

### Example 2: Find customers who joined after the earliest join date

```sql
SELECT CustomerName, JoinDate
FROM Customers
WHERE JoinDate >
(
    SELECT MIN(JoinDate)
    FROM Customers
);
```

---

## 8) Multiple Row Subquery

A **multiple row subquery** returns **more than one row**.

In such cases, we use:

- `IN`
- `ANY`
- `ALL`

### Example 1: Find products whose category is Electronics or Books

```sql
SELECT ProductName, Price
FROM Products
WHERE CategoryId IN
(
    SELECT CategoryId
    FROM Categories
    WHERE CategoryName IN ('Electronics', 'Books')
);
```

### Example 2: Find customers who placed orders

```sql
SELECT CustomerName
FROM Customers
WHERE CustomerId IN
(
    SELECT CustomerId
    FROM Orders
);
```

---

## 9) Multiple Column Subquery

A **multiple column subquery** returns **more than one column**.

### Example: Find order records that match customerId and productId from a specific condition

```sql
SELECT OrderId, CustomerId, ProductId, TotalAmount
FROM Orders
WHERE (CustomerId, ProductId) IN
(
    SELECT CustomerId, ProductId
    FROM Orders
    WHERE Quantity >= 2
);
```

---

## 10) Correlated Subquery

A **correlated subquery** depends on the outer query.

### Example 1: Find products whose price is greater than the average price of their own category

```sql
SELECT p.ProductName, p.Price, p.CategoryId
FROM Products p
WHERE p.Price >
(
    SELECT AVG(p2.Price)
    FROM Products p2
    WHERE p2.CategoryId = p.CategoryId
);
```

### Example 2: Find customers whose order amount is greater than their own average order amount

```sql
SELECT o1.CustomerId, o1.OrderId, o1.TotalAmount
FROM Orders o1
WHERE o1.TotalAmount >
(
    SELECT AVG(o2.TotalAmount)
    FROM Orders o2
    WHERE o2.CustomerId = o1.CustomerId
);
```

---

## 11) Nested Subquery

A **nested subquery** means a subquery inside another subquery.

### Example

```sql
SELECT ProductName, CategoryId, Price
FROM Products
WHERE CategoryId IN
(
    SELECT DISTINCT CategoryId
    FROM Products
    WHERE ProductId IN
    (
        SELECT ProductId
        FROM Orders
        WHERE TotalAmount > 20000
    )
);
```

---

## 12) Subquery in WHERE Clause

```sql
SELECT *
FROM Orders
WHERE TotalAmount >
(
    SELECT AVG(TotalAmount)
    FROM Orders
);
```

---

## 13) Subquery in SELECT Clause

### Example 1

```sql
SELECT
    ProductName,
    Price,
    (
        SELECT AVG(Price)
        FROM Products
    ) AS AveragePrice
FROM Products;
```

### Example 2

```sql
SELECT
    CustomerName,
    (
        SELECT COUNT(*)
        FROM Orders o
        WHERE o.CustomerId = c.CustomerId
    ) AS TotalOrders
FROM Customers c;
```

---

## 14) Subquery in FROM Clause

A subquery in `FROM` acts like a temporary table.

### Example 1: Average of customer total purchases

```sql
SELECT AVG(CustomerTotal) AS AverageCustomerSpending
FROM
(
    SELECT CustomerId, SUM(TotalAmount) AS CustomerTotal
    FROM Orders
    GROUP BY CustomerId
) AS CustomerSummary;
```

### Example 2: Highest customer spending

```sql
SELECT MAX(CustomerTotal) AS HighestSpending
FROM
(
    SELECT CustomerId, SUM(TotalAmount) AS CustomerTotal
    FROM Orders
    GROUP BY CustomerId
) AS SpendingData;
```

---

## 15) Scalar Subquery

A **scalar subquery** returns exactly **one value**.

### Example

```sql
SELECT ProductName, Price
FROM Products
WHERE Price >
(
    SELECT AVG(Price)
    FROM Products
);
```

---

## 16) Subquery with IN

```sql
SELECT ProductName
FROM Products
WHERE ProductId IN
(
    SELECT ProductId
    FROM Orders
    WHERE CustomerId = 1
);
```

---

## 17) Subquery with EXISTS

```sql
SELECT CustomerName
FROM Customers c
WHERE EXISTS
(
    SELECT 1
    FROM Orders o
    WHERE o.CustomerId = c.CustomerId
);
```

---

## 18) Subquery with NOT EXISTS

```sql
SELECT CustomerName
FROM Customers c
WHERE NOT EXISTS
(
    SELECT 1
    FROM Orders o
    WHERE o.CustomerId = c.CustomerId
);
```

### Another example

```sql
SELECT ProductName
FROM Products p
WHERE NOT EXISTS
(
    SELECT 1
    FROM Orders o
    WHERE o.ProductId = p.ProductId
);
```

---

## 19) Subquery with ANY

```sql
SELECT ProductName, Price
FROM Products
WHERE Price > ANY
(
    SELECT Price
    FROM Products
    WHERE CategoryId =
    (
        SELECT CategoryId
        FROM Categories
        WHERE CategoryName = 'Books'
    )
);
```

---

## 20) Subquery with ALL

```sql
SELECT ProductName, Price
FROM Products
WHERE Price > ALL
(
    SELECT Price
    FROM Products
    WHERE CategoryId =
    (
        SELECT CategoryId
        FROM Categories
        WHERE CategoryName = 'Books'
    )
);
```

---

## 21) Practical Subquery Examples

### Example 1: Find customers who bought books

```sql
SELECT CustomerName
FROM Customers
WHERE CustomerId IN
(
    SELECT CustomerId
    FROM Orders
    WHERE ProductId IN
    (
        SELECT ProductId
        FROM Products
        WHERE CategoryId =
        (
            SELECT CategoryId
            FROM Categories
            WHERE CategoryName = 'Books'
        )
    )
);
```

### Example 2: Find the most expensive product

```sql
SELECT ProductName, Price
FROM Products
WHERE Price =
(
    SELECT MAX(Price)
    FROM Products
);
```

### Example 3: Find orders made by customers from Chennai

```sql
SELECT *
FROM Orders
WHERE CustomerId IN
(
    SELECT CustomerId
    FROM Customers
    WHERE City = 'Chennai'
);
```

### Example 4: Find products whose price is less than average price of Electronics

```sql
SELECT ProductName, Price
FROM Products
WHERE Price <
(
    SELECT AVG(Price)
    FROM Products
    WHERE CategoryId =
    (
        SELECT CategoryId
        FROM Categories
        WHERE CategoryName = 'Electronics'
    )
);
```

### Example 5: Find customers whose total order amount is above overall average order amount

```sql
SELECT DISTINCT CustomerId
FROM Orders
WHERE CustomerId IN
(
    SELECT CustomerId
    FROM Orders
    GROUP BY CustomerId
    HAVING SUM(TotalAmount) >
    (
        SELECT AVG(TotalAmount)
        FROM Orders
    )
);
```

### Example 6: Find category names whose products are ordered

```sql
SELECT CategoryName
FROM Categories
WHERE CategoryId IN
(
    SELECT DISTINCT CategoryId
    FROM Products
    WHERE ProductId IN
    (
        SELECT ProductId
        FROM Orders
    )
);
```

---

## 22) Subquery vs Join

### Using Subquery

```sql
SELECT ProductName
FROM Products
WHERE CategoryId =
(
    SELECT CategoryId
    FROM Categories
    WHERE CategoryName = 'Electronics'
);
```

### Same using Join

```sql
SELECT p.ProductName
FROM Products p
JOIN Categories c
ON p.CategoryId = c.CategoryId
WHERE c.CategoryName = 'Electronics';
```

---

## 23) Important Rules

1. Single row subquery uses operators like `=`, `>`, `<`
2. Multiple row subquery uses `IN`, `ANY`, `ALL`
3. Correlated subquery depends on outer query
4. `EXISTS` and `NOT EXISTS` are used to check related row existence
5. Subquery in `FROM` must always have an alias in MySQL

Example:

```sql
SELECT *
FROM
(
    SELECT CustomerId, SUM(TotalAmount) AS TotalSpent
    FROM Orders
    GROUP BY CustomerId
) AS X;
```

---

## 24) Common Errors in Subqueries

### Error 1: Subquery returns more than 1 row

Wrong:

```sql
SELECT ProductName
FROM Products
WHERE CategoryId =
(
    SELECT CategoryId
    FROM Categories
);
```

Correct:

```sql
SELECT ProductName
FROM Products
WHERE CategoryId IN
(
    SELECT CategoryId
    FROM Categories
);
```

### Error 2: Missing alias in FROM subquery

Wrong:

```sql
SELECT *
FROM
(
    SELECT CustomerId, SUM(TotalAmount)
    FROM Orders
    GROUP BY CustomerId
);
```

Correct:

```sql
SELECT *
FROM
(
    SELECT CustomerId, SUM(TotalAmount) AS TotalSpent
    FROM Orders
    GROUP BY CustomerId
) AS CustomerTotals;
```

---

## 25) Practice Queries

### Q1. Find products whose price is greater than average price

```sql
SELECT ProductName, Price
FROM Products
WHERE Price >
(
    SELECT AVG(Price)
    FROM Products
);
```

### Q2. Find customers who have placed at least one order

```sql
SELECT CustomerName
FROM Customers c
WHERE EXISTS
(
    SELECT 1
    FROM Orders o
    WHERE o.CustomerId = c.CustomerId
);
```

### Q3. Find products that were never ordered

```sql
SELECT ProductName
FROM Products p
WHERE NOT EXISTS
(
    SELECT 1
    FROM Orders o
    WHERE o.ProductId = p.ProductId
);
```

### Q4. Find products in categories Electronics and Books

```sql
SELECT ProductName
FROM Products
WHERE CategoryId IN
(
    SELECT CategoryId
    FROM Categories
    WHERE CategoryName IN ('Electronics', 'Books')
);
```

### Q5. Find product whose price is highest in the Products table

```sql
SELECT ProductName, Price
FROM Products
WHERE Price =
(
    SELECT MAX(Price)
    FROM Products
);
```

### Q6. Find customers who ordered products costing more than all Books

```sql
SELECT DISTINCT CustomerId
FROM Orders
WHERE ProductId IN
(
    SELECT ProductId
    FROM Products
    WHERE Price > ALL
    (
        SELECT Price
        FROM Products
        WHERE CategoryId =
        (
            SELECT CategoryId
            FROM Categories
            WHERE CategoryName = 'Books'
        )
    )
);
```

---

## 26) Summary Table

| Type | Returns | Common Operators |
|------|---------|------------------|
| Single Row Subquery | One row | `=`, `>`, `<` |
| Multiple Row Subquery | Many rows | `IN`, `ANY`, `ALL` |
| Multiple Column Subquery | Many columns | Row comparison |
| Correlated Subquery | Depends on outer row | Varies |
| Scalar Subquery | One value | Single-value comparison |
| EXISTS Subquery | Checks existence | `EXISTS` |
| NOT EXISTS Subquery | Checks non-existence | `NOT EXISTS` |
| Subquery in SELECT | One value per row or constant | Scalar / Correlated |
| Subquery in FROM | Temporary table | Derived table |
| Nested Subquery | Query inside query | Varies |

---

## 27) Final Conclusion

A **subquery** is one of the most powerful features in MySQL.

Using subqueries, we can:

- break complex logic into smaller parts
- filter records dynamically
- compare values with calculated results
- check existence of records
- solve real-world business queries easily

Most commonly used in real projects:

- subquery in `WHERE`
- `IN`
- `EXISTS`
- `NOT EXISTS`
- correlated subquery
- subquery in `FROM`

---

## 28) Full Practice Script

```sql
CREATE DATABASE SubqueryDemo;
USE SubqueryDemo;

CREATE TABLE Customers
(
    CustomerId INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(100) NOT NULL,
    City VARCHAR(50),
    Email VARCHAR(100),
    JoinDate DATE
);

CREATE TABLE Categories
(
    CategoryId INT PRIMARY KEY AUTO_INCREMENT,
    CategoryName VARCHAR(100) NOT NULL
);

CREATE TABLE Products
(
    ProductId INT PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(100) NOT NULL,
    CategoryId INT,
    Price DECIMAL(10,2),
    Stock INT,
    FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId)
);

CREATE TABLE Orders
(
    OrderId INT PRIMARY KEY AUTO_INCREMENT,
    CustomerId INT,
    ProductId INT,
    OrderDate DATE,
    Quantity INT,
    TotalAmount DECIMAL(10,2),
    FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId),
    FOREIGN KEY (ProductId) REFERENCES Products(ProductId)
);

INSERT INTO Customers (CustomerName, City, Email, JoinDate)
VALUES
('Amit Sharma', 'Chennai', 'amit@gmail.com', '2024-01-10'),
('Priya Nair', 'Bangalore', 'priya@gmail.com', '2024-02-15'),
('Rahul Verma', 'Hyderabad', 'rahul@gmail.com', '2024-03-05'),
('Sneha Iyer', 'Chennai', 'sneha@gmail.com', '2024-01-25'),
('Karthik Raj', 'Mumbai', 'karthik@gmail.com', '2024-04-11');

INSERT INTO Categories (CategoryName)
VALUES
('Electronics'),
('Clothing'),
('Books'),
('Home Appliances');

INSERT INTO Products (ProductName, CategoryId, Price, Stock)
VALUES
('Laptop', 1, 75000.00, 10),
('Mobile Phone', 1, 25000.00, 25),
('T-Shirt', 2, 800.00, 100),
('Jeans', 2, 1500.00, 60),
('SQL Book', 3, 550.00, 40),
('Microwave Oven', 4, 12000.00, 8),
('Python Book', 3, 700.00, 30);

INSERT INTO Orders (CustomerId, ProductId, OrderDate, Quantity, TotalAmount)
VALUES
(1, 1, '2024-05-01', 1, 75000.00),
(2, 2, '2024-05-03', 1, 25000.00),
(3, 3, '2024-05-05', 2, 1600.00),
(1, 5, '2024-05-06', 3, 1650.00),
(4, 4, '2024-05-07', 1, 1500.00),
(2, 6, '2024-05-08', 1, 12000.00),
(3, 2, '2024-05-09', 1, 25000.00),
(5, 7, '2024-05-10', 2, 1400.00);

SELECT ProductName, Price
FROM Products
WHERE Price > (SELECT AVG(Price) FROM Products);

SELECT CustomerName
FROM Customers
WHERE CustomerId IN (SELECT CustomerId FROM Orders);

SELECT ProductName
FROM Products p
WHERE NOT EXISTS
(
    SELECT 1
    FROM Orders o
    WHERE o.ProductId = p.ProductId
);

SELECT p.ProductName, p.Price, p.CategoryId
FROM Products p
WHERE p.Price >
(
    SELECT AVG(p2.Price)
    FROM Products p2
    WHERE p2.CategoryId = p.CategoryId
);

SELECT CustomerName
FROM Customers c
WHERE EXISTS
(
    SELECT 1
    FROM Orders o
    WHERE o.CustomerId = c.CustomerId
);

SELECT *
FROM Orders
WHERE TotalAmount >
(
    SELECT AVG(TotalAmount)
    FROM Orders
);

SELECT
    ProductName,
    Price,
    (SELECT AVG(Price) FROM Products) AS AveragePrice
FROM Products;

SELECT AVG(CustomerTotal) AS AverageCustomerSpending
FROM
(
    SELECT CustomerId, SUM(TotalAmount) AS CustomerTotal
    FROM Orders
    GROUP BY CustomerId
) AS CustomerSummary;
```
