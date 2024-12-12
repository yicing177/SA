package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CartService {

    private List<ItemRecord> itemRecords;
    private double totalPrice;

    // Constructor
    public CartService() {
        this.itemRecords = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    // 定義點餐記錄類別
    public static class ItemRecord {
        private String recordID;
        private String itemID;
        private String type;
        private String name;
        private int amount;
        private double price;
        private String content;

        // Constructor
        public ItemRecord(String recordID, String itemID, String type, String name, int amount, double price, String content) {
            this.recordID = recordID;
            this.itemID = itemID;
            this.type = type;
            this.name = name;
            this.amount = amount;
            this.price = price;
            this.content = content;
        }

        public String getRecordID() {
            return recordID;
        }

        @Override
        public String toString() {
            return "ItemRecord{" +
                    "recordID='" + recordID + '\'' +
                    ", itemID='" + itemID + '\'' +
                    ", type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", amount=" + amount +
                    ", price=" + price +
                    ", content='" + content + '\'' +
                    '}';
        }
    }

    // 添加菜單項目至購物車
    public void addItem(MenuService.menuItem menuItem, int amount, String content) {
        String recordID = UUID.randomUUID().toString();
        double totalItemPrice = menuItem.getPrice() * amount;
        itemRecords.add(new ItemRecord(recordID, menuItem.getItemID(), menuItem.getType(), menuItem.getName(), amount, totalItemPrice, content));
        totalPrice += totalItemPrice;
    }

    // 添加套餐項目至購物車
    public void addSetItem(MenuService.menuItem mainItem, MenuService.menuItem submealItem, MenuService.menuItem beverageItem, String content) {
        // 確保項目類型正確
        if (!"main".equalsIgnoreCase(mainItem.getType()) || !"submeal".equalsIgnoreCase(submealItem.getType()) || !"beverage".equalsIgnoreCase(beverageItem.getType())) {
            throw new IllegalArgumentException("Invalid item types for a set. Required: main, submeal, beverage.");
        }

        String recordID = UUID.randomUUID().toString();
        // 計算套餐價格，不包含飲料的價格
        double setPrice = mainItem.getPrice() + submealItem.getPrice();
        itemRecords.add(new ItemRecord(recordID, mainItem.getItemID() + "," + submealItem.getItemID() + "," + beverageItem.getItemID(),
                "set", mainItem.getName() + "+" + submealItem.getName() + "+" + beverageItem.getName(), 1, setPrice, content));
        totalPrice += setPrice;
    }

    // 自定義餐點內容
    public String customize(String itemID, String note) {
        return "Customized note for item " + itemID + ": " + note;
    }

    // 刪除點餐記錄
    public void deleteItemRecord(String recordID) {
        ItemRecord recordToRemove = null;
        for (ItemRecord record : itemRecords) {
            if (record.getRecordID().equals(recordID)) {
                recordToRemove = record;
                break;
            }
        }
        if (recordToRemove != null) {
            itemRecords.remove(recordToRemove);
            totalPrice -= recordToRemove.price;
        } else {
            System.out.println("Record with ID " + recordID + " not found.");
        }
    }

    // 修改點餐記錄
    public void modifyItemRecord(String recordID, int amount, String content) {
        if (amount < 1) {
            System.out.println("Amount must be at least 1.");
            return;
        }

        for (ItemRecord record : itemRecords) {
            if (record.getRecordID().equals(recordID)) {
                double originalPrice = record.price;
                record.amount = amount;
                record.price = record.amount * (record.price / record.amount); // 單價重新計算
                record.content = content;

                totalPrice = totalPrice - originalPrice + record.price;
                return;
            }
        }

        System.out.println("Record with ID " + recordID + " not found.");
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<ItemRecord> getItemRecords() {
        return itemRecords;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart Details:\n");
        for (ItemRecord record : itemRecords) {
            sb.append(record.toString()).append("\n");
        }
        sb.append("Total Price: ").append(totalPrice).append("\n");
        return sb.toString();
    }
    
 // 查看購物車內容
    public void viewCart() {
        System.out.println("Current Cart Details:");
        for (ItemRecord record : itemRecords) {
            System.out.println(record);
        }
        System.out.println("Total Price: " + totalPrice);
    }



    public static void main(String[] args) {
        // 測試功能
        MenuService menuService = new MenuService();
        menuService.addMenuItem(new MenuService.menuItem("1", "main", "Steak", 15.99, "Grilled steak with sauce"));
        menuService.addMenuItem(new MenuService.menuItem("2", "submeal", "Salad", 5.99, "Fresh garden salad"));
        menuService.addMenuItem(new MenuService.menuItem("3", "beverage", "Cola", 1.99, "Chilled cola drink"));
        menuService.addMenuItem(new MenuService.menuItem("4", "main", "Pasta", 12.99, "Creamy Alfredo pasta"));
        menuService.addMenuItem(new MenuService.menuItem("5", "submeal", "Soup", 4.99, "Hot chicken soup"));
        menuService.addMenuItem(new MenuService.menuItem("6", "beverage", "Tea", 2.99, "Hot green tea"));

        CartService cart = new CartService();
        
        // 添加單點
        MenuService.menuItem steak = menuService.getMenuItem("main").get(0);
        MenuService.menuItem pasta = menuService.getMenuItem("main").get(1);
        String steakContent = cart.customize(steak.getItemID(), "Medium rare");
        String pastaContent = cart.customize(pasta.getItemID(), "Extra cheese");
        cart.addItem(steak, 2, steakContent);
        cart.addItem(pasta, 1, pastaContent);
        
        // 查看現存購物車內容
        cart.viewCart();

        // 添加套餐
        MenuService.menuItem salad = menuService.getMenuItem("submeal").get(0);
        MenuService.menuItem soup = menuService.getMenuItem("submeal").get(1);
        MenuService.menuItem cola = menuService.getMenuItem("beverage").get(0);
        MenuService.menuItem tea = menuService.getMenuItem("beverage").get(1);

        String setContent1 = cart.customize(steak.getItemID() + "," + salad.getItemID() + "," + cola.getItemID(), "No ice, Medium rare");
        String setContent2 = cart.customize(pasta.getItemID() + "," + soup.getItemID() + "," + tea.getItemID(), "Less sugar");
        cart.addSetItem(steak, salad, cola, setContent1);
        cart.addSetItem(pasta, soup, tea, setContent2);

        // 查看現存購物車內容
        cart.viewCart();
        
        
        // 修改單點記錄
        String recordIDToModify = cart.getItemRecords().get(0).getRecordID();
        cart.modifyItemRecord(recordIDToModify, 3, "Well done");
        
        // 查看現存購物車內容
        cart.viewCart();

        // 刪除套餐記錄
        String recordIDToDelete = cart.getItemRecords().get(3).getRecordID();
        cart.deleteItemRecord(recordIDToDelete);

        // 查看現存購物車內容
        cart.viewCart();
    }
}

