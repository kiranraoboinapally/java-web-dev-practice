create table Jobs
(
    Jid int,
    Jname varchar(45),
    Jcategory varchar(45),
    Jqualification varchar(45)
);





create table employee
    -> (
    -> eid int not null,
    -> efirst_name varchar(45) not null,
    -> elast_name varchar(45),
    -> email varchar(45) not null unique,
    -> emobile bigint not null unique,
    -> eage int not null default '29',
    -> ebasic_salary int not null,
    -> eta double as (ebasic_salary/100*10),
    -> eda double as (ebasic_salary/100*5),
    -> ehra double as (ebasic_salary/100*7),
    -> etax double not null,
    -> salary double as (ebasic_salary+eta+eda+ehra),
    -> final_salary double  as (salary-etax/100*18)
    -> );