package com.info6250.packages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.dao.WorkspaceDAO;
import com.info6250.packages.entities.Cart_items;
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

	
	
	
}
