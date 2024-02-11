package com.example.demo.dto;

import jakarta.persistence.Id;

public class StateDTO {
	
	
	@Id
	private int state_id;
	private String state;
	private String isUnionTerritory;
	
	
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
	
	public String getIsUnionTerritory() {
		return isUnionTerritory;
	}
	public void setIsUnionTerritory(String isUnionTerritory) {
		this.isUnionTerritory = isUnionTerritory;
	}
	@Override
	public String toString() {
		return "StateDTO [state_id=" + state_id + ", state=" + state + ", isUnionTerritory=" + isUnionTerritory + "]";
	}
	

}
