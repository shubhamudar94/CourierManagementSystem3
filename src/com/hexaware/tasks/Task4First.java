package com.hexaware.tasks;

import java.util.Scanner;

public class Task4First {
	public static void main(String[] args) {
		String[][] parcelTrackingData = { { "ABC123", "In transit" }, { "XYZ456", "Out for delivery" },
				{ "123DEF", "Delivered" }, { "456GHI", "In transit" } };

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter parcel tracking number: ");
		String inputTrackingNumber = scanner.nextLine();

		String status = findStatus(parcelTrackingData, inputTrackingNumber);

		if (status != null) {
			switch (status.toLowerCase()) {
			case "in transit":
				System.out.println("Parcel with tracking number " + inputTrackingNumber + " is in transit.");
				break;
			case "out for delivery":
				System.out.println("Parcel with tracking number " + inputTrackingNumber + " is out for delivery.");
				break;
			case "delivered":
				System.out.println("Parcel with tracking number " + inputTrackingNumber + " has been delivered.");
				break;
			default:
				System.out.println("Unknown status for tracking number " + inputTrackingNumber);
			}
		} else {
			System.out.println("Tracking number not found.");
		}
	}

	private static String findStatus(String[][] parcelTrackingData, String trackingNumber) {
		for (String[] parcel : parcelTrackingData) {
			if (parcel[0].equalsIgnoreCase(trackingNumber)) {
				return parcel[1];
			}
		}
		return null;
	}
}
