create table T_XBBNHBS_TicketTypeDetails (ticketType varchar(30),
amount number);
insert into T_XBBNHBS_TicketTypeDetails(ticketType, amount) values('FirstClass', 150);
insert into T_XBBNHBS_TicketTypeDetails(ticketType, amount) values('SecondClass', 120);
insert into T_XBBNHBS_TicketTypeDetails(ticketType, amount) values('BoxOffice', 200);
select * from T_XBBNHBS_TicketTypeDetails;