package com.info6250.packages.service;

import java.util.List;

import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;

public interface RestaurantService {

	public List<Restaurant> getRestaurants();

	public void saveRestaurant(Restaurant theRestaurant);

	public Restaurant getRestaurant(int theId);
	
	
	public List<Menu> getAllMenu();

	public void saveMenu(Menu theRestaurant);

	public Menu getMenu(int theId);
	
	
	
	
}
