package com.example.demo;

public class Order {
	private String orderID;
    private String orderStatus;
    private String orderContent;
    private String orderDate;

    public void showOrderStatus() {
        // 顯示訂單狀態邏輯
    }

    // Getter 和 Setter
    public String getOrderID() {
        return orderID;
    }

    public void setOrderid(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String ordercContent) {
        this.orderContent = orderContent;
    }

    }
