package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class Yob {
	public String value;
	 public int conf;
	 
	 
	public Yob() {
		super();
	}
	public Yob(String value, int conf) {
		super();
		this.value = value;
		this.conf = conf;
	}
	@Override
	public String toString() {
		return "Yob [value=" + value + ", conf=" + conf + "]";
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getConf() {
		return conf;
	}
	public void setConf(int conf) {
		this.conf = conf;
	}
}
