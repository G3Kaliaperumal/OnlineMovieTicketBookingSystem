package com.inautix.XBBNHBS.Food;

import java.util.Iterator;
import java.util.List;
import java.sql.SQLException;

public class Food {
	public double calculatingPrice(FoodBean food, int quantity) throws SQLException, ClassNotFoundException{
		double price = 0;
		FoodDao dao = new FoodDao();
		price = dao.getPrice(food) * quantity;
		return price; 
	}
	
	public void display(FoodBean food, int quantity){
		System.out.println("Your Food Order is:");
		System.out.println("Food Type:"+food.getFoodType());
		System.out.println("Food Supplier Name:"+food.getFoodSupplierName());
		System.out.println("Food Quantity:"+ quantity);
		System.out.println("Total Price:"+food.getPrice());
        System.out.println("Pay the amount after the food is delivered to you");
	}
	
	public void listFoodTypes() throws ClassNotFoundException{
		FoodDao dao = new FoodDao();
		List<FoodBean> list = dao.listFoodTypes();
		Iterator<FoodBean> iterator = list.iterator();
		System.out.println("FoodType FoodSupplierName Cost");
		while(iterator.hasNext()){
			FoodBean foodBean = iterator.next();
			System.out.println(foodBean.getFoodType()+" "+foodBean.getFoodSupplierName()+" "+foodBean.getPrice());
		}
	}

	public String getFoodSupplier(FoodBean foodBean) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		FoodDao dao = new FoodDao();
		String foodSupplier = dao.getFoodSupplier(foodBean);
		return foodSupplier;
	}
}
