package com.example.demo;

public class MenuItem {
	private String type;
    private String itemID;
    private String name;
    private int price;
    private String description;
    private String content;
    
    public MenuItem(String type, String itemID, String name, int price, String description) {
        this.type = type;
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.content = content;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override 
    public String toString() {
    	return "MenuItem [名子=" + name + ", 價格=" + price + "]"; 
    }
}
