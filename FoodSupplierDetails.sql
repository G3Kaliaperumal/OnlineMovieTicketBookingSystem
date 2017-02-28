create table T_XBBNHBS_FoodSupplierDetails(
foodType varchar(30),
foodSupplierName varchar(30),
price number)
insert into T_XBBNHBS_FoodSupplierDetails(foodType, foodSupplierName, price) values('Puff', 'Puffies', 100);
insert into T_XBBNHBS_FoodSupplierDetails(foodType, foodSupplierName, price) values('Pizza', 'DominasPizza', 150);
insert into T_XBBNHBS_FoodSupplierDetails(foodType, foodSupplierName, price) values('Popcorn', 'PopcornMania', 200);
select * from T_XBBNHBS_FoodSupplierDetails;