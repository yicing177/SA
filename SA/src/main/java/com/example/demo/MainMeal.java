package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MainMeal extends MenuItem {
	private String sauce;
	private String ingredient;

	public MainMeal(String type, String itemID, String name, int price, String description, String sauce,
			String ingredient) {
		super(type, itemID, name, price, description);
		this.sauce = sauce;
		this.ingredient = ingredient;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
}
