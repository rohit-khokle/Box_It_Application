package com.info6250.packages.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "Restaurant")
@Table(name = "enterprise")
public class BoxItRestaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private int id;
	
	@Column(name = "store_name")
	private String name;
	
	@Column(name = "zip_code")
	private Long zipCode;
	
	@Column(name = "manager_username")
	private String manager;
	
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "revenue")
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
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
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
