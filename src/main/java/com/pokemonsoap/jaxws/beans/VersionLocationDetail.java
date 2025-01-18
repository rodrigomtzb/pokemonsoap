package com.pokemonsoap.jaxws.beans;

import java.util.List;

public class VersionLocationDetail {
	
	private List<EncounterDetail> encounter_details;
	private Integer max_chance;
	private Version version;
	
	public List<EncounterDetail> getEncounter_details() {
		return encounter_details;
	}
	public void setEncounter_details(List<EncounterDetail> encounter_details) {
		this.encounter_details = encounter_details;
	}
	public Integer getMax_chance() {
		return max_chance;
	}
	public void setMax_chance(Integer max_chance) {
		this.max_chance = max_chance;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	
}
