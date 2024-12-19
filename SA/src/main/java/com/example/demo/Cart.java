package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.CartService.ItemRecord;
import com.example.demo.CartService.SetRecord;

public class Cart {
	private int totalPrice = 0;
	private List<ItemRecord> items;

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ItemRecord> getItems() {
		return items;
	}

	public void setItems(List<ItemRecord> items) {
		this.items = items;
	}
	public List<SetRecord> setRecords = new ArrayList<>();;
	public List<ItemRecord> itemRecords;
	
	public int getTotalPrice() {
		int total = 0;

		for (ItemRecord item : itemRecords) {
			total += item.getPrice();
		}

		for (SetRecord setRecord : setRecords) {
			total += setRecord.getPrice();
		}

		return total;
	}
	public void updateItemQuantity(String recordID, int newAmount) {
		// 找到對應的 ItemRecord
		ItemRecord item = itemRecords.stream().filter(i -> i.getRecordID().equals(recordID)).findFirst()
				.orElseThrow(() -> new RuntimeException("Item not found"));
		int originalPrice = item.getPrice();
		item.setAmount(newAmount); // 更新數量
		int price = item.getPrice()* item.getAmount();
		item.setPrice(price);
		totalPrice = getTotalPrice(); // 重新計算總價
	}

	public void updateSetQuantity(String recordID, int newAmount) {
		// 找到對應的 SetRecord
		SetRecord setRecord = setRecords.stream().filter(s -> s.getsetRecordID().equals(recordID)).findFirst()
				.orElseThrow(() -> new RuntimeException("Set record not found"));
		int originalPrice = setRecord.getPrice();
		// 更新數量
		setRecord.setAmount(newAmount);

		// 重新計算套餐總價
		int price = (setRecord.getMainItem().getPrice() + setRecord.getSideItem().getPrice()) * newAmount;
		setRecord.setPrice(price);

		// 更新總金額
		totalPrice = getTotalPrice();
	}

	public void deleteItem(String recordID) {
		itemRecords.removeIf(item -> item.getRecordID().equals(recordID)); // 刪除對應的項目
		totalPrice = getTotalPrice(); // 重新計算總價
	}

	public void deleteSetItem(String setRecordID) {
		setRecords.removeIf(set -> set.getsetRecordID().equals(setRecordID));
		totalPrice = getTotalPrice();
	}
	public List<ItemRecord> viewCart() {
		return itemRecords;
	}
	public void addItem(MenuItem menuItem, int amount, String content) {
		String recordID = UUID.randomUUID().toString();
		int totalItemPrice = menuItem.getPrice() * amount;
		itemRecords.add(new ItemRecord(recordID, menuItem.getItemID(), menuItem.getType(), menuItem.getName(), amount,
				totalItemPrice, content));
		totalPrice += totalItemPrice;
	}

	public void addSetMeal(MenuItem mainItem, MenuItem sideItem, MenuItem drinkItem, int amount, int totalPrice) {
		String setRecordID = UUID.randomUUID().toString();
		SetRecord setRecord = new SetRecord(setRecordID, mainItem, sideItem, drinkItem, amount, totalPrice); 
																												
		setRecords.add(setRecord);
		this.totalPrice += totalPrice;
	}
}
