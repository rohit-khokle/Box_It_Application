package com.info6250.packages.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "workspace")
public class Workspace {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "restaurant_id")
	private int restaurant_id;
	
	@Column(name = "customer_id")
	private long customer_id;
	
	@Column(name = "total_value")
	private Double total_value;
	
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "assigned_user")
	private long assigned_user;
	
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="workspace_id")
	private List<Cart_items> cartItems;

	public Workspace() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public Double getTotal_value() {
		return total_value;
	}

	public void setTotal_value(Double total_value) {
		this.total_value = total_value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getAssigned_user() {
		return assigned_user;
	}

	public void setAssigned_user(long assigned_user) {
		this.assigned_user = assigned_user;
	}

	@Override
	public String toString() {
		return "Workspace [id=" + id + ", restaurant_id=" + restaurant_id + ", customer_id=" + customer_id
				+ ", total_value=" + total_value + ", status=" + status + ", date=" + date + ", assigned_user="
				+ assigned_user + "]";
	}

	public List<Cart_items> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Cart_items> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	public void add(Cart_items tempMenu) {
		
		if(cartItems == null) {
			cartItems = new ArrayList<Cart_items>();
		}
		cartItems.add(tempMenu);
		
	//	tempMenu.setWorkspace(this);		
	}

}
