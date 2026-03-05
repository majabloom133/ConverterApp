package com.example;

// Import scanner to read input, and LocalDateTime for date/time
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        // Create a scanner that listens to what I write
        Scanner scanner = new Scanner(System.in);
        // Create a loop so the scanner keeps running
        boolean keepRunning = true;

        System.out.println("=== Welcome to my Converter App ===");

        while (keepRunning) {
            // Create while-loop that runs as long as keepRunning is true.
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Currency (SEK to USD");
            System.out.println("2. Temperature (Celsius to Fahrenheit)");
            System.out.println("3. Length (Meters to Kilometers)");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");

            // Reads input as a String
            String choice = scanner.nextLine();

            // Use switch to control user input
            // Every 'case' matches a number in the menu, and calls for the right method
            switch (choice) {
                case "1":
                    convertCurrency(scanner);
                    break;
                case "2":
                    convertTemperature(scanner);
                    break;
                case "3":
                    convertLength(scanner);
                    break;
                case "4":
                    System.out.println("Exiting... Goodbye!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        // Turns scanner off
        scanner.close();
    }

        // Prepare methods
        public static void convertCurrency(Scanner sc) {
            System.out.println("Currency Converter Selected.");
        }

        public static void convertTemperature(Scanner sc) {
            System.out.println("Temperature Converter is selected.");
        }

        public static void convertLength(Scanner sc) {
            System.out.println("Length Converter selected.");
        }


    }
