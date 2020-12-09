package com.info6250.packages.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.Workspace;


@Repository
public class WorkspaceDAOImpl implements WorkspaceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Workspace> getCurrentOrders(long userid) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE status != 'DELIVERED' "
						+ "AND customer_id=:cusid", 
						Workspace.class);
		theQuery.setParameter("cusid", userid);
		List<Workspace> workspace = theQuery.getResultList();
		System.out.println("getCurrentOrder  = "+workspace);
		return workspace;
	}

	@Override
	public List<Workspace> getAllOrders(long userid) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE status = 'DELIVERED' " 
						+ "AND customer_id=:cusid", 
						Workspace.class);
		theQuery.setParameter("cusid", userid);
		List<Workspace> workspace = theQuery.getResultList();
		return workspace;
	}

	@Override
	public List<Cart_items> getMyCart(long workspaceId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Cart_items> theQuery =
				currentSession.createQuery("from Cart_items WHERE workspace_id=:workid", 
						Cart_items.class);
		theQuery.setParameter("workid", workspaceId);
		List<Cart_items> workspace = theQuery.getResultList();

		return workspace;
	}

	@Override
	public boolean checkValidity(Long id, int checkCartId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE id=:workid "
						+ "AND customer_id=:cusid", 
						Workspace.class);
		theQuery.setParameter("workid", checkCartId);
		theQuery.setParameter("cusid", id);
		List<Workspace> workspace = theQuery.getResultList();
		if(workspace.size() == 0)
			return false;
		else
			return true;
	}
}
