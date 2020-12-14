package com.info6250.packages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.dao.RestaurantDAO;
import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.user.BoxItMenu;


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


	@Override
	@Transactional
	public Restaurant getRestaurant(String name) {
		
		return restaurantDAO.getRestaurant(name);
	}


	@Override
	@Transactional
	public List<Restaurant> getRestaurantNamesPagnination(Integer count) {
		// TODO Auto-generated method stub
		return restaurantDAO.getRestaurantNamesPagnination(count);
	}


	@Override
	@Transactional
	public Long getRestaurantCountPagnination() {
		return restaurantDAO.getRestaurantCountPagnination();
	}


	@Override
	@Transactional
	public List<User> getAllStaffPagnination(Integer firstCount) {
		return restaurantDAO.getAllStaffPagnination(firstCount);
	}


	@Override
	@Transactional
	public Long getAllStaffCountPagnination() {
		return restaurantDAO.getAllStaffCountPagnination();
	}


	@Override
	@Transactional
	public void saveMenu(BoxItMenu theMenu) {
		
		Menu menu = new Menu();
		
		
		menu.setId(theMenu.getId());
		menu.setDish_name(theMenu.getDish_name());
		menu.setDish_category(theMenu.getDish_category());
		menu.setPrice(Double.parseDouble(theMenu.getPrice()));
		menu.setDescription(theMenu.getDescription());
		menu.setRemarks(theMenu.getRemarks());
		menu.setCalories(Double.parseDouble(theMenu.getCalories()));
		
		restaurantDAO.saveMenu(menu);
		
	}


	@Override
	@Transactional
	public BoxItMenu getBoxItMenu(int theId) {
		Menu theMenu = restaurantDAO.getMenu(theId);
		
		BoxItMenu menu = new BoxItMenu();
		
		
		menu.setId(theMenu.getId());
		menu.setDish_name(theMenu.getDish_name());
		menu.setDish_category(theMenu.getDish_category());
		menu.setPrice(theMenu.getPrice()+"");
		menu.setDescription(theMenu.getDescription());
		menu.setRemarks(theMenu.getRemarks());
		menu.setCalories(theMenu.getCalories()+"");
		
		
		// TODO Auto-generated method stub
		return menu;
	}


	@Override
	@Transactional
	public List<User> getAllStaffPagnination(Integer pageNumber, Restaurant restaurant) {	
		return restaurantDAO.getAllStaffPagnination(pageNumber,restaurant);
	
	}


	@Override
	@Transactional
	public Long getRestaurantStaffCountPagnination(Restaurant restaurant) {
		return restaurantDAO.getAllStaffCountPagnination(restaurant);
	}

}
