package com.example.demo.dto;

public class CityDTO {
	
	private int city_id;
	private String city;
	private String state_name;
	
	
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	@Override
	public String toString() {
		return "CityDTO [city_id=" + city_id + ", city=" + city + ", state_name=" + state_name + "]";
	}
	
	
	

}
