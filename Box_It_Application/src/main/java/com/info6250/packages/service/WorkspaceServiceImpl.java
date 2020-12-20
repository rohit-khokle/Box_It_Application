package com.info6250.packages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.dao.WorkspaceDAO;
import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.Workspace;

/**
 * @author Rohit
 *
 */
@Service 
public class WorkspaceServiceImpl implements WorkspaceService {

	@Autowired
	WorkspaceDAO workspaceDAO;
	
	
	@Override
	@Transactional
	public List<Workspace> getCurrentOrders(User user) {
		long id = user.getId();
		return workspaceDAO.getCurrentOrders(id);
	}

	
	
	@Override
	@Transactional
	public List<Workspace> getAllOrders(User user) {
		long id = user.getId();
		return workspaceDAO.getAllOrders(id);
	}



	@Override
	@Transactional
	public List<Cart_items> getMyCart(long workspaceId) {
		return workspaceDAO.getMyCart(workspaceId);
	}



	@Override
	@Transactional
	public boolean checkValidity(Long id, int checkCartId) {
		return workspaceDAO.checkValidity(id, checkCartId);
	}



	@Override
	@Transactional
	public List<Workspace> getRestaurantWorkspaces(Restaurant theRestaurant) {
		int id = theRestaurant.getId();
		return workspaceDAO.getRestaurantWorkspaces(id);
	}



	@Override
	@Transactional
	public List<User> getChefs(Restaurant theRestaurant) {
		return workspaceDAO.getChefs(theRestaurant);
	}



	@Override
	@Transactional
	public List<User> getDeliveryExecs(Restaurant theRestaurant) {
		return workspaceDAO.getDeliveryExecs(theRestaurant);
	}



	@Override
	@Transactional
	public void assignToChef(Workspace theWorkspace, long id) {
		workspaceDAO.assignToChef( theWorkspace, id);	
	}



	@Override
	@Transactional
	public void assignToDelivery(Workspace theWorkspace, long id) {
			workspaceDAO.assignToDelivery(theWorkspace, id);	
	}



	@Override
	@Transactional
	public void addStatusOnWorkspace(Workspace theWorkspace, String status) {
		workspaceDAO.addStatusOnWorkspace(theWorkspace,status);
	}



	@Override
	@Transactional
	public User getCustomerDetails(long customerId) {
		return workspaceDAO.getCustomer(customerId);
		
	}


	@Override
	@Transactional
	public Workspace getWorkspace(int theId) {
		return  workspaceDAO.getWorkspace(theId);
	}



	@Override
	@Transactional
	public List<Workspace> getRestaurantWorkspacesHistory(Restaurant restaurant) {
		int id = restaurant.getId();
		return  workspaceDAO.getRestaurantWorkspacesHistory(id);
		}



	@Override
	@Transactional
	public List<Workspace> getChefWorkspaces(Long id) {
		return workspaceDAO.getChefWorkspaces(id);
	}


	@Override
	@Transactional
	public List<Workspace> getDelWorkspaces(Long id) {
		return workspaceDAO.getDelWorkspaces(id);
	}



	@Override
	@Transactional
	public List<Workspace> getDeliveryHistoryWorkspace(Long id) {
		return workspaceDAO.getDeliveryHistoryWorkspace(id);
	}



	@Override
	@Transactional
	public List<Workspace> getChefHistoryWorkspace(Long id) {
		return workspaceDAO.getChefHistoryWorkspace(id);
	}



	@Override
	@Transactional
	public Workspace getCurrentOrder(User user) {
		return workspaceDAO.getCurrentOrder(user);
	}



	@Override
	@Transactional
	public List<Workspace> getAllWorkspaceDetails() {
		return workspaceDAO.getAllWorkspaceDetails();
	}



	
	
}
