package com.example.demo.dto;

import java.time.LocalDate;

public class UserDTO {
	
	
    
	private String username;
    
	private String password;
    
	private String name;
	
    private String role_name;
    

    private String state_name;
    
    private String city_name;
    
    private LocalDate dob;
    
    private int pincode;
    
 
    
    private int status;
    
    private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", name=" + name + ", role_name="
				+ role_name + ", state_name=" + state_name + ", city_name=" + city_name + ", dob=" + dob + ", pincode="
				+ pincode + ", status=" + status + ", email=" + email + "]";
	}

	
    
    
    
    
	
		 
}
