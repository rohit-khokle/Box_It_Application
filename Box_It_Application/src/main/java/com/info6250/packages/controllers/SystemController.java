package com.info6250.packages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.service.RestaurantService;

@Controller
@RequestMapping("/systems")
public class SystemController {

	@Autowired
	RestaurantService restaurantService;
	

	@GetMapping("/new-restaurant")
	public String showFormForAdd(Model theModel) {
		
		Restaurant theRestaurant = new Restaurant();
		theModel.addAttribute("restaurant", theRestaurant);
		return "new-restaurant";
	}
	
	
	
	@PostMapping("/saveRestaurant")
	public String saveRestaurant(@ModelAttribute("restaurant") Restaurant theRestaurant){
		
		restaurantService.saveRestaurant(theRestaurant);
		return "redirect:/employees";
	}
	
	
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("restaurantID") int theId, Model theModel) {
		// Get the restaurant from the service
		Restaurant theRestaurant = restaurantService.getRestaurant(theId);
		//  Set restaurant
		theModel.addAttribute("restaurant", theRestaurant);
		
		return "new-restaurant";
	}

	@GetMapping("/setup-menu")
	public String showCurrentMenu(Model theModel) {
		
		// Get Restaurants frpom the DAO
		List<Menu> allMenu = restaurantService.getAllMenu();

		// Add the restaurants to the model
		theModel.addAttribute("allMenu",allMenu);
		
		
		return "setup-menu-view";
	}
	
	

	@PostMapping("/add-menu")
	public String showMenuFormForAdd(Model theModel) {
		
		Menu theMenu = new Menu();
		theModel.addAttribute("menu", theMenu);
		return "new-menu";
	}
	
	
	@PostMapping("/saveMenu")
	public String saveRestaurant(@ModelAttribute("menu") Menu theMenu){
		
		restaurantService.saveMenu(theMenu);
		return "redirect:/systems/setup-menu";
	}
	
	
}
