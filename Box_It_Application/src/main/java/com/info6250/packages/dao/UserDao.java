package com.info6250.packages.dao;

import com.info6250.packages.entities.User;

public interface UserDao {

	User findByUserName(String userName);
	
	void save(User user);	
	
	User getUserById(Long id);

	void deleteStaff(long theId);
	
}
