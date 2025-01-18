package com.pokemonsoap.jaxws.beans;

import java.util.List;

public class AbilitiesResponse {
	
	private List<AbilityDetail> abilities;
	
	public AbilitiesResponse() {
		
	}
	
	public AbilitiesResponse(List<AbilityDetail> abilities) {
		this.abilities = abilities;
	}

	public List<AbilityDetail> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<AbilityDetail> abilities) {
		this.abilities = abilities;
	}

	@Override
	public String toString() {
		return "AbilitiesResponse abilitiesNumber: "+abilities.size() ;
	}
	
}
