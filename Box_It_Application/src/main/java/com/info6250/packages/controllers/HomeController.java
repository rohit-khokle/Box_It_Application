 package com.info6250.packages.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import com.info6250.packages.entities.Payment_Details;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.service.CustomerService;
import com.info6250.packages.service.RestaurantService;
import com.info6250.packages.user.BoxitPaymentDetails;

@Controller
public class HomeController {

	@Autowired
	private RestaurantService restaurantService;
	
	//private Logger logger = Logger.getLogger(getClass().getName());
	
	
    
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	
	
	
	@GetMapping("/")
	public String showLandingPage() {
		return "landing";
	}
	
	@GetMapping("/home")
	public String showHome(HttpSession session) {	
		return "redirect";
		//	return "home";
	}

	@GetMapping("/myworkspace1")
	public String showManagers() {
		
		return "managers_home";
	}
	

	@GetMapping("/systems")
	public String showSystems(Model theModel) {
		
		
		// Get Restaurants frpom the DAO
		List<Restaurant> restaurants = restaurantService.getRestaurants();

		// Add the restaurants to the model
		theModel.addAttribute("restaurants",restaurants);
		
		return "admins";
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
