package com.example.demo;

import java.util.ArrayList;
import java.util.List;
public class Submeal extends MenuItem {
	private String sauce;
    private String ingredient;

    public Submeal(String type, String itemID, String name, int price, String description, String sauce, String ingredient) {
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
   
    public static void main(String[] args) {
       
    	Submeal 豬塊 = new Submeal("Snack", "SF001", "豬塊", 67, "因應禽流感，雞塊先以豬塊代替", "甜醋醬", "內含豬肉");
        Submeal 超派= new Submeal("Snack", "SF002", "超派", 22, "內含獵豹肉，吃了變超派", "地溝油", "內含獵豹肉");
        Submeal 倉鼠餅 = new Submeal("Snack", "SF003", "倉鼠餅", 87, "毛茸茸又可愛，少女打卡必備", "無", "伊晴小孩");
        Submeal 羅波高 = new Submeal("Snack", "SF004", "羅波高", 64, "", "辣醬", "");
        Submeal 育達出皮蛋 = new Submeal("Snack", "SF005", "育達出皮蛋", 13, "臭皮蛋", "皮蛋", "蛋");
        Submeal 陵邱香雞排 = new Submeal("Snack", "SF006", "陵邱香雞排", 8450, "", "蒜", "雞排");

        // Add to a list
        List<Submeal> submealList = new ArrayList<>();
        submealList.add(豬塊);
        submealList.add(超派);
        submealList.add(倉鼠餅);
        submealList.add(羅波高);
        submealList.add(育達出皮蛋);
        submealList.add(陵邱香雞排);

    }
}
