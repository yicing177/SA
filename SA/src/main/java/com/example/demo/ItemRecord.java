package com.example.demo;

public class ItemRecord {
	private String recordID;
	private String itemID;
	private String type;
	private String name;
	private int amount;
	private int price;

	// Constructor
	public ItemRecord(String recordID, String itemID, String type, String name, int amount, int price, String content) {
		this.recordID = recordID;
		this.itemID = itemID;
		this.type = type;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRecordID() {
		return recordID;
	}

	public String getItemID() {
		return itemID;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public int getPrice() {
		return price;
	}
}