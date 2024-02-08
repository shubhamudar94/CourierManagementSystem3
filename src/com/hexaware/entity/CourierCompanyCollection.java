package com.hexaware.entity;

import java.util.ArrayList;
import java.util.List;

public class CourierCompanyCollection {
	// Variables
	private String companyName;
	private List<Courier> courierDetails;
	private List<Employee> employeeDetails;
	private List<Location> locationDetails;

	// Constructors
	public CourierCompanyCollection() {
		courierDetails = new ArrayList<>();
		employeeDetails = new ArrayList<>();
		locationDetails = new ArrayList<>();
	}

	public CourierCompanyCollection(String companyName) {
		this();
		this.companyName = companyName;
	}

	// Getters and Setters
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Courier> getCourierDetails() {
		return courierDetails;
	}

	public void setCourierDetails(List<Courier> courierDetails) {
		this.courierDetails = courierDetails;
	}

	public List<Employee> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(List<Employee> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public List<Location> getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(List<Location> locationDetails) {
		this.locationDetails = locationDetails;
	}

	// Additional methods for adding, removing, updating details as needed
}
