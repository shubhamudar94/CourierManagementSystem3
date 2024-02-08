package com.hexaware.dao;

import com.hexaware.entity.Courier;
import com.hexaware.entity.CourierCompanyCollection;
import com.hexaware.dao.ICourierUserService;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class CourierUserServiceCollectionImpl implements ICourierUserService {
	protected CourierCompanyCollection companyObj;

	public CourierUserServiceCollectionImpl(CourierCompanyCollection companyObj) {
		this.companyObj = companyObj;
	}

	@Override
	public String placeOrder(Courier courierObj) {
		// Implementation for placing an order
		companyObj.getCourierDetails().add(courierObj);
		// Generate and return the tracking number
		return generateTrackingNumber();
	}

	@Override
	public String getOrderStatus(String trackingNumber) {
		// Implementation for getting order status
		// Iterate through courier details to find the order with the matching tracking
		// number
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
		// Iterate through courier details to find the order with the matching tracking
		// number and remove it
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
		// Iterate through courier details to find orders assigned to the specified
		// staff member
		for (Courier courier : companyObj.getCourierDetails()) {
			if (courier.getEmployeeID() == courierStaffId) {
				assignedOrders.add(courier);
			}
		}
		return assignedOrders;
	}

	// Method to generate a tracking number (example implementation)
	private String generateTrackingNumber() {
		// Generate and return a unique tracking number
		return UUID.randomUUID().toString();
	}
}
