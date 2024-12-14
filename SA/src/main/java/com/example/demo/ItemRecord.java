package com.example.demo;

public class ItemRecord {
	private String recordID;
	private String itemID;
	private int recordPrice;
	private int amount;
	private String foodInfo;
	private String content;
	private String type;
	private String name;

	public ItemRecord(String recordID, String itemID, String type, String name, int amount, double price,
			String content) {
		this.recordID = recordID;
		this.itemID = itemID;
		this.type = type;
		this.name = name;
		this.amount = amount;
		this.recordPrice = recordPrice;
		this.content = content;
	}
}
