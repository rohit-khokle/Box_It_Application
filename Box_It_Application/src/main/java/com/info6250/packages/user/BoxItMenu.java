package com.info6250.packages.user;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



public class BoxItMenu {

	private int id;

	@NotNull(message = "is required")
	private String dish_name;
	
	@NotNull(message = "is required")
	private String dish_category;
	
	@NotNull(message = "is required")
	@Pattern(regexp = "\\d+\\.?\\d*", message="Please enter valid input")
	private  String price;
	
	@NotNull(message = "is required")
	@Pattern(regexp = "\\d+\\.?\\d*", message="Please enter valid input")
	private String calories;

	

	private String description;

	private String remarks;


	private int quantity;
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public String getDish_category() {
		return dish_category;
	}

	public void setDish_category(String dish_category) {
		this.dish_category = dish_category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Menu [dish_name=" + dish_name + ", dish_category=" + dish_category + ", price=" + price
				+ ",  quantity="
				+ quantity + "]";
	}

	

	public BoxItMenu() {}


}
