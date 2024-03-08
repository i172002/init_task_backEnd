package com.example.demo.Pojo;



import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class ResponsePOJO {
	 public String requestId;
	 public ArrayList<Result> result = new ArrayList<>();
	@Override
	public String toString() {
		return "ResponsePOJO [requestId=" + requestId + ", result=" + result + "]";
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public ArrayList<Result> getResult() {
		return result;
	}
	public void setResult(ArrayList<Result> result) {
		this.result = result;
	}

}
