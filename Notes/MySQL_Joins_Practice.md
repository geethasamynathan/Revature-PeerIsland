# MySQL Joins - Complete Practice Script

## Real-World Use Case: Employee - Department - Project

---

## 1. Create Database

```sql
CREATE DATABASE CompanyJoinDB;
USE CompanyJoinDB;
```

---

## 2. Create Tables

```sql
CREATE TABLE Departments
(
    DepartmentId INT PRIMARY KEY,
    DepartmentName VARCHAR(50),
    Location VARCHAR(50)
);

CREATE TABLE Employees
(
    EmpId INT PRIMARY KEY,
    EmpName VARCHAR(50),
    Gender VARCHAR(10),
    Salary DECIMAL(10,2),
    DepartmentId INT,
    FOREIGN KEY (DepartmentId) REFERENCES Departments(DepartmentId)
);

CREATE TABLE Projects
(
    ProjectId INT PRIMARY KEY,
    ProjectName VARCHAR(50),
    ClientName VARCHAR(50)
);

CREATE TABLE EmployeeProjects
(
    EmpId INT,
    ProjectId INT,
    RoleName VARCHAR(50),
    PRIMARY KEY (EmpId, ProjectId),
    FOREIGN KEY (EmpId) REFERENCES Employees(EmpId),
    FOREIGN KEY (ProjectId) REFERENCES Projects(ProjectId)
);
```

---

## 3. Insert Data

```sql
INSERT INTO Departments VALUES
(1, 'HR', 'Chennai'),
(2, 'IT', 'Bangalore'),
(3, 'Finance', 'Hyderabad'),
(4, 'Sales', 'Mumbai'),
(5, 'Support', 'Pune');

INSERT INTO Employees VALUES
(101, 'Aarav', 'Male', 50000, 2),
(102, 'Diya', 'Female', 45000, 1),
(103, 'Karthik', 'Male', 70000, 3),
(104, 'Sneha', 'Female', 65000, 2),
(105, 'Rahul', 'Male', 40000, 4),
(106, 'Meera', 'Female', 48000, NULL),
(107, 'Vikram', 'Male', 55000, 5);

INSERT INTO Projects VALUES
(201, 'Payroll System', 'ABC Corp'),
(202, 'E-Commerce App', 'XYZ Ltd'),
(203, 'Banking Portal', 'National Bank'),
(204, 'CRM Tool', 'Retail Hub'),
(205, 'Analytics Dashboard', 'Data Insight');

INSERT INTO EmployeeProjects VALUES
(101, 202, 'Developer'),
(101, 205, 'Support Engineer'),
(103, 203, 'Analyst'),
(104, 202, 'Tester'),
(105, 204, 'Sales Coordinator'),
(107, 205, 'Support Lead');
```

---

## 4. INNER JOIN

```sql
SELECT e.EmpId, e.EmpName, d.DepartmentName
FROM Employees e
INNER JOIN Departments d
ON e.DepartmentId = d.DepartmentId;
```

---

## 5. LEFT JOIN

```sql
SELECT e.EmpId, e.EmpName, d.DepartmentName
FROM Employees e
LEFT JOIN Departments d
ON e.DepartmentId = d.DepartmentId;
```

---

## 6. RIGHT JOIN

```sql
SELECT e.EmpName, d.DepartmentName
FROM Employees e
RIGHT JOIN Departments d
ON e.DepartmentId = d.DepartmentId;
```

---

## 7. FULL OUTER JOIN (MySQL way)

```sql
SELECT e.EmpName, d.DepartmentName
FROM Employees e
LEFT JOIN Departments d
ON e.DepartmentId = d.DepartmentId

UNION

SELECT e.EmpName, d.DepartmentName
FROM Employees e
RIGHT JOIN Departments d
ON e.DepartmentId = d.DepartmentId;
```

---

## 8. CROSS JOIN

```sql
SELECT e.EmpName, p.ProjectName
FROM Employees e
CROSS JOIN Projects p;
```

---

## 9. SELF JOIN

```sql
CREATE TABLE EmployeeHierarchy
(
    EmpId INT PRIMARY KEY,
    EmpName VARCHAR(50),
    ManagerId INT
);

INSERT INTO EmployeeHierarchy VALUES
(1, 'Arun', NULL),
(2, 'Banu', 1),
(3, 'Charan', 1),
(4, 'Divya', 2);

SELECT e.EmpName AS Employee, m.EmpName AS Manager
FROM EmployeeHierarchy e
LEFT JOIN EmployeeHierarchy m
ON e.ManagerId = m.EmpId;
```

---

## 10. Practice Queries

```sql
-- Employees without department
SELECT * FROM Employees WHERE DepartmentId IS NULL;

-- Employees without project
SELECT e.EmpName
FROM Employees e
LEFT JOIN EmployeeProjects ep ON e.EmpId = ep.EmpId
WHERE ep.ProjectId IS NULL;

-- Departments without employees
SELECT d.DepartmentName
FROM Employees e
RIGHT JOIN Departments d ON e.DepartmentId = d.DepartmentId
WHERE e.EmpId IS NULL;
```
