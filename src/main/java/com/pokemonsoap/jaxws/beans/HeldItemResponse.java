package com.pokemonsoap.jaxws.beans;

import java.util.List;

public class HeldItemResponse {
	
	List<HeldItem> held_items;
	
	public HeldItemResponse( List<HeldItem> held_items ) {
		this.held_items = held_items;
	}

	public List<HeldItem> getHeld_items() {
		return held_items;
	}

	public void setHeld_items(List<HeldItem> held_items) {
		this.held_items = held_items;
	}
	
	@Override
	public String toString() {
		return "HeldItemResponse held_itemsNumber: "+held_items.size() ;
	}

}
