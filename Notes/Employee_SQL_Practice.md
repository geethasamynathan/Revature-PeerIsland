# Employee Performance SQL Practice (MySQL)

## Real-World Use Case: Employee Performance and Bonus Tracking

This dataset helps practice:
- Operators
- WHERE
- GROUP BY
- HAVING

---

## 1. Create Database

```sql
CREATE DATABASE CompanyDB;
USE CompanyDB;
```

---

## 2. Create Table

```sql
CREATE TABLE EmployeePerformance
(
    EmpId INT PRIMARY KEY AUTO_INCREMENT,
    EmpName VARCHAR(50) NOT NULL,
    Gender VARCHAR(10),
    Department VARCHAR(30),
    City VARCHAR(30),
    Salary DECIMAL(10,2),
    ExperienceYears INT,
    PerformanceRating INT,
    MonthlyBonus DECIMAL(10,2),
    JoinDate DATE
);
```

---

## 3. Insert Data

```sql
INSERT INTO EmployeePerformance
(EmpName, Gender, Department, City, Salary, ExperienceYears, PerformanceRating, MonthlyBonus, JoinDate)
VALUES
('Aarav', 'Male', 'IT', 'Bangalore', 65000, 5, 4, 5000, '2021-06-15'),
('Diya', 'Female', 'HR', 'Chennai', 45000, 3, 3, 3000, '2022-02-10'),
('Karthik', 'Male', 'Finance', 'Hyderabad', 70000, 7, 5, 7000, '2020-01-20'),
('Sneha', 'Female', 'IT', 'Bangalore', 80000, 8, 5, 9000, '2019-09-25'),
('Rahul', 'Male', 'Sales', 'Mumbai', 40000, 2, 2, 1500, '2023-03-18');
```

---

## 4. Operators

### Arithmetic
```sql
SELECT EmpName, Salary + MonthlyBonus AS Total FROM EmployeePerformance;
```

### Comparison
```sql
SELECT * FROM EmployeePerformance WHERE Salary > 60000;
```

### Logical
```sql
SELECT * FROM EmployeePerformance WHERE Department='IT' AND Salary>60000;
```

### Special
```sql
SELECT * FROM EmployeePerformance WHERE Salary BETWEEN 40000 AND 70000;
SELECT * FROM EmployeePerformance WHERE Department IN ('IT','HR');
SELECT * FROM EmployeePerformance WHERE EmpName LIKE 'A%';
```

---

## 5. WHERE

```sql
SELECT * FROM EmployeePerformance WHERE PerformanceRating >= 4;
```

---

## 6. GROUP BY

```sql
SELECT Department, COUNT(*) FROM EmployeePerformance GROUP BY Department;
```

---

## 7. HAVING

```sql
SELECT Department, AVG(Salary)
FROM EmployeePerformance
GROUP BY Department
HAVING AVG(Salary) > 60000;
```

---

## 8. Combined Query

```sql
SELECT Department, AVG(Salary)
FROM EmployeePerformance
WHERE Salary > 40000
GROUP BY Department
HAVING AVG(Salary) > 60000;
```

---

## Practice Tasks

1. Find employees with salary > 50000  
2. Count employees per department  
3. Departments with avg salary > 60000  
4. Names starting with 'A'  
