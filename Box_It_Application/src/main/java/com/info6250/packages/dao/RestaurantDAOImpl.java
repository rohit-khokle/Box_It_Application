package com.info6250.packages.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
//	@Transactional
	public List<Restaurant> getRestaurants() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Restaurant> theQuery =
				currentSession.createQuery("from Restaurant ORDER BY store_name", 
						Restaurant.class);
		List<Restaurant> restaurants = theQuery.getResultList();
		System.out.println("got result");
		return restaurants;
	}

	@Override
//	@Transactional
	public List<User> getAllStaff() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		SQLQuery<User> theQuery =
				currentSession.createSQLQuery("SELECT * FROM USER WHERE restaurant_name IS NOT NULL ORDER BY restaurant_name");

		theQuery.addEntity(User.class);
//				currentSession.createQuery("from User u WHERE u.restaurantName IS NOT :temp", 
//						User.class);
	//	theQuery.setParameter("temp", null);
		List<User> users = theQuery.getResultList();
		System.out.println("got result");
		return users;
	}



	@Override
	public void saveRestaurant(Restaurant theRestaurant) {
		Session currentSession = sessionFactory.getCurrentSession();	
		if(theRestaurant.getId() ==  0)
			currentSession.save(theRestaurant);
		else
			currentSession.update(theRestaurant);
		
	}



	@Override
	public Restaurant getRestaurant(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();	
		return currentSession.get(Restaurant.class,	 theId);
	}



	@Override
	public List<Menu> getAllMenu() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Menu> theQuery =
				currentSession.createQuery("from Menu ORDER BY dish_category", 
						Menu.class);
	//	System.out.println("3. query object created");		
		// Execute query and get result list
		List<Menu> restaurants = theQuery.getResultList();
		System.out.println("got result");
		// Return the results		
		return restaurants;
	}



	@Override
	public void saveMenu(Menu theMenu) {
		Session currentSession = sessionFactory.getCurrentSession();	
		
		System.out.println(theMenu);
		
		if(theMenu.getId() ==  0)
			currentSession.save(theMenu);
		else
			currentSession.update(theMenu);
		
	}



	@Override
	public Menu getMenu(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();	
		return currentSession.get(Menu.class, theId);
	}

	@Override
	public List<String> getAllRestaurantNames() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		// Query<String> theQuery =
		SQLQuery<String> query = 		currentSession.createSQLQuery("SELECT store_name FROM enterprise"); //,createQuery("SELECT name FROM Restaurant", 
					//	String.class);
	//	System.out.println("3. query object created");		
		// Execute query and get result list
		
		List<String> restaurants = query.getResultList();
		System.out.println("got result");
		// Return the results			
		
		return restaurants;
	}

}
