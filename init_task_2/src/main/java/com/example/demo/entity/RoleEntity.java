package com.example.demo.entity;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;

@Entity
public class RoleEntity {
	
	@Id
    //@OneToOne(mappedBy = "role_id", cascade = CascadeType.ALL)

	private int role_id;
    @Column(nullable = false) 

	private String role;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "RoleEntity [role_id=" + role_id + ", role=" + role + "]";
	}  
	

}
