package com.hexaware.dao;

import com.hexaware.entity.Courier;
import com.hexaware.entity.CourierCompany;
import com.hexaware.dao.ICourierUserService;
import java.util.List;
import java.util.ArrayList;

public class CourierUserServiceImpl implements ICourierUserService {
	protected CourierCompany companyObj;

	public CourierUserServiceImpl(CourierCompany companyObj) {
		this.companyObj = companyObj;
	}

	@Override
	public String placeOrder(Courier courierObj) {
		// Implementation for placing an order
		// Example: Add the courier object to the company's list of courier details
		companyObj.addCourier(courierObj);
		// Return the generated tracking number
		return courierObj.getTrackingNumber();
	}

	@Override
	public String getOrderStatus(String trackingNumber) {
		// Implementation for getting order status
		// Example: Search for the courier object with the provided tracking number
		for (Courier courier : companyObj.getCourierDetails()) {
			if (courier.getTrackingNumber().equals(trackingNumber)) {
				return courier.getStatus();
			}
		}
		return "Order not found";
	}

	@Override
	public boolean cancelOrder(String trackingNumber) {
		// Implementation for canceling an order
		// Example: Search for the courier object with the provided tracking number and
		// remove it
		for (Courier courier : companyObj.getCourierDetails()) {
			if (courier.getTrackingNumber().equals(trackingNumber)) {
				companyObj.getCourierDetails().remove(courier);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Courier> getAssignedOrder(int courierStaffId) {
		// Implementation for getting orders assigned to a specific courier staff member
		List<Courier> assignedOrders = new ArrayList<>();
		// Example: Search for courier objects assigned to the specified staff member
		for (Courier courier : companyObj.getCourierDetails()) {
			if (courier.getEmployeeID() == courierStaffId) {
				assignedOrders.add(courier);
			}
		}
		return assignedOrders;
	}
}
