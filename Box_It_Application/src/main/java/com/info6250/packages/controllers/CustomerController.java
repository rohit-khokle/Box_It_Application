package com.info6250.packages.controllers;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

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

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.MyCart;
import com.info6250.packages.entities.Payment_Details;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.User_Address;
import com.info6250.packages.entities.Workspace;
import com.info6250.packages.service.CustomerService;
import com.info6250.packages.service.RestaurantService;
import com.info6250.packages.user.BoxItUserAddress;
import com.info6250.packages.user.BoxitPaymentDetails;

@Controller
@RequestMapping("/my-box-it")
public class CustomerController {
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Cart_items cart_items;
	
	@Autowired
	private List<Cart_items> cart_list;
	
	@Autowired
	private  Workspace workspace;
	
	@GetMapping("/home")
	public String showCustomerWorkspace( HttpSession session, Model theModel) {
		User_Address address;
		Payment_Details payment;
		User user;
		try {
			 user = (User)session.getAttribute("user");		
			 address = customerService.getAddress(user);
			 payment =  customerService.getPayment(user);
		}
		catch(Exception e)
		{
			return "redirect:/logout";	
		}
		if(address.getId() != 0) { 
			
			// Put into Session.
			BoxItUserAddress boxitaddress = new BoxItUserAddress();
			boxitaddress.convert(address);
			System.out.println(boxitaddress);
			System.out.println("boxitaddress" + boxitaddress);
			session.setAttribute("address", boxitaddress);
			session.setAttribute("addressPrompt", "address_present");		
		}else
		{	
			BoxItUserAddress boxitaddress = new BoxItUserAddress();
			boxitaddress.setUser_id(user.getId());
			session.setAttribute("address", boxitaddress);
			// No address. Show prompt
			session.setAttribute("addressPrompt", "No address");
		}
		if(payment.getId() != 0) 
		{	
			BoxitPaymentDetails boxitpayment = new BoxitPaymentDetails();
			boxitpayment.convert(payment);
	
			// Put payment into Session
			session.setAttribute("payment_details", boxitpayment);
			session.setAttribute("paymentPrompt", "payment_present");
		}
		else
		{
			
			BoxitPaymentDetails boxitPayment = new BoxitPaymentDetails();
			boxitPayment.setUser_id(user.getId());
			
			session.setAttribute("payment_details", boxitPayment);
					
			// Put into prompt
			session.setAttribute("paymentPrompt", "No payment");
		}
		
		// Get Restaurants fpom the DAO
		List<Restaurant> restaurants = restaurantService.getRestaurants();
	
		// Add the restaurants to the model
		theModel.addAttribute("restaurants",restaurants);
		
		
		return "home";
	}
	
	 
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
		User_Address address;
		Payment_Details payment;
		User user;
		try {
			 user = (User)session.getAttribute("user");		
			 address = customerService.getAddress(user);
			 payment =  customerService.getPayment(user);
		}
		catch(Exception e)
		{
			return "redirect:/logout";	
		}
		if(address.getId() != 0) { 
			
			// Put into Session.
			BoxItUserAddress boxitaddress = new BoxItUserAddress();
			boxitaddress.convert(address);
			System.out.println(boxitaddress);
			System.out.println("boxitaddress" + boxitaddress);
			session.setAttribute("address", boxitaddress);
			session.setAttribute("addressPrompt", "address_present");		
		}else
		{	
			BoxItUserAddress boxitaddress = new BoxItUserAddress();
			boxitaddress.setUser_id(user.getId());
			session.setAttribute("address", boxitaddress);
			// No address. Show prompt
			session.setAttribute("addressPrompt", "No address");
		}
		if(payment.getId() != 0) 
		{	
			BoxitPaymentDetails boxitpayment = new BoxitPaymentDetails();
			boxitpayment.convert(payment);
	
			// Put payment into Session
			session.setAttribute("payment_details", boxitpayment);
			session.setAttribute("paymentPrompt", "payment_present");
		}
		else
		{
			
			BoxitPaymentDetails boxitPayment = new BoxitPaymentDetails();
			boxitPayment.setUser_id(user.getId());
			
			session.setAttribute("payment_details", boxitPayment);
					
			// Put into prompt
			session.setAttribute("paymentPrompt", "No payment");
		}
		
//		}
		return "my-profile";
	}
	
	@GetMapping("/my-payment")
	public String showMyPayment(
			HttpSession session,  
			Model theModel) {
		User user = (User)session.getAttribute("user");
		BoxitPaymentDetails payment = (BoxitPaymentDetails) session.getAttribute("payment_details");
		
		if(payment.getId() != 0) 
		{	
			theModel.addAttribute("payment_details", payment);
			theModel.addAttribute("payment_Prompt", "payment_present");
		}		
		else
		{
			BoxitPaymentDetails tempPayment = new BoxitPaymentDetails();
			tempPayment.setUser_id(user.getId());
			theModel.addAttribute("payment_details",tempPayment);
			theModel.addAttribute("payment_Prompt", "payment_not_present");
		}
		return "my-payment";
	}
	
	@GetMapping("/my-address")
	public String showMyAddress(
			HttpSession session,  
			Model theModel) {
		
		User user = (User)session.getAttribute("user");
		BoxItUserAddress address = (BoxItUserAddress)session.getAttribute("address");
		System.out.println("showMyAddress "+address);

		if(address.getId() != 0) 
		{	
			theModel.addAttribute("address", address);
			theModel.addAttribute("address_Prompt", "address_present");
		}		
		else
		{
			
			BoxItUserAddress tempAddress = new BoxItUserAddress();
		//	tempAddress.setUser_id(user.getId());
			
			theModel.addAttribute("address",tempAddress);
			theModel.addAttribute("address_Prompt", "address_not_present");
		}

		return "my-address";
	}
	
	@GetMapping("/my-profile")
	public String updateMyProfile(
			HttpSession session,  
			Model theModel) {
		User user = (User)session.getAttribute("user");
		System.out.println("My-Profile details :"+user.getFirstName());
		Payment_Details payment =  customerService.getPayment(user);
		if(payment.getId() != 0) 
			theModel.addAttribute("payment_details", payment);
		
		else
			theModel.addAttribute("payment_details", new BoxitPaymentDetails());

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
    	
    	
    

    	// Load Menu 
		List<Menu> allMenu = restaurantService.getAllMenu();
		theModel.addAttribute("allMenu",allMenu);
		
		
		return "show-menu";
	}
		
	@PostMapping("/step-3")
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
	
	@GetMapping("/place-order")
	public String placeOrder(HttpSession session,
			Model theModel) 
	{
		MyCart myCart = (MyCart)session.getAttribute("myCart");
    	Restaurant selectedRestaurant = (Restaurant)session.getAttribute("selectedRestaurant");
    	User user = (User)session.getAttribute("user");
    	
    	System.out.println("My Cart items are : "+myCart);
    	System.out.println("Selected Restaurant : "+selectedRestaurant);
    	System.out.println("The logged in user : "+user);
    	
   
      	Double total_value = 0.0;   	
    	for(Menu temp : myCart.getMyItems()) {
    			cart_items = temp.convertIntoCartItems(this.cart_items);
    			workspace.add(cart_items);
    			cart_list.add(cart_items);
    			total_value = total_value+ temp.getPrice();
    	} 
    	theModel.addAttribute("Total_Value", total_value);
    	
    	workspace.setCartItems(cart_list);  	
    	workspace.setRestaurant_id(selectedRestaurant.getId());
    	workspace.setCustomer_id(user.getId());
    	workspace.setStatus("ORDER PLACED");
    	workspace.setTotal_value(total_value);
    	
    	Date todayDate = new Date();
    	workspace.setDate(todayDate.toString());
    	
    	System.out.println("CART LIST" + cart_list);
    	customerService.creatWorkspace(workspace);
    //	customerService.addItems(cart_list);
    	
    	return "order_placed";
	}
		
	
	
}
