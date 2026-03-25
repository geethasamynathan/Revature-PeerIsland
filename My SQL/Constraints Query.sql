CREATE DATABASE companydb;
use companydb;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(100)
);

INSERT INTO employee(name, department)
VALUES
('Arun', 'Java'),
('Meena', 'Testing'),
('Karthik', 'Cloud');

use BankDB;
create table Employee
(
EmpId int primary key auto_increment,
EmpName varchar(30),
Gender varchar(6));

desc Employee;

insert into Employee (EmpName,Gender) values ('Deekshitha','female');


select * from  Employee;


create table tblEmployee
(
EmpId int ,
EmpName varchar(30),
Gender varchar(6));

desc tblEmployee

alter table tblEmployee add constraint primary key(EmpId) 

insert into tblEmployee  values (2,'Fransy','Female');

ALTER TABLE tblEmployee
MODIFY EmpId INT NOT NULL AUTO_INCREMENT;

Select * from tblEmployee

ALTER TABLE tblEmployee ADD Email varchar(50) unique

insert into tblEmployee (EmpName,Gender) values ('Geetha','Female');


insert into tblEmployee  values (5,'Ajay','Male');

UPDATE tblEmployee SET Email='tina@mail.com' WHERE EmpId=1

ALTER TABLE tblEmployee ADD Location varchar(50) Default 'Chennai'

insert into tblEmployee (EmpName,Gender) values ('Jey','Male');

UPDATE tblEmployee SET Email='tina@mail.com' WHERE EmpId=1
UPDATE tblEmployee SET Email='info@mail.com' -- error because Email is having unique constraint


SET SQL_SAFE_UPDATEs=0;

-- How to update Location for Multiple Employee
UPDATE tblEmployee SET Location='Bangalore' WHERE EMPID IN (1,3,6);

SELECT * FROM tblEmployee;

-- NOT NULL CONSTRAINT

DESC tblEmployee

ALTER TABLE tblEmployee MODIFY EmpName varchar(30) NOT NULL


-- CHECK Constraint
ALTER TABLE tblEmployee ADD Salary decimal(10,2) CHECK (salary between 10000 and 1000000)

UPDATE tblEmployee SET Salary=5000 WHERE EmpId=1 -- error  as check constraint violation

UPDATE tblEmployee SET Salary=45000 WHERE EmpId=1
UPDATE tblEmployee SET Salary=990005 WHERE EmpId=2

ALTER TABLE tblEmployee 
MODIFY Location varchar(100) Default 'Chennai',
ADD CHECK (Location IN ('Chennai','Bangalore','Coimbatore','Hyderbad'))


 INSERT INTO tblEmployee values (4,'ManiDeep','male','manideep@mail.com','Coimbatore',23000)
 
 SELECT * FROM tblEmployee
 
 -- Foreign Key Constraint
 
 DROP TABLE Employee;
 
 
 CREATE TABLE Departments
 (DepartmentId INT PRIMARY KEY,
 DepartmentName varchar(100) NOT NULL);
 
 
  CREATE TABLE Employees
 (EmpId INT PRIMARY KEY,
 EmpName varchar(100) NOT NULL,
 DeptId INT,
 CONSTRAINT Fk_emp_deptId
 FOREIGN KEY(DeptId) REFERENCES Departments(DepartmentId)
 );
 
  INSERT INTO Departments 
  values (101,'HR'),
 (102,'Admin')
 
 
 
 
 INSERT INTO Employees  values  (1,'Harish',101)
 
INSERT INTO Employees  values  (2,'Jey',1) -- error there is no departmentId in Deparrtment Table with Id 1;
  
  
   INSERT INTO  Employees values 
   (2,'Brundharika',102),
     (3,'Janani',101), 
     (4,'Ananya',102)
     
SELECT * FROM Departments;
SELECT * FROM Employees;

DELETE FROM Departments WHERE DepartmentId=101; -- error 
   
  -- FOREIGN KEY with ON DELETE CASCADE
  
  ALTER TABLE Employees
  DROP CONSTRAINT FK_emp_DeptId;
  
ALTER TABLE Employees
  ADD   CONSTRAINT fk_emp_DeptId  FOREIGN KEY(DeptId) 
  REFERENCES Departments(DepartmentId) ON DELETE CASCADE;
  
  SELECT * FROM Departments;
SELECT * FROM Employees;

DELETE FROM Departments WHERE DepartmentId=101;


INSERT INTO Departments   values (101,'HR');

INSERT INTO Employees  values  (1,'Harish',101);
INSERT INTO  Employees values  (3,'Janani',101);

  -- FOREIGN KEY with ON DELETE SET NULL
    ALTER TABLE Employees
  DROP CONSTRAINT FK_emp_DeptId;
  
ALTER TABLE Employees
  ADD   CONSTRAINT fk_emp_DeptId  FOREIGN KEY(DeptId) 
  REFERENCES Departments(DepartmentId) ON DELETE SET NULL;
  
DELETE FROM Departments WHERE DepartmentId=101;

SELECT * FROM Departments;
SELECT * FROM Employees;