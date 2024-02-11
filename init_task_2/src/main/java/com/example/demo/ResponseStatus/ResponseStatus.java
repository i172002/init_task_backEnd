package com.example.demo.ResponseStatus;

public class ResponseStatus {
	
	private String status;
	private String errorMsg;
	
	public ResponseStatus(String status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "ResponseStatus [status=" + status + ", errorMsg=" + errorMsg + "]";
	}
	
	
	
	
	

}
