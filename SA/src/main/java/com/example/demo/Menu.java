package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private String updateData;
	private String editionVersion;
	private List<MenuItem> menuItems;
	public Menu(String updateData, String editionversion) {
		this.updateData= updateData;
		this.editionVersion= editionVersion;
		this.menuItems = new ArrayList<>();
		
		initializeMainMeals();
	}
	   // Getters and Setters
    public String getUpdateData() {
        return updateData;
    }

    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }

    public String getEditionVersion() {
        return editionVersion;
    }

    public void setEditionVersion(String editionVersion) {
        this.editionVersion = editionVersion;
    }
	public List<MenuItem> getMenuItems() { 
		return menuItems; 
	} 
	public void addMenuItem(MenuItem menuItem) { 
		this.menuItems.add(menuItem); 
	} 
	public void removeMenuItem(MenuItem menuItem) {
		this.menuItems.remove(menuItem); 
	} 
	
	private void initializeMainMeals() { 
		// Creating MainMeal objects for each main dish 
		MainMeal 重油仲嚴小麥克 = new MainMeal("Main", "MF001", "重油仲嚴小麥克", 827, "很油很鹹", "番茄醬", "牛肉，麵包，生菜"); 
		MainMeal 半層吉事堡 = new MainMeal("Main", "MF002", "半層吉事堡", 458, "比雙層吉是堡薄", "塔塔醬", "起司，生菜"); 
		MainMeal 香甜雞腿堡 = new MainMeal("Main", "MF003", "香甜雞腿堡", 372, "不會辣的香辣雞腿堡", "甜醬", "雞腿，生菜，甜醬"); 
		MainMeal 大享堡 = new MainMeal("Main", "MF004", "大享堡", 99, "比大亨堡多一根熱狗", "辣醬", "熱狗，起司"); 
		MainMeal 伊晴拉麵 = new MainMeal("Main", "MF005", "伊晴拉麵", 2010, "單身拉麵", "醬油口味", "拉麵 ，叉燒，糖心蛋"); 
		MainMeal 螺施豆腐煲 = new MainMeal("Main", "MF006", "螺施豆腐煲", 7537, "施味臭豆甫", "酸辣", "豆腐，蔬菜，田螺"); 
		MainMeal 火穎地諭麻醬麵 = new MainMeal("Main", "MF007", "火穎地諭麻醬麵", 9999, "火辣面", "麻醬", "麵，麻醬"); 
		
		// Add these MainMeal items to menuItems list 
		this.menuItems.add(重油仲嚴小麥克); 
		this.menuItems.add(半層吉事堡); 
		this.menuItems.add(香甜雞腿堡); 
		this.menuItems.add(大享堡); 
		this.menuItems.add(伊晴拉麵); 
		this.menuItems.add(螺施豆腐煲); 
		this.menuItems.add(火穎地諭麻醬麵);
	}
	@Override public String toString() { 
		return "Menu [updateData=" + updateData + ", editionVersion=" + editionVersion + ", menuItems=" + menuItems + "]"; 
	}
}
