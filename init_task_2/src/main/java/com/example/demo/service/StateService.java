package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.StateRepo;
import com.example.demo.ResponseStatus.ResponseStatus;
import com.example.demo.dto.StateDTO;
import com.example.demo.entity.StateEntity;
import com.example.demo.response.Response;


@Service
public class StateService {

	@Autowired
	StateRepo staterepo;
	
	public ResponseStatus addState(StateDTO state) {
		System.out.println("Entered in the Service Layer");
		if((staterepo.existsById(state.getState_id())) || (staterepo.existsByState(state.getState())))
		{
			return new ResponseStatus("error","State Already Present");
		}
		
			
			StateEntity newState = new StateEntity();
			newState.setState_id(state.getState_id());
			newState.setState(state.getState());
			if((state.getIsUnionTerritory()).equals("yes"))
			{
				newState.setIsUnionTerritory(1);
			}
			else
			{
				newState.setIsUnionTerritory(0);
			}
		
		
		
		staterepo.save(newState);
		System.out.print(newState);
		return new ResponseStatus("OK","State Added");
		
	}
	
	public List<StateDTO> getStates()
	{
		List<StateEntity> states = staterepo.findAll();
		List<StateDTO> resp = new ArrayList<StateDTO>();
		for(int i = 0;i<states.size();i++)
		{
			StateDTO state = new StateDTO();
			state.setState_id(states.get(i).getState_id());
			state.setState(states.get(i).getState());
			if(states.get(i).getIsUnionTerritory() == 0)
			    state.setIsUnionTerritory("no");
			else
			    state.setIsUnionTerritory("yes");
			resp.add(state);
	
		}
		return resp;
		
	}

	public Response getStateById(int state_id) {
		try {
		StateEntity res_state_entity = staterepo.findById(state_id);
		System.out.println("Inside the Service Layer");
		if(res_state_entity != null)
		{
			return new Response(200,"State Found",res_state_entity);
		}
		else
		{
			return new Response(400,"State Not Found",null);

		}
		}catch(Exception e )
		{
			System.out.println("Service Catch"+e.getMessage());
			return null;
		}
		

		

	}
	
	
}
