package com.info6250.packages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
	
	@PostMapping("/view-restaurants")
	public String showManagers() {
		return "view-restaurants";
	}
	

	@PostMapping("/setup-menu")
	public String showSystems() {
		return "setup-menu-view";
	}
	
	
}
