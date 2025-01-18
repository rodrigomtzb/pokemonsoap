package com.pokemonsoap.jaxws.beans;

public class PokemonSOAPRequest {
	
	String pokemonName;

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	@Override
	public String toString() {
		return "pokemonName: "+pokemonName;
	}
	
}
