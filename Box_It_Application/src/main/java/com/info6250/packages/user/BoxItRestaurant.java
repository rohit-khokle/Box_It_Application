package com.info6250.packages.user;


import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class BoxItRestaurant {


	private int id;
	
	@NotNull(message = "is required")
	private String name;
	
	@NotNull(message = "is required")
	@Pattern(regexp = "^^\\d{5}$", message="Must be five digit")
	private String zipCode;
	

	@NotNull(message = "is required")
	private String manager;
	

	@NotNull(message = "is required")	
	private String address;
	

	private Double revenue;
	
	
	@Transient
	private Long ordersServed;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	
	
	
	
	
	public Long getOrdersServed() {
		return ordersServed;
	}
	public void setOrdersServed(Long ordersServed) {
		this.ordersServed = ordersServed;
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", zipCode=" + zipCode + ", manager=" + manager + "]";
	}
	
	
	
	
	public BoxItRestaurant() {

	}

	
	
	
	
	
	
	
	
	
}
