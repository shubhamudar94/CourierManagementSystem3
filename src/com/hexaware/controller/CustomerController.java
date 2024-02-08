package com.hexaware.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.hexaware.exception.UserNotFoundException;
import com.hexaware.model.Customer;


public class CustomerController {
	
	Customer cus = new Customer();
	Scanner sc = new Scanner(System.in);
	public void addCustomer() {
		System.out.println("Enter Cusno");
		int cid = sc.nextInt();
		cus.setCusno(cid);
		System.out.println("Enter Cname");
		String cname = sc.next();		
		cus.setCname(cname);
		System.out.println("Customer " + cid + " added Successfully !!!");
	}
	


	public void viewCustomer() {
		System.out.println("Cid : "+ cus.getCusno() + " Cname :  " + cus.getCname());
	}
	
}

