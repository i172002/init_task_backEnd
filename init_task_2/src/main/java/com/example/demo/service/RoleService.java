package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.RoleRepo;
import com.example.demo.ResponseStatus.ResponseStatus;
import com.example.demo.entity.RoleEntity;
//import com.example.demo.entity.StateEntity;
import com.example.demo.response.Response;

@Service
public class RoleService {
	
	@Autowired
	RoleRepo rolerepo;

	public ResponseStatus addRole(RoleEntity role) {
		System.out.println("Entered in the Service Layer");
		if((rolerepo.existsById(role.getRole_id())) || (rolerepo.existsByRole(role.getRole())))
		{
			return new ResponseStatus("error","Role Already Preesent");
		}
		
			
			RoleEntity newRole = new RoleEntity();
			newRole.setRole_id(role.getRole_id());
			newRole.setRole(role.getRole());
		    rolerepo.save(newRole);
		    System.out.print(newRole);
		    return new ResponseStatus("OK","State Added");
		
	}

	public List<RoleEntity> getRoles() {
		
		return (List<RoleEntity>) rolerepo.findAll();
	}

	public Response getRoleById(int role_id){
		try {
			RoleEntity res_role_entity = rolerepo.findById(role_id);
			System.out.println("Inside the Service Layer");
			if(res_role_entity != null)
			{
				return new Response(200,"Role Found",res_role_entity);
			}
			else
			{
				return new Response(400,"Role Not Found",null);

			}
			}catch(Exception e )
			{
				System.out.println("Service Catch"+e.getMessage());
				return null;
			}
		
	}

	
	
	

}