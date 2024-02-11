	package com.example.demo.entity;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;


	@Entity
	public class CityEntity {

	    @Id	
	    //@OneToOne(mappedBy = "city_id", cascade = CascadeType.ALL)
		private int city_id;
	    @Column(nullable = false) 

		private String city;
		@ManyToOne
		@JoinColumn(name = "state_id")
		private StateEntity state_id;
		
		public StateEntity getState_id() {
			return state_id;
		}
		public void setState_id(StateEntity state_id) {
			this.state_id = state_id;
		}
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
		@Override
		public String toString() {
			return "CityEntity [city_id=" + city_id + ", city=" + city + ", state_id=" + state_id + "]";
		}
		
	}

