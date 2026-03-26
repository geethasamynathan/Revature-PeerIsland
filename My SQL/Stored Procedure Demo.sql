-- Stored Procedure

Create Database StoredProcedure_Demo_DB;
use StoredProcedure_Demo_DB;

CREATE TABLE Employees
(
    EmpId INT PRIMARY KEY AUTO_INCREMENT,
    EmpName VARCHAR(100),
    Department VARCHAR(50),
    Salary DECIMAL(10,2),
    JoiningDate DATE,
    Status VARCHAR(20)
);

INSERT INTO Employees (EmpName, Department, Salary, JoiningDate, Status) VALUES
('Arun', 'HR', 30000, '2023-01-10', 'Active'),
('Priya', 'IT', 50000, '2022-05-15', 'Active'),
('Karan', 'Finance', 45000, '2021-03-20', 'Inactive'),
('Meena', 'IT', 60000, '2020-07-12', 'Active'),
('Rahul', 'Sales', 35000, '2024-02-01', 'Active');

select * FROM Employees;

DELIMITER //
CREATE PROCEDURE SP_GetAllEmployees()
BEGIN
SELECT * FROM Employees;
END //
DELIMITER ;

CALL  SP_GetAllEmployees;
drop procedure  GetallEmployees;

-- CREATE STORED PROCEDURE WITH IN (or) INPUT Parameter
GetEmployeesByDepartment

DELIMITER //
CREATE PROCEDURE GetEmployeesByDepartment (IN dept_name varchar(30))
BEGIN
SELECT * FROM Employees where Department=dept_name;
END//

DELIMITER ;


CALL GetEmployeesByDepartment('IT');


--  Stored Procedure With DML 
DELIMITER //
CREATE PROCEDURE AddNewEployee
 (
IN p_EmpName VARCHAR(100),
IN p_Department varchar(100),
IN p_Salary DECIMAL(10,2),
IN p_JoinDate Date,
IN p_Status Varchar(20)
)
BEGIN
INSERT INTO Employees (EmpName,Department,Salary,JoiningDate,Status)
VALUES (p_EmpName,p_Department,p_Salary,p_JoinDate,p_Status);
END //

DELIMITER ;

call AddNewEployee ('Deekshitha','IT',45000,'2026-06-20','Active')

call SP_GetAllEmployees;

DELIMITER //
CREATE PROCEDURE UpdateSalary( 
IN  p_EmpId int, 
IN p_Salary Decimal(10,2)
)
BEGIN
UPDATE Employees SET Salary=p_Salary WHERE EmpId=p_EmpId;
END //

DELIMITER ;


call UpdateSalary(1,55000)


-- Stored Procedure With OUT paramter

drop procedure GetEmployeCount
DELIMITER //
CREATE PROCEDURE GetEmployeCount( 
OUT  total_count int
)
BEGIN
SELECT COUNT(*)  INTO total_count FROM  Employees ;
END //

CALL GetEmployeCount(@emp_total);
SELECT @emp_total

Drop procedure IncreaseSalary
DELIMITER //
CREATE PROCEDURE IncreaseSalary( INOUT p_salary decimal(10,2))
BEGIN
SET p_salary=p_salary+(p_salary*0.10);
END //

DELIMITER ;


SET @sal=50000;
CALL IncreaseSalary(@sal);
SELECT @sal;
