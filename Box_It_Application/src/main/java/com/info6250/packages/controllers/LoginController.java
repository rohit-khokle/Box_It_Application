package com.info6250.packages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/BoxItLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}	
	
	@PostMapping(value = "/customerLogin")
	public String customerLoginPage() {
		return "customer-login";
	}
	
	@GetMapping("/register")
	public String showNewRegisterationPage() {
		return "customer-register";
	}
	
	
}
