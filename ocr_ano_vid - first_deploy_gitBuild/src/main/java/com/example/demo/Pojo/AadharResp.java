package com.example.demo.Pojo;

import org.springframework.stereotype.Component;

@Component
public class AadharResp{

public String adhaar_mask_dms;
 public ResponsePOJO response;
@Override
public String toString() {
	return "AadharResp [adhaar_mask_dms=" + adhaar_mask_dms + ", response=" + response + "]";
}
public String getAdhaar_mask_dms() {
	return adhaar_mask_dms;
}
public void setAdhaar_mask_dms(String adhaar_mask_dms) {
	this.adhaar_mask_dms = adhaar_mask_dms;
}
public ResponsePOJO getResponse() {
	return response;
}
public void setResponse(ResponsePOJO response) {
	this.response = response;
}
}


