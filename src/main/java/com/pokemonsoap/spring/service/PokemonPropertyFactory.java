package com.pokemonsoap.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemonsoap.jaxws.beans.AbilityDetail;
import com.pokemonsoap.jaxws.beans.BaseExperienceResponse;
import com.pokemonsoap.jaxws.beans.HeldItem;
import com.pokemonsoap.jaxws.beans.IdResponse;
import com.pokemonsoap.jaxws.beans.Location;
import com.pokemonsoap.jaxws.beans.LocationAreaEncounterResponse;
import com.pokemonsoap.jaxws.beans.NameResponse;
import com.pokemonsoap.jaxws.constant.PropertyName;

@Service
public class PokemonPropertyFactory {
	
	@Autowired
	APIConexionService connexion;
	
	public List<Object> getProperties( String pokemonName,  PropertyName property ) throws JsonProcessingException, IOException, InterruptedException{
		
		Map<String, Object> responseObj = connexion.getPokemon( pokemonName );
		
		List<Object> lstProperties = new ArrayList<Object>();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(responseObj.get(property.getValue()));
		
		switch (property) {
		
	        case ABILITIES:
	        	
	    		List<AbilityDetail> abilityList = mapper.readValue( json, new TypeReference<List<AbilityDetail>>() {});
	        	
	    		abilityList.forEach(ability -> lstProperties.add(ability));
	    		
	    		break;
	    		
	        case HELD_ITEMS:
	        	
	    		List<HeldItem> heldItemList = mapper.readValue( json, new TypeReference<List<HeldItem>>() {});
	        	
	    		heldItemList.forEach(heldItem -> lstProperties.add(heldItem));
	    		
	    		break;
	    		
	        default:
				throw new IOException();
        	
		}
		
		return lstProperties;
		
	}
	
	public Object getProperty( String pokemonName,  PropertyName property ) throws JsonProcessingException, IOException, InterruptedException{
		
		Map<String, Object> responseObj = connexion.getPokemon( pokemonName );
		
		switch (property) {
			
			case LOCATION_AREA_ENCOUNTERS:
	        	
	        	return  (String)responseObj.get(property.getValue());
	        	
			case NAME:
				
				String name = (String)responseObj.get(property.getValue());
				
				return new NameResponse(name);

			case ID:
				
				Integer id = (Integer)responseObj.get(property.getValue());
				
				return new IdResponse(id);
				
			case BASE_EXPERIENCE:
				
				Integer baseExperience = (Integer)responseObj.get(property.getValue());
				
				return new BaseExperienceResponse(baseExperience);
				
			default:
				throw new IOException();
		}
		
	}
	
	public LocationAreaEncounterResponse getPropertyLocation(String pokemonName) throws JsonProcessingException, IOException, InterruptedException {
		
		Map<String, Object> responseObj = connexion.getPokemon( pokemonName );
		
		String url = (String)responseObj.get( PropertyName.LOCATION_AREA_ENCOUNTERS.getValue() );
		
		String json = connexion.get(url);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Location> locationLst =  mapper.readValue( json, new TypeReference<List<Location>>() {});
		
		return new LocationAreaEncounterResponse(locationLst);
		
		
	}

}
