package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.RoleRepo;
import com.example.demo.ResponseStatus.ResponseStatus;
import com.example.demo.entity.RoleEntity;
//import com.example.demo.entity.StateEntity;

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

	
	
	

}
