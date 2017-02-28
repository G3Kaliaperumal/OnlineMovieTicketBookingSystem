create table T_XBBNHBS_Ratings (movieId number references T_XBBNHBS_Movie(movieId),
rating number,
movieRaterId number references T_XBBNHBS_MovieRaterDetails(movieRaterId));
insert into T_XBBNHBS_Ratings(movieId, rating, movieRaterId) values(1, 4, 1);
insert into T_XBBNHBS_Ratings(movieId, rating, movieRaterId) values(2, 3, 1);
select * from T_XBBNHBS_Ratings