package com.hexaware.tasks;

public class Task2Second {
	public static void main(String[] args) {
		double currentLocation = 0.0; // initial location of the courier
		double destination = 100.0; // destination location
		double speed = 10.0; // constant speed in units per iteration

		System.out.println("Courier is on the way to the destination.");

		while (currentLocation < destination) {

			currentLocation += speed;

			System.out.println("Courier is at location: " + currentLocation);
		}

		System.out.println("Courier has reached its destination.");
	}
}
