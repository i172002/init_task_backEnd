package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Integer>{

	boolean existsByUsername(String username);

	boolean existsByPassword(String username);
	
	UserEntity findById(int id);
  
	
	

}
