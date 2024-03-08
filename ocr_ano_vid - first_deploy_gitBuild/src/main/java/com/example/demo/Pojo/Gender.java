package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class Gender {
	public String value;
	 public double conf;
	 
	 
	public Gender() {
		super();
	}
	public Gender(String value, double conf) {
		super();
		this.value = value;
		this.conf = conf;
	}
	@Override
	public String toString() {
		return "Gender [value=" + value + ", conf=" + conf + "]";
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
