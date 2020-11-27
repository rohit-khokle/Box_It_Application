package com.info6250.packages.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dish_id")
	private int id;

	@Column(name = "dish_name")
	private String dish_name;
	
	@Column(name = "dish_category")
	private String dish_category;
	
	@Column(name = "dish_price")
	private  double price;
	
	@Column(name = "dish_calories")
	private double calories;

	
	@Column(name = "dish_desc")
	private String description;

	
	
	@Column(name = "remarks")
	private String remarks;

	
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
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

	@Override
	public String toString() { return "Menu [id=" + id + ", dish_name=" + dish_name + ", dish_category=" + dish_category + ", price=" + price
				+ ", calories=" + calories + "]"; }

	public Menu() {}
}
