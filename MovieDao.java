package com.inautix.XBBNHBS.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBUtil.ConnectionManager;

public class MovieDao {

	public List<MovieBean> getAvailableMovies() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		List<MovieBean> moviesList = new ArrayList<MovieBean>();
		Connection con = ConnectionManager.getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "Select * from T_XBBNHBS_Movie";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				MovieBean movieBean = new MovieBean();
				movieBean.setMovieId(rs.getInt(1));
				movieBean.setMovieName(rs.getString(2));
				moviesList.add(movieBean);
				
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
		return moviesList;
	}

	public List<MovieBean> displayTicketTypeDetails() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getDBConnection();
		List<MovieBean> list = new ArrayList<MovieBean>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "Select * from T_XBBNHBS_TicketTypeDetails";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				MovieBean movie = new MovieBean();
				movie.setTypeOfTicket(rs.getString(1));
				movie.setAmount(rs.getInt(2));
				list.add(movie);
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
		return list;
	}

	public String getMovieName(int movieId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String movieName = "";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = ConnectionManager.getDBConnection();
		String query = "Select movieName from T_XBBNHBS_Movie where movieId = ?";
		try{
			stmt=con.prepareStatement(query);
			stmt.setInt(1, movieId);
			rs = stmt.executeQuery();
			while(rs.next()){
				movieName = rs.getString(1);
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
		return movieName;
	}

	public int getAmount(String ticketType) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int amount = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = ConnectionManager.getDBConnection();
		String query = "Select amount from T_XBBNHBS_TicketTypeDetails where ticketType = ?";
		try{
			stmt=con.prepareStatement(query);
			stmt.setString(1, ticketType);
			rs = stmt.executeQuery();
			while(rs.next()){
				amount = rs.getInt(1);
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
		return amount;
	}

	public int getDiscountAmount(String discountCode) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int discountAmount = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = ConnectionManager.getDBConnection();
		String query = "Select discountAmount from T_XBBNHBS_DiscountDetails where discountCode = ?";
		try{
			stmt=con.prepareStatement(query);
			stmt.setString(1, discountCode);
			rs = stmt.executeQuery();
			while(rs.next()){
				discountAmount = rs.getInt(1);
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
		return discountAmount;
	}

	public int getMovieId(String movieName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int movieId = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = ConnectionManager.getDBConnection();
		String query = "Select movieId from T_XBBNHBS_Movie where movieName = ?";
		try{
			stmt=con.prepareStatement(query);
			stmt.setString(1, movieName);
			rs = stmt.executeQuery();
			while(rs.next()){
				movieId = rs.getInt(1);
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
		return movieId;
	}

}
