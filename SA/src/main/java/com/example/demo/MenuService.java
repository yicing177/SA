package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    // 定義菜單項目類別
    public static class menuItem {
        private String itemID;
        private String type; // "main", "submeal", "beverage"
        private String name;
        private double price;
        private String description;
        // Constructor
        public menuItem(String itemID, String type, String name, double price, String description) {
            this.itemID = itemID;
            this.type = type;
            this.name = name;
            this.price = price;
            this.description = description;
        }
        // Getters
        public String getItemID() {
            return itemID;
        }
        public String getType() {
            return type;
        }
        public String getName() {
            return name;
        }
        public double getPrice() {
            return price;
        }
        public String getDescription() {
            return description;
        }
        @Override
        public String toString() {
            return "menuItem{" +
                    "itemID='" + itemID + '\'' +
                    ", type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
    // 菜單列表
    private List<menuItem> menuItems;
    // Constructor
    public MenuService() {
        this.menuItems = new ArrayList<>();
    }
    // 新增菜單項目
    public void addMenuItem(menuItem menuItem) {
        menuItems.add(menuItem);
    }
    /**
     * 根據type查找菜單項目。
     * @param type 菜單項目的類型，例如"main"、"submeal"、"beverage"
     * @return 符合條件的菜單項目列表
     */
    public List<menuItem> getMenuItem(String type) {
        List<menuItem> filteredItems = new ArrayList<>();
        for (menuItem item : menuItems) {
            if (type == null || item.getType().equalsIgnoreCase(type)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
    public static void main(String[] args) {
        // 測試
        MenuService menu = new MenuService();
        menu.addMenuItem(new menuItem("1", "main", "Steak", 15.99, "Grilled steak with sauce"));
        menu.addMenuItem(new menuItem("2", "submeal", "Salad", 5.99, "Fresh garden salad"));
        menu.addMenuItem(new menuItem("3", "beverage", "Cola", 1.99, "Chilled cola drink"));
        menu.addMenuItem(new menuItem("4", "main", "Pasta", 12.99, "Creamy Alfredo pasta"));
        System.out.println("--- 主餐 ---");
        List<menuItem> mainItems = menu.getMenuItem("main");
        for (menuItem item : mainItems) {
            System.out.println(item);
        }
        System.out.println("\n--- 飲料 ---");
        List<menuItem> beverageItems = menu.getMenuItem("beverage");
        for (menuItem item : beverageItems) {
            System.out.println(item);
        }
        System.out.println("\n--- 所有項目 ---");
        List<menuItem> allItems = menu.getMenuItem(null);
        for (menuItem item : allItems) {
            System.out.println(item);
        }
    }
}
