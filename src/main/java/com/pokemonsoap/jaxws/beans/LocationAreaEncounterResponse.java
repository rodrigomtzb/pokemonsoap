package com.pokemonsoap.jaxws.beans;

import java.util.List;

public class LocationAreaEncounterResponse {

	private List<Location> locations;
	
	public LocationAreaEncounterResponse(List<Location> locations) {
		this.locations = locations;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	@Override
	public String toString() {
		return "LocationAreaEncounterResponse LocationsNumber: "+locations.size() ;
	}
	
}
