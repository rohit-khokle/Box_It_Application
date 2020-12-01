package com.info6250.packages.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findByUserName(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		
		theQuery.setParameter("uName", userName);
		User theUser = null;
		try {
			
			theUser = theQuery.getSingleResult();
			
		} catch(Exception e) {
			theUser = null;
			
		}

		return theUser;
	}

	@Override
	public void save(User user) {
		Session currentSession = sessionFactory.getCurrentSession();		
		currentSession.saveOrUpdate(user);

	}

	@Override
	public User getUserById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();	
		return currentSession.get(User.class,id);
	}

	@Override
	public void deleteStaff(long theId) {
		
		// GEt the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();	
		
		
		// Delete object the primay key
		
		Query theQuery = currentSession.createQuery("DELETE FROM User WHERE id=:theUserId");
		theQuery.setParameter("theUserId", theId);
		
		theQuery.executeUpdate();	
	}

}
