package com.pokemonsoap.jaxws.beans;

import java.util.List;

public class EncounterDetail {

	private Integer chance;
	private Integer max_level;
	private Integer min_level;
	private Method method;
	private List<ConditionValue> condition_values;
	
	public Integer getChance() {
		return chance;
	}
	public void setChance(Integer chance) {
		this.chance = chance;
	}
	public Integer getMax_level() {
		return max_level;
	}
	public void setMax_level(Integer max_level) {
		this.max_level = max_level;
	}
	public Integer getMin_level() {
		return min_level;
	}
	public void setMin_level(Integer min_level) {
		this.min_level = min_level;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public List<ConditionValue> getCondition_values() {
		return condition_values;
	}
	public void setCondition_values(List<ConditionValue> condition_values) {
		this.condition_values = condition_values;
	}
	
}
