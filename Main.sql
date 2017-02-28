create table T_XBBNHBS_CancellationDetails(
timeInHours number primary key,
deductionAmount number)
insert into T_XBBNHBS_CancellationDetails(timeInHours, deductionAmount) values(1, 200);
insert into T_XBBNHBS_CancellationDetails(timeInHours, deductionAmount) values(2, 180);
insert into T_XBBNHBS_CancellationDetails(timeInHours, deductionAmount) values(3, 160);
insert into T_XBBNHBS_CancellationDetails(timeInHours, deductionAmount) values(4, 140);
insert into T_XBBNHBS_CancellationDetails(timeInHours, deductionAmount) values(5, 120);
insert into T_XBBNHBS_CancellationDetails(timeInHours, deductionAmount) values(6, 100);
select * from T_XBBNHBS_CancellationDetails;

create table T_XBBNHBS_DiscountDetails(
discountCode varchar(10),
discountAmount number)
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('AAAAAA', 500);
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('AAABBB', 400);
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('ABCABC', 300);
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('ABC100', 200);
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('ABCXYZ', 100);
select * from T_XBBNHBS_DiscountDetails;

create table T_XBBNHBS_FoodSupplierDetails(
foodType varchar(30),
foodSupplierName varchar(30),
price number)
insert into T_XBBNHBS_FoodSupplierDetails(foodType, foodSupplierName, price) values('Puff', 'Puffies', 100);
insert into T_XBBNHBS_FoodSupplierDetails(foodType, foodSupplierName, price) values('Pizza', 'DominasPizza', 150);
insert into T_XBBNHBS_FoodSupplierDetails(foodType, foodSupplierName, price) values('Popcorn', 'PopcornMania', 200);
select * from T_XBBNHBS_FoodSupplierDetails;

create table T_XBBNHBS_Movie(movieId number primary key,
movieName varchar(30))
insert into T_XBBNHBS_Movie(movieId, movieName) values(1, 'Fantastic Four');
insert into T_XBBNHBS_Movie(movieId, movieName) values(2, 'Alvin and the Chimpunks');
select * from T_XBBNHBS_Movie;

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

create table T_XBBNHBS_Ratings (movieId number references T_XBBNHBS_Movie(movieId),
rating number,
movieRaterId number references T_XBBNHBS_MovieRaterDetails(movieRaterId));
insert into T_XBBNHBS_Ratings(movieId, rating, movieRaterId) values(1, 4, 1);
insert into T_XBBNHBS_Ratings(movieId, rating, movieRaterId) values(2, 3, 1);
select * from T_XBBNHBS_Ratings

create table T_XBBNHBS_TheatreDetails(theatreId number primary key,
theatreName varchar(30),
fromTime timestamp,
toTime timestamp,
movieId number references T_XBBNHBS_Movie(movieId))
insert into T_XBBNHBS_TheatreDetails(theatreId, theatreName, fromTime, toTime, movieId) values(1, 'Raksha Theatre', TO_TIMESTAMP('2017-04-01 06:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2017-04-01 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);
insert into T_XBBNHBS_TheatreDetails(theatreId, theatreName, fromTime, toTime, movieId) values(2, 'Vetri Theatre', TO_TIMESTAMP('2017-04-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2017-04-01 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), 2);
select * from T_XBBNHBS_TheatreDetails;

create table T_XBBNHBS_Ticket(ticketId number primary key,
movieName varchar(30),
noOfSeats number,
discountCode varchar(30),
totalPrice number,
theatreId number references T_XBBNHBS_TheatreDetails(theatreId),
viewerId number references T_XBBNHBS_ViewerDetails(ViewerId));

insert into T_XBBNHBS_Ticket(ticketId, movieName, noOfSeats, discountCode, totalPrice, theatreId, viewerId) values(1, 'Fantastic Four', 4, 'ABC100',  600, 1, 1);
select * from T_XBBNHBS_Ticket;

create table T_XBBNHBS_TicketTypeDetails (ticketType varchar(30),
amount number);
insert into T_XBBNHBS_TicketTypeDetails(ticketType, amount) values('FirstClass', 150);
insert into T_XBBNHBS_TicketTypeDetails(ticketType, amount) values('SecondClass', 120);
insert into T_XBBNHBS_TicketTypeDetails(ticketType, amount) values('BoxOffice', 200);
select * from T_XBBNHBS_TicketTypeDetails;

CREATE TABLE T_XBBNHBS_ViewerDetails(
viewerId number PRIMARY KEY,
viewerName varchar(30),
phoneNumber varchar(10),
password varchar(15)
)
insert into T_XBBNHBS_ViewerDetails(viewerId, viewerName, phoneNumber, password) values (1, 'AnnieMarie', '8220309040', 'annie@#$');
insert into T_XBBNHBS_ViewerDetails(viewerId, viewerName, phoneNumber, password) values (2, 'Bency', '8120309040', '@#$bency');
insert into T_XBBNHBS_ViewerDetails(viewerId, viewerName, phoneNumber, password) values (3, 'Christopher', '8220809040', 'chrissy@g');
insert into T_XBBNHBS_ViewerDetails(viewerId, viewerName, phoneNumber, password) values (4, 'Denny', '8220309041', 'denny123');
insert into T_XBBNHBS_ViewerDetails(viewerId, viewerName, phoneNumber, password) values (5, 'Esther', '8220309050', 'esther345');

select * from T_XBBNHBS_ViewerDetails;
