/**
 * 
 */
package com.info6250.packages.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.User_Address;
import com.info6250.packages.entities.Workspace;
import com.info6250.packages.service.CustomerService;
import com.info6250.packages.service.RestaurantService;
import com.info6250.packages.service.UserService;
import com.info6250.packages.service.WorkspaceService;
import com.info6250.packages.user.BoxItEmployee;

/**
 * @author Rohit
 *
 */
@Controller
@RequestMapping("/manager")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	WorkspaceService workspaceService;
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	CustomerService customerService;
		
	
	@GetMapping("/myworkspace")
	public String showManager(HttpSession session, Model theModel) {
		User user;
		Restaurant restaurant;
		List<Workspace> workspaces;
		try {
			 user = (User)session.getAttribute("user");	
			 restaurant = (Restaurant)restaurantService.getRestaurant(user.getRestaurantName());
		}
		catch(Exception e)
		{
			
			return "redirect:/BoxItLoginPage";
		}
		 workspaces = (List<Workspace>)workspaceService.getRestaurantWorkspaces(restaurant);
		
	//	"currentRestaurantOrders", allOR	
	//	
		
		theModel.addAttribute("currentRestaurantOrders", workspaces);
		
		session.setAttribute("workspaceRestaurant", restaurant);
		
		
		return "manager_home";
	}	
	
	
	@GetMapping("/assignment")
	public String staffAssignment(HttpSession session, 
			@ModelAttribute("orderID") int theId, 
			Model theModel) {
		
		User user; 
		List<User> chefs;
		List<Cart_items> orderCart;
		Workspace theWorkspace;
		Restaurant restaurant;
		User_Address address;
		User customer;
		
		try {
			 user = (User)session.getAttribute("user");	
			 
			 	// Get Workspace
				theWorkspace = 
						workspaceService.getWorkspace(theId);
				
				// Get Customer details
				customer = workspaceService.getCustomerDetails(theWorkspace.getCustomer_id());
				address = customerService.getAddress(customer);
				
				// Get Restaurant Details
				restaurant = 
						(Restaurant)session.getAttribute("workspaceRestaurant");	
				
				
				// Get Cart
				orderCart = 
						workspaceService.getMyCart(theId);
				
				// Get Chefs
				chefs = workspaceService.getChefs(restaurant);


		
		}
		catch(Exception e)
		{
			
			return "redirect:/BoxItLoginPage";
		}

				
		System.out.println(" customer id : "+ theWorkspace.getCustomer_id());
		

		theModel.addAttribute("workspace", theWorkspace);		
		theModel.addAttribute("customer", customer);
		theModel.addAttribute("currentCart", orderCart);
		theModel.addAttribute("chefs", chefs);	
		theModel.addAttribute("address", address);	
		
		
		return "order-assignment";
	}	
	
	@GetMapping("/decline")
	public String declineOrder(HttpSession session, 
			@ModelAttribute("orderID") int theId, 
			Model theModel) {
		
		User user; 
		List<User> chefs;
		List<Cart_items> orderCart;
		Workspace theWorkspace;
		Restaurant restaurant;
		User_Address address;
		User customer;
		
		try {
			 user = (User)session.getAttribute("user");	
			 
			 	// Get Workspace
				theWorkspace = 
						workspaceService.getWorkspace(theId);
				
				// Get Customer details
				customer = workspaceService.getCustomerDetails(theWorkspace.getCustomer_id());
				address = customerService.getAddress(customer);
				
				// Get Restaurant Details
				restaurant = 
						(Restaurant)session.getAttribute("workspaceRestaurant");	
				
				
				// Get Cart
				orderCart = 
						workspaceService.getMyCart(theId);
			

		
		}
		catch(Exception e)
		{
			
			return "redirect:/BoxItLoginPage";
		}

				
		System.out.println(" customer id : "+ theWorkspace.getCustomer_id());
		

		theModel.addAttribute("workspace", theWorkspace);		
		theModel.addAttribute("customer", customer);
		theModel.addAttribute("currentCart", orderCart);
	//	theModel.addAttribute("chefs", chefs);	
		theModel.addAttribute("address", address);	
		
		
		return "manager_decline";
	}	
	

	
	@PostMapping("/AssignChef")
	public String assignChef(HttpSession session, HttpServletRequest request, @RequestParam String workspaceId, Model theModel) {
		
		Workspace theWorkspace = (Workspace) 
						workspaceService.getWorkspace(Integer.parseInt(workspaceId));
		
		Long id = Long.parseLong(request.getParameter("staff"));
		
		workspaceService.assignToChef(theWorkspace, id);
		
		return "redirect:/home";
	}	
	
	
	
	@GetMapping("/RestaurantStats")
	public String getRestaurantStats(HttpSession session, HttpServletRequest request, @RequestParam String workspaceId, Model theModel) {
		
		Workspace theWorkspace = (Workspace) 
						workspaceService.getWorkspace(Integer.parseInt(workspaceId));
		
		theWorkspace.setStatus("DECLINED");
		theWorkspace.setWorkspaceResponse(request.getParameter("declineResponse"));
		customerService.createWorkspace(theWorkspace);
		
		
		return "redirect:/home";
	}	
	
	
	@PostMapping("/ProcessDecline")
	public String declineOrder(HttpSession session, HttpServletRequest request, @RequestParam String workspaceId, Model theModel) {
		
		Workspace theWorkspace = (Workspace) 
				workspaceService.getWorkspace(Integer.parseInt(workspaceId));

		theWorkspace.setStatus("DECLINED");
		theWorkspace.setWorkspaceResponse(request.getParameter("declineResponse"));
		customerService.updateWorkspace(theWorkspace);
		
		return "redirect:/home";
	}	
	
	@GetMapping("/OrderHistory")
	public String showOrderHistory(HttpSession session, Model theModel) {
		User user;
		Restaurant restaurant;
		List<Workspace> workspaces;
		try {
			 user = (User)session.getAttribute("user");	
			 restaurant = (Restaurant)restaurantService.getRestaurant(user.getRestaurantName());
			 workspaces = (List<Workspace>)workspaceService.getRestaurantWorkspacesHistory(restaurant);
		}
		catch(Exception e)
		{
			
			return "redirect:/BoxItLoginPage";
		}
		
	//	"currentRestaurantOrders", allOR	
	//	
		
		theModel.addAttribute("currentRestaurantOrders", workspaces);
		
		session.setAttribute("workspaceRestaurant", restaurant);
		
		
		return "manager_order_history";
	}	
	
	
	/*
	 * Manage Staff
	 * 
	 */

	@GetMapping("/manageStaff")
	public String showOStaff(HttpSession session,
			@ModelAttribute("pageCount") Integer pageNumber,
			Model theModel) {
		User user;                 
		Restaurant restaurant;
		try {
			 user = (User)session.getAttribute("user");	
			 restaurant = (Restaurant)restaurantService.getRestaurant(user.getRestaurantName());
			
		}
		catch(Exception e)
		{
			return "redirect:/BoxItLoginPage";
		}
		
		
		// Pagination
		System.out.println("Page count : "+ pageNumber);	
		List<User> allStaff = restaurantService.getAllStaffPagnination(pageNumber, restaurant);
		Long count = restaurantService.getRestaurantStaffCountPagnination(restaurant);
		
		
		
		// Add the restaurants to the model
		theModel.addAttribute("allStaff",allStaff);
		theModel.addAttribute("pageNumber",pageNumber);		
		theModel.addAttribute("restaurantsCount",count);
		
		
		return "manage-staff-manager";
	}	
	
	@GetMapping("/add-new-staff")
	public String addNewStaff(Model theModel, HttpSession session) {
		
		// Get Restaurants from the DAO
		
		Restaurant theRestaurant = (Restaurant) session.getAttribute("workspaceRestaurant");
		
		// Add the restaurants to the model
		theModel.addAttribute("theRestaurant",theRestaurant);
		
		BoxItEmployee theEmployee = new BoxItEmployee();
		
		theEmployee.setRestaurantName(theRestaurant.getName());
		
		theModel.addAttribute("crmUser",theEmployee);
		
		return "staff-registration-form-manager";
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
			 
				return "staff-registration-form-manager";
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
	
			return "staff-registration-form-manager";
	    }
	
	    userService.saveStaff(theCrmUser);
		
		// Get Restaurants frpom the DAO
		List<User> allStaff = restaurantService.getAllStaff();
		theModel.addAttribute("allStaff",allStaff);    
	   
	    return "redirect:/manager/manageStaff?pageCount=0";	

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
		
		
		
		theModel.addAttribute("crmUser", theBoxItUser);
		theModel.addAttribute("id", theUser.getId());
	
		
		return "staff-update-form-manager";
	}
	
	
	@PostMapping("/update-staff")
	public String updateStaff(//@Valid @ModelAttribute("crmUser") BoxItUser theCrmUser,
			@Valid @ModelAttribute("crmUser") BoxItEmployee theCrmUser,
			BindingResult theBindingResult, 
			Model theModel) {
		
		String userName = theCrmUser.getUserName();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 return "staff-update-form-manager";
	        }
	
		// check the database if user already exists
	    User userWithId = userService.getUserById(theCrmUser.getId());
	    User existing = userService.findByUserName(userName);
	    
	    if(!(theCrmUser.getUserName().equalsIgnoreCase(userWithId.getUserName())))
	    {	
		    
		    if (existing != null){
		    	theModel.addAttribute("crmUser", theCrmUser);
				theModel.addAttribute("registrationError", "User name already exists.");

		    	return "staff-update-form-manager";
		    }
	    }
	    
	    userService.saveStaff(theCrmUser);
		
		// Get Restaurants frpom the DAO
		List<User> allStaff = restaurantService.getAllStaff();
		
		// Add the restaurants to the model
		theModel.addAttribute("allStaff",allStaff);    
		
		
		return "redirect:/manager/manageStaff?pageCount=0";		
		
	}
	
	
	/*
	 * 
	 * Delivery Assignment
	 * 
	 */
	@GetMapping("/assignmentDelivery")
	public String delAssignment(HttpSession session, 
			@ModelAttribute("orderID") int theId, 
			Model theModel) {
		
		User user; 
		List<User> dels;
		List<Cart_items> orderCart;
		Workspace theWorkspace;
		Restaurant restaurant;
		User_Address address;
		User customer;
		
		try {
			 user = (User)session.getAttribute("user");	
			 
			 	// Get Workspace
				theWorkspace = 
						workspaceService.getWorkspace(theId);
				
				// Get Customer details
				customer = workspaceService.getCustomerDetails(theWorkspace.getCustomer_id());
				address = customerService.getAddress(customer);
				
				// Get Restaurant Details
				restaurant = 
						(Restaurant)session.getAttribute("workspaceRestaurant");	
				
				
				// Get Cart
				orderCart = 
						workspaceService.getMyCart(theId);
				
				// Get Delivery Executives
				dels = workspaceService.getDeliveryExecs(restaurant);


		
		}
		catch(Exception e)
		{
			
			return "redirect:/BoxItLoginPage";
		}

	

		theModel.addAttribute("workspace", theWorkspace);		
		theModel.addAttribute("customer", customer);
		theModel.addAttribute("currentCart", orderCart);
		theModel.addAttribute("dels", dels);	
		theModel.addAttribute("address", address);	
		
		
		return "delivery-assignment";
	}	
	
	
	@PostMapping("/AssignDel")
	public String assignDel(HttpSession session, HttpServletRequest request, @RequestParam String workspaceId, Model theModel) {
		
		Workspace theWorkspace = (Workspace) 
						workspaceService.getWorkspace(Integer.parseInt(workspaceId));
		
		Long id = Long.parseLong(request.getParameter("staff"));
		
		workspaceService.assignToDelivery(theWorkspace, id);
		
		return "redirect:/home";
	}	
	
	
	
	
	@GetMapping("/my-Profile")
	public String myProfileUpdate(HttpSession session, 
			Model theModel) {
		User theUser; 

		try {
			theUser = (User)session.getAttribute("user");	
		}
		catch(Exception e)
		{
			
			return "redirect:/BoxItLoginPage";
		}

		
		
		BoxItEmployee theBoxItUser = new BoxItEmployee();
		
		theBoxItUser.setId(theUser.getId());
		theBoxItUser.setEmail(theUser.getEmail());
		theBoxItUser.setFirstName(theUser.getFirstName());
		theBoxItUser.setLastName(theUser.getLastName());
		theBoxItUser.setPassword(theUser.getPassword());
		theBoxItUser.setRestaurantName(theUser.getRestaurantName());
		theBoxItUser.setRole(theUser.getStaffRole());
		theBoxItUser.setUserName(theUser.getUserName());
		
		
		
		theModel.addAttribute("crmUser", theBoxItUser);
		theModel.addAttribute("id", theUser.getId());
	
		
		return "profile-update-manager";
	}
	
	
	@PostMapping("/profile-staff")
	public String updateProfile(//@Valid @ModelAttribute("crmUser") BoxItUser theCrmUser,
			HttpSession session, 
			@Valid @ModelAttribute("crmUser") BoxItEmployee theCrmUser,
			BindingResult theBindingResult, 
			Model theModel) {
		
		String userName = theCrmUser.getUserName();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 return "profile-update-manager";
	        }
	
		// check the database if user already exists
//	    User userWithId = userService.getUserById(theCrmUser.getId());
//	    User existing = userService.findByUserName(userName);
//	    
//	    if(!(theCrmUser.getUserName().equalsIgnoreCase(userWithId.getUserName())))
//	    {	
//		    
//		    if (existing != null){
//		    	theModel.addAttribute("crmUser", theCrmUser);
//				theModel.addAttribute("registrationError", "User name already exists.");
//
//		    	return "staff-update-form-manager";
//		    }
//	    }
	    
	    userService.saveStaff(theCrmUser);
		
	    
	   session.setAttribute("user", userService.findByUserName(theCrmUser.getUserName())); 
		
	   return "redirect:/home";		
		
	}	
	
	
		
}
