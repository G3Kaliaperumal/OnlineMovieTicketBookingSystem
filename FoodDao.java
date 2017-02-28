package com.inautix.XBBNHBS.Food;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBUtil.ConnectionManager;

public class FoodDao {
	public double getPrice(FoodBean fb) throws ClassNotFoundException{
		double price = 0;
		PreparedStatement stmt = null;
		Connection con= ConnectionManager.getDBConnection();
		ResultSet rs=null;
		String query="SELECT price FROM T_XBBNHBS_FoodSupplierDetails where foodType = ? ";
		try{
			stmt = con.prepareStatement(query);
			stmt.setString(1, fb.getFoodType());
			rs = stmt.executeQuery();
			while(rs.next()){
				price = rs.getInt(1);
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
		return price;
	}
	
	public List<FoodBean> listFoodTypes() throws ClassNotFoundException{
		Statement stmt = null;
		Connection con = ConnectionManager.getDBConnection();
		List<FoodBean> foodList = new ArrayList<FoodBean>();
		ResultSet rs = null;
		String query = "SELECT * FROM T_XBBNHBS_FoodSupplierDetails";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				FoodBean foodBean = new FoodBean();
				foodBean.setFoodType(rs.getString(1));
				foodBean.setFoodSupplierName(rs.getString(2));
				foodBean.setPrice(rs.getInt(3));
				foodList.add(foodBean);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
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
		return foodList;
	}
	public String getFoodSupplier(FoodBean fb) throws ClassNotFoundException{
		String foodSupplier = null;
		PreparedStatement stmt = null;
		Connection con= ConnectionManager.getDBConnection();
		ResultSet rs=null;
		String query="SELECT foodSupplierName FROM T_XBBNHBS_FoodSupplierDetails where foodType = ? ";
		try{
			stmt = con.prepareStatement(query);
			stmt.setString(1, fb.getFoodType());
			rs = stmt.executeQuery();
			while(rs.next()){
				foodSupplier = rs.getString(1);
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
		return foodSupplier;
	}
}
