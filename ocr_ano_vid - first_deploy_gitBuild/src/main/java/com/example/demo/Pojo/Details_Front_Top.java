package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class Details_Front_Top {

	public Aadhaar aadhaar;
	 public Father father;
	 public Name name;
	 public ImageUrl imageUrl;
	
	public Details_Front_Top(Aadhaar aadhaar, Father father, Name name, ImageUrl imageUrl) {
		super();
		this.aadhaar = aadhaar;
		this.father = father;
		this.name = name;
		this.imageUrl = imageUrl;
	}
	public Aadhaar getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(Aadhaar aadhaar) {
		this.aadhaar = aadhaar;
	}
	public Father getFather() {
		return father;
	}
	public void setFather(Father father) {
		this.father = father;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public ImageUrl getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(ImageUrl imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Details_Front_Top [aadhaar=" + aadhaar + ", father=" + father + ", name=" + name + ", imageUrl="
				+ imageUrl + "]";
	}
	 
}
