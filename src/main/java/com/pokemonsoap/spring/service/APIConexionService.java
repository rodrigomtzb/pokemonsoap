package com.pokemonsoap.spring.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class APIConexionService {
	
	@Value("${url.pokemon.service}")
	private String baseURL;
	
	public  Map<String, Object> getPokemon(String pokemonName)throws InterruptedException, IOException  {
		
		String json = get(baseURL+pokemonName);
		
	    
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> map = mapper.readValue(json, new TypeReference<>() {});
	    
	    return map; 
		
		
	}
	
	public String get( String url )throws InterruptedException, IOException {
		
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(url))
	          .build();

	    HttpResponse<String> response =
	          client.send(request, BodyHandlers.ofString());
		
	    
	    return response.body();
	}
	
	

}
