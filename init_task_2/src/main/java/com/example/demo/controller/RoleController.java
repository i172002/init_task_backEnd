package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseStatus.ResponseStatus;
import com.example.demo.entity.RoleEntity;
import com.example.demo.response.Response;
import com.example.demo.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	RoleService roleservice;
	LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	@PostMapping("/addRole")
	public ResponseEntity<Response> addState(@RequestBody RoleEntity role)
	{
		try {
			//Timestamp timestamp = Timestamp.from(Instant.now());
			if(role == null)
			{
				System.out.print("if state obj is null "+role);
				return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),role),HttpStatus.OK);

			}
			else{
			ResponseStatus resp =   (ResponseStatus) roleservice.addRole(role);
			if((resp.getStatus()).equals("OK"))
			    return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),role),HttpStatus.OK);
			else
				return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),resp),HttpStatus.BAD_REQUEST);

			}
					
		}
		catch(Exception e) {
		    System.out.println(e.getMessage());
			System.out.print("in catch "+role);
            //state.setState("STATE NAME IS MISSING");
			return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),role),HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/getRoles")
	public Response getStates()
	{
		List<RoleEntity> resp = (List<RoleEntity>) roleservice.getRoles();
		return new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),resp);
	}
	
	
	@GetMapping("/getRoleById/{role_id}")
	public Response getRoleById(@PathVariable("role_id") int role_id)
	{
		try {
		Response resp = roleservice.getRoleById(role_id);
		if(resp.getStatus() ==  200) {
			System.out.println("Inside OK"+role_id);
			return new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),resp.getResponse());
		}
		else {
			System.out.println("Inside error"+role_id);
			return new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),resp.getStatusMsg());
			
		}}catch(Exception e)
		{
			System.out.println("Controller Catch"+e.getMessage());
			return null;
		}
		


	}
	


}
