package com.info6250.packages.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.info6250.packages.validation.FieldMatch;




@FieldMatch.List(
		{@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
		})
public class BoxItUser {
	private long id;

	@NotNull(message = "is required")
	@Size(min = 1, message= "is required")
	private String userName;
	
	@NotNull(message = "is required")
	private String password;
	
	
	@NotNull(message = "is required")
	private String matchingPassword;
	
	
	@NotNull(message = "is required")
	@Size(min = 1, message= "is required")
	private String firstName;
	
	
	@NotNull(message = "is required")
	@Size(min = 1, message= "is required")
	private String lastName;
	
	
	
	@NotNull(message = "is required")
	private String email;

	
	@NotNull(message = "is required")
	private String role;
	
	@NotNull(message = "is required")
	private String restaurantName;


	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMatchingPassword() {
		return matchingPassword;
	}



	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getRestaurantName() {
		return restaurantName;
	}



	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}



	public BoxItUser() {
		
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	
	
	

}
