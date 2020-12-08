package com.info6250.packages.service;

import java.util.List;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Payment_Details;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.User_Address;
import com.info6250.packages.entities.Workspace;

public interface CustomerService {

	Integer createWorkspace(Workspace workspace);
	void addItems(Workspace workspace);
	User_Address  getAddress(User user);
	Payment_Details getPayment(User user);
	void addAddress(User_Address address);
	void addPayment(Payment_Details payment);
	void addToCart(List<Cart_items> cart_list);

}
