create table T_XBBNHBS_TheatreDetails(theatreId number primary key,
theatreName varchar(30),
fromTime timestamp,
toTime timestamp,
movieId number references T_XBBNHBS_Movie(movieId))
insert into T_XBBNHBS_TheatreDetails(theatreId, theatreName, fromTime, toTime, movieId) values(1, 'Raksha Theatre', TO_TIMESTAMP('2017-04-01 06:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2017-04-01 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);
insert into T_XBBNHBS_TheatreDetails(theatreId, theatreName, fromTime, toTime, movieId) values(2, 'Vetri Theatre', TO_TIMESTAMP('2017-04-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2017-04-01 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), 2);
select * from T_XBBNHBS_TheatreDetails;
