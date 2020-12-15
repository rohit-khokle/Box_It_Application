package com.info6250.packages.dao;

import java.util.List;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.Workspace;

public interface WorkspaceDAO {
	
	public List<Workspace> getCurrentOrders(long userid);
	public List<Workspace> getAllOrders(long userid);
	public List<Cart_items> getMyCart(long workspaceId);
	public boolean checkValidity(Long id, int checkCartId);
	public List<Workspace> getRestaurantWorkspaces(int id);
	public List<User> getChefs(Restaurant theRestaurant);
	public List<User> getDeliveryExecs(Restaurant theRestaurant);
	public void assignToChef(Workspace theWorkspace, long id);
	public void assignToDelivery(Workspace theWorkspace, long id );
	public void addStatusOnWorkspace(Workspace theWorkspace, String status);
	public User getCustomer(long customerId);
	public Workspace getWorkspace(int theId);
	public List<Workspace> getRestaurantWorkspacesHistory(int id);
	public List<Workspace> getChefWorkspaces(Long id);
	public List<Workspace> getDelWorkspaces(Long id);
	public List<Workspace> getDeliveryHistoryWorkspace(Long id);
	public List<Workspace> getChefHistoryWorkspace(Long id);
	public Workspace getCurrentOrder(User user);
	
}
