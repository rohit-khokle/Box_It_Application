package com.info6250.packages.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Workspace;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	@Override
	@Transactional
	public void createWorkspace(Workspace workspace) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(workspace);
	//a	addItems(workspace);
	}




	@Override
	public void addItems(Workspace workspace) {
		Session currentSession = sessionFactory.getCurrentSession();
		for(Cart_items myCart : workspace.getCartItems()) {	
			currentSession.save(myCart);
		}
		System.out.println("END");
	}

	
	
	
	
	
	
}
