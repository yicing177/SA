package com.example.demo;

public class MenuItem {
	private String type;
	private Long itemID;
	private String name;
	private Double price;
	private String description;

	// Constructors, getters, setters, toString()
	public MenuItem(String type, Long id, String name, Double price, String description) {
		this.type = type;
		this.itemID = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	// Getters and Setters
}
