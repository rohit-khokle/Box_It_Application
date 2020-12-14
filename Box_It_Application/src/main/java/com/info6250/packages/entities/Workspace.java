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
	private Integer id;
	
	@Column(name = "restaurant_id")
	private Integer restaurant_id;
	
	@Column(name = "customer_id")
	private Long customer_id;
	
	@Column(name = "total_value")
	private Double total_value;
	
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "assigned_chef")
	private Long assigned_chef;

	@Column(name = "assigned_delivery_exec")
	private Long assigned_delivery_exec;
	
	@Column(name= "restaurant_name")
	private String restaurantName;
	
	
	@Column(name= "workspace_response")
	private String workspaceResponse;
	
	
	@Column(name= "workspace_request")
	private String workspaceRequest;
	
	
	
	
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="workspace_id")
	private List<Cart_items> cartItems;

	public Workspace() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(Integer restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
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


	public Long getAssigned_chef() {
		return assigned_chef;
	}

	public void setAssigned_chef(Long assigned_chef) {
		this.assigned_chef = assigned_chef;
	}

	public Long getAssigned_delivery_exec() {
		return assigned_delivery_exec;
	}

	public void setAssigned_delivery_exec(Long assigned_delivery_exec) {
		this.assigned_delivery_exec = assigned_delivery_exec;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	
	
	
	public String getWorkspaceResponse() {
		return workspaceResponse;
	}

	public void setWorkspaceResponse(String workspaceResponse) {
		this.workspaceResponse = workspaceResponse;
	}

	public String getWorkspaceRequest() {
		return workspaceRequest;
	}

	public void setWorkspaceRequest(String workspaceRequest) {
		this.workspaceRequest = workspaceRequest;
	}

	@Override
	public String toString() {
		return "Workspace [id=" + id + ", restaurant_id=" + restaurant_id + ", customer_id=" + customer_id
				+ ", total_value=" + total_value + ", status=" + status + ", date=" + date + ", assigned_chef="
				+ assigned_chef + ", assigned_delivery_exec=" + assigned_delivery_exec + ", restaurantName="
				+ restaurantName + "]";
	}

	public List<Cart_items> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Cart_items> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	public void add(Cart_items selectedItem) {
		if(cartItems != null)
			addItemInCart(selectedItem);
		else
		{
			cartItems = new ArrayList<Cart_items>();
			addItemInCart(selectedItem);
			
		}
	}
	
	public void addItemInCart(Cart_items menu) {
		if(cartItems.contains(menu))
		{
			for(Cart_items tempMenu : cartItems) {
				if(tempMenu.equals(menu)) {
					int quantity = tempMenu.getQuantity();
					quantity++;
					Double price = tempMenu.getPrice()+menu.getPrice();
					menu.setPrice(price);
					menu.setQuantity(quantity);
					cartItems.remove(tempMenu);
					cartItems.add(menu);
					break;
				}
			}
			
		}
		else
		{
			menu.setQuantity(1);
			cartItems.add(menu);
		}
		
	
}

	public void removeFromCart(Cart_items convertIntoCartItems) {
		for(Cart_items tempMenu : cartItems) {
			if(tempMenu.equals(convertIntoCartItems)) {
				int quantity = tempMenu.getQuantity();
				if(quantity == 1) {
					cartItems.remove(tempMenu);
					break;
				}
				else {
					quantity--;
					Double price = convertIntoCartItems.getPrice();
					price = price * quantity;
					convertIntoCartItems.setPrice(price);
					convertIntoCartItems.setQuantity(quantity);
					cartItems.remove(tempMenu);					
					cartItems.add(convertIntoCartItems);
					break;
				}
			}
		}
	}

}
