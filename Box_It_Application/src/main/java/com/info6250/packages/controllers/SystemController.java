package com.info6250.packages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/systems")
public class SystemController {


	@PostMapping("/new-restaurant")
	public String showHome() {
		return "new-restaurant";
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
