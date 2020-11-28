package com.info6250.packages.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info6250.packages.dao.UserDao;
import com.info6250.packages.entities.Role;
import com.info6250.packages.entities.User;
import com.info6250.packages.user.BoxItUser;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");	
		}
		
		
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), 
				mapRolesToAuthorities(user.getRoles()));
	}

	@Override
	@Transactional
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(BoxItUser boxItUser) {
		
		User user = new User();
		user.setUserName(boxItUser.getUserName());
		user.setPassword(passwordEncoder.encode(boxItUser.getUserName()));
		user.setFirstName(boxItUser.getFirstName());
		user.setLastName(boxItUser.getLastName());
		user.setEmail(boxItUser.getEmail());
		if(boxItUser.getRole().equals("customer"))
			user.setRoles(Arrays.asList(new Role("ROLE_CUSTOMER")));
		else
			user.setRoles(Arrays.asList(new Role("ROLE_EMPLOYEE")));
		userDao.save(user);

	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	

}
