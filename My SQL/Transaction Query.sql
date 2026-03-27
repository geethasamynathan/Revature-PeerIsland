SELECT @@autocommit;
USE BankDB;
CREATE TABLE BankAccounts
(
    AccountId INT PRIMARY KEY,
    AccountHolderName VARCHAR(50),
    Balance DECIMAL(10,2)
) ENGINE=InnoDB;

INSERT INTO BankAccounts (AccountId, AccountHolderName, Balance)
VALUES
(101, 'Arun', 10000.00),
(102, 'Banu', 5000.00),
(103, 'Charan', 8000.00);

SELECT * FROM BankAccounts;

SHOW TABLE STATUS LIKE 'BankAccounts';
SHOW TABLE STATUS LIKE 'Customer';


START TRANSACTION;
UPDATE BankAccounts
SET Balance = Balance - 2000
WHERE AccountId = 101;

UPDATE BankAccounts
SET Balance = Balance + 2000
WHERE AccountId = 102;
COMMIT;


START TRANSACTION;

UPDATE BankAccounts
SET Balance = Balance - 1000
WHERE AccountId = 101;

ROLLBACK;


SELECT * FROM BankAccounts;


START TRANSACTION;

UPDATE BankAccounts
SET Balance = Balance - 500
WHERE AccountId = 102;

SAVEPOINT sp1;

UPDATE BankAccounts
SET Balance = Balance + 500
WHERE AccountId = 103;

ROLLBACK TO sp1;

COMMIT;