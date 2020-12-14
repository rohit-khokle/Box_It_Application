package com.info6250.packages.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Payment_Details;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.User_Address;
import com.info6250.packages.entities.Workspace;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer createWorkspace(Workspace workspace) {
		Session currentSession = sessionFactory.getCurrentSession();
		return (Integer) currentSession.save(workspace);

	}
	
	@Override
	public void updateWorkspace(Workspace workspace) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(workspace);

	}
	// addItems can be removed.
	
	@Override
	public void addItems(Workspace workspace) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		for(Cart_items myCart : workspace.getCartItems()) {	
//			currentSession.save(myCart);
//		}
	}

	@Override
	public User_Address getAddress(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User_Address> query = 
				currentSession.createQuery("from User_Address ua where ua.user_id=:id", User_Address.class);
		query.setParameter("id", user.getId());
		List<User_Address> address = query.getResultList();
		
		if(address.size() == 0)
			return new User_Address();
		
		return address.get(0);
		
		
	}

	@Override
	public Payment_Details getPaymentDetails(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Payment_Details> query = 
				currentSession.createQuery("from Payment_Details ua where ua.user_id=:id", Payment_Details.class);
		query.setParameter("id", user.getId());
		List<Payment_Details> payment = query.getResultList();
		if(payment.size() == 0)
			return new Payment_Details();
		return payment.get(0);
		
	}

	@Override
	public void addAddress(User_Address address) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(address);
	}

	@Override
	public void addPayment(Payment_Details payment) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(payment);
	}

	@Override
	@Transactional
	public void addToCart(List<Cart_items> cart_list) {
		Session currentSession = sessionFactory.getCurrentSession();
		for(Cart_items myCart :cart_list) {	
			currentSession.save(myCart);
		}
	}


}
