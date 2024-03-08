package com.example.demo.Pojo;


public class ano_vid_pojo {
    
	public String aadharNo;
	public String vid;
	
	public ano_vid_pojo(String aadharNo, String vid) {
		super();
		this.aadharNo = aadharNo;
		this.vid = vid;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	@Override
	public String toString() {
		return "ano_vid_pojo [aadharNo=" + aadharNo + ", vid=" + vid + "]";
	}
	
	
	
    
}
