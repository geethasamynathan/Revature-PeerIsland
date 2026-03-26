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
CREATE PROCEDURE SPGetAllEmployees()
BEGIN
SELECT * FROM Employees;
END //
DELIMITER ;


drop procedure  GetallEmployees;


CALL 