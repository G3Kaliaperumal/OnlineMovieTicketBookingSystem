package com.inautix.XBBNHBS.Ticket;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.inautix.XBBNHBS.Movie.MovieBean;
import com.inautix.XBBNHBS.Movie.MovieDao;

public class Ticket implements iTicket{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	@Override
	public void book(MovieBean movieBean, int noOfSeats, String discountCode) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		MovieDao dao = new MovieDao();
		int discountAmount = dao.getDiscountAmount(discountCode);
		double amount = movieBean.getAmount();
		Ticket ticket = new Ticket();
		double price = ticket.calculatingPrice(amount, discountAmount, noOfSeats);
		ticket.insertValues(movieBean, noOfSeats, discountCode);
		System.out.println("Movie Name:"+ movieBean.getMovieName());
		System.out.println("Number of Seats:"+ noOfSeats);
		System.out.println("Total Amount after deducting discount:"+price);
	}
	private void insertValues(MovieBean movieBean, int noOfSeats, String discountCode) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		TicketDao dao = new TicketDao();
		dao.insertValues(movieBean, noOfSeats, discountCode);
	}
	@Override
	public void book(MovieBean movieBean, int noOfSeats) {
		// TODO Auto-generated method stub
		double amount = movieBean.getAmount();
		Ticket ticket = new Ticket();
		double price = ticket.calculatingPrice(amount, noOfSeats);
		System.out.println("Movie Name:"+ movieBean.getMovieName());
		System.out.println("Number of Seats:"+ noOfSeats);
		System.out.println("Total Amount:"+price);
	}
	
	public double calculatingPrice(double amount, int noOfSeats) {
		// TODO Auto-generated method stub
		double price = 0.0;
		price = noOfSeats * amount;
		return price;
	}
	
    public double calculatingPrice(double amount, int discountAmount, int noOfSeats){
		double price = 0.0;
		price = (amount * noOfSeats) - discountAmount; 
		return price;
	}
    
	public void cancel(int ticketId) throws ClassNotFoundException{
		TicketDao dao = new TicketDao();
		dao.cancel(ticketId);
	}
	
	public void viewSummary() throws ClassNotFoundException{
		System.out.println("TicketID MovieName NoOfSeats DiscountCode FromTime ToTime ViewerId");
		TicketDao dao = new TicketDao();
		List<TicketBean> ticketDetails = dao.getTicketDetails();
		Iterator<TicketBean> iterator = ticketDetails.iterator();
		while(iterator.hasNext()){
			TicketBean ticketBean = iterator.next();
			System.out.println(ticketBean.getTicketId()+" "+ticketBean.getMovieName()+" "
			+ticketBean.getNoOfSeats()+" "+ticketBean.getDiscount()+" "
					+ticketBean.getTotalPrice()+" "+ticketBean.getTheatreId()+" "+ticketBean.getViewerId());
		}
		
	}
	
	
	
}
