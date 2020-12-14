package com.info6250.packages.service;

import java.util.List;

import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;

public interface RestaurantService {

	public List<Restaurant> getRestaurants();

	public void saveRestaurant(Restaurant theRestaurant);

	public Restaurant getRestaurant(int theId);
	
	public Restaurant getRestaurant(String name);
	
	public List<Menu> getAllMenu();

	public void saveMenu(Menu theRestaurant);

	public Menu getMenu(int theId);
	
	public List<User> getAllStaff();
	
	public List<String> getAllRestaurantNames();
	
	public List<Restaurant> getRestaurantNamesPagnination(Integer firstCount);
	
	public Long getRestaurantCountPagnination();
	
	public List<User> getAllStaffPagnination(Integer firstCount);
	
	public Long getAllStaffCountPagnination();
	
	
	
}
