package com.inautix.XBBNHBS.MovieRate;

import java.util.Iterator;
import java.util.List;

import com.inautix.XBBNHBS.Movie.MovieDao;

public class MovieRate {

	public void setMovieRatings(MovieRateBean movieRater) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		MovieRateDao dao = new MovieRateDao();
		dao.setMovieRatings(movieRater);
	}

	public void getRatings() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		MovieRateDao dao = new MovieRateDao();
		MovieDao movieDao = new MovieDao();
		System.out.println("MovieRaterName MovieName Rate");
		List<MovieRateBean> ratingsDetails = dao.getRatings();
		Iterator<MovieRateBean> iterator = ratingsDetails.iterator();
		while(iterator.hasNext()){
			MovieRateBean movieRateBean = iterator.next();
			String movieRaterName = dao.getMovieRaterName(movieRateBean.getMovieRaterId());
			String movieName = movieDao.getMovieName(movieRateBean.getMovieId());
			System.out.println(movieRaterName+" "+movieName+" "+movieRateBean.getMovieRate());
			
		}
	}

}
