create table T_XBBNHBS_Ticket(ticketId number primary key,
movieName varchar(30),
noOfSeats number,
discountCode varchar(30),
totalPrice number,
theatreId number references T_XBBNHBS_TheatreDetails(theatreId),
viewerId number references T_XBBNHBS_ViewerDetails(ViewerId));

insert into T_XBBNHBS_Ticket(ticketId, movieName, noOfSeats, discountCode, totalPrice, theatreId, viewerId) values(1, 'Fantastic Four', 4, 'ABC100',  600, 1, 1);
select * from T_XBBNHBS_Ticket;
