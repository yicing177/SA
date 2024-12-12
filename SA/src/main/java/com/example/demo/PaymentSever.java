package com.example.demo;

public class PaymentSever {

    private int paymentID;
    private String paymentMethod;
    private String paymentStatus;
    private String receipt;
		
    // Getter and Setter for paymentID
    public int getPaymentID() {
    	// TODO Auto-generated method stub
        return paymentID;
    }
    
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    // Getter and Setter for paymentMethod
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Getter and Setter for paymentStatus
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Getter and Setter for receipt
    public String getReceipt() {
        return receipt;
	}
}


