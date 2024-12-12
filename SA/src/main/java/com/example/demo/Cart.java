package com.example.demo;

import java.util.List;

import com.example.demo.CartService.ItemRecord;

public class Cart {
    private double totalPrice;
    private List<ItemRecord> items;


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ItemRecord> getItems() {
        return items;
    }

    public void setItems(List<ItemRecord> items) {
        this.items = items;
    }
    public void modifyItemRecord(ItemRecord item) {
        // 修改購物車項目邏輯
    }

    public void deleteItemRecord(ItemRecord item) {
        // 刪除購物車項目邏輯
    }

    public void addItem(ItemRecord item) {
        items.add(item);
    }

    public int addSetItem(int itemID, int price, int setPrice ) {
    	setPrice = 0;
    	setPrice = setPrice + price;
    	return setPrice;
    }

    }

    // Getter 和 Setter