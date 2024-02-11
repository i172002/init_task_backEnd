package com.example.demo.entity;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//mport jakarta.persistence.OneToOne;

@Entity
public class StateEntity {
  
	
    //@OneToOne(mappedBy = "state_id", cascade = CascadeType.ALL)
	@Id
	private int state_id;
    @Column(nullable = false) 
	private String state;
	private int isUnionTerritory; 
	public int getIsUnionTerritory() {
		return isUnionTerritory;
	}
	public void setIsUnionTerritory(int isUnionTerritory) {
		this.isUnionTerritory = isUnionTerritory;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "StateEntity [state_id=" + state_id + ", state=" + state + ", isUnionTerritory=" + isUnionTerritory
				+ "]";
	}
	
	
}
