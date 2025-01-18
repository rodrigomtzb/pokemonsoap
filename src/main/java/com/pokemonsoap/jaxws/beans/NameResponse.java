package com.pokemonsoap.jaxws.beans;

public class NameResponse {
	
	private String name;
	
	public NameResponse(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "NameResponse name: "+name ;
	}

}
