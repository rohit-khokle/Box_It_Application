package com.info6250.packages.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.info6250.packages.entities.User;
import com.info6250.packages.entities.Workspace;
import com.info6250.packages.service.WorkspaceService;

@Controller
public class GetOrderProgressAJAX {

	@Autowired
	private WorkspaceService workspaceService;
	@RequestMapping(value = "getStatus", method = RequestMethod.POST )
	public @ResponseBody Workspace getOrderStatus(HttpSession session,
			HttpServletRequest request, 
			HttpServletResponse response,
			Model theModel) {
		User user = (User)session.getAttribute("user");
    	long userid = user.getId();
    	System.out.println("get status controller called");

		// get current orders
		Workspace currentOrder = workspaceService.getCurrentOrder(user);	
		
		
		
		return currentOrder;	
		
		
		
	}
	
	
	
}
