package com.info6250.packages.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.user.BoxItMenu;

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Restaurant> getRestaurants() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Restaurant> theQuery =
				currentSession.createQuery("from Restaurant ORDER BY store_name", 
						Restaurant.class);
		List<Restaurant> restaurants = theQuery.getResultList();
		return restaurants;
	}

	@Override
	public List<User> getAllStaff() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		SQLQuery<User> theQuery =
				currentSession.createSQLQuery("SELECT * FROM user WHERE restaurant_name IS NOT NULL ORDER BY restaurant_name");

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
	public Restaurant getRestaurant(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Restaurant> theQuery =
				currentSession.createQuery("from Restaurant WHERE store_name =:storeName", 
						Restaurant.class);
		theQuery.setParameter("storeName", name);
		
		return theQuery.getSingleResult();
	}

	
	


	@Override
	public List<Menu> getAllMenu() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Menu> theQuery =
				currentSession.createQuery("from Menu ORDER BY dish_category", 
						Menu.class);
	
		// Execute query and get result list
		List<Menu> restaurants = theQuery.getResultList();
		System.out.println("got result");
		// Return the results		
		return restaurants;
	}



	@Override
	public void saveMenu(Menu theMenu) {
		Session currentSession = sessionFactory.getCurrentSession();	
	
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
		// Return the results			
		
		return restaurants;
	}

	
	
	@Override
	public List<Restaurant> getRestaurantNamesPagnination(Integer count) {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Criteria criteria = currentSession.createCriteria(Restaurant.class);
		criteria.setFirstResult(count);
		criteria.setMaxResults(5);
		List<Restaurant> firstPage = criteria.list();
		
			
		return firstPage;
	}
	

	
	@Override
	public Long getRestaurantCountPagnination() {
	
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteriaCount = currentSession.createCriteria(Restaurant.class);
		criteriaCount.setProjection(Projections.rowCount());
		Long count = (Long) criteriaCount.uniqueResult();
		
		return count;
	}

	@Override
	public List<User> getAllStaffPagnination(Integer firstCount) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Criteria criteria = currentSession.createCriteria(User.class);
		criteria.add(Restrictions.isNotNull("restaurantName"));
		criteria.addOrder(Order.desc("restaurantName"));
		criteria.setFirstResult(firstCount);
		criteria.setMaxResults(5);
		List<User> firstPage = criteria.list();
	
		return firstPage;
	}

	@Override
	public Long getAllStaffCountPagnination() {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteriaCount = currentSession.createCriteria(User.class);

		criteriaCount.setProjection(Projections.rowCount());
		Long count = (Long) criteriaCount.uniqueResult();
		
		return count;
	}



	@Override
	public List<User> getAllStaffPagnination(Integer pageNumber, Restaurant restaurant) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Criteria criteria = currentSession. createCriteria(User.class);
		criteria.add(Restrictions.isNotNull("restaurantName"));
		criteria.add(Restrictions.eq("restaurantName", restaurant.getName())); 
		criteria.add(Restrictions.ne("staffRole", "Manager"));
		criteria.addOrder(Order.asc("staffRole"));
		criteria.setFirstResult(pageNumber);
		criteria.setMaxResults(5);
		List<User> firstPage = criteria.list();
		return firstPage;
	}

	@Override
	public Long getAllStaffCountPagnination(Restaurant restaurant) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteriaCount = currentSession.createCriteria(User.class);
		criteriaCount.add(Restrictions.isNotNull("restaurantName"));
		criteriaCount.add(Restrictions.eq("restaurantName", restaurant.getName())); 
		criteriaCount.add(Restrictions.eq("staffRole", "Manager"));
		criteriaCount.setProjection(Projections.rowCount());
		Long count = (Long) criteriaCount.uniqueResult();
		
		return count;
	}

	@Override
	public Restaurant findByRestaurantName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Restaurant> theQuery = currentSession.createQuery("from Restaurant where name=:rName", Restaurant.class);
		
		theQuery.setParameter("rName", name);
		Restaurant theUser = null;
		try {
			
			theUser = theQuery.getSingleResult();
			
		} catch(Exception e) {
			theUser = null;
			
		}

		return theUser;
	}
	
	
	
	
	
}
