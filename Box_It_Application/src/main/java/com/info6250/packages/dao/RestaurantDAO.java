package com.info6250.packages.dao;

import java.util.List;

import com.info6250.packages.entities.Restaurant;

public interface RestaurantDAO {
	
	public List<Restaurant> getRestaurants();

	public void saveRestaurant(Restaurant theRestaurant);

}
