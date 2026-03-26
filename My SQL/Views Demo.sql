Use Joinsdb;

Select * from Employees;
Select * from Departments;
Select * from Projects;
Select * from EmployeeProjects;

-- Simple View 
CREATE VIEW vw_EmployeeBasics AS
SELECT EmpId,EmpName,Gender FROM employees;

-- How to call the view 
SELECT * FROM vw_EmployeeBasics;

-- Complex View 
CREATE VIEW vw_EmployeeWithDepartments AS
SELECT 
e.EmpId,e.EmpName,e.Salary,d.DepartmentName 
FROM Employees e
LEFT JOIN Departments d
ON e.DepartmentId= d.DepartmentId;

SELECT * FROM vw_EmployeeWithDepartments;

-- another example for Complex view

DROP VIEW vw_EmployeeWithDepartments;
-- Complex View 
CREATE OR REPLACE  VIEW vw_EmployeeProjectDetails AS
SELECT 
e.EmpName,d.DepartmentName ,p.ProjectName,ep.RoleName
FROM Employees e
 JOIN Departments d ON e.DepartmentId= d.DepartmentId
 JOIN EmployeeProjects ep ON e.empId=ep.EmpId
 JOIN Projects p ON ep.ProjectId=p.ProjectId;
 
 
 INSERT  INTO vw_EmployeeBasics
 VALUES (108,'Fransy','Female');
 
 SELECT * FROM vw_EmployeeBasics;
 
 Select * from Employees;
 
 
 DROP VIEW viewname;
 
 