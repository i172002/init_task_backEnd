package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StateEntity;

public interface StateRepo extends JpaRepository<StateEntity,Integer>{
	
	boolean existsByState(String state);

	StateEntity findByState(String state_name);
	
	StateEntity findById(int id);
	

}
