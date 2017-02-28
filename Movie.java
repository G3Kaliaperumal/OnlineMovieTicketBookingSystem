package com.inautix.XBBNHBS.Movie;

import java.util.Iterator;
import java.util.List;

public class Movie {
	public void getAvailableMovies() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("MovieId MovieName");
		MovieDao dao = new MovieDao();
		List<MovieBean> moviesList = dao.getAvailableMovies();
		Iterator<MovieBean> iterator = moviesList.iterator();
		while(iterator.hasNext()){
			MovieBean movie = iterator.next();
			System.out.println(movie.getMovieId()+" "+movie.getMovieName());
		}
	}

	public void getClassDetails() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("TypeOfTicket Amount");
		MovieDao dao = new MovieDao();
		List<MovieBean> list = dao.displayTicketTypeDetails();
		Iterator<MovieBean> iterator = list.iterator();
		while(iterator.hasNext()){
			MovieBean movie = iterator.next();
			System.out.println(movie.getTypeOfTicket()+" "+movie.getAmount());
		}
	}

	public String getMovieName(int movieId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		MovieDao dao = new MovieDao();
		String movieName = dao.getMovieName(movieId);
		return movieName;
	}

	public int getAmount(String typeOfTicket) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		MovieDao dao = new MovieDao();
		int amount = dao.getAmount(typeOfTicket);
		return amount;
	}
	
	public int getMovieId(String movieName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		MovieDao dao = new MovieDao();
		int movieId = dao.getMovieId(movieName);
		return movieId;
	}

}
