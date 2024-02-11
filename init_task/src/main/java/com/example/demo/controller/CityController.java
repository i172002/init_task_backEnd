package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseStatus.ResponseStatus;
import com.example.demo.dto.CityDTO;
import com.example.demo.response.Response;
import com.example.demo.service.CityService;

@RestController
public class CityController {

	@Autowired
	CityService cityservice;
	LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	
	@PostMapping("/addCity")
	public ResponseEntity<Response> addCity(@RequestBody CityDTO city)
	{
		
		try {
			if(city == null)
			{
				System.out.print("if city obj is null "+ city);
				return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),city),HttpStatus.OK);

			}
			else{
			ResponseStatus resp =   (ResponseStatus) cityservice.addCity(city);
			if((resp.getStatus()).equals("OK"))
			    return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),city),HttpStatus.OK);
			else
				return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),resp),HttpStatus.BAD_REQUEST);

			}
					
		}
		catch(Exception e) {
		    System.out.println("This is error message "+e.getMessage());
			System.out.print("in catch "+city);
            //state.setState("STATE NAME IS MISSING");
			return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),city),HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/getCities")
	public Response getCities()
	{
		List<CityDTO> resp = (List<CityDTO>) cityservice.getCities();
		return new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),resp);
	}
	
	
	
	
}
