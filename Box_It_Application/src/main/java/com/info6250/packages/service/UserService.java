package com.info6250.packages.service;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.info6250.packages.entities.User;
import com.info6250.packages.user.BoxItEmployee;
import com.info6250.packages.user.BoxItUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);
	void save(BoxItUser boxItUser);
	void saveStaff(BoxItUser boxItUser);
	void saveStaff(BoxItEmployee boxItUser);
	User getUserById(Long id);
	void deleteStaff(long theId);
	void update(BoxItUser theCrmUser);
}
