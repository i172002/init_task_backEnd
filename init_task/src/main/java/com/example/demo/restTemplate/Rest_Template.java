package com.example.demo.restTemplate;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CityEntity;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.StateEntity;
import com.example.demo.response.Response;
import com.example.demo.response.Response1;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Rest_Template {
	
	RestTemplate restTemplate = new RestTemplate();  //RestTemplte Object Creation


	
	public Response getStateByIdApiCalling (String url) {
		try {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    
	    HttpEntity<String> entity = new HttpEntity<String>("parameters",headers); 
	    
//	    ObjectMapper om =new ObjectMapper();
//	    System.out.println("This is op of OM"+om.writeValueAsString(entity));
	    
//	    ResponseEntity<Response> resp = restTemplate.exchange(url,HttpMethod.GET,entity,Response.class);
	    Response1 resp = restTemplate.getForObject(url,Response1.class);
	    System.out.println("inside the RestTemplate"+resp);

	    //System.out.println("This is the op of "+om.writeValueAsString(resp));
//	    String responseValue = "";
//	    try {
//	        ObjectMapper objectMapper = new ObjectMapper();
//	        JsonNode rootNode = objectMapper.readTree(responseBody);
//	        JsonNode responseNode = rootNode.get("response");
//	        if (responseNode != null) {
//	            responseValue = responseNode.asText();
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace(); // Handle parsing exception gracefully
//	    }
		//return new Response(200,"State Found", res_state_entity.getState());
	    
	    
	    return new Response(200,"State Found",resp.getResponse());

		
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("In catch Rest_Template "+ e);
            return new Response(404,"Error",e.getMessage());																		 //and we can give that as reply
			                                                                 //Sample e.getMessage(): "{"timestamp":"2024-02-09 00:29:29","status":400,"statusMsg":"400 BAD_REQUEST","response":"State Not Found"}"
		}
		
	}
	
	public Response getCityByIdApiCalling (String url) {
		try {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    
	    HttpEntity<String> entity = new HttpEntity<String>("parameters",headers); 
	    
//	    ObjectMapper om =new ObjectMapper();
//	    System.out.println("This is op of OM"+om.writeValueAsString(entity));
	    
//	    ResponseEntity<Response> resp = restTemplate.exchange(url,HttpMethod.GET,entity,Response.class);
	    Response1 resp = restTemplate.getForObject(url,Response1.class);
	    System.out.println("inside the RestTemplate"+resp);

	    //System.out.println("This is the op of "+om.writeValueAsString(resp));
//	    String responseValue = "";
//	    try {
//	        ObjectMapper objectMapper = new ObjectMapper();
//	        JsonNode rootNode = objectMapper.readTree(responseBody);
//	        JsonNode responseNode = rootNode.get("response");
//	        if (responseNode != null) {
//	            responseValue = responseNode.asText();
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace(); // Handle parsing exception gracefully
//	    }
		//return new Response(200,"State Found", res_state_entity.getState());
	    
	    
	    return new Response(200,"City Found",resp.getResponse());

		
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("In catch Rest_Template "+ e);
            return new Response(404,"Error",e.getMessage());																		 //and we can give that as reply
			                                                                 //Sample e.getMessage(): "{"timestamp":"2024-02-09 00:29:29","status":400,"statusMsg":"400 BAD_REQUEST","response":"State Not Found"}"
		}
		
	}

	public Response getRoleByIdApiCalling(String url) {
		try {
			HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    
		    HttpEntity<String> entity = new HttpEntity<String>("parameters",headers); 
		    
//		    ObjectMapper om =new ObjectMapper();
//		    System.out.println("This is op of OM"+om.writeValueAsString(entity));
		    
//		    ResponseEntity<Response> resp = restTemplate.exchange(url,HttpMethod.GET,entity,Response.class);
		    Response1 resp = restTemplate.getForObject(url,Response1.class);
		    System.out.println("inside the RestTemplate "+resp);

		    //System.out.println("This is the op of "+om.writeValueAsString(resp));
//		    String responseValue = "";
//		    try {
//		        ObjectMapper objectMapper = new ObjectMapper();
//		        JsonNode rootNode = objectMapper.readTree(responseBody);
//		        JsonNode responseNode = rootNode.get("response");
//		        if (responseNode != null) {
//		            responseValue = responseNode.asText();
//		        }
//		    } catch (Exception e) {
//		        e.printStackTrace(); // Handle parsing exception gracefully
//		    }
			//return new Response(200,"State Found", res_state_entity.getState());
		    
		    
		    return new Response(200,"Role Found",resp.getResponse());

			
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("In catch Rest_Template "+ e);
	            return new Response(404,"Error",e.getMessage());																		 //and we can give that as reply
				                                                                 //Sample e.getMessage(): "{"timestamp":"2024-02-09 00:29:29","status":400,"statusMsg":"400 BAD_REQUEST","response":"State Not Found"}"
			}

	}
	
	
}
