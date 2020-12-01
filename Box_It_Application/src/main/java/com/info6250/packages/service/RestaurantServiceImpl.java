package com.info6250.packages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.dao.RestaurantDAO;
import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;


@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantDAO restaurantDAO;
	
	
	
	@Override
	@Transactional
	public List<Restaurant> getRestaurants() {
		return restaurantDAO.getRestaurants();
	}


	@Override
	@Transactional
	public List<User> getAllStaff() {
		return restaurantDAO.getAllStaff();
	}


	@Override
	@Transactional
	public void saveRestaurant(Restaurant theRestaurant) {
		restaurantDAO.saveRestaurant(theRestaurant);
	}



	@Override
	@Transactional
	public Restaurant getRestaurant(int theId) {
		
		return restaurantDAO.getRestaurant(theId);
	}



	@Override
	@Transactional
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return restaurantDAO.getAllMenu();
	}



	@Override
	@Transactional
	public void saveMenu(Menu theRestaurant) {
		restaurantDAO.saveMenu(theRestaurant);
		
	}



	@Override
	@Transactional
	public Menu getMenu(int theId) {
		return restaurantDAO.getMenu(theId);
	}


	@Override
	@Transactional
	public List<String> getAllRestaurantNames() {
		// TODO Auto-generated method stub
		return restaurantDAO.getAllRestaurantNames();
	}

}
