package com.hexaware.model;

public class Customer {
	
	private int cusno;
	private String cname;
	
	public Customer(){
		System.out.println("From Customer Constr...");
	}
	
	public Customer(int cno, String cname){
		this.cusno = cno;
		this.cname = cname;
	}
	public int getCusno() {
		return cusno;
	}
	public void setCusno(int cusno) {
		this.cusno = cusno;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public String toString() {
		return cusno+ " -- " +cname;
	}

}
