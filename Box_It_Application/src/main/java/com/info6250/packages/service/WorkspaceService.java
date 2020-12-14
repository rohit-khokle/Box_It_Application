package com.info6250.packages.service;

import java.util.List;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.Workspace;


public interface WorkspaceService {
	
	// Get Current Workspaces -> Customer
	public List<Workspace> getCurrentOrders(User user);

	// Get All Workspaces -> Customer
	public List<Workspace> getAllOrders(User user);
	
	// Get Cart Items of the order
	public List<Cart_items> getMyCart(long workspaceId);
	
	// Check illegal access to the order
	public boolean checkValidity(Long id, int checkCartId);
	
	// Get Restaurant Specific workspaces
	public List<Workspace> getRestaurantWorkspaces(Restaurant theRestaurant);
	
	// Get List of Chef in the restaurant
	public List<User> getChefs(Restaurant theRestaurant);
	
	// Get List of Delivery in the restaurant
	public List<User> getDeliveryExecs(Restaurant theRestaurant);
	
	// Assign workspace to Chef
	public void assignToChef(Workspace theWorkspace, long id);
	
	// Assign workspace to Delivery 
	public void assignToDelivery(Workspace theWorkspace, long id);
	
	// Update status on workspace
	public void addStatusOnWorkspace(Workspace theWorkspace, String status);
	
	// Get Customer Details and Address
	public User getCustomerDetails(long customerId);

	public Workspace getWorkspace(int theId);

	public List<Workspace> getRestaurantWorkspacesHistory(Restaurant restaurant);

	// public List<Workspace> getMyWorkspaces(Long id);

	public List<Workspace> getChefWorkspaces(Long id);
	public List<Workspace> getDelWorkspaces(Long id);

	public List<Workspace> getDeliveryHistoryWorkspace(Long id);

	
	
}
