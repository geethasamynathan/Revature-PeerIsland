Use Joinsdb;

Select * from Employees;
Select * from Departments;
Select * from Projects;
Select * from EmployeeProjects;


DROP  table auditlog;
CREATE TABLE AuditLog
(
AuditId int Primary Key auto_increment,
TableName varchar(100),
ActionType Varchar(30),
ActionDescription varchar(255),
ActionTime DateTime
);

-- DML  Trigger
-- After INSERT TRigger

DROP TRIGGER trg_Departments_AfterInsert;
DELIMITER //
CREATE TRIGGER trg_Departments_AfterInsert
AFTER INSERT ON Departments
FOR EACH ROW
BEGIN
INSERT INTO AuditLog (TableName,ActionType,ActionDescription,ActionTime)
VALUES ('Departments','INSERT', 
CONCAT('New Department added ' ,NEW.DepartmentName, 'at ', NEW.Location),
NOW()
);

END //


Select * from AuditLog;
SELECT * from Departments;

INSERT INTO Departments values (6,'Admin','Delhi')


-- BEFORE TRIGGER
DELIMITER //
CREATE TRIGGER trg_EmployeeProjects_BeforeInsert
BEFORE INSERT ON EmployeeProjects
FOR EACH ROW
BEGIN
IF NEW.RoleName IS NULL OR NEW.RoleName = '' THEN
SIGNAL SQLSTATE '45000'
SET message_text='RoleName cannot be null or Empty';
END IF;
END //
DELIMITER ;


INSERT INTO EmployeeProjects VALUES (108,'202','')


DELIMITER //

CREATE TRIGGER trg_EmployeeProjects_AfterDelete
AFTER DELETE ON EmployeeProjects
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog(TableName, ActionType, ActionDescription, ActionTime)
    VALUES
    (
        'EmployeeProjects',
        'DELETE',
        CONCAT(
            'Employee ', OLD.EmpId,
            ' removed from Project ', OLD.ProjectId,
            ', Role was ', OLD.RoleName
        ),
        NOW()
    );
END //

DELIMITER ;


DELETE FROM EmployeeProjects
WHERE EmpId = 105 AND ProjectId = 204;


SELECT * FROM auditlog;

CREATE TABLE EmployeeAudit
(
    AuditId INT PRIMARY KEY AUTO_INCREMENT,
    EmpId INT,
    OldSalary DECIMAL(10,2),
    NewSalary DECIMAL(10,2),
    UpdatedOn DATETIME
);

DELIMITER //

CREATE TRIGGER trg_Employees_AfterUpdate
AFTER UPDATE ON Employees
FOR EACH ROW
BEGIN
    INSERT INTO EmployeeAudit(EmpId, OldSalary, NewSalary, UpdatedOn)
    VALUES
    (
        OLD.EmpId,
        OLD.Salary,
        NEW.Salary,
        NOW()
    );
END //

DELIMITER ;


SELECT * from Employees;
UPDATE Employees
SET Salary = 60000
WHERE EmpId = 101;


SELECT * from EmployeeAudit;