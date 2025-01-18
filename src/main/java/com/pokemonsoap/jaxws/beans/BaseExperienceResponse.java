package com.pokemonsoap.jaxws.beans;

public class BaseExperienceResponse {
	
	private Integer base_experience;
	
	public BaseExperienceResponse() {}
	
	public BaseExperienceResponse( Integer base_experience ) {
		this.base_experience = base_experience;
	}

	public Integer getBase_experience() {
		return base_experience;
	}

	public void setBase_experience(Integer base_experience) {
		this.base_experience = base_experience;
	}
	
	@Override
	public String toString() {
		return "BaseExperienceResponse base_experience: "+base_experience ;
	}

}
