package com.inautix.XBBNHBS.Ticket;

import java.sql.SQLException;
import java.util.Scanner;

import com.inautix.XBBNHBS.Food.Food;
import com.inautix.XBBNHBS.Food.FoodBean;
import com.inautix.XBBNHBS.Movie.Movie;
import com.inautix.XBBNHBS.Movie.MovieBean;
import com.inautix.XBBNHBS.MovieRate.MovieRate;
import com.inautix.XBBNHBS.MovieRate.MovieRateBean;
import com.inautix.XBBNHBS.TheatreDetails.TheatreDetails;

public class TicketApp {
	public static void main(String args[]) throws SQLException, ClassNotFoundException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Online Movie Ticket Booking System");
		System.out.println("Enter your choice:");
		System.out.println("1. Book Movie Ticket  2. View Ticket Details 3.Rate the Movie 4.View Movie Ratings 5.CancelTicket");
		int choice = scan.nextInt();
		switch(choice){
		case 1:
			System.out.println("Latest New Movies in Theatres:");
			Ticket ticket = new Ticket();
			Movie movie = new Movie();
			TheatreDetails theatre = new TheatreDetails();
			movie.getAvailableMovies();
			MovieBean movieBean = new MovieBean();
			System.out.println("Enter the movieId of the movie that you want to watch");
			int movieId = scan.nextInt();
			movieBean.setMovieId(movieId);
			String movieName = movie.getMovieName(movieId);
			movieBean.setMovieName(movieName);
			System.out.println("Enter the number of seats that you want to book:");
			int noOfSeats = scan.nextInt();
			movie.getClassDetails();
			System.out.println("Enter the class:(Select from the available options)");
			String typeOfTicket = scan.next();
			movieBean.setTypeOfTicket(typeOfTicket);
			int amount = movie.getAmount(typeOfTicket);
			movieBean.setAmount(amount);
			theatre.displayTheatreDetails(movieId);
			System.out.println("Do you have a discount code:(yes/no)");
			String input = scan.next();
			if(input.equals("yes")){
				System.out.println("Enter the discount code");
				String discountCode = scan.next();
				ticket.book(movieBean, noOfSeats, discountCode);
			}
			else{
				ticket.book(movieBean, noOfSeats);
			}
			System.out.println("Movie Ticket Booked Successfully");
			System.out.println("Do you want to order food?(yes/no)");
			input = scan.next();
			if(input.equals("yes")){
				Food food=new Food();
				FoodBean foodBean = new FoodBean();
				System.out.println("Available food types are:");
				food.listFoodTypes();
				System.out.println("Enter food type");
				foodBean.setFoodType(scan.next());
				System.out.println("Enter quantity");
				int quantity = scan.nextInt();
				String foodSupplier = food.getFoodSupplier(foodBean);
				foodBean.setFoodSupplierName(foodSupplier);
				double price = food.calculatingPrice(foodBean,quantity);
				foodBean.setPrice(price);
				food.display(foodBean, quantity);
			}
			break;
		case 2:
			Ticket ticket1 = new Ticket();
			ticket1.viewSummary();
			break;
		case 3:
			MovieRateBean movieRater = new MovieRateBean();
			MovieRate movieRating = new MovieRate();
			System.out.println("Enter the movieRater Id");
			movieRater.setMovieRaterId(scan.nextInt());
			System.out.println("Enter the movie Id");
			movieRater.setMovieId(scan.nextInt());
			System.out.println("What is the rating (maximum - 5 and minimun - 1)that you would like to give for the movie ?");
			movieRater.setMovieRate(scan.nextInt());
			movieRating.setMovieRatings(movieRater);
			System.out.println("Ratings are successfully updated");
			break;
		case 4:
			MovieRate movieRating1 = new MovieRate();
			movieRating1.getRatings();
			break;
		case 5:
			Ticket ticket2 = new Ticket();
			System.out.println("Enter ticketID");
			int ticketId = scan.nextInt();
			ticket2.cancel(ticketId);
			System.out.println("Ticket successfully cancelled");
			break;
		default:
			System.out.println("Invalid Choice");
		}
		scan.close();
	}
}
