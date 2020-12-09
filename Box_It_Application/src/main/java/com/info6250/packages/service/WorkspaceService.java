package com.info6250.packages.service;

import java.util.List;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.Workspace;


public interface WorkspaceService {
	
	// Get Current Workspaces -> Customer
	public List<Workspace> getCurrentOrders(User user);

	// Get All Workspaces -> Customer
	public List<Workspace> getAllOrders(User user);
	
	// Get Cart Items of the order
	public List<Cart_items> getMyCart(long workspaceId);

	public boolean checkValidity(Long id, int checkCartId);
	
	
	
}
