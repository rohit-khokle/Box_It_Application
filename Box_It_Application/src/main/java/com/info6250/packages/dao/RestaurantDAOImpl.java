package com.info6250.packages.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.entities.Restaurant;

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
//	@Transactional
	public List<Restaurant> getRestaurants() {
		
		// System.out.println("1 Control coming in the getRestaurants Method");
		
		
		// Get the current Hibernate Session
	//	Session currentSession = sessionFactory.getCurrentSession();
		Session currentSession = sessionFactory.openSession();
		
		
//		System.out.println("2. got currentSession");
		// Create a query
		Query<Restaurant> theQuery =
				currentSession.createQuery("from Restaurant ORDER BY store_name", 
						Restaurant.class);
	//	System.out.println("3. query object created");		
		// Execute query and get result list
		List<Restaurant> restaurants = theQuery.getResultList();
		System.out.println("got result");
		// Return the results		
		return restaurants;
	}



	@Override
	public void saveRestaurant(Restaurant theRestaurant) {
		Session currentSession = sessionFactory.openSession();	
		currentSession.save(theRestaurant);
	}

}
