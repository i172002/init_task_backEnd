package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class Aadhaar {
	 
	 public String value;
	 public double conf;
	 public String isMasked;
	 public String isHidden;
	 public Aadhaar() {
		 
	 }
	 
	 public Aadhaar(String value, double conf, String isMasked, String isHidden) {
			super();
			this.value = value;
			this.conf = conf;
			this.isMasked = isMasked;
			this.isHidden = isHidden;
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
	public String getIsMasked() {
		return isMasked;
	}
	public void setIsMasked(String isMasked) {
		this.isMasked = isMasked;
	}
	public String getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(String isHidden) {
		this.isHidden = isHidden;
	}
	@Override
	public String toString() {
		return "Aadhaar [value=" + value + ", conf=" + conf + ", isMasked=" + isMasked + ", isHidden=" + isHidden + "]";
	}
}
