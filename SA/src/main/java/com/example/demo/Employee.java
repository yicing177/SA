package com.example.demo;

public class Employee {
    private String name;
    private String employeeID;
    private String contactInfo;

    public void updateStatus() {
        // 更新狀態邏輯
    }

    public void viewOrder() {
        // 查看訂單邏輯
    }

    public void confirmOrder() {
        // 確認訂單邏輯
    }
    
    // Getter 和 Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}

