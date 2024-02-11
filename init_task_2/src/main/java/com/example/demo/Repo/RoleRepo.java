package com.example.demo.Repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.RoleEntity;

public interface RoleRepo extends CrudRepository<RoleEntity,Integer>{

	boolean existsByRole(String role);

	RoleEntity findByRole(String role_name);
	
	RoleEntity findById(int role_id);

}
