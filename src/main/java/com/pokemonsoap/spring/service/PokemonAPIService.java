package com.pokemonsoap.spring.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonsoap.jaxws.beans.AbilitiesResponse;
import com.pokemonsoap.jaxws.beans.AbilityDetail;
import com.pokemonsoap.jaxws.beans.BaseExperienceResponse;
import com.pokemonsoap.jaxws.beans.HeldItem;
import com.pokemonsoap.jaxws.beans.HeldItemResponse;
import com.pokemonsoap.jaxws.beans.IdResponse;
import com.pokemonsoap.jaxws.beans.LocationAreaEncounterResponse;
import com.pokemonsoap.jaxws.beans.NameResponse;
import com.pokemonsoap.jaxws.beans.PokemonSOAPRequest;
import com.pokemonsoap.jaxws.constant.PropertyName;

@Service("pokemonAPIService")
@SuppressWarnings("unchecked")
public class PokemonAPIService {
	
	@Autowired
	PokemonPropertyFactory factory;

	public AbilitiesResponse getAbilities( PokemonSOAPRequest request ) throws InterruptedException, IOException {
		
		List<AbilityDetail> abilityList = (List<AbilityDetail>)(Object)factory.getProperties(request.getPokemonName(), PropertyName.ABILITIES);
		
		return  new AbilitiesResponse(abilityList);
		
	}
	
	public HeldItemResponse getHelItems( PokemonSOAPRequest request ) throws InterruptedException, IOException {
		
		List<HeldItem> heldItemsList = (List<HeldItem>)(Object)factory.getProperties(request.getPokemonName(), PropertyName.ABILITIES);
		
		return new HeldItemResponse(heldItemsList);

	}
	
	public BaseExperienceResponse getBaseExperience(PokemonSOAPRequest request) throws InterruptedException, IOException  {
		
		return  (BaseExperienceResponse) factory.getProperty(request.getPokemonName(), PropertyName.BASE_EXPERIENCE);
	
	}
	
	public NameResponse getName(PokemonSOAPRequest request) throws InterruptedException, IOException  {
		
		return (NameResponse)factory.getProperty(request.getPokemonName(), PropertyName.NAME);
	
	}
	
	public IdResponse getId(PokemonSOAPRequest request) throws InterruptedException, IOException  {

		return (IdResponse)factory.getProperty(request.getPokemonName(), PropertyName.ID);
		
	}
	
	public LocationAreaEncounterResponse getLocationArea(PokemonSOAPRequest request) throws InterruptedException, IOException  {
		
		return factory.getPropertyLocation(request.getPokemonName());
		
	}

}
