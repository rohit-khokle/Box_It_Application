package com.info6250.packages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.info6250.packages.dao.CustomerDAO;
import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Payment_Details;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.User_Address;
import com.info6250.packages.entities.Workspace;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public Integer createWorkspace(Workspace workspace) {
		return customerDAO.createWorkspace(workspace);   
	}

	@Override
	@Transactional
	public void addItems(Workspace workspace) {
		customerDAO.addItems(workspace);  
		
	}

	@Override
	@Transactional
	public User_Address getAddress(User user) {
		return customerDAO.getAddress(user);
	}

	@Override
	@Transactional
	public Payment_Details getPayment(User user) {
		return customerDAO.getPaymentDetails(user);
	}

	@Override
	@Transactional
	public void addAddress(User_Address address) {
		customerDAO.addAddress(address);
		
	}

	@Override
	@Transactional
	public void addPayment(Payment_Details payment) {
		customerDAO.addPayment(payment);
	}

	@Override
	@Transactional
	public void addToCart(List<Cart_items> cart_list) {
		customerDAO.addToCart(cart_list);
		
	}
	

	
	
	
	
	
	
	
	
}
