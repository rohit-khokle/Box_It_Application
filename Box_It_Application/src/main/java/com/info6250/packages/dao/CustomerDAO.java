package com.info6250.packages.dao;

import java.util.List;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Payment_Details;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.User_Address;
import com.info6250.packages.entities.Workspace;

public interface CustomerDAO {

	Integer createWorkspace(Workspace workspace);
	void addItems(Workspace workspace);
	User_Address getAddress(User user);
	Payment_Details getPaymentDetails(User user);

	void addAddress(User_Address address);
	void addPayment(Payment_Details payment);
	void addToCart(List<Cart_items> cart_list);
	void updateWorkspace(Workspace workspace);
}
