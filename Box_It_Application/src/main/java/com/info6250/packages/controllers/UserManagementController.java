package com.info6250.packages.controllers;


import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.info6250.packages.entities.Payment_Details;
import com.info6250.packages.entities.User;
import com.info6250.packages.entities.User_Address;
import com.info6250.packages.service.CustomerService;
import com.info6250.packages.service.UserService;
import com.info6250.packages.user.BoxItUserAddress;
import com.info6250.packages.user.BoxitPaymentDetails;

@Controller
@RequestMapping("/update")
public class UserManagementController {

	@Autowired
	CustomerService customerService;
	
	
	@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}	
	
		@PostMapping("/processPaymentDetailsForm")
		public String processPaymentForm(HttpSession session,
					@Valid @ModelAttribute("payment_details") BoxitPaymentDetails payment_details, 
					BindingResult theBindingResult, 
					Model theModel) {
	
			 if (theBindingResult.hasErrors()){
				 return "my-payment";
		        }

			 Payment_Details payment = new Payment_Details();
			 User user = (User) session.getAttribute("user");			 
			 payment.setId(payment_details.getId());
			 payment.setCard_name(payment_details.getCard_name());
			 payment.setCard_number(payment_details.getCard_number());
			 payment.setCvv(payment_details.getCvv());
			 payment.setUser_id(user.getId());
			 
			 
			 Date todaysDate = new Date();
			 payment.setDate(todaysDate.toLocaleString());
			 customerService.addPayment(payment);
			 
			theModel.addAttribute("show_alert", "Alright! Payment Details Updated");    
			session.setAttribute("payment_details", payment_details);
			
			return "my-profile";		
		}
		
		@PostMapping("/processAddressDetailsForm")
		public String processAddressForm(HttpSession session,
					@Valid @ModelAttribute("address") BoxItUserAddress address, 
					BindingResult theBindingResult, 
					Model theModel) {
	
			 if (theBindingResult.hasErrors()){
				 return "my-address";
		        }
			 
			 
			 User user = (User) session.getAttribute("user");
			 User_Address userAddress = new  User_Address();
			 
			 userAddress.setId(address.getId());
			 userAddress.setAddress(address.getAddress());
			 userAddress.setUser_id(user.getId());
			 userAddress.setUserName(address.getUserName());
			 userAddress.setZipCode(address.getZipCode());
			 userAddress.setContactInfo(address.getContactInfo());

			customerService.addAddress(userAddress);
			session.setAttribute("address", address);
			theModel.addAttribute("show_alert", "Hoorah! Address Details Updated"); 
	        return "my-profile";		

		}
	
	
		
	
	
}
