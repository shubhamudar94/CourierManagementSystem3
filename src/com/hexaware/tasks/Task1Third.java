package com.hexaware.tasks;

import java.util.Scanner;

public class Task1Third {
    public static void main(String[] args) {
        // Hardcoded user credentials (for demonstration)
        String username = "Shubham";
        String password = "s12345678";
        
        // Input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        
        // Authentication
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
        
        scanner.close();
    }
}
