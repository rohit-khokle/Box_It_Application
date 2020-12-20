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
				currentSession.createQuery("from Workspace WHERE status != 'DELIVERED' AND status != 'DECLINED' "
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
				currentSession.createQuery("from Workspace WHERE status IN('DELIVERED','DECLINED') " 
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

	@Override
	public List<Workspace> getRestaurantWorkspaces(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE status NOT IN ('DECLINED', 'DELIVERED') AND restaurant_id=:res_id", 
						Workspace.class);
		theQuery.setParameter("res_id", id);
		List<Workspace> workspaces = theQuery.getResultList();
		return workspaces;
	}
	
	
	@Override
	public List<Workspace> getRestaurantWorkspacesHistory(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE status IN ('DECLINED', 'DELIVERED') AND restaurant_id=:res_id", 
						Workspace.class);
		theQuery.setParameter("res_id", id);
		List<Workspace> workspaces = theQuery.getResultList();
		return workspaces;
	}
	

	@Override
	public List<User> getChefs(Restaurant theRestaurant) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery =
				currentSession.createQuery("from User WHERE restaurantName=:name AND "
						+ "staffRole=:role", 
						User.class);
		theQuery.setParameter("name", theRestaurant.getName());
		theQuery.setParameter("role", "Chef");
			
	
		List<User> chefs = theQuery.getResultList();
		return chefs;
	}

	@Override
	public List<User> getDeliveryExecs(Restaurant theRestaurant) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery =
				currentSession.createQuery("from User WHERE restaurantName=:name "
						+ "AND staffRole=:role", 
						User.class);
		theQuery.setParameter("name", theRestaurant.getName());
		theQuery.setParameter("role","Delivery Executive");
		List<User> delivery_execs = theQuery.getResultList();
		return delivery_execs;
	}

	@Override
	public void assignToChef( Workspace theWorkspace, long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		theWorkspace.setAssigned_chef(id);
		theWorkspace.setStatus("ACCEPTED");
		currentSession.saveOrUpdate(theWorkspace);
	}

	@Override
	public void assignToDelivery( Workspace theWorkspace, long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		theWorkspace.setAssigned_delivery_exec(id);
		theWorkspace.setStatus("PICKED");
		currentSession.saveOrUpdate(theWorkspace);
		
	}

	@Override
	public void addStatusOnWorkspace(Workspace theWorkspace, String status) {
		Session currentSession = sessionFactory.getCurrentSession();
		theWorkspace.setStatus(status);
		currentSession.saveOrUpdate(theWorkspace);	
		
	}

	@Override
	public User getCustomer(long customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return (User)currentSession.get(User.class, customerId);
	}

	@Override
	public Workspace getWorkspace(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return (Workspace)currentSession.get(Workspace.class, theId);
	}

	@Override
	public List<Workspace> getChefWorkspaces(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE status IN ('ACCEPTED',  'PREP') AND assigned_chef=:userid "
						, 
						Workspace.class);
		theQuery.setParameter("userid", id);
		List<Workspace> workspaces = theQuery.getResultList();
		return workspaces;
	}
	
	
	@Override
	public List<Workspace> getDelWorkspaces(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE status IN ('BOXED-IT', 'PICKED', 'En Route') AND assigned_delivery_exec=:userid "
						, 
						Workspace.class);
		theQuery.setParameter("userid", id);
		List<Workspace> workspaces = theQuery.getResultList();
		return workspaces;
	}

	@Override
	public List<Workspace> getDeliveryHistoryWorkspace(Long id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE status IN ('DELIVERED') AND assigned_delivery_exec=:userid "
						, 
						Workspace.class);
		theQuery.setParameter("userid", id);
		List<Workspace> workspaces = theQuery.getResultList();
		return workspaces;
	}

	@Override
	public List<Workspace> getChefHistoryWorkspace(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE status IN ('DELIVERED') AND assigned_chef=:userid "
						, 
						Workspace.class);
		theQuery.setParameter("userid", id);
		List<Workspace> workspaces = theQuery.getResultList();
		return workspaces;
	}

	@Override
	public Workspace getCurrentOrder(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE "
						+ " customer_id=:cusid ORDER BY date DESC", 
						Workspace.class);
		theQuery.setParameter("cusid", user.getId());
		Workspace workspace = new Workspace();
		try {
			workspace = theQuery.getResultList().get(0);
		}
		catch(Exception e) {
			return workspace;
		}
		return workspace;
	}

	@Override
	public List<Workspace> getAllWorkspaceDetails() {
Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Workspace> theQuery =
				currentSession.createQuery("from Workspace WHERE status IN ('DELIVERED','DECLINED')", 
						Workspace.class);
		List<Workspace> workspaces = theQuery.getResultList();
		
		return workspaces;
	}

}
