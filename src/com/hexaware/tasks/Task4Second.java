package com.hexaware.tasks;

public class Task4Second {
	public static void main(String[] args) {
		// Example usage:
		validateCustomerInfo("Shubham Udar", "name");
		validateCustomerInfo("123 @ Clny 10", "address");
		validateCustomerInfo("5667 St 7", "address");
		validateCustomerInfo("555-123-4567", "phone number");
		validateCustomerInfo("555-123-45667", "phone number");
		validateCustomerInfo("Sangamesh123", "name");
	}

	private static void validateCustomerInfo(String data, String detail) {
		boolean isValid;

		switch (detail.toLowerCase()) {
		case "name":
			isValid = isValidName(data);
			break;
		case "address":
			isValid = isValidAddress(data);
			break;
		case "phone number":
			isValid = isValidPhoneNumber(data);
			break;
		default:
			System.out.println("Invalid detail type.");
			return;
		}

		if (isValid) {
			System.out.println(detail + " is valid: " + data);
		} else {
			System.out.println(detail + " is not valid: " + data);
		}
	}

	private static boolean isValidName(String name) {
		return name.matches("[A-Za-z]+(?:\\s[A-Za-z]+)*");
	}

	private static boolean isValidAddress(String address) {
		return address.matches("[\\w\\s]+");
	}

	private static boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
	}
}
