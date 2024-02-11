package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseStatus.ResponseStatus;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.response.Response;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")

public class UserController {
    
	@Autowired
	UserService userservice;
	
	LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	
	@PostMapping("/addUser")
	public ResponseEntity<Response> addUser(@RequestBody UserDTO user)
	{
		System.out.println("Enter the controller Layer");
		try {
			//Timestamp timestamp = Timestamp.from(Instant.now());
			if(user == null)
			{
				System.out.print("if user obj is null "+user);
				return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),user),HttpStatus.OK);

			}
			else{
			ResponseStatus resp =   (ResponseStatus) userservice.addUser(user);
			if((resp.getStatus()).equals("OK"))
			    return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),user),HttpStatus.OK);
			else
				return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),resp),HttpStatus.BAD_REQUEST);

			}
					
		}
		catch(Exception e) {
		    System.out.println(e.getMessage());
			System.out.print("in catch "+user);
            //state.setState("STATE NAME IS MISSING");
			return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),user),HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/getUsers")
	public Response getUsers()
	{
		
		List<UserDTO> resp = (List<UserDTO>) userservice.getUsers();
		return new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),resp);
	}
	
    @GetMapping("/getUserById/{uid}")
    public ResponseEntity<Response> getUser(@PathVariable("uid") int uid )
    {
    	Response resp = userservice.getUserById(uid);
    	
		return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),resp),HttpStatus.OK);

    	
//		if(resp.getStatus() ==  200) {
//			System.out.println("Inside ok");
//			
//			return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),resp.getResponse()),HttpStatus.OK);
//		}
//		else {
//			System.out.println("Inside error");
//			
//			return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),resp.getStatusMsg()),HttpStatus.BAD_REQUEST);
//			
//		}
    }
    
    
	
	 
}
