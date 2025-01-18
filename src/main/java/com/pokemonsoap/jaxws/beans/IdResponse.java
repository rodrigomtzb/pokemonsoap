package com.pokemonsoap.jaxws.beans;

public class IdResponse {

	private Integer id;
	
	public IdResponse( Integer id ) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "IdResponse id: "+id ;
	}
	
}
