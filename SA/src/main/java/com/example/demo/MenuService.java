package com.example.demo;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MenuService {

	// Getters

	public String getItemID() {

		return getItemID();

	}

	public String getType() {

		return getType();

	}

	public String getName() {

		return getName();

	}

	public double getPrice() {

		return getPrice();

	}

	public String getDescription() {

		return getDescription();

	}

	@Override

	public String toString() {

		return "menuItem{" +

				"itemID='" + getItemID() + '\'' +

				", type='" + getType() + '\'' +

				", name='" + getName() + '\'' +

				", price=" + getPrice() +

				", description='" + getDescription() + '\'' +

				'}';

	}
	private List<MenuItem> menuItems = new ArrayList<>();

	public List<MenuItem> getMenuItem(String type) {

		List<MenuItem> filteredItems = new ArrayList<>();

		for (MenuItem item : menuItems) {

			if (type == null || item.getType().equalsIgnoreCase(type)) {

				filteredItems.add(item);

			}

		}

		return filteredItems;

	}

	private List<MenuItem> mainMenu = new ArrayList<>();
	private List<MenuItem> subMealMenu = new ArrayList<>();
	private List<MenuItem> beverageMenu = new ArrayList<>();

	public MenuService() {
		mainMenu.add(new MainMeal("Main", "MF001", "重油仲儼小麥克", 827, "很油很鹹", "番茄醬", "牛肉，麵包，生菜"));
		mainMenu.add(new MainMeal("Main", "MF002", "半層吉事堡", 458, "比雙層吉是堡薄", "塔塔醬", "起司，生菜"));
		mainMenu.add(new MainMeal("Main", "MF003", "香甜雞腿堡", 372, "不會辣的香辣雞腿堡", "甜醬", "雞腿，生菜，甜醬"));
		mainMenu.add(new MainMeal("Main", "MF004", "大享堡", 99, "比大亨堡多一根熱狗", "辣醬", "熱狗，起司"));
		mainMenu.add(new MainMeal("Main", "MF005", "伊晴拉麵", 2010, "單身拉麵", "醬油口味", "拉麵 ，叉燒，糖心蛋"));
		mainMenu.add(new MainMeal("Main", "MF006", "螺施豆腐煲", 7537, "施味臭豆甫", "酸辣", "豆腐，蔬菜，田螺"));
		mainMenu.add(new MainMeal("Main", "MF007", "火穎地諭麻將麵", 9999, "火辣面", "麻將", "麵，麻將"));

		subMealMenu.add(new Submeal("Snack", "SF001", "豬塊", 67, "因應禽流感，雞塊先以豬塊代替", "甜醋醬", "內含豬肉"));
		subMealMenu.add(new Submeal("Snack", "SF002", "超派", 22, "內含獵豹肉，吃了變超派", "地溝油", "內含獵豹肉"));
		subMealMenu.add(new Submeal("Snack", "SF003", "倉鼠餅", 87, "毛茸茸又可愛，少女打卡必備", "無", "伊晴小孩"));
		subMealMenu.add(new Submeal("Snack", "SF004", "羅波高", 64, "", "辣醬", ""));
		subMealMenu.add(new Submeal("Snack", "SF005", "育達出皮蛋", 13, "臭皮蛋", "皮蛋", "蛋"));
		subMealMenu.add(new Submeal("Snack", "SF006", "陵邱香雞排", 8450, "", "蒜", "雞排"));

		beverageMenu.add(new Beverage("Drink", "B001", "可悲", 83, "比可樂還好喝", true, "半糖"));
		beverageMenu.add(new Beverage("Drink", "B002", "冰碧", 47, "比雪碧還好喝", true, "少糖"));
		beverageMenu.add(new Beverage("Drink", "B003", "蘭達", 90, "比芬達還好喝", false, "無糖"));
	}

	public MenuItem getItemById(String itemID) {
		MenuItem item = mainMenu.stream().filter(m -> m.getItemID().equals(itemID)).findFirst().orElse(null);
		return item;
	}

	// 提供主餐資料
	public List<MenuItem> getMainMenu() {
		return mainMenu;
	}

	public List<MenuItem> getSubMealMenu() {
		return subMealMenu;
	}

	public List<MenuItem> getBeverageMenu() {
		return beverageMenu;
	}

	public List<MenuItem> getAllMenuItems() {
		List<MenuItem> allMenuItems = new ArrayList<>();
		allMenuItems.addAll(mainMenu);
		allMenuItems.addAll(subMealMenu);
		allMenuItems.addAll(beverageMenu);
		return allMenuItems;
	}

	public MenuItem findMenuItemByID(String itemID) {
		// 在所有菜單項目中查找
		for (MenuItem item : mainMenu) {
			if (item.getItemID().equals(itemID)) {
				return item; // 找到後返回該項目
			}
		}
		for (MenuItem item : subMealMenu) {
			if (item.getItemID().equals(itemID)) {
				return item;
			}
		}
		for (MenuItem item : beverageMenu) {
			if (item.getItemID().equals(itemID)) {
				return item;
			}
		}
		// 如果未找到，拋出異常或返回 null
		throw new IllegalArgumentException("MenuItem not found with ID: " + itemID);
	}

}