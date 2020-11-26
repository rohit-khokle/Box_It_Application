package com.info6250.packages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.dao.RestaurantDAO;
import com.info6250.packages.entities.Restaurant;


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
	public void saveRestaurant(Restaurant theRestaurant) {
		restaurantDAO.saveRestaurant(theRestaurant);
	}

}
