package com.hexaware.tasks;

public class Task1Second{
    public static void main(String[] args) {
        double parcelWeight = 25.0; // Change this to test different weights
        
        // Categorize parcels based on weight
        String category;
        if (parcelWeight < 10.0) {
            category = "Light";
        } else if (parcelWeight < 20.0) {
            category = "Medium";
        } else {
            category = "Heavy";
        }
        
        // Output the category
        System.out.println("Parcel weight category: " + category);
    }
}

