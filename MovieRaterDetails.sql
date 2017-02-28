create table T_XBBNHBS_MovieRaterDetails(
movieRaterId number primary key,
movieRaterName varchar(30),
phoneNumber varchar(10),
email varchar(30),
address varchar(30),
password varchar(30))
insert into T_XBBNHBS_MovieRaterDetails(movieRaterId, movieRaterName, phoneNumber, email, address, password) values(1, 'Abi', '9456872386', 'abi123@gmail.com', 'Nair Street', 'abi@123');
insert into T_XBBNHBS_MovieRaterDetails(movieRaterId, movieRaterName, phoneNumber, email, address, password) values(2, 'Banu', '9456872386', 'banu123@gmail.com', 'Iyer Street', 'banu@123');
select * from T_XBBNHBS_MovieRaterDetails;