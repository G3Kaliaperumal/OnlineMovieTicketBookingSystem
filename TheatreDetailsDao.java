package com.inautix.XBBNHBS.TheatreDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inautix.XBBNHBS.Movie.Movie;

import DBUtil.ConnectionManager;

public class TheatreDetailsDao {

	public List<TheatreDetailsBean> getTheatreDetails(int movieId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		List<TheatreDetailsBean> theatresList = new ArrayList<TheatreDetailsBean>();
		Connection con = ConnectionManager.getDBConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "Select * from T_XBBNHBS_TheatreDetails where movieId = ?";
		try{
			stmt= con.prepareStatement(query);
			stmt.setInt(1, movieId);
			rs = stmt.executeQuery();
			while(rs.next()){
				TheatreDetailsBean theatre = new TheatreDetailsBean();
				theatre.setTheatreId(rs.getInt(1));
				theatre.setTheatreName(rs.getString(2));
				theatresList.add(theatre);
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
		return theatresList;
	}

	public Date getFromTime(String movieName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Date fromTime = null;
		Movie movie = new Movie();
		Connection con = ConnectionManager.getDBConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "Select fromTime from T_XBBNHBS_TheatreDetails where movieId = ?";
		try{
			stmt= con.prepareStatement(query);
			stmt.setInt(1, movie.getMovieId(movieName));
			rs = stmt.executeQuery(query);
			while(rs.next()){
				fromTime = rs.getDate(1);
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
		return fromTime;
	}

	public Date getEndTime(String movieName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Date endTime = null;
		Movie movie = new Movie();
		Connection con = ConnectionManager.getDBConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "Select toTime from T_XBBNHBS_TheatreDetails where movieId = ?";
		try{
			stmt= con.prepareStatement(query);
			stmt.setInt(1, movie.getMovieId(movieName));
			rs = stmt.executeQuery(query);
			while(rs.next()){
				endTime = rs.getDate(1);
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
		return endTime;
	}

	public int getTheatreId(String movieName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int theatreId = 0;
		Movie movie = new Movie();
		Connection con = ConnectionManager.getDBConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "Select theatreId from T_XBBNHBS_TheatreDetails where movieId = ?";
		try{
			stmt= con.prepareStatement(query);
			stmt.setInt(1, movie.getMovieId(movieName));
			rs = stmt.executeQuery();
			while(rs.next()){
				theatreId = rs.getInt(1);
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
		return theatreId;
	}

}
