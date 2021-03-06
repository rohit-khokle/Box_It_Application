package com.info6250.packages.entities;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



public class MyCart {
	
	private List<Menu> myItems;
	
	private int quantity;
	
	private double total_value;

	public List<Menu> getMyItems() {
		return myItems;
	}
	public void setMyItems(List<Menu> myItems) {
		this.myItems = myItems;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MyCart() { 
		this.myItems = new ArrayList<Menu>();
		}
	
	public double getTotal_value() {
		return total_value;
	}
	public void setTotal_value(double total_value) {
		this.total_value = total_value;
	}
	
	
	
	public void addItemInCart(Menu menu) {
			if(myItems.contains(menu))
			{
				for(Menu tempMenu : myItems) {
					if(tempMenu.equals(menu)) {
						int quantity = tempMenu.getQuantity();
						quantity++;
						Double price = tempMenu.getPrice()+menu.getPrice();
						menu.setPrice(price);
						menu.setQuantity(quantity);
						myItems.remove(tempMenu);
						myItems.add(menu);
						break;
					}
				}
				
			}
			else
			{
				menu.setQuantity(1);
				myItems.add(menu);
			}
			
		
	}
	
	
	public void removeFromCart(Menu selectedItem) {
		
		for(Menu tempMenu : myItems) {
			if(tempMenu.equals(selectedItem)) {
				int quantity = tempMenu.getQuantity();
				if(quantity == 1) {
					myItems.remove(tempMenu);
					break;
				}
				else {
					quantity--;
					Double price = selectedItem.getPrice();
					price = price * quantity;
					selectedItem.setPrice(price);
					selectedItem.setQuantity(quantity);
					myItems.remove(tempMenu);					
					myItems.add(selectedItem);
					break;
				}
			}
		}
		
	}
	@Override
	public String toString() {
		return "MyCart [myItems=" + myItems + ", quantity=" + quantity + ", total_value=" + total_value + "]";
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	

