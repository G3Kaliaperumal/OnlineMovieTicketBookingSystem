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
