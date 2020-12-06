package com.info6250.packages.dao;

import com.info6250.packages.entities.Payment_Details;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.User_Address;
import com.info6250.packages.entities.Workspace;

public interface CustomerDAO {

	void createWorkspace(Workspace workspace);
	void addItems(Workspace workspace);
	User_Address getAddress(User user);
	Payment_Details getPaymentDetails(User user);

	void addAddress(User_Address address);
	void addPayment(Payment_Details payment);

}
