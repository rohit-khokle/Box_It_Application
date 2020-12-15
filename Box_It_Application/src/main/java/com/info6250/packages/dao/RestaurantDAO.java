package com.info6250.packages.dao;

import java.util.List;

import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.user.BoxItMenu;

public interface RestaurantDAO {
	
	public List<Restaurant> getRestaurants();

	public void saveRestaurant(Restaurant theRestaurant);

	public Restaurant getRestaurant(int theId);

	
	public List<Menu> getAllMenu();

	public void saveMenu(Menu theMenu);

	public Menu getMenu(int theId);

	public List<User> getAllStaff();
	
	public List<String> getAllRestaurantNames();

	public Restaurant getRestaurant(String name);

	public List<Restaurant> getRestaurantNamesPagnination(Integer count);

	public Long getRestaurantCountPagnination();

	public List<User> getAllStaffPagnination(Integer firstCount);

	public Long getAllStaffCountPagnination();


	public List<User> getAllStaffPagnination(Integer pageNumber, Restaurant restaurant);

	public Long getAllStaffCountPagnination(Restaurant restaurant);

	public Restaurant findByRestaurantName(String name);
	
}
