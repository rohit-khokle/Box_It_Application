package com.info6250.packages.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cart_items")
public class Cart_items {

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

	
	@Transient
	private String description;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "quantity")
	private int quantity;
	
	
	
	@ManyToOne(cascade= {
			CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH 
	})
	@JoinColumn(name="workspace_id")
	private Workspace workspace;
	
	
	
	
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

	
	
	
	
	


	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calories);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dish_category == null) ? 0 : dish_category.hashCode());
		result = prime * result + ((dish_name == null) ? 0 : dish_name.hashCode());
		result = prime * result + id;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		Cart_items other = (Cart_items) obj;

		if (dish_category == null) {
			if (other.dish_category != null)
				return false;
		} else if (!dish_category.equals(other.dish_category))
			return false;
		if (dish_name == null) {
			if (other.dish_name != null)
				return false;
		} else if (!dish_name.equals(other.dish_name))
			return false;


		return true;
	}

	public Cart_items() {}
}
