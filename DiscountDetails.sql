create table T_XBBNHBS_DiscountDetails(
discountCode varchar(10),
discountAmount number)
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('AAAAAA', 500);
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('AAABBB', 400);
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('ABCABC', 300);
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('ABC100', 200);
insert into T_XBBNHBS_DiscountDetails(discountCode, discountAmount) values('ABCXYZ', 100);
select * from T_XBBNHBS_DiscountDetails;