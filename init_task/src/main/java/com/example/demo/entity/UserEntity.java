package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    @Column(nullable = false) 
	private String username;
    @Column(nullable = false) 
	private String password;
    @Column(nullable = false) 
	private String name;
    @Column(nullable = false) 
    private String email;
    

	@ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role_id;
    
    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateEntity state_id;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city_id;
    @Column(nullable = false) 
    private LocalDate dob;
    @Column(nullable = false) 
    private int pincode;
    @Column(nullable = false) 
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime created_date;
    @Column(nullable = false) 
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime modified_date;
    @Column(nullable = false) 
    private int status;
    
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
	public CityEntity getCity_id() {
		return city_id;
	}
	public void setCity_id(CityEntity city_id) {
		this.city_id = city_id;
	}
	public void setRole_id(RoleEntity role_id) {
		this.role_id = role_id;
	}
	public void setState_id(StateEntity state_id) {
		this.state_id = state_id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public LocalDateTime getModified_date() {
		return modified_date;
	}
	public void setModified_date(LocalDateTime modified_date) {
		this.modified_date = modified_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public RoleEntity getRole_id() {
		return role_id;
	}
	public StateEntity getState_id() {
		return state_id;
	}
	@Override
	public String toString() {
		return "UserEntity [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", role_id=" + role_id + ", state_id=" + state_id + ", city_id=" + city_id
				+ ", dob=" + dob + ", pincode=" + pincode + ", status=" + status + "]";
	}

	
	
	
		 
}
