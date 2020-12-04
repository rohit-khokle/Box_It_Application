package com.info6250.packages.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.MyCart;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.service.RestaurantService;
import com.info6250.packages.service.UserService;

@Controller
@RequestMapping("/my-box-it")
public class CustomerController {
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	private UserService userService;
//	
//	@Autowired
//	private MyCart myCart;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
    
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	

	@GetMapping("/order-History")
	public String showOrderHistory(
			HttpSession session,  
			Model theModel) {
		return "my-orders";
	}
	
	
	@GetMapping("/my-Profile")
	public String showMyProfile(
			HttpSession session,  
			Model theModel) {
		return "my-profile";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/step-2")
	public String showMenu(
			HttpSession session,  
			@ModelAttribute("restaurantID") int theId, 
			Model theModel) {
		
		// Get the restaurant from the service
		Restaurant theRestaurant = restaurantService.getRestaurant(theId);
		//  Set restaurant
		theModel.addAttribute("restaurant", theRestaurant);
		session.setAttribute("selectedRestaurant", theRestaurant);
		
		
		
		// Get Restaurants from the DAO
		List<Menu> allMenu = restaurantService.getAllMenu();

		// Add the restaurants to the model
		theModel.addAttribute("allMenu",allMenu);

		return "show-menu";
	}
	
	
	
	
	
	@GetMapping("/add-into-cart")
	public String addIntoCart( HttpSession session,	 HttpServletResponse  response,		
			@ModelAttribute("checkCart") MyCart checkCart,
//			@ModelAttribute("restaurantID") int theId,
			@ModelAttribute("menuID") int theMenuId, 
			Model theModel) {	
				
    	Menu selectedItem = restaurantService.getMenu(theMenuId);
    	checkCart.addItemInCart(selectedItem);
    
    	
    	if(session.getAttribute("checkCart") != null) {
    		MyCart currentCart = (MyCart) session.getAttribute("checkCart");
    		currentCart.addItemInCart(selectedItem); // getMyItems().add(selectedItem);
        	session.setAttribute("checkCart", currentCart);
    		
    	}
    	else
    	{
    		session.setAttribute("checkCart", checkCart);
    	}
    	

    
    	
  /*  	
    	if(myCart.getMyItems() != null) {
    		myCart.getMyItems().add(selectedItem);
    		session.setAttribute("selectedItem", selectedItem);

    	}
    	else {
    		session.setAttribute("selectedItem", selectedItem);
	    	myCart.getMyItems().add(selectedItem);
	//    	session.setAttribute("myCart",  myCart);
	    		
	    	
	    	//request.getSession().setAttribute("array_of_selectedItem", items);
	    	//request.getSession().setAttribute("Random", "Check If this comes");
	    	
    	
    	}
	    
    	//request.getSession().setAttribute("random", "Something");
     	theModel.addAttribute("myCart",myCart);
   */
    

    	// Show Alert Prompt
    	theModel.addAttribute("promptThis", selectedItem);
    	
    	
    	//  Load restaurant 
//		Restaurant theRestaurant = restaurantService.getRestaurant(theId);
//		theModel.addAttribute("restaurant", theRestaurant);
//		session.setAttribute("selectedRestaurant", theRestaurant);
		
    	// Load Menu 
		List<Menu> allMenu = restaurantService.getAllMenu();
		theModel.addAttribute("allMenu",allMenu);
		
		
		return "show-menu";
	}
	
	
	@PostMapping("/checkout")
	public String checkoutProcess(HttpSession session,
			@ModelAttribute("restaurant") Restaurant theRestaurant,
			Model theModel) 
	{
		MyCart myCart = (MyCart)session.getAttribute("myCart");
		System.out.println("My values : "+myCart);	
    
		
		Restaurant selectedRestaurant = (Restaurant)session.getAttribute("selectedRestaurant");
//		System.out.println("My Restaurant : "+selectedRestaurant);	
		theModel.addAttribute("restaurant",selectedRestaurant);
		
		
		return "checkout";
	}
	
	@GetMapping("/refresh-cart")
	public String removeFromCart(HttpSession session,	 
			HttpServletResponse  response,		
			@ModelAttribute("restaurant") Restaurant restaurant,
			@ModelAttribute("menuID") int theMenuId, 
			Model theModel) 
	{
		MyCart myCart = (MyCart)session.getAttribute("myCart");
    	
		Menu selectedItem = restaurantService.getMenu(theMenuId);
		myCart.removeFromCart(selectedItem);	
      	session.setAttribute("restaurant", restaurant);
      	session.setAttribute("myCart", myCart);
		return "checkout";
	}
	
		
	
	
}
