create database BTVN;
use BTVN;

create table departments 
(
deID int primary key,
deName varchar(20),
deDecrip text,
cre datetime ,
updated datetime
);
create table roles 
(
roID int primary key,
roName varchar (30),
cre datetime,
updated datetime
);
create table salary_detail_type
(
satpID int primary key,
satpName varchar(20),
cre datetime,
updated datetime 
);
create table salary_detail
(
sadtID int primary key,
amount double(12,2),
saID int,
satpID int,
operation tinyint(3),
 foreign key (saID) references salary(saID),
foreign key (satpID) references salary_detail_type(satpID)
);

create table users
(
usID int primary key ,
firstName varchar(30),
lastName varchar(30),
email varchar(30),
phone varchar(20),
employeeID varchar(10),
avatar text,
departmentID int,
gender tinyint(10),
age int(3),
create_At datetime,
update_At datetime 
);
create table User_Depart
( 
udID int primary key,
usID int,
deID int,
start_date date ,
end_date date ,
create_At datetime,
update_At datetime
);
alter table User_Depart
-- us ở đây là id của bảng department !!!
add constraint FK_User foreign key (usID) references users(usID),
add constraint FK_De foreign key (deID) references departments(deID);

create table User_Role 
(
urID int primary key,
usID int,
roID int,
start_date date,
end_date date ,
create_at datetime,
update_at datetime,
foreign key (usID) references User_Depart(usID),
foreign key(roID) references  roles(roID)
);

create table salary
(
saID int primary key,
urID int,
total_salary double(12,2),
sMonth varchar(20),
sYear varchar(4),
create_at datetime,
update_at datetime,
foreign key (urID) references User_Role(urID)
);
-- Chèn dữ liệu vào bảng salary_detail_type
INSERT INTO salary_detail_type (satpID, satpName, cre, updated)
VALUES
    (1, 'luong chinh', '2023-09-27 08:00:00', '2023-09-27 08:30:00'),
    (2, 'phu cap', '2023-09-27 09:00:00', '2023-09-27 09:30:00'),
    (3, 'luong phu', '2023-09-27 10:00:00', '2023-09-27 10:30:00'),
    (4, 'Type D', '2023-09-27 11:00:00', '2023-09-27 11:30:00'),
    (5, 'Type E', '2023-09-27 12:00:00', '2023-09-27 12:30:00'),
    (6, 'Type F', '2023-09-27 13:00:00', '2023-09-27 13:30:00'),
    (7, 'Type G', '2023-09-27 14:00:00', '2023-09-27 14:30:00'),
    (8, 'Type H', '2023-09-27 15:00:00', '2023-09-27 15:30:00'),
    (9, 'Type I', '2023-09-27 16:00:00', '2023-09-27 16:30:00'),
    (10, 'Type J', '2023-09-27 17:00:00', '2023-09-27 17:30:00');

INSERT INTO salary_detail (sadtID, amount, saID, satpID, operation)
VALUES
    (1, 1000.00, 1, 1, 1),
    (2, 1500.50, 1, 2, 2),
    (3, 800.00, 2, 1, 1),
    (4, 1200.75, 2, 3, 2),
    (5, 950.25, 3, 2, 1),
    (6, 2000.00, 3, 3, 2);

-- lấy ra lương tháng 5 của 1 user bất kì 
select firstName , lastName , total_salary
from users as u join user_depart as ud on u.usID = ud.usID
join user_role as ur on ud.udID = ur.urID
join salary as sa on ur.urID = sa.saID
where sMonth = 5;
-- lấy ra danh sách lương của phòng ban trong tháng 5 
select deName , sum(total_salary) 
from departments as de join user_depart as ud on de.deID = ud.udID
join user_role as ur on ud.udID = ur.urID
join salary as sa on sa.saID = ur.urID
where sMonth = 5
group by (de.deID)
order by sum(total_salary) DESC;

-- lấy ra phòng ban có tổng lương là cao nhất 
select deName , sum(total_salary) as tongluong
from departments as de join user_depart as ud on de.deID = ud.udID
join user_role as ur on ud.udID = ur.urID
join salary as sa on sa.saID = ur.urID
group by (de.deID);









