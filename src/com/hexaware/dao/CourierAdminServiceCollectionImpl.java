package com.hexaware.dao;

import com.hexaware.entity.CourierCompanyCollection;
import com.hexaware.entity.Employee;

public class CourierAdminServiceCollectionImpl extends CourierUserServiceCollectionImpl implements ICourierAdminService {

    public CourierAdminServiceCollectionImpl(CourierCompanyCollection companyObj) {
        super(companyObj);
    }

    @Override
    public int addCourierStaff(String employeeName, String contactNumber) {
        // Implementation for adding a new courier staff member
        // Example: Create a new Employee object
        Employee newEmployee = new Employee(employeeName, contactNumber);
        // Add the new employee to the company's list of employee details
        companyObj.getEmployeeDetails().add(newEmployee);
        // Return the ID of the newly added courier staff member
        return newEmployee.getEmployeeID();
    }
}
