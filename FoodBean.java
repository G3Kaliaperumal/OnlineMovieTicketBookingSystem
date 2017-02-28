package com.inautix.XBBNHBS.Food;

public class FoodBean {
	private String foodType;
	private double price;
	private String foodSupplierName;
	
	public FoodBean(){
		this.foodType = "";
		this.price = 0;
		this.setFoodSupplierName("");
	}
	public String getFoodType() {
		return foodType;
	}
	
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	public double getPrice() {
	    return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getFoodSupplierName() {
		return foodSupplierName;
	}
	
	public void setFoodSupplierName(String foodSupplierName) {
		this.foodSupplierName = foodSupplierName;
	}
	
}
