                  package com.example.demo;

public class Manager {
	private String name;
    private String managerID;
    private String contactInfo;

    // Constructor
    public Manager(String name, String managerID, String contactInfo) {
        this.name = name;
        this.managerID = managerID;
        this.contactInfo = contactInfo;
    }
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
