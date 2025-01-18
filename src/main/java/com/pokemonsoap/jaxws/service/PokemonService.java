package com.pokemonsoap.jaxws.service;

import com.pokemonsoap.jaxws.beans.AbilitiesResponse;
import com.pokemonsoap.jaxws.beans.BaseExperienceResponse;
import com.pokemonsoap.jaxws.beans.HeldItemResponse;
import com.pokemonsoap.jaxws.beans.IdResponse;
import com.pokemonsoap.jaxws.beans.LocationAreaEncounterResponse;
import com.pokemonsoap.jaxws.beans.NameResponse;
import com.pokemonsoap.jaxws.beans.PokemonSOAPRequest;
import com.pokemonsoap.spring.context.SpringContext;
import com.pokemonsoap.spring.service.PokemonAPIService;

public class PokemonService {
	
	public PokemonAPIService service;
	
	public PokemonService() {
		service = (PokemonAPIService)SpringContext.getBean("pokemonAPIService");
	}
	

	public AbilitiesResponse getAbilities(PokemonSOAPRequest request) {
		
		try {
		
		return service.getAbilities(request);
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public BaseExperienceResponse getBaseExperience(PokemonSOAPRequest request) {
		
		try {
		
		return service.getBaseExperience(request);
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public IdResponse getId(PokemonSOAPRequest request) {
		
		try {
		
		return service.getId(request);
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public NameResponse getName(PokemonSOAPRequest request) {
		
		try {
		
		return service.getName(request);
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public HeldItemResponse getHeldItems(PokemonSOAPRequest request) {
		
		try {
			
			return service.getHelItems(request);
			
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	public LocationAreaEncounterResponse getLocationAreaEncounter(PokemonSOAPRequest request) {
		
		try {
			
			return service.getLocationArea(request);
			
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	
	
}
