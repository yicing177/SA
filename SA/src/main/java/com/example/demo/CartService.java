package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class CartService {

	public List<ItemRecord> itemRecords;
	private int totalPrice;

	// Constructor
	public CartService() {
		this.itemRecords = new ArrayList<>();
		this.totalPrice = 0;
	}

	// 定義點餐記錄類別
	public static class ItemRecord {
		private String recordID;
		private String itemID;
		private String type;
		private String name;
		private int amount;
		private int price;

		// Constructor
		public ItemRecord(String recordID, String itemID, String type, String name, int amount, int price,
				String content) {
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

		@Override
		public String toString() {
			return "ItemRecord{" + "recordID='" + recordID + '\'' + ", itemID='" + itemID + '\'' + ", type='" + type
					+ '\'' + ", name='" + name + '\'' + ", amount=" + amount + ", price=" + price +'}';
		}

		public void setTotalPrice(int i) {
			this.price = price;

		}
	}

	public static class SetRecord {
		private String setRecordID;
		private MenuItem mainItem;
		private MenuItem sideItem;
		private MenuItem drinkItem;
		private int amount; 
		private int price;

		public SetRecord(String setRecordID, MenuItem mainItem, MenuItem sideItem, MenuItem drinkItem, int amount,
				int price) {
			this.setRecordID = setRecordID;
			this.mainItem = mainItem;
			this.sideItem = sideItem;
			this.drinkItem = drinkItem;
			this.amount = amount;
			this.price = price;
		}

		// Getter 和 Setter 方法
		public String getsetRecordID() {
			return setRecordID;
		}

		public MenuItem getMainItem() {
			return mainItem;
		}

		public void setMainItem(MenuItem mainItem) {
			this.mainItem = mainItem;
		}

		public MenuItem getSideItem() {
			return sideItem;
		}

		public void setSideItem(MenuItem sideItem) {
			this.sideItem = sideItem;
		}

		public MenuItem getDrinkItem() {
			return drinkItem;
		}

		public void setDrinkItem(MenuItem drinkItem) {
			this.drinkItem = drinkItem;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}
	}

	// 添加菜單項目至購物車
	public void addItem(MenuItem menuItem, int amount, String content) {
		String recordID = UUID.randomUUID().toString();
		int totalItemPrice = menuItem.getPrice() * amount;
		itemRecords.add(new ItemRecord(recordID, menuItem.getItemID(), menuItem.getType(), menuItem.getName(), amount,
				totalItemPrice, content));
		totalPrice += totalItemPrice;
	}

	private List<SetRecord> setRecords = new ArrayList<>();

	public void addSetMeal(MenuItem mainItem, MenuItem sideItem, MenuItem drinkItem, int amount, int totalPrice) {
		String setRecordID = UUID.randomUUID().toString();
		SetRecord setRecord = new SetRecord(setRecordID, mainItem, sideItem, drinkItem, amount, totalPrice); 
																												
		setRecords.add(setRecord);
		this.totalPrice += totalPrice;
	}

	public List<SetRecord> viewSetCart() {
		return setRecords; 
	}

	public void updateItemQuantity(String recordID, int newAmount) {
		// 找到對應的 ItemRecord
		ItemRecord item = itemRecords.stream().filter(i -> i.getRecordID().equals(recordID)).findFirst()
				.orElseThrow(() -> new RuntimeException("Item not found"));
		int unitPrice = item.getPrice() / item.getAmount();
		item.setAmount(newAmount); // 更新數量
		int updatedPrice = unitPrice * newAmount;
	    item.setPrice(updatedPrice);
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

	public List<ItemRecord> getItemRecords() {
		return itemRecords;
	}

	public List<SetRecord> getSetRecords() {
		return setRecords;
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
	public List<ItemRecord> viewCart() {
		return itemRecords;
	}

	private final List<Cart> cartItems = new ArrayList<>();

	public void addToCart(Cart item) {
		cartItems.add(item);
	}

	public void clearCart() {
		cartItems.clear();
	}
}
