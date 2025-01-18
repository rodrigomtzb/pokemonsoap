package com.pokemonsoap.jaxws.beans;

import java.util.List;

public class Location {

	private LocationArea location_area;
	private List<VersionLocationDetail> version_details;
	
	public LocationArea getLocation_area() {
		return location_area;
	}
	public void setLocation_area(LocationArea location_area) {
		this.location_area = location_area;
	}
	public List<VersionLocationDetail> getVersion_details() {
		return version_details;
	}
	public void setVersion_details(List<VersionLocationDetail> version_details) {
		this.version_details = version_details;
	}
	
	
}
