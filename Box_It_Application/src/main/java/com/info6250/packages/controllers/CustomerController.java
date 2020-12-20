package com.info6250.packages.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info6250.packages.entities.Cart_items;
import com.info6250.packages.entities.Menu;
import com.info6250.packages.entities.Payment_Details;
import com.info6250.packages.entities.Restaurant;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.User_Address;
import com.info6250.packages.entities.Workspace;
import com.info6250.packages.service.CustomerService;
import com.info6250.packages.service.RestaurantService;
import com.info6250.packages.service.UserService;
import com.info6250.packages.service.WorkspaceService;
import com.info6250.packages.user.BoxItEmployee;
import com.info6250.packages.user.BoxItUser;
import com.info6250.packages.user.BoxItUserAddress;
import com.info6250.packages.user.BoxitPaymentDetails;

/**
 * @author Rohit
 *
 */
@Controller
@RequestMapping("/my-box-it")
public class CustomerController {
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private WorkspaceService workspaceService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String showCustomerWorkspace( HttpSession session,  @ModelAttribute("pageCount") Integer pageNumber ,  Model theModel) {
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
			return "redirect:/BoxItLoginPage";	
		}
		if(address.getId() != 0) { 
			
			// Put into Session.
			BoxItUserAddress boxitaddress = new BoxItUserAddress();
			boxitaddress.convert(address);

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
	//	List<Restaurant> restaurants = restaurantService.getRestaurants();
		
		
		// Pagination
		System.out.println("Page count : "+ pageNumber);	
		List<Restaurant> restaurants = restaurantService.getRestaurantNamesPagnination(pageNumber);
		Long count = restaurantService.getRestaurantCountPagnination();
		
		
		
		// Add the restaurants to the model
		theModel.addAttribute("restaurants",restaurants);
		theModel.addAttribute("pageNumber",pageNumber);		
		theModel.addAttribute("restaurantsCount",count);
		
		
		
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

		if(address.getId() != 0) { 
			
			// Put into Session.
			BoxItUserAddress boxitaddress = new BoxItUserAddress();
			boxitaddress.convert(address);
			session.setAttribute("address", boxitaddress);
			session.setAttribute("addressPrompt", "address_present");		
		}else
		{	
			BoxItUserAddress boxitaddress = new BoxItUserAddress();
			boxitaddress.setUser_id(user.getId());
			session.setAttribute("address", boxitaddress);
			// No address. Show prompt
			session.setAttribute("addressPrompt", "no_address");
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
			session.setAttribute("paymentPrompt", "no_payment");
		}
		
		}
		catch(Exception e)
		{
			return "redirect:/BoxItLoginPage";	
		}
		return "my-profile";
	}
	
	@GetMapping("/my-payment")
	public String showMyPayment(
			HttpSession session,  
			Model theModel) {
		User user = (User)session.getAttribute("user");
		

		Payment_Details paymentDetails =  customerService.getPayment(user);		
		BoxitPaymentDetails payment =  new BoxitPaymentDetails();   //(BoxitPaymentDetails) session.getAttribute("payment_details");
		payment.convert(paymentDetails);
		
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
		
		
		User_Address addressDetails = customerService.getAddress(user);
		BoxItUserAddress address = new BoxItUserAddress();    //(BoxItUserAddress)session.getAttribute("address");
		address.convert(addressDetails);

		
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
	
	
	/*
	@GetMapping("/add-into-cart")
	public String addIntoCart( HttpSession session,	 HttpServletResponse  response,		
	//		@ModelAttribute("checkCart") List<Cart_items> cartList,
			@ModelAttribute("checkCart") MyCart checkCart,
//			@ModelAttribute("restaurantID") int theId,
			@ModelAttribute("menuID") int theMenuId, 
			Model theModel) {	
				
    	Menu selectedItem = restaurantService.getMenu(theMenuId);
   // 	cartList.add(selectedItem.convertIntoCartItems(new Cart_items())); // 
    	checkCart.addItemInCart(selectedItem);
    	 
    	if(session.getAttribute("checkCart") != null) {
    		MyCart currentCart = (MyCart) session.getAttribute("checkCart");
    	//	List<Cart_items> currentCart = (List<Cart_items>) session.getAttribute("checkCart");
        	
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
   
    	
    	// Show Alert Prompt
    	theModel.addAttribute("promptThis", selectedItem);
    	
    	
    

    	// Load Menu 
		List<Menu> allMenu = restaurantService.getAllMenu();
		theModel.addAttribute("allMenu",allMenu);
		
		
		return "show-menu";
	}
		*/
	
	
	
	@GetMapping("/add-into-cart")
	public String addIntoCart( HttpSession session,	 HttpServletResponse  response,		
			@ModelAttribute("checkCart") Workspace checkCart,
        	@ModelAttribute("menuID") int theMenuId, 
			Model theModel) {	
				
    	Menu selectedItem = restaurantService.getMenu(theMenuId);
    	 
    	if(session.getAttribute("checkCart") != null) {
    		Workspace currentCart = (Workspace) session.getAttribute("checkCart");
    		currentCart.add(selectedItem.convertIntoCartItems(new Cart_items()));
        	session.setAttribute("checkCart", currentCart);
    		
    	}
    	else
    	{
    		Cart_items item = selectedItem.convertIntoCartItems(new Cart_items());
    		item.setQuantity(1);		
    		checkCart.add(selectedItem.convertIntoCartItems(new Cart_items()));  // addItemInCart(selectedItem);
    		session.setAttribute("checkCart", checkCart);
    	}
    	 	
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
		Workspace myCart = (Workspace)session.getAttribute("myCart");
		
		Restaurant selectedRestaurant = (Restaurant)session.getAttribute("selectedRestaurant");
//		System.out.println("My Restaurant : "+selectedRestaurant);	
		theModel.addAttribute("restaurant",selectedRestaurant);
		
			
		return "checkout";
	}
	/*
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
	*/

	
	@GetMapping("/refresh-cart")
	public String removeFromCart(HttpSession session,	 
			HttpServletResponse  response,		
			@ModelAttribute("restaurant") Restaurant restaurant,
			@ModelAttribute("menuID") int theMenuId, 
			Model theModel) 
	{
		Workspace myCart = (Workspace)session.getAttribute("myCart");
    	
		Menu selectedItem = restaurantService.getMenu(theMenuId);
		myCart.removeFromCart(selectedItem.convertIntoCartItems(new Cart_items()));	
      	session.setAttribute("restaurant", restaurant);
      	session.setAttribute("myCart", myCart);
		return "checkout";
	}
	
	
	
	@GetMapping("/place-order")
	public String placeOrder(HttpSession session,
			Model theModel) 
	{
		Workspace myCart = (Workspace)session.getAttribute("myCart");
    	Restaurant selectedRestaurant = (Restaurant)session.getAttribute("selectedRestaurant");
    	User user = (User)session.getAttribute("user");
    	
    	System.out.println("My Cart items are : "+myCart);
    	System.out.println("Selected Restaurant : "+selectedRestaurant);
    	System.out.println("The logged in user : "+user);
    	
    	if(myCart != null) {
	    	try {
		    	// Fill in workspace object..    	
		    	myCart.setRestaurant_id(selectedRestaurant.getId());
		    	Restaurant theRestaurant = (Restaurant)session.getAttribute("selectedRestaurant");
		    	myCart.setRestaurantName(theRestaurant.getName());
		    	myCart.setCustomer_id(user.getId());
		    	myCart.setWorkspaceRequest("");
		    	myCart.setWorkspaceResponse("");
		    	myCart.setStatus("ORDER PLACED"); 	
	    	}
	    	catch(Exception e) {
	    		return "redirect:/BoxItLoginPage";		
	    	}
    	}
    	else {
    		
    		theModel.addAttribute("restaurantID", selectedRestaurant.getId());
    		return "redirect:/my-box-it/step-2";
    	}
    	
    	
    	
      	Double total_value = 0.0;   	
      	for(Cart_items temp : myCart.getCartItems()) {
     		total_value = total_value+ temp.getPrice();
    	}

      	
      	
      	myCart.setTotal_value(total_value);
 
      	if(myCart.getTotal_value() == 0.0) {
      		theModel.addAttribute("restaurantID", selectedRestaurant.getId());
      		theModel.addAttribute("emptyCart", "emptyCart");
    		return "redirect:/my-box-it/step-2";
    		
      		
      	}
      	Date todayDate = new Date();
      	myCart.setDate(todayDate.toString());
 
      	
 		theModel.addAttribute("emptyCart", "emptyCart");
    	theModel.addAttribute("Total_Value", total_value);
    	
    	
    	
    	BoxItUserAddress address = (BoxItUserAddress)session.getAttribute("address");
    	BoxitPaymentDetails payment = (BoxitPaymentDetails)session.getAttribute("payment_details");
    	
    	if((address.getId() != 0) && (payment.getId() != 0))
    			{
    				customerService.createWorkspace(myCart);
    				return "redirect:/my-box-it/my-orders";
    			}
    	else {
    		session.setAttribute("warningPrompt", 1);  
    		return "redirect:/my-box-it/my-profile";	
    	}
	}
		
	@GetMapping("/my-orders")
	public String goToOrders(HttpSession session,
			Model theModel) {
		User user;
		try {
	    	user = (User)session.getAttribute("user");
    		long userid = user.getId();
    	}
    	catch(Exception e) {
    		return "redirect:/BoxItLoginPage";		
    	}
		
		// get current orders
		List<Workspace> currentOrders = workspaceService.getCurrentOrders(user);
		
		// get past history
		List<Workspace> allOrders =workspaceService.getAllOrders(user);
		
		theModel.addAttribute("currentOrders", currentOrders);
		theModel.addAttribute("allOrders", allOrders);		
		
		return "my-orders";
	}	

	@GetMapping("/checkOrder")
	public String checkOrderItems(HttpSession session,
			Model theModel) {
		User user;
		try {
	    	user = (User)session.getAttribute("user");
    		long userid = user.getId();
    	}
    	catch(Exception e) {
    		return "redirect:/BoxItLoginPage";		
    	}
		
		// get current orders
		List<Workspace> currentOrders = workspaceService.getCurrentOrders(user);	
		// get past history
		List<Workspace> allOrders =workspaceService.getAllOrders(user);
				
		theModel.addAttribute("currentOrders", currentOrders);
		theModel.addAttribute("allOrders", allOrders);		
		
		return "my-orders";
	}	
	
	@GetMapping("/my-cart")
	public String checkOrder(HttpSession session, 
			@ModelAttribute("orderID") int checkCartId
			,Model theModel) {
		
		User user = (User)session.getAttribute("user");
		try {
			if(workspaceService.checkValidity(user.getId(), checkCartId))
			{
				
				
				List<Cart_items> theCart =workspaceService.getMyCart(checkCartId);
				
				Workspace theWorkspace = (Workspace) 
						workspaceService.getWorkspace(checkCartId);
				
		//		Cart_items oneCartItem = theCart.get(0);
		//		Workspace workspace = oneCartItem.getWorkspace_id();
				Restaurant theRestaurant = restaurantService.getRestaurant(theWorkspace.getRestaurant_id());
				theModel.addAttribute("currentCart", theCart);
				theModel.addAttribute("currentRestaurant", theRestaurant);
				
				return "my-cart";
			}
			else 
				return "access-denied";	
		}
		catch(Exception e)
		{
			
			return "/home";
		}

	}
	
	
	
	@RequestMapping(value = "getStatus", method = RequestMethod.GET )
	public @ResponseBody String getOrderStatus(HttpSession session, 
			Model theModel) {
		
		User user = (User)session.getAttribute("user");
    	long userid = user.getId();
    	System.out.println("get status controller called");

		// get current orders
		Workspace currentOrder = workspaceService.getCurrentOrder(user);	
		
		if(currentOrder.getStatus() != null) {
		
				
				
				if(currentOrder.getStatus().equalsIgnoreCase("order placed")) {
					
					return "Hooray! Order is placed. Waiting for order to be accepted.";
					
				}
		
				if(currentOrder.getStatus().equalsIgnoreCase("DECLINED")) {
					
					return "Oh no! Order was declined. We are sorry.";
					
				}
				
				if(currentOrder.getStatus().equalsIgnoreCase("DELIVERED")) {
					
					return "Box-it was delivered! Yum! Yum!";
					
				}
				
				if(currentOrder.getStatus().equalsIgnoreCase("PREP")) {
					
					return "Our Master Chef's working on it!";
					
				}
				
				if(currentOrder.getStatus().equalsIgnoreCase("ACCEPTED")) {
					
					return "Yes! Order is Accepted!";
					
				}
				
				if(currentOrder.getStatus().equalsIgnoreCase("en route")) {
					
					return "Box-it is on the way!";
					
				}
				if(currentOrder.getStatus().equalsIgnoreCase("Boxed-it")) {
							return "Boxed and ready for pick up!";
				}
				if(currentOrder.getStatus().equalsIgnoreCase("Picked")) {
					return "Picked up! AWESOME!";	
				}
		}	
		return "Uhm...we don't have any order yet.";			
	}

	
	/*
	 *  Update Profile
	 * 
	 * 
	 */
	
	
	@GetMapping("/update-profile")
	public String showStaffForUpdate(HttpSession session, Model theModel) {
		
		User user;
		long userid = 0;
		try {
	    	user = (User)session.getAttribute("user");
    		userid = user.getId();
    	}
    	catch(Exception e) {
    		return "redirect:/BoxItLoginPage";		
    	}
		
		// Get the restaurant from the service
		User theUser = userService.getUserById(userid);
		
		//  Set restaurant
		BoxItUser theBoxItUser = new BoxItUser();
	//	BoxItEmployee theBoxItUser = new BoxItEmployee();
		
		theBoxItUser.setId(theUser.getId());
		theBoxItUser.setEmail(theUser.getEmail());
		theBoxItUser.setFirstName(theUser.getFirstName());
		theBoxItUser.setLastName(theUser.getLastName());
		theBoxItUser.setPassword(theUser.getPassword());
		theBoxItUser.setRestaurantName(theUser.getRestaurantName());
		theBoxItUser.setRole("customer");
		theBoxItUser.setUserName(theUser.getUserName());
		
		
		
		theModel.addAttribute("crmUser", theBoxItUser);
	//	theModel.addAttribute("id", theUser.getId());
	
		
		return "customer-update-form";
	}
	
	
	@PostMapping("/processUpdateForm")
	public String updateStaff(//@Valid @ModelAttribute("crmUser") BoxItUser theCrmUser,
			@Valid @ModelAttribute("crmUser") BoxItUser theCrmUser,
			BindingResult theBindingResult, 
			Model theModel) {
		
		String userName = theCrmUser.getUserName();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 return "customer-update-form";
	        }
	
		theCrmUser.setRole("customer");
	    userService.update(theCrmUser); // save(theCrmUser); // saveStaff(theCrmUser);
				
		return "redirect:/my-box-it/my-Profile";		
		
	}
	
	
	
}
