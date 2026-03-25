-- Joins Demo

CREATE DATABASE JoinsDB;

USE JoinsDb;

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

Select * from Employees;
Select * from Departments;
Select * from Projects;
Select * from EmployeeProjects;

-- INNER JOIN
Select  e.EmpId,e.EmpName,d.DepartmentName,e.DepartmentId
FROM Employees e
INNER JOIN  Departments d
ON e.DepartmentId= d.DepartmentId;


-- LEFT JOIN
Select  e.EmpId,e.EmpName,d.DepartmentName
FROM Employees e
LEFT JOIN  Departments d
ON e.DepartmentId= d.DepartmentId;


-- RIGHT JOIN
Select  e.EmpId,e.EmpName,d.DepartmentName
FROM Employees e
RIGHT JOIN  Departments d
ON e.DepartmentId= d.DepartmentId;



-- FULL JOIN
Select  EmpName,d.DepartmentName
FROM Employees 
LEFT JOIN  Departments d
ON e.DepartmentId= d.DepartmentId
UNION
Select  e.EmpName,d.DepartmentName
FROM Employees e
RIGHT  JOIN  Departments d
ON e.DepartmentId= d.DepartmentId;

Select  e.EmpName,p.ProjectName
FROM Employees e
CROSS JOIN  Projects p
ON e.EmpId= p.ProjectId


-- SELF JOIN 

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

SELECT e.EmpName AS Employee, m.EmpName as Manager
FROM EmployeeHierarchy e
LEFT JOIN
EmployeeHierarchy m
ON e.ManagerId= m.EmpId;



-- Exampl of Joins with 3 tables

SELECT e.EmpId, e.EmpName,d.DepartmentName,p.ProjectName,ep.RoleName
FROM Employees e
INNER JOIN Departments d
ON e.DepartmentId=d.DepartmentId
INNER JOIN EmployeeProjects ep
ON e.EmpId=ep.EmpId
INNER JOIN Projects p
On p.ProjectId=ep.ProjectId;
