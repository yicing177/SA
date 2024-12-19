package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private String updateData;
	private String editedVersion;
	private List<MenuItem> menuItems;
	
	public Menu(String updateData, String editionversion) {
		this.updateData= updateData;
		this.editedVersion= editedVersion;
		this.menuItems = new ArrayList<>();
        this.subMealMenu = new ArrayList<>();
        this.beverageMenu = new ArrayList<>();
        // 从 MainMenu 中加载主菜单项
        this.menuItems.addAll(MainMeal.getMainMenu());
	}
	private static List<MenuItem> mainMenu;
	private List<MenuItem> subMealMenu ;
	private List<MenuItem> beverageMenu ;
	
	   // Getters and Setters
    public String getUpdateData() {
        return updateData;
    }

    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }

    public String getEditionVersion() {
        return editedVersion;
    }

    public void setEditionVersion(String editionVersion) {
        this.editedVersion = editedVersion;
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
}
