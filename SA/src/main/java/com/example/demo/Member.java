package com.example.demo;

public class Member extends Customer {
	private String name;
	private int memberID;

	
	public Member(String name, int memberID, String phoneNumber, int customerID) {
		super(customerID,phoneNumber);
		this.name = name;
		this.memberID= memberID;
	} 
	   // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

	
}
