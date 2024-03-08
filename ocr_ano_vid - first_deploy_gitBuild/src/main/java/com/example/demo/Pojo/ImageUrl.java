package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class ImageUrl {
  public String value;
  
  

public ImageUrl() {
	super();
}

public ImageUrl(String value) {
	super();
	this.value = value;
}

@Override
public String toString() {
	return "ImageUrl [value=" + value + "]";
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}
}
