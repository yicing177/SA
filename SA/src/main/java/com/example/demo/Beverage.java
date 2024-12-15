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
    
}