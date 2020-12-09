package com.info6250.packages.dao;

import java.util.List;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Workspace;

public interface WorkspaceDAO {
	
	public List<Workspace> getCurrentOrders(long userid);
	public List<Workspace> getAllOrders(long userid);
	public List<Cart_items> getMyCart(long workspaceId);
	public boolean checkValidity(Long id, int checkCartId);
	
	
	

}
