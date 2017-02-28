package com.inautix.XBBNHBS.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inautix.XBBNHBS.Movie.MovieBean;
import com.inautix.XBBNHBS.Movie.MovieDao;
import com.inautix.XBBNHBS.TheatreDetails.TheatreDetailsDao;

import DBUtil.ConnectionManager;

public class TicketDao {
	public List<TicketBean> getTicketDetails() throws ClassNotFoundException{
		List<TicketBean> ticketDetails = new ArrayList<TicketBean>();
		Connection con = ConnectionManager.getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "Select * from T_XBBNHBS_Ticket";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				TicketBean ticketBean = new TicketBean();
				ticketBean.setTicketId(rs.getInt(1));
				ticketBean.setMovieName(rs.getString(2));
				ticketBean.setNoOfSeats(rs.getInt(3));
				ticketBean.setDiscount(rs.getString(4));
				ticketBean.setTotalPrice(rs.getInt(5));
				ticketBean.setTheatreId(rs.getInt(6));
				ticketBean.setViewerId(rs.getInt(7));
				ticketDetails.add(ticketBean);
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				con.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return ticketDetails;
	}
	
	public List<TicketBean> getTicketDetails(int ticketId) throws ClassNotFoundException{
		List<TicketBean> ticketDetails = new ArrayList<TicketBean>();
		Connection con = ConnectionManager.getDBConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "Select * from T_XBBNHBS_Ticket where ticketId = ?";
		try{
			stmt = con.prepareStatement(query);
			stmt.setInt(1, ticketId);
			rs = stmt.executeQuery();
			while(rs.next()){
				TicketBean ticketBean = new TicketBean();
				ticketBean.setTicketId(rs.getInt(1));
				ticketBean.setMovieName(rs.getString(2));
				ticketBean.setNoOfSeats(rs.getInt(3));
				ticketBean.setDiscount(rs.getString(4));
				ticketBean.setTotalPrice(rs.getInt(5));
				ticketBean.setTheatreId(rs.getInt(6));
				ticketBean.setViewerId(rs.getInt(7));
				ticketDetails.add(ticketBean);
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				con.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return ticketDetails;
	}

	public void insertValues(MovieBean movieBean, int noOfSeats, String discountCode) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		TheatreDetailsDao dao = new TheatreDetailsDao();
		Ticket ticket = new Ticket();
		MovieDao movieDao = new MovieDao();
		Connection con = ConnectionManager.getDBConnection();
		PreparedStatement stmt = null;
		String query = "insert into T_XBBNHBS_Ticket(ticketId, movieName, noOfSeats, discountCode, totalPrice, theatreId, viewerId) values(?, ?, ?, ?, ?, ?, ?)";
		try{
			int discountAmount = movieDao.getDiscountAmount(discountCode);
			int totalPrice = (int) ticket.calculatingPrice(movieBean.getAmount(), discountAmount, noOfSeats);
			int theatreId = dao.getTheatreId(movieBean.getMovieName());
			stmt =  con.prepareStatement(query);
			stmt.setInt(1, 2);
			stmt.setString(2, movieBean.getMovieName());
			stmt.setInt(3, noOfSeats);
			stmt.setString(4, discountCode); 
			stmt.setInt(5, totalPrice);
			stmt.setInt(6, theatreId);
			stmt.setInt(7, 5);
			stmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				con.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void cancel(int ticketId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		String query = "delete from T_XBBNHBS_Ticket where ticketId = ?";
		Connection con = ConnectionManager.getDBConnection();
		try{
			stmt = con.prepareStatement(query);
			stmt.setInt(1, ticketId);
			stmt.executeUpdate();
			System.out.println("Money will be refunded");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				con.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
