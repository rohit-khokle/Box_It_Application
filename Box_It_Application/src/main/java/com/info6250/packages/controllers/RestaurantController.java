/**
 * 
 */
package com.info6250.packages.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.info6250.packages.service.WorkspaceService;

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
	CustomerService customerService;
		
	
	@GetMapping("/myworkspace")
	public String showManager(HttpSession session, Model theModel) {
		User user;
		Restaurant restaurant;
		List<Workspace> workspaces;
		try {
			 user = (User)session.getAttribute("user");	
			 restaurant = (Restaurant)restaurantService.getRestaurant(user.getRestaurantName());
			 workspaces = (List<Workspace>)workspaceService.getRestaurantWorkspaces(restaurant);
		}
		catch(Exception e)
		{
			
			return "redirect:/BoxItLoginPage";
		}
		
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
	
	@GetMapping("/manager/decline")
	public String declineOrder(HttpSession session,  Model theModel) {
		User user;
		Restaurant restaurant;
		List<Workspace> workspaces;
		try {
			 user = (User)session.getAttribute("user");	
			 restaurant = (Restaurant)restaurantService.getRestaurant(user.getRestaurantName());
			 System.out.println(" "+restaurant);
			 workspaces = (List<Workspace>)workspaceService.getRestaurantWorkspaces(restaurant);
		}
		catch(Exception e)
		{
			
			return "/";
		}
		
		theModel.addAttribute("currentRestaurantOrders", workspaces);		
		session.setAttribute("workspaceRestaurant", restaurant);
		
		return "manager_home";
	}	
	

	
	@PostMapping("/AssignChef")
	public String assignChef(HttpSession session, HttpServletRequest request, @RequestParam String workspaceId, Model theModel) {
		
		Workspace theWorkspace = (Workspace) 
						workspaceService.getWorkspace(Integer.parseInt(workspaceId));
		
		Long id = Long.parseLong(request.getParameter("staff"));
		
		workspaceService.assignToChef(theWorkspace, id);
		
		return "redirect:/home";
	}	
	
	
	
	
	
	

}
