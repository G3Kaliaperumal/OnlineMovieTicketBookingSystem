package com.inautix.XBBNHBS.Ticket;

import com.inautix.XBBNHBS.Movie.MovieBean;

public interface iTicket {
	public void book(MovieBean movieBean, int noOfSeats, String discountCode) throws ClassNotFoundException;
	public void book(MovieBean movieBean, int noOfSeats);
	public void cancel(int ticketId) throws ClassNotFoundException;
	public void viewSummary() throws ClassNotFoundException;
	public double calculatingPrice(double amount, int discountAmount, int noOfSeats);
	public double calculatingPrice(double amount, int noOfSeats);
}
