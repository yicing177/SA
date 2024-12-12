package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
	private int customerID;
	private String phoneNumber;
	private List<Menu> menus;//1...*對1 關西
	
	public Customer(int customerID, String phoneNumber) {
		this.customerID = customerID ;
		this.phoneNumber = phoneNumber;
		this.menus=new ArrayList<>();
	}
	//Default constructor
	public Customer() {
		this.menus = new ArrayList<>();
	}
		
	// Getters and Setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<Menu> getMenus() {
        return menus;
    }
    public void addMenu(Menu menu) {
    	this.menus.add(menu);
    }
    public void removeMenu(Menu menu) {
        this.menus.remove(menu);
    }

    // To display customer information and their menus
    @Override
    public String toString() {
        return "客戶 ID: " + customerID + ", 電話: " + phoneNumber + ", Menus: " + menus;
    }
}
    //method
   
	

