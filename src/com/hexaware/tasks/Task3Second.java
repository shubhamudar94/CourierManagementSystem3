package com.hexaware.tasks;

class Couriers {
	String name;
	double currentLocation;
	boolean available;

	Couriers(String name, double currentLocation) {
		this.name = name;
		this.currentLocation = currentLocation;
		this.available = true;
	}
}

public class Task3Second {
	public static void main(String[] args) {
		Couriers[] couriers = initializeCouriers();
		double orderLocation = 69.0;

		Couriers nearestCourier = findNearestCourier(couriers, orderLocation);

		if (nearestCourier != null) {
			System.out.println("Nearest available courier for the new order is: " + nearestCourier.name);
		} else {
			System.out.println("No available couriers.");
		}
	}

	private static Couriers[] initializeCouriers() {
		return new Couriers[] { new Couriers("CourierA", 10.0), new Couriers("CourierB", 30.0),
				new Couriers("CourierC", 50.0), new Couriers("CourierD", 70.0), new Couriers("CourierE", 90.0) };
	}

	private static Couriers findNearestCourier(Couriers[] couriers, double orderLocation) {
		Couriers nearestCourier = null;
		double minDistance = Double.MAX_VALUE;

		for (Couriers courier : couriers) {
			if (courier.available) {
				double distance = Math.abs(courier.currentLocation - orderLocation);

				if (distance < minDistance) {
					minDistance = distance;
					nearestCourier = courier;
				}
			}
		}

		return nearestCourier;
	}
}
