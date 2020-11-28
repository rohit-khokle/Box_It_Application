package com.info6250.packages.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.info6250.packages.entities.User;
import com.info6250.packages.user.BoxItUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);
	void save(BoxItUser boxItUser);
	
}
