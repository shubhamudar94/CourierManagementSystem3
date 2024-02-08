package com.hexaware.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.hexaware.controller.CustomerController;
import com.hexaware.exception.UserNotFoundException;

public class CustomerMain {
	
	public static void main(String[] args) {
		System.out.println("Welcome to CustomerLogin");
		CustomerController cc = new CustomerController();
		Scanner sc = new Scanner(System.in);
		String ch =null;
		do {
		System.out.println("Enter your choice");
		System.out.println("1. Add Customer");
		System.out.println("2. View Customer");
		
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			cc.addCustomer();
			break;
		}
		case 2: {
			cc.viewCustomer();
			break;
		}
		default: {
			System.out.println("Enter a valid Choice !!!");
			break;
		}
		}
		System.out.println("Do u wnt to continue ? Y or y");
		ch = sc.next();
		
		}while(ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system !!!");
		System.exit(0);

	}
}
