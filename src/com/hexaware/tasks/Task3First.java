package com.hexaware.tasks;

public class Task3First {
	public static void main(String[] args) {
		double[] trackingHistory = new double[10];
		int currentUpdateIndex = 0; // index to keep track of the current update

		simulateLocationUpdate(trackingHistory, currentUpdateIndex++, 0.0);
		simulateLocationUpdate(trackingHistory, currentUpdateIndex++, 10.0);
		simulateLocationUpdate(trackingHistory, currentUpdateIndex++, 25.0);
		simulateLocationUpdate(trackingHistory, currentUpdateIndex++, 50.0);
		simulateLocationUpdate(trackingHistory, currentUpdateIndex++, 75.0);
		simulateLocationUpdate(trackingHistory, currentUpdateIndex++, 100.0);

		displayTrackingHistory(trackingHistory, currentUpdateIndex);
	}

	private static void simulateLocationUpdate(double[] trackingHistory, int index, double location) {
		trackingHistory[index] = location;
	}

	private static void displayTrackingHistory(double[] trackingHistory, int endIndex) {
		System.out.println("Parcel Tracking History:");
		for (int i = 0; i < endIndex; i++) {
			System.out.println("Update " + (i + 1) + ": Location " + trackingHistory[i]);
		}
	}
}
