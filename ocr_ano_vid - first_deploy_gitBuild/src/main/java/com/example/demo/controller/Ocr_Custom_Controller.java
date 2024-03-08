package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Response.Response;
import com.example.demo.service.Ocr_Custom_Service;

@RestController
public class Ocr_Custom_Controller {
	
	@Autowired
	Ocr_Custom_Service ocr_serv;
	
	LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    
	 @PostMapping("/ocr_ano_vid")
	 public ResponseEntity<Response> getImageToText(
			 										@RequestPart("image")MultipartFile image
//	 												@RequestParam ("GrayScale") boolean grayscale,
//	 												@RequestParam ("Threshold") boolean threshold,
//	 												@RequestParam ("Adaptive Threshold") boolean adaptiveThreshold
	 												)
	 {
		 System.out.println(image.getOriginalFilename());
	
		try {
            
			
			Response resp = ocr_serv.getImageToText(image);
			
			if(resp.getStatus() ==  200)
			     return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),resp.getResponse()),HttpStatus.OK);
			else
			     return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),resp.getStatusMsg()),HttpStatus.OK);
                 
           // return null;
		} catch (Exception e) {
			e.printStackTrace();
			//return null;
			return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),null),HttpStatus.OK);

		}      

	 }


      
}
