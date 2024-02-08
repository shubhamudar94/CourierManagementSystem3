package com.hexaware.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task4Fifth {
	private static final Map<String, Map<String, Double>> cityDistances = new HashMap<>();

	static {
		Map<String, Double> puneDistances = new HashMap<>();
		puneDistances.put("Mumbai", 149.0);
		puneDistances.put("Ahmednagar", 120.0);
		cityDistances.put("Pune", puneDistances);

		Map<String, Double> mumbaiDistances = new HashMap<>();
		mumbaiDistances.put("Pune", 149.0);
		mumbaiDistances.put("Ahmednagar", 266.0);
		cityDistances.put("Mumbai", mumbaiDistances);

		Map<String, Double> ahmednagarDistances = new HashMap<>();
		ahmednagarDistances.put("Pune", 120.0);
		ahmednagarDistances.put("Mumbai", 266.0);
		cityDistances.put("Ahmednagar", ahmednagarDistances);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Available cities: Pune, Mumbai, Ahmednagar");

		System.out.print("Enter source city: ");
		String sourceCity = scanner.nextLine();

		System.out.print("Enter destination city: ");
		String destinationCity = scanner.nextLine();

		if (!cityDistances.containsKey(sourceCity) || !cityDistances.containsKey(destinationCity)) {
			System.out.println("Invalid city names. Please enter cities from the provided list.");
			return;
		}

		System.out.print("Enter parcel weight (in kg): ");
		double parcelWeight = scanner.nextDouble();

		double shippingCost = calculateShippingCost(sourceCity, destinationCity, parcelWeight);
		System.out.println("Shipping cost: ₹" + shippingCost);

		scanner.close();
	}

	private static double calculateShippingCost(String sourceCity, String destinationCity, double parcelWeight) {
		double distance = cityDistances.get(sourceCity).get(destinationCity);

		double weightCost = parcelWeight * 2.5; // ₹2.50 per kg

		return distance + weightCost;
	}
}
