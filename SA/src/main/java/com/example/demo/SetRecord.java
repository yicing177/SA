package com.example.demo;

public class SetRecord {
    private MenuItem mainItem; 
    private MenuItem sideItem; 
    private MenuItem drinkItem; 
    private int price;       
    private int amount;
    private String setRecordID;

    public SetRecord(MenuItem mainItem, MenuItem sideItem, MenuItem drinkItem, int price) {
        this.mainItem = mainItem;
        this.sideItem = sideItem;
        this.drinkItem = drinkItem;
        this.price = price;
    }

    // Getter 和 Setter 方法
    public MenuItem getMainItem() {
        return mainItem;
    }

    public void setMainItem(MenuItem mainItem) {
        this.mainItem = mainItem;
    }

    public MenuItem getSideItem() {
        return sideItem;
    }

    public void setSideItem(MenuItem sideItem) {
        this.sideItem = sideItem;
    }

    public MenuItem getDrinkItem() {
        return drinkItem;
    }

    public void setDrinkItem(MenuItem drinkItem) {
        this.drinkItem = drinkItem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
