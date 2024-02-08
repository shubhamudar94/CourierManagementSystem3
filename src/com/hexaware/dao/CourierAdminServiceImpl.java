package com.hexaware.dao;

import com.hexaware.entity.CourierCompany;
import com.hexaware.entity.Employee;


public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService {
    
    public CourierAdminServiceImpl(CourierCompany companyObj) {
        super(companyObj);
    }

    @Override
    public int addCourierStaff(String name, String contactNumber) {
        // Implementation for adding a new courier staff member
        Employee newEmployee = new Employee(); // Example: Create a new Employee object
        newEmployee.setEmployeeName(name);
        newEmployee.setContactNumber(contactNumber);
        // Add the new employee to the company's list of employee details
        companyObj.getEmployeeDetails().add(newEmployee);
        // Return the ID of the newly added courier staff member
        return newEmployee.getEmployeeID();
    }
}

