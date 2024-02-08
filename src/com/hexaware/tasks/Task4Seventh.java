package com.hexaware.tasks;

import java.util.ArrayList;
import java.util.List;

public class Task4Seventh {
    public static void main(String[] args) {
        List<String> addresses = new ArrayList<>();
        addresses.add("123 Main St, CityA, ZipA");
        addresses.add("456 Oak St, CityB, ZipB");
        addresses.add("123 Main St, CityA, ZipA");  // Similar to the first address
        addresses.add("789 Maple St, CityC, ZipC");

        List<String> similarAddresses = findSimilarAddresses(addresses);

        System.out.println("Similar Addresses:");
        for (String address : similarAddresses) {
            System.out.println(address);
        }
    }

    private static List<String> findSimilarAddresses(List<String> addresses) {
        List<String> similarAddresses = new ArrayList<>();

        for (int i = 0; i < addresses.size(); i++) {
            for (int j = i + 1; j < addresses.size(); j++) {
                String address1 = addresses.get(i);
                String address2 = addresses.get(j);

                if (areAddressesSimilar(address1, address2)) {
                    similarAddresses.add(address1);
                    similarAddresses.add(address2);
                }
            }
        }

        return similarAddresses;
    }

    private static boolean areAddressesSimilar(String address1, String address2) {

        String[] parts1 = address1.split(", ");
        String[] parts2 = address2.split(", ");

        return parts1.length > 1 && parts2.length > 1 &&
               parts1[0].equalsIgnoreCase(parts2[0]) &&
               parts1[1].equalsIgnoreCase(parts2[1]);
    }
}

