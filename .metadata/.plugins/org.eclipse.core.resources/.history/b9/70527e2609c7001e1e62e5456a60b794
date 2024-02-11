package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CityEntity;

public interface CityRepo extends JpaRepository<CityEntity,Integer>{


	boolean existsByCity(String city);

	CityEntity findByCity(String state_name);

	CityEntity getByCity(String city_name);

}
