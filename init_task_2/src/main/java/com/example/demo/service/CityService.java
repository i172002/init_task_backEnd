package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.CityRepo;
import com.example.demo.Repo.StateRepo;
import com.example.demo.ResponseStatus.ResponseStatus;
import com.example.demo.dto.CityDTO;
import com.example.demo.entity.CityEntity;
import com.example.demo.entity.StateEntity;
import com.example.demo.response.Response;

@Service
public class CityService {

	@Autowired
	CityRepo cityrepo;
	@Autowired
	StateRepo staterepo;
	
	public ResponseStatus addCity(CityDTO city) {
		System.out.println("Entered in the Service Layer");
		if((cityrepo.existsById(city.getCity_id())) || (cityrepo.existsByCity(city.getCity())))
		{
			return new ResponseStatus("error","City Already Preesent");
		}
		if(!staterepo.existsByState(city.getState_name()))
		{
			return new ResponseStatus("error","Invalid State Name");

		}

		CityEntity newCity = new CityEntity();
		newCity.setCity_id(city.getCity_id());
		newCity.setCity(city.getCity());
		newCity.setState_id(staterepo.findByState(city.getState_name()));	
		cityrepo.save(newCity);
		System.out.print(newCity);
		return new ResponseStatus("OK","City Added");
		
	}
	
	public List<CityDTO> getCities()
	{
		List<CityEntity> cities = cityrepo.findAll();
		List<CityDTO> resp = new ArrayList<CityDTO>();
		for(int i = 0;i<cities.size();i++)
		{
			CityDTO city = new CityDTO();
			city.setCity_id(cities.get(i).getCity_id());
			city.setCity(cities.get(i).getCity());
			StateEntity temp_state = cities.get(i).getState_id();
			city.setState_name(temp_state.getState());
			resp.add(city);
	
		}
		return resp;


	}

	public Response getCityById(int city_id) {
		try {
			CityEntity res_city_entity = cityrepo.findById(city_id);
			System.out.println("Inside the Service Layer");
			if(res_city_entity != null)
			{
				return new Response(200,"City Found",res_city_entity);
			}
			else
			{
				return new Response(400,"City Not Found",null);

			}
			}catch(Exception e )
			{
				System.out.println("Service Catch"+e.getMessage());
				return null;
			}
				
	}
}
