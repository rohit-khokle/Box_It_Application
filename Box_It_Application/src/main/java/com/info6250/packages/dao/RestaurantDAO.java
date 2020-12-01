package com.info6250.packages.dao;

import java.util.List;

import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;

public interface RestaurantDAO {
	
	public List<Restaurant> getRestaurants();

	public void saveRestaurant(Restaurant theRestaurant);

	public Restaurant getRestaurant(int theId);

	
	public List<Menu> getAllMenu();

	public void saveMenu(Menu theMenu);

	public Menu getMenu(int theId);

	public List<User> getAllStaff();
	
	public List<String> getAllRestaurantNames();
	
}
