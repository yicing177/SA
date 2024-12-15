package com.example.demo;

import java.util.List;

public class Cart {
	private int totalPrice = 0;
	private List<ItemRecord> items;

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ItemRecord> getItems() {
		return items;
	}

	public void setItems(List<ItemRecord> items) {
		this.items = items;
	}
}
