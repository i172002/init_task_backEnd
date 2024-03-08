package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class Qr {
	 public String value;
     
	public Qr() {
		super();
	}

	public Qr(String value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "Qr [value=" + value + "]";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
