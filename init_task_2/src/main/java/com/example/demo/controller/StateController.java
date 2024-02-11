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
import com.example.demo.dto.StateDTO;
import com.example.demo.entity.StateEntity;
import com.example.demo.response.Response;
import com.example.demo.service.StateService;

@RestController
//@CrossOrigin("http://localhost:3000")
@CrossOrigin("http://192.168.56.1:3000")
public class StateController {
	
	@Autowired
	StateService stateservice;
	
	LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	
	@PostMapping("/addState")
	public ResponseEntity<Response> addState(@RequestBody StateDTO state)
	{
		try {
			//Timestamp timestamp = Timestamp.from(Instant.now());
			if(state == null)
			{
				System.out.print("if state obj is null "+state);
				return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),state),HttpStatus.OK);

			}
			else{
			ResponseStatus resp =   (ResponseStatus) stateservice.addState(state);
			if((resp.getStatus()).equals("OK"))
			    return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),state),HttpStatus.OK);
			else
				return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),resp),HttpStatus.BAD_REQUEST);

			}
					
		}
		catch(Exception e) {
		    System.out.println(e.getMessage());
			System.out.print("in catch "+state);
            //state.setState("STATE NAME IS MISSING");
			return new ResponseEntity<>(new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),state),HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/getStates")
	public Response getStates()
	{
		List<StateDTO> resp = (List<StateDTO>) stateservice.getStates();
		return new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),resp);
	}
	
	@GetMapping("/getStateById/{state_id}")
	public Response getStateById(@PathVariable("state_id") int state_id)
	{
		try {
		Response resp = stateservice.getStateById(state_id);
		if(resp.getStatus() ==  200) {
			System.out.println("Inside OK "+state_id);
			if(resp.getResponse() instanceof Object)
			System.out.println("resp.getResponse is the Object" );
			StateEntity response_state = (StateEntity) resp.getResponse();
			return new Response(formattedDateTime,HttpStatus.OK.value(),HttpStatus.OK.toString(),response_state);
		}
		else {
			System.out.println("Inside error"+state_id);
			return new Response(formattedDateTime,HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),resp.getStatusMsg());
			
		}}catch(Exception e)
		{
			System.out.println("Controller Catch"+e.getMessage());
			return null;
		}
		


	}
	
	

}
