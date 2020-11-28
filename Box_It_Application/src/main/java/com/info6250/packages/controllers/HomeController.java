 package com.info6250.packages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.info6250.packages.dao.RestaurantDAO;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.service.RestaurantService;

@Controller
public class HomeController {

	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/")
	public String showLandingPage() {
		return "landing";
	}
	
	@GetMapping("/home")
	public String showHome() {
		return "redirect";
		//	return "home";
	}

	@GetMapping("/managers")
	public String showManagers() {
	
		return "managers";
	}
	

	@GetMapping("/systems")
	public String showSystems(Model theModel) {
		
		
		// Get Restaurants frpom the DAO
		List<Restaurant> restaurants = restaurantService.getRestaurants();

		// Add the restaurants to the model
		theModel.addAttribute("restaurants",restaurants);
		
		return "admins";
	}
	
	@GetMapping("/my-box-it")
	public String showCustomerWorkspace(Model theModel) {
		return "home";
	}
	
	
	@GetMapping("/chef-dashboard")
	public String showChef() {
		return "chef";
	}

	@GetMapping("/delivery-exe-dashboard")
	public String showDel() {
		return "delivery";
	}
	
	
	
	
}
