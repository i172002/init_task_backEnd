package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class Result {
	 public Object details;
	 public String type;
	@Override
	public String toString() {
		return "Result [details=" + details + ", type=" + type + "]";
	}
	public Object getDetails() {
		return details;
	}
	public void setDetails(Object obj) {
		this.details = obj;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
