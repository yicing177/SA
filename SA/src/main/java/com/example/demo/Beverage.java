package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Beverage extends MenuItem {
	private Boolean isCold;
	private String sugar;

	public Beverage(String type, String itemID, String name, int price, String description, Boolean isCold,
			String sugar) {
		super(type, itemID, name, price, description);
		this.isCold = isCold;
		this.sugar = sugar;
	}

	public boolean isCold() {
		return isCold;
	}

	public void setCold(boolean isCold) {
		this.isCold = isCold;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	private static List<MenuItem> beverageMenu = new ArrayList<>();

	public static void initializeMenu() {
		beverageMenu.add(new Beverage("Drink", "B001", "可悲", 83, "比可樂還好喝", true, "半糖"));
		beverageMenu.add(new Beverage("Drink", "B002", "冰碧", 47, "比雪碧還好喝", true, "少糖"));
		beverageMenu.add(new Beverage("Drink", "B003", "蘭達", 90, "比芬達還好喝", false, "無糖"));
	}

	public static List<MenuItem> getBeverageMenu() {
		return new ArrayList<>(beverageMenu); // 返回一个副本以保护原始数据
	}
}