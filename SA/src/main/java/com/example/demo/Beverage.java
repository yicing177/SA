package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Beverage extends MenuItem {
    private Boolean isCold;
    private String sugar;

    public Beverage(String type, String itemID, String name, int price, String description, Boolean isCold, String sugar) {
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

    /*public void setDiscount() {
        System.out.println("Beverage will be free.");
    }
	*/
    
    public static void main(String[] args) {
        // Create specific beverages
        Beverage 可悲 = new Beverage("Drink", "B001", "可悲", 83, "比可樂還好喝", true, "半糖");
        Beverage 冰碧 = new Beverage("Drink", "B002", "冰碧", 47, "比雪碧還好喝", true, "少糖");
        Beverage 蘭達 = new Beverage("Drink", "B003", "蘭達", 90, "比芬達還好喝", false, "無糖");

        // Add beverages to a list
        List<Beverage> beverageList = new ArrayList<>();
        beverageList.add(可悲);
        beverageList.add(冰碧);
        beverageList.add(蘭達);

        // Display beverages
        System.out.println("可選擇的飲料");
        for (Beverage beverage : beverageList) {
            System.out.println("商品名稱: " + beverage.getName() + ", 價格: " + beverage.getPrice() + ", Description: " + beverage.getDescription());
            System.out.println("要冰嗎: " + (beverage.isCold() ? "Yes" : "No") + ", 甜度: " + beverage.getSugar());
        }
        
        /*
        // Example of applying discount
        System.out.println("\nApplying discount...");
        可悲.setDiscount();*/
    }
}