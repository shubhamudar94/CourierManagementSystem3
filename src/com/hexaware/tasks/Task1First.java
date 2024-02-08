package com.hexaware.tasks;

import java.util.Scanner;


public class Task1First {
    public static void main(String[] args) {
       
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the order status(Processing, Delivered, Cancelled): ");
        String orderStatus = sc.nextLine();
        sc.close();

       
        if (orderStatus.equalsIgnoreCase("Processing")) {
            System.out.println("NOT DELIVERED");
        } else if (orderStatus.equalsIgnoreCase("Delivered")) {
            System.out.println("DELIVERED SUCCESSFULLY");
        } else if (orderStatus.equalsIgnoreCase("Cancelled")) {
            System.out.println("NOT DELIVERED, ORDER HAS BEEN CANCELLED.");
        } else {
            System.out.println("PLEASE ENTER VALID STATUS");
        }
    }
}