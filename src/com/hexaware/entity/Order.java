package com.hexaware.entity;

import java.util.Date;

public class Order {
    private int orderID;
    private String customerName;
    private String customerAddress;
    private String itemDescription;
    private int courierID;
    private Date orderDate;

    public Order(String customerName, String customerAddress, String itemDescription, Date orderDate) {
    	//this.orderID = orderID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.itemDescription = itemDescription;
        //this.courierID = courierID;
        this.orderDate = orderDate;
    }

    // Getters and setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getCourierID() {
        return courierID;
    }

    public void setCourierID(int courierID) {
        this.courierID = courierID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    // toString method
    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", courierID=" + courierID +
                ", orderDate=" + orderDate +
                '}';
    }
}


