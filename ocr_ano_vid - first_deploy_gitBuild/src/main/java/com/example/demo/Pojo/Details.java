package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class Details {
	 public Aadhaar aadhaar;
	 public Father father;
	 public Name name;
	 public ImageUrl imageUrl;
	 public Dob dob;
	 public Gender gender;	
	 public Mother mother;
	 public Yob yob;
	 public Qr qr;
	 
	 
	public Details(Aadhaar aadhaar, Father father, Name name, ImageUrl imageUrl) {
		super();
		this.aadhaar = aadhaar;
		this.father = father;
		this.name = name;
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Details [aadhaar=" + aadhaar + ", father=" + father + ", name=" + name + ", imageUrl=" + imageUrl
				+ ", dob=" + dob + ", gender=" + gender + ", mother=" + mother + ", yob=" + yob + ", qr=" + qr + "]";
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
	public Dob getDob() {
		return dob;
	}
	public void setDob(Dob dob) {
		this.dob = dob;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Mother getMother() {
		return mother;
	}
	public void setMother(Mother mother) {
		this.mother = mother;
	}
	public Yob getYob() {
		return yob;
	}
	public void setYob(Yob yob) {
		this.yob = yob;
	}
	public Qr getQr() {
		return qr;
	}
	public void setQr(Qr qr) {
		this.qr = qr;
	}
}
