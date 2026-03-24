CREATE DATABASE BankDB;
use BankDB;

drop table Branch 
create table Branches.Branch(
BranchId int auto_increment primary key,
Branchcode char(6) NOT NULL unique,
BranchName varchar(100) NOT NULL,
IFSCCode char(11) NOT NULL Unique,
Address varchar(150),
City varchar(50),
Email varchar(100) NOT NULL Unique,
OpenDate Date Not Null,
iIsActive bit Not NULL Default 1
);

insert into Branches.Branch 
(BranchCode,BranchName,IFSCCode,Address,City,Email,OpenDate,iIsActive)
VALUES

('BR1002','Coimbatore Branch','SBI0001235','Avinashi Salai', 'Avinashi','coimbatore.main@bank.com','2021-04-01',0),
('BR1003','Bangalore Main Branch','SBI0001236','Brigad Road', 'T Nagar','bangalore.main@bank.com','2021-05-01',1)


select * from Branches.Branch

CREATE SCHEMA  Branches;


CREATE TABLE CUSTOMER
(
CustomerId int,
CustomerName varchar(50));


insert into Customer values (101,'Harish')


insert into Customer (CustomerName)  
values ('Shivam'),
('Ananya'),
('Deekshitha')

delete from Customer 

SELECT * from Customer

SET SQL_SAFE_UPDATES=0;
delete from Customer where CustomerId is NULL

ALTER TABLE Customer Modify
CustomerId int NOT NULL

DESC Customer


ALTER TABLE Customer
Modify
CustomerId int NOT NULL Auto_increment,
ADD PRIMARY KEY(CustomerId)


ALTER TABLE Customer
Add Email varchar(100) unique,
Add ConatctNo bigint