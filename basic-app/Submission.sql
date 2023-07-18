create schema tarun;
use tarun;

create table lead_detail ( 
 id varchar(20) primary key,
 first_name varchar(20), 
 last_name varchar(20), 
 email_address varchar(30),
 phone_number varchar(15)
 );

create table submission (
id varchar(20) primary key,
consultant_id varchar(20),
 submission_date date,
 vendor_company varchar(60),
 vendor_name varchar(40),
 vendor_email_Address varchar(60),
 vendor_phone_number varchar(15),
 implementation_partner varchar(50),
 client_name varchar(40),
 pay_rate int,
 submission_status varchar(20),
 submission_type varchar(20),
 city varchar(20),
 state varchar(20),
 zip int
 );
 
 drop table submission;
 
create table consultant_detail
(
  id varchar(20) primary key,
  lead_id varchar(20),
first_name varchar(20),
last_name varchar(20),
email_address varchar(30),
phone_number varchar(15)
);
 
 create table submission_update(
 id varchar(20) primary key,
submission_id varchar(20),
update_text varchar(30),
created_date date);

 alter table consultant_detail add constraint fk_leadid foreign key (lead_id) references lead_detail(id);
 
 alter table submission add constraint fk_consultantid foreign key (consultant_id) references consultant_detail(id);
 
 alter table submission_update add constraint fk_submissionid foreign key (submission_id) references submission(id);
 /*Given a "Employee" table with first_name, last_name, job_start_date and salary as columns.
write a DDL command to create this table*/
 create table Employee(
 first_name varchar(20),
 last_name varchar(20),
 job_start_date date,
 salary int
 );
 /*write a DDL command to add a new column "department"*/
 
 alter table Employee add column department varchar(20);
 
 /*Write a SQL query to find the highest salary from an "Employee" table.*/
 select max(salary) from Employee;
 
 /*write a query to find all the employees who joined in the last 6 months;*/
 
 
 /*write a query display number of employees in each department.*/
 select department,count(department) from Employee group by department;
 
 /*Write a SQL query to update email_address on the consultant_detail table*/
 update consultant_detail set email_address="a@a" where id=1;
 
 /*Write a SQL to find total number of submissions for each constulant.*/
 select cd.first_name,count(consultant_id) from submission s join consultant_detail cd
 on cd.id= s.consultant_id group by s.consultant_id;
 
 /*Write a SQL to find total number of submissions for each constulant by each submission day*/
 select cd.first_name,s.submission_date,count(consultant_id) from submission s join consultant_detail cd
 on cd.id= s.consultant_id group by s.consultant_id,s.submission_date;
 
 /*write a SQL to delete all submissions where "rate" is null*/
 delete from submission where pay_rate is null;
 
 /*Given a lead name and submission date, Write a SQL query to find the submissions.*/
 select count(*) from submission s 
 join consultant_detail cd on cd.id=s.consultant_id 
 join lead_detail ld on ld.id= cd.lead_id
 where ld.first_name="prem" and s.submission_date='2023-07-07'
 group by ld.first_name,s.submission_date;
 
 /*Write a SQL query to find the number of submissions by each lead.*/
 select ld.first_name,count(ld.first_name) from submission s 
 join consultant_detail cd on cd.id=s.consultant_id 
 join lead_detail ld on ld.id= cd.lead_id
 group by ld.first_name;
 
 
 