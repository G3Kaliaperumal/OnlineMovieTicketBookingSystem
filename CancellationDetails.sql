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