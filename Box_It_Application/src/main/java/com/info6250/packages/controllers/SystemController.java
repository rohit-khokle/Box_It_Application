package com.info6250.packages.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.service.RestaurantService;
import com.info6250.packages.service.UserService;
import com.info6250.packages.user.BoxItEmployee;
import com.info6250.packages.user.BoxItMenu;
import com.info6250.packages.user.BoxItUser;

@Controller
@RequestMapping("/systems")
public class SystemController {

	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	/*
	 * 
	 * 			Restaurant Management
	 * 
	 */
	
	@GetMapping("/new-restaurant")
	public String showFormForAdd(Model theModel) {
		
		Restaurant theRestaurant = new Restaurant();
		theModel.addAttribute("restaurant", theRestaurant);
		return "new-restaurant";
	}

	@PostMapping("/saveRestaurant")
	public String saveRestaurant(@ModelAttribute("restaurant") Restaurant theRestaurant){
		theRestaurant.setOrdersServed(0L);
		theRestaurant.setRevenue(0D);
		restaurantService.saveRestaurant(theRestaurant);
		return "redirect:/systems?pageCount=0";
	}
		
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("restaurantID") int theId, Model theModel) {
		// Get the restaurant from the service
		Restaurant theRestaurant = restaurantService.getRestaurant(theId);
		//  Set restaurant
		theModel.addAttribute("restaurant", theRestaurant);
		
		return "new-restaurant";
	}
	
	
	/*
	 * 							Menu Management
	 * */
/*
 * 
	
	@GetMapping("/setup-menu")
	public String showCurrentMenu(Model theModel) {
		
		// Get Restaurants from the DAO
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

 */
	
	@GetMapping("/setup-menu")
	public String showCurrentMenu(Model theModel) {
		
		// Get Restaurants from the DAO
		List<Menu> allMenu = restaurantService.getAllMenu();

		// Add the restaurants to the model
		theModel.addAttribute("allMenu",allMenu);
		
		
		return "setup-menu-view";
	}
	
	@PostMapping("/add-menu")
	public String showMenuFormForAdd(Model theModel) {
		
		BoxItMenu theMenu = new BoxItMenu();
		theModel.addAttribute("menu", theMenu);
		return "new-menu";
	}

	@GetMapping("/showMenuForUpdate")
	public String showMenuForUpdate(@ModelAttribute("menuID") int theId, Model theModel) {
		
//		Menu theMenu = restaurantService.getMenu(theId);
		
		BoxItMenu theMenu = restaurantService.getBoxItMenu(theId);
		
		//  Set restaurant
		theModel.addAttribute("menu", theMenu);
		
		return "new-menu";
	}
	
	@PostMapping("/saveMenu")
	public String saveRestaurant(Model theModel, 
			@Valid @ModelAttribute("menu") BoxItMenu theMenu, 
			BindingResult theBindingResult
			){
		
		 if (theBindingResult.hasErrors()){
				return "new-menu";
	        }
		
		
		restaurantService.saveMenu(theMenu);
		
		
		return "redirect:/systems/setup-menu";
	}
	
	
	/*
	 * 							Staff Management
	 * 
	 * */
	
	
	@GetMapping("/manage-staff")
	public String showStaff(Model theModel,
			@ModelAttribute("pageCount") Integer pageNumber) {
		
		// Get Restaurants frpom the DAO
	//	List<User> allStaff = restaurantService.getAllStaff();
		
		
		// Pagination
		System.out.println("Page count : "+ pageNumber);	
		List<User> allStaff = restaurantService.getAllStaffPagnination(pageNumber);
		Long count = restaurantService.getAllStaffCountPagnination();
		
		
		
		// Add the restaurants to the model
		theModel.addAttribute("allStaff",allStaff);
		theModel.addAttribute("pageNumber",pageNumber);		
		theModel.addAttribute("restaurantsCount",count);
		

		return "manage-staff";
	}

	@GetMapping("/add-new-staff")
	public String addNewStaff(Model theModel) {
		
		// Get Restaurants from the DAO
		List<String> allRestaurant = restaurantService.getAllRestaurantNames();

		// Add the restaurants to the model
		theModel.addAttribute("allRestaurant",allRestaurant);
	//	theModel.addAttribute("crmUser", new BoxItUser());
		theModel.addAttribute("crmUser", new BoxItEmployee());
		
		return "staff-registration-form";
	}

	

	// Adding new staff member code
	
	@PostMapping("/add-staff/processRegistrationForm")
	public String saveStaffMember( //	@Valid @ModelAttribute("crmUser") BoxItUser theCrmUser, 
			@Valid @ModelAttribute("crmUser") BoxItEmployee theCrmUser, 
			BindingResult theBindingResult, 
			Model theModel) {
		
		String userName = theCrmUser.getUserName();
		
		// form validation
		 if (theBindingResult.hasErrors()){
				// Get Restaurants from the DAO
				List<String> allRestaurant = restaurantService.getAllRestaurantNames();
				// Add the restaurants to the model
				theModel.addAttribute("allRestaurant",allRestaurant);
			 
				return "staff-registration-form";
	        }
	
		// check the database if user already exists
	    User existing = userService.findByUserName(userName);
	    if (existing != null){
	    	theModel.addAttribute("crmUser", theCrmUser);
			theModel.addAttribute("registrationError", "User name already exists.");
			
			
			// Get Restaurants from the DAO
			List<String> allRestaurant = restaurantService.getAllRestaurantNames();
			// Add the restaurants to the model
			theModel.addAttribute("allRestaurant",allRestaurant);
	
			return "staff-registration-form";
	    }
	
	    userService.saveStaff(theCrmUser);
		
		// Get Restaurants frpom the DAO
		List<User> allStaff = restaurantService.getAllStaff();
		theModel.addAttribute("allStaff",allStaff);    
	   
	    return "redirect:/systems/manage-staff?pageCount=0";	

	}

	@GetMapping("/showStaffForUpdate")
	public String showStaffForUpdate(@ModelAttribute("theId") Long theId, Model theModel) {
		// Get the restaurant from the service
		User theUser = userService.getUserById(theId);
		//  Set restaurant
	//	BoxItUser theBoxItUser = new BoxItUser();
		BoxItEmployee theBoxItUser = new BoxItEmployee();
		
		theBoxItUser.setId(theUser.getId());
		theBoxItUser.setEmail(theUser.getEmail());
		theBoxItUser.setFirstName(theUser.getFirstName());
		theBoxItUser.setLastName(theUser.getLastName());
		theBoxItUser.setPassword(theUser.getPassword());
		theBoxItUser.setRestaurantName(theUser.getRestaurantName());
		theBoxItUser.setRole(theUser.getStaffRole());
		theBoxItUser.setUserName(theUser.getUserName());
		
		
		// Get Restaurants from the DAO
		List<String> allRestaurant = restaurantService.getAllRestaurantNames();

		// Add the restaurants to the model
		theModel.addAttribute("allRestaurant",allRestaurant);
		
		theModel.addAttribute("crmUser", theBoxItUser);
		theModel.addAttribute("id", theUser.getId());
		return "staff-update-form";
	}
	
	/*
	 * Deleting a staff member
	 * */
	
	@GetMapping("/deleteStaff")
	public String deleteStaff(@RequestParam("theId") long theId) {
		  userService.deleteStaff(theId);
		  return "redirect:/systems/manage-staff?pageCount=0";	
	}
	
	@PostMapping("/update-staff")
	public String updateStaff(//@Valid @ModelAttribute("crmUser") BoxItUser theCrmUser,
			@Valid @ModelAttribute("crmUser") BoxItEmployee theCrmUser,
			BindingResult theBindingResult, 
			Model theModel) {
		
		String userName = theCrmUser.getUserName();
		
		// form validation
		 if (theBindingResult.hasErrors()){
				// Get Restaurants from the DAO
				List<String> allRestaurant = restaurantService.getAllRestaurantNames();

				// Add the restaurants to the model
				theModel.addAttribute("allRestaurant",allRestaurant);
			 return "staff-update-form";
	        }
	
		// check the database if user already exists
	    User userWithId = userService.getUserById(theCrmUser.getId());
	    User existing = userService.findByUserName(userName);
	    
	    if(!(theCrmUser.getUserName().equalsIgnoreCase(userWithId.getUserName())))
	    {	
		    
		    if (existing != null){
		    	theModel.addAttribute("crmUser", theCrmUser);
				theModel.addAttribute("registrationError", "User name already exists.");
		
				logger.warning("User name already exists.");
				
				// Get Restaurants from the DAO
				List<String> allRestaurant = restaurantService.getAllRestaurantNames();

				// Add the restaurants to the model
				theModel.addAttribute("allRestaurant",allRestaurant);
		    	return "staff-update-form";
		    }
	    }
	    
	    userService.saveStaff(theCrmUser);
		
		// Get Restaurants frpom the DAO
		List<User> allStaff = restaurantService.getAllStaff();
		
		// Add the restaurants to the model
		theModel.addAttribute("allStaff",allStaff);    
		
		
		return "redirect:/systems/manage-staff?pageCount=0";		
		
	}
	
	
}
