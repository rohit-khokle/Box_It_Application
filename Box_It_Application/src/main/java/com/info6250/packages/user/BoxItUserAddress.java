package com.info6250.packages.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.info6250.packages.entities.User_Address;



public class BoxItUserAddress {
	private long id;

	@NotNull(message = "is required")
	@Pattern(regexp = "^[A-Za-z]{3,50}$", message="Must only be alphabets and the name length can be between 3 and 50 characters")
	private String userName;

	
	@NotNull(message = "is required")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$", message="Only alphanumeric values accepted")
	private String address;
	
	@NotNull(message = "is required")
	@Pattern(regexp = "^^\\d{5}$", message="Must be five digit")
	private String zipCode;
	
	
	@NotNull(message = "is required")	
	@Pattern(regexp = "^^\\d{10}$", message="Must be ten digit")
	private String contactInfo;
	
	
	@NotNull(message = "is required")	
	private long user_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}


	public void convert(User_Address address) {
		this.user_id = address.getUser_id();
		this.id =  address.getId();
		this.address =  address.getAddress();
		this.zipCode =   address.getZipCode();
		this.contactInfo =  address.getContactInfo();
		this.userName =  address.getUserName();
		
	}

	@Override
	public String toString() {
		return "BoxItUserAddress [id=" + id + ", userName=" + userName + ", address=" + address + ", zipCode=" + zipCode
				+ ", contactInfo=" + contactInfo + ", user_id=" + user_id + ", getId()=" + getId() + ", getUserName()="
				+ getUserName() + ", getAddress()=" + getAddress() + ", getZipCode()=" + getZipCode()
				+ ", getUser_id()=" + getUser_id() + ", getContactInfo()=" + getContactInfo();
	}
}


