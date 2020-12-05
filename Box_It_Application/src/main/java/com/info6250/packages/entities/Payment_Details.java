package com.info6250.packages.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class Payment_Details {
	private long id;
	
	@NotNull(message = "is required")
	@Pattern(regexp = "^[A-Za-z]{3,50}$", message="Must only be alphabets and the name length can be between 3 and 50 characters")
	private String card_name;
	
	@NotNull(message = "is required")
	@Pattern(regexp = "^\\d{10}$", message="Must be only 10 digits")
	private String card_number;
	
	

	@NotNull(message = "is required")										// @Pattern(regexp = "^\\d{3}$", message="Must be only 3 digits")
	private String cvv;
	
	
	private String date;
	
	private long user_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
}
