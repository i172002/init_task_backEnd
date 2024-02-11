package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Repo.CityRepo;
import com.example.demo.Repo.RoleRepo;
import com.example.demo.Repo.StateRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.ResponseStatus.ResponseStatus;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.CityEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.response.Response;
import com.example.demo.restTemplate.Rest_Template;




@Service
public class UserService {
	
	@Autowired
	UserRepo userrepo;
	@Autowired
	CityRepo cityrepo;
	@Autowired
	StateRepo staterepo;
	@Autowired
	RoleRepo rolerepo;
	
	@Autowired
	Rest_Template restTemplate;
	

	public ResponseStatus addUser(UserDTO user) {
	    int state_id;
	    int city_state_id;
	    System.out.println("Entered in the Service Layer");
//	    if (userrepo.existsById(user.getUid())) {
//	        return new ResponseStatus("error", "User Already Present");
//	    }
	    if (userrepo.existsByUsername(user.getUsername())) {
	        return new ResponseStatus("error", "UserName Taken");
	    }
	    if (!staterepo.existsByState(user.getState_name())) {
	        return new ResponseStatus("error", "Invalid State");
	    } else {
	        state_id = staterepo.findByState(user.getState_name()).getState_id();
	    }
	    if (cityrepo.existsByCity(user.getCity_name())) {
	        CityEntity temp_city = cityrepo.getByCity(user.getCity_name());
	        city_state_id = temp_city.getState_id().getState_id();
	        if (city_state_id != state_id) {
	            return new ResponseStatus("error", "State and City Doesn't Match");
	        }
	    } else {
	        return new ResponseStatus("error", "Invalid City");
	    }
	    if (!rolerepo.existsByRole(user.getRole_name())) {
	        return new ResponseStatus("error", "Invalid Role");
	    }
	    if (!user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$")) {
	        return new ResponseStatus("error", "Invalid Password");
	    }
	    if (!user.getUsername().matches("^[^\\s]+$")) {
	        return new ResponseStatus("error", "Invalid Username");
	    }

	    UserEntity newUser = new UserEntity();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(user.getPassword());
	    newUser.setName(user.getName());
	    newUser.setDob(user.getDob());
	    newUser.setRole_id(rolerepo.findByRole(user.getRole_name()));
	    newUser.setCreated_date(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
	    newUser.setModified_date(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
	    newUser.setState_id(staterepo.findByState(user.getState_name()));
	    newUser.setCity_id(cityrepo.findByCity(user.getCity_name()));
	    newUser.setPincode(user.getPincode());
	    newUser.setStatus(1);
	    newUser.setEmail(user.getEmail());

	    userrepo.save(newUser);
	    System.out.print(user);
	    
	    return new ResponseStatus("OK", "State Added");
	}

	public List<UserDTO> getUsers() {
		

		List<UserEntity> users = userrepo.findAll();
		List<UserDTO> resp = new ArrayList<UserDTO>();
		
		for(int i = 0;i<users.size();i++)
		{
			UserDTO user = new UserDTO();

			UserEntity i_user = users.get(i);
			user.setUsername(i_user.getUsername());
			user.setPassword(i_user.getPassword());
			user.setName(i_user.getName());
			user.setDob(i_user.getDob());
			user.setPincode(i_user.getPincode());
			user.setStatus(i_user.getStatus());
			user.setEmail(i_user.getEmail());
		
			user.setState_name(i_user.getState_id().getState());  //i_user.getState_id() will return the StateEntity Object
			user.setCity_name(i_user.getCity_id().getCity());     //.getState() will return the state_name in that object						
			user.setRole_name(i_user.getRole_id().getRole());
			resp.add(user);
	
		}
		return resp; 
	}
	
	

	private   String getStateByNameURL  = "http://localhost:8081/getStateById/";
	private   String getCityByNameURL   = "http://localhost:8081/getCityById/";
    private   String  getRoleByNameURL   = "http://localhost:8081/getRoleById/";
	public Response getUserById(int uid) {
		int state_id,role_id,city_id;
		

		UserEntity user_entity = userrepo.findById(uid);
		if(user_entity == null)
			return new Response(404,"User Not Found",null);
		
		UserDTO user_resp = new UserDTO();
		
		user_resp.setUsername(user_entity.getUsername());
		user_resp.setPassword(user_entity.getPassword());
		user_resp.setDob(user_entity.getDob());
		user_resp.setEmail(user_entity.getEmail());
		user_resp.setName(user_entity.getName());
		user_resp.setEmail(user_entity.getEmail());
		user_resp.setStatus(user_entity.getStatus());
		state_id = user_entity.getState_id().getState_id();
		city_id = user_entity.getCity_id().getCity_id();
		role_id = user_entity.getRole_id().getRole_id();
		System.out.println("ID's "+state_id+" "+city_id+" "+role_id);
		
		
		
		try {
			
			Response res_state_name = restTemplate.getStateByIdApiCalling(getStateByNameURL+state_id);
		    LinkedHashMap<String, Object> responseData = (LinkedHashMap<String, Object>) res_state_name.getResponse();
		    String stateValue = (String) responseData.get("state");
		    System.out.println(stateValue);

		    user_resp.setState_name(stateValue);
			
		}catch(Exception e) {
			System.out.println("In UserService catch and in StateAPI call "+e.getMessage());
			return null;
		}
        try {
			
			Response res_city_name = restTemplate.getCityByIdApiCalling(getCityByNameURL+city_id);
		    LinkedHashMap<String, Object> responseData = (LinkedHashMap<String, Object>) res_city_name.getResponse();
		    String cityValue = (String) responseData.get("city");
		    System.out.println(cityValue);
		    user_resp.setCity_name(cityValue);
			
		}catch(Exception e) {
			System.out.println("In UserService catch and in CityAPI call"+e.getMessage());
			return null;
		}
		  try {
			
			
			Response res_role_name = restTemplate.getRoleByIdApiCalling(getRoleByNameURL+role_id);
			LinkedHashMap<String, Object> responseData = (LinkedHashMap<String, Object>) res_role_name.getResponse();
		    String roleValue = (String) responseData.get("role");
		    System.out.println(roleValue);
		    user_resp.setRole_name(roleValue);
			
		  }catch(Exception e) {
			System.out.println("In UserService catch and in RoleAPI Call"+e.getMessage());
			
		  }
		
    return  new Response(200,"User Found",user_resp);
	}//end of getUserById
  
	
	

}