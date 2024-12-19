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

	private static List<MenuItem> mainMenu = new ArrayList<>();

	public static void initializeMenu() {
		mainMenu.add(new MainMeal("Main", "MF001", "重油仲儼小麥克", 827, "很油很鹹", "番茄醬", "牛肉，麵包，生菜"));
		mainMenu.add(new MainMeal("Main", "MF002", "半層吉事堡", 458, "比雙層吉是堡薄", "塔塔醬", "起司，生菜"));
		mainMenu.add(new MainMeal("Main", "MF003", "香甜雞腿堡", 372, "不會辣的香辣雞腿堡", "甜醬", "雞腿，生菜，甜醬"));
		mainMenu.add(new MainMeal("Main", "MF004", "大享堡", 99, "比大亨堡多一根熱狗", "辣醬", "熱狗，起司"));
		mainMenu.add(new MainMeal("Main", "MF005", "伊晴拉麵", 2010, "單身拉麵", "醬油口味", "拉麵 ，叉燒，糖心蛋"));
		mainMenu.add(new MainMeal("Main", "MF006", "螺施豆腐煲", 7537, "施味臭豆甫", "酸辣", "豆腐，蔬菜，田螺"));
		mainMenu.add(new MainMeal("Main", "MF007", "火穎地諭麻將麵", 9999, "火辣面", "麻將", "麵，麻將"));
	}

	public static List<MenuItem> getMainMenu() {
		return new ArrayList<>(mainMenu); 
	}
}
