package com.info6250.packages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.info6250.packages.dao.CustomerDAO;
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
	public void creatWorkspace(Workspace workspace) {
		customerDAO.createWorkspace(workspace);   
	}

	@Override
	@Transactional
	public void addItems(Workspace workspace) {
		customerDAO.addItems(workspace);  
		
	}

	@Override
	@Transactional
	public User_Address getAddress(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Payment_Details getPayment(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
