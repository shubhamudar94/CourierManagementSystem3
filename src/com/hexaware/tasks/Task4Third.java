package com.hexaware.tasks;

import java.util.Scanner;

public class Task4Third {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter street: ");
		String street = scanner.nextLine();

		System.out.print("Enter city: ");
		String city = scanner.nextLine();

		System.out.print("Enter state: ");
		String state = scanner.nextLine();

		System.out.print("Enter zip code: ");
		String zipCode = scanner.nextLine();

		System.out.println("Initial Address: " + street + " " + city + " " + state + " " + zipCode);

		String formattedAddress = formatAddress(street, city, state, zipCode);
		System.out.println("Formatted Address: " + formattedAddress);

		scanner.close();
	}

	private static String formatAddress(String street, String city, String state, String zipCode) {
		String formattedStreet = capitalizeEachWord(street);
		String formattedCity = capitalizeEachWord(city);
		String formattedState = capitalizeEachWord(state);

		String formattedZipCode = formatZipCode(zipCode);

		return formattedStreet + ", " + formattedCity + ", " + formattedState + " " + formattedZipCode;
	}

	private static String capitalizeEachWord(String input) {
		String[] words = input.split("\\s+");
		StringBuilder result = new StringBuilder();

		for (String word : words) {
			result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
		}

		return result.toString().trim();
	}

	private static String formatZipCode(String zipCode) {
		return zipCode.replaceAll("\\D", ""); // Remove non-digit characters
	}
}
