package com.hexaware.tasks;

import java.security.SecureRandom;

public class Task4Sixth {
	private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String DIGITS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+";

	public static void main(String[] args) {
		String generatedPassword = generateSimplePassword();
		System.out.println("Generated Password: " + generatedPassword);
	}

	private static String generateSimplePassword() {
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();

		password.append(getRandomChar(UPPER_CASE, random));
		password.append(getRandomChar(UPPER_CASE, random));

		password.append(getRandomChar(LOWER_CASE, random));
		password.append(getRandomChar(LOWER_CASE, random));

		password.append(getRandomChar(DIGITS, random));
		password.append(getRandomChar(DIGITS, random));

		password.append(getRandomChar(SPECIAL_CHARACTERS, random));
		password.append(getRandomChar(SPECIAL_CHARACTERS, random));

		return password.toString();
	}

	private static char getRandomChar(String characterSet, SecureRandom random) {
		int randomIndex = random.nextInt(characterSet.length());
		return characterSet.charAt(randomIndex);
	}
}
