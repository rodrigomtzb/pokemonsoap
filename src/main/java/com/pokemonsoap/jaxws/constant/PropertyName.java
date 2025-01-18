package com.pokemonsoap.jaxws.constant;

public enum PropertyName {
	
	ABILITIES("abilities"),
	BASE_EXPERIENCE("base_experience"),
	NAME("name"),
	ID("id"),
	HELD_ITEMS("held_items"),
	LOCATION_AREA_ENCOUNTERS("location_area_encounters");
	
	private final String value;
	
	PropertyName (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
