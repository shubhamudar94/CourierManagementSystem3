package com.hexaware.tasks;

import java.util.ArrayList;
import java.util.List;

class Courier {
	String name;
	double proximity; // dist from the shipment location
	double loadCapacity; // max weight the courier can carry

	Courier(String name, double proximity, double loadCapacity) {
		this.name = name;
		this.proximity = proximity;
		this.loadCapacity = loadCapacity;
	}
}

class Shipment {
	double shipmentWeight;
	String assignedCourier;

	Shipment(double shipmentWeight) {
		this.shipmentWeight = shipmentWeight;
		this.assignedCourier = null;
	}
}

public class Task1Fourth {
	public static void main(String[] args) {
		List<Courier> couriers = initializeCouriers();
		List<Shipment> shipments = initializeShipments();

		for (Shipment shipment : shipments) {
			for (Courier courier : couriers) {

				if (courier.proximity < 10 && courier.loadCapacity >= shipment.shipmentWeight) {
					shipment.assignedCourier = courier.name;
					System.out.println(
							"Courier " + courier.name + " assigned to shipment with weight " + shipment.shipmentWeight);
					break;
				}
			}
		}

		for (Shipment shipment : shipments) {
			if (shipment.assignedCourier != null) {
				System.out.println("Shipment with weight " + shipment.shipmentWeight + " assigned to Courier "
						+ shipment.assignedCourier);
			} else {
				System.out.println("No courier available for shipment with weight " + shipment.shipmentWeight);
			}
		}
	}

	private static List<Courier> initializeCouriers() {
		List<Courier> couriers = new ArrayList<>();
		couriers.add(new Courier("CourierA", 5.0, 20.0));
		couriers.add(new Courier("CourierB", 12.0, 15.0));
		return couriers;
	}

	private static List<Shipment> initializeShipments() {
		List<Shipment> shipments = new ArrayList<>();
		shipments.add(new Shipment(12.0));
		shipments.add(new Shipment(8.0));
		shipments.add(new Shipment(25.0));
		return shipments;
	}
}
