USE CompanyDB;
DROP TABLE EmployeePerformance;
CREATE TABLE  EmployeePerformance
(
EmpId INT PRIMARY KEY AUTO_INCREMENT,
EmpName VARCHAR(30) NOT NULL,
Gender varchar(10),
Department Varchar(50),
City Varchar(30),
Salary Decimal(10,2),
ExperienceYears INT,
PerformanceRating INT,
MonthlyBonus Decimal(10,2),
JoinDate DATE);


SELECT * FROM EmployeePerformance;

INSERT INTO EmployeePerformance
(EmpName, Gender, Department, City, Salary, ExperienceYears, PerformanceRating, MonthlyBonus, JoinDate)
VALUES
('Aadhi', 'Male', 'IT', 'Bangalore', 65000, 5, 4, 5000, '2021-06-15'),
('Diya', 'Female', 'HR', 'Chennai', 45000, 3, 3, 3000, '2022-02-10'),
('Karthik', 'Male', 'Finance', 'Hyderabad', 70000, 7, 5, 7000, '2020-01-20'),
('Sneha', 'Female', 'IT', 'Bangalore', 80000, 8, 5, 9000, '2019-09-25'),
('Rahul', 'Male', 'Sales', 'Mumbai', 40000, 2, 2, 1500, '2023-03-18');




-- operators Demo

SELECT * FROM EmployeePerformance;

SELECT EmpName,Salary, MonthlyBonus,Salary +MonthlyBonus AS TotalSalary FROM EmployeePerformance;
SELECT EmpName,Salary, MonthlyBonus,Salary -MonthlyBonus AS OnlySalaryWithoutBonus FROM EmployeePerformance;

-- Comparison Operator
SELECT * FROM EmployeePerformance WHERE Salary >60000;

SELECT * FROM EmployeePerformance WHERE Salary >60000 OR department='Finance';

SELECT * FROM EmployeePerformance WHERE Salary  BETWEEN 50000 and 75000;
SELECT * FROM EmployeePerformance WHERE Salary NOT  BETWEEN 50000 and 75000;

SELECT * FROM EmployeePerformance WHERE Department IN ('IT','HR');
SELECT * FROM EmployeePerformance WHERE Department NOT  IN ('IT','HR');

SELECT * FROM EmployeePerformance WHERE EmpName LIKE  'A%';
SELECT * FROM EmployeePerformance WHERE EmpName LIKE  '%A';

SELECT * FROM EmployeePerformance WHERE EmpName LIKE  'A_d%';


-- GROUP BY
SELECT  Department,Count(*) FROM EmployeePerformance GROUP BY Department;


-- HAVING

SELECT  Department, AVG(Salary) FROM EmployeePerformance
GROUP BY Department HAVING AVG(Salary) > 60000;



--Combined Query (HAving, WHERE ,GRoup BY)
SELECT  Department, AVG(Salary) FROM EmployeePerformance
WHERE Salary> 50000
GROUP BY Department HAVING AVG(Salary) > 60000;


INSERT INTO EmployeePerformance
(EmpName, Gender, Department, City, Salary, ExperienceYears, PerformanceRating, MonthlyBonus, JoinDate)
VALUES
('Keerthi', 'Female', 'Sales', 'Mumbai', 40000, 2,2, NULL, '2026-02-01');


SELECT * FROM EmployeePerformance;

SELECT * FROM EmployeePerformance WHERE MonthlyBonus IS NULL;
SELECT * FROM EmployeePerformance WHERE MonthlyBonus IS NOT NULL;


SELECT * FROM EmployeePerformance WHERE MonthlyBonus != NULL;

UPDATE EmployeePerformance SET MonthlyBonus= 2500 WHERE MonthlyBonus IS NULL;

SELECT * FROM EmployeePerformance order BY department;

SELECT * FROM EmployeePerformance order BY department, EmpName;
SELECT * FROM EmployeePerformance order BY department desc, EmpName desc;

SELECT EMpId, EmpName,Gender, Department, City,Salary, ExperienceYears,MonthlyBonus,JoinDate
From EmployeePerformance
ORDER BY Count(*) OVER (PARTITION BY Department) DESC,Department,EmpName;