//TASK 5.3

package com.hexaware.entity;

public class Employee {
	// Variables
	private int employeeID;
	private String employeeName;
	private String email;
	private String contactNumber;
	private String role;
	private double salary;

	// Default Constructor
	public Employee() {
	}
	
	
	// Parameterized Constructor
	public Employee(int employeeID, String employeeName, String email, String contactNumber, String role,
			double salary) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.role = role;
		this.salary = salary;
	}
	
	public Employee(String employeeName, String contactNumber) {
        this.employeeName = employeeName;
        this.contactNumber = contactNumber;
    }

	// Getters and Setters
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	// toString method
	@Override
	public String toString() {
		return "Employee{" + "employeeID=" + employeeID + ", employeeName='" + employeeName + '\'' + ", email='" + email
				+ '\'' + ", contactNumber='" + contactNumber + '\'' + ", role='" + role + '\'' + ", salary=" + salary
				+ '}';
	}
}
