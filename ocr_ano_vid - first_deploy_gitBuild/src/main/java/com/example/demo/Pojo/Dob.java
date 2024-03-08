package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class Dob {
	public String value;
	 public double conf;
	 
	 
	public Dob() {
		super();
	}
	public Dob(String value, double conf) {
		super();
		this.value = value;
		this.conf = conf;
	}
	@Override
	public String toString() {
		return "Dob [value=" + value + ", conf=" + conf + "]";
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public double getConf() {
		return conf;
	}
	public void setConf(double conf) {
		this.conf = conf;
	}
}
