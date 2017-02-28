package com.inautix.XBBNHBS.MovieRate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBUtil.ConnectionManager;

public class MovieRateDao {

	public void setMovieRatings(MovieRateBean movieRater) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getDBConnection();
		PreparedStatement stmt = null;
		String query = "insert into T_XBBNHBS_Ratings(movieId, rating, movieRaterId) values(?, ?, ?)";
		try{
			stmt = con.prepareStatement(query);
			stmt.setInt(1, movieRater.getMovieId());
			stmt.setInt(2, movieRater.getMovieRate());
			stmt.setInt(3, movieRater.getMovieRaterId());
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

	public List<MovieRateBean> getRatings() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		List<MovieRateBean> list = new ArrayList<MovieRateBean>();
		Connection con = ConnectionManager.getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "Select * from T_XBBNHBS_Ratings";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				MovieRateBean movieRateBean = new MovieRateBean();
				movieRateBean.setMovieId(rs.getInt(1));
				movieRateBean.setMovieRate(rs.getInt(2));
				movieRateBean.setMovieRaterId(rs.getInt(3));		
				list.add(movieRateBean);
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

	public String getMovieRaterName(int movieRaterId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String movieRaterName = null;
		Connection con = ConnectionManager.getDBConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "Select movieRaterName from T_XBBNHBS_MovieRaterDetails where movieRaterId = ?";
		try{
			stmt = con.prepareStatement(query);
			stmt.setInt(1, movieRaterId);
			rs = stmt.executeQuery();
			while(rs.next()){
				movieRaterName = rs.getString(1);
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
		return movieRaterName;

   }
}
