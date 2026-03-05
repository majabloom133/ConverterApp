package com.example;

// Import scanner to read input, and LocalDateTime for date/time
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    // Added this to include class level scope as well, just to learn
    static double sekToUsdRate = 0.095;

    public static void main(String[] args) {
        // Create a scanner that listens to what I write
        Scanner scanner = new Scanner(System.in);
        // Create a loop so the scanner keeps running
        boolean keepRunning = true;

        System.out.println("=== Welcome to my Converter App ===");

        while (keepRunning) {
            // Create while-loop that runs as long as keepRunning is true.
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Currency (SEK to USD)");
            System.out.println("2. Temperature (Celsius to Fahrenheit)");
            System.out.println("3. Length (Meters to Kilometers)");
            System.out.println("4. Weight (Kilograms to Pounds)");
            System.out.println("5. Area (Square Meters to Hectares)");
            System.out.println("6. Volume (Liters to Gallons)");
            System.out.println("7. Exit");
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
                    convertWeight(scanner);
                    break;
                case "5":
                    convertArea(scanner);
                    break;
                case "6":
                    convertVolume(scanner);
                    break;
                case "7":
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
    // Currency method
    public static void convertCurrency(Scanner sc) {
        System.out.println("\n--- Currency Converter Selected. ---");
        System.out.print("Enter the amount in SEK: ");
        // Inside try-catch to make sure program doesn't crash from error
        try {
            // Read amount, use double to read decimals
            double sek = Double.parseDouble(sc.nextLine());
            //Calculate USD - fixed exchange rate
            double usd = sek * sekToUsdRate;
            // Changed to class level scope
            System.out.println("Result: " + sek + " SEK = " + usd + " USD");
            printTimestamp();
        } catch (Exception e) {
            System.out.println("Error: Enter a valid number (use dots for decimals)");
        }
    }


    // Call timestamp method to display date + time
    public static void printTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = now.format(formatter);
        System.out.println("Converted at: " + formattedDate);
    }


    public static void convertTemperature(Scanner sc) {
        System.out.println("\n--- Temperature Converter is selected. ---");
        System.out.print("Enter degrees in Celsius: ");
        // Write in try-catch to prevent crashing after an error.
        try {
            // Read input, change to double
            double celsius = Double.parseDouble(sc.nextLine());
            // This changes Celsius into Fahrenheit
            double fahrenheit = (celsius * 1.8) + 32;
            // Print result
            System.out.println("Result: " + celsius + "°C = " + fahrenheit + "°F");
            // Call for Timestamp method to show when
            printTimestamp();
        } catch (Exception e) {
        System.out.println("Invalid input! Use numbers only.");
    }
}


    public static void convertLength(Scanner sc) {
        System.out.println("\n--- Length Converter selected. ---");
        System.out.print("Enter Length in meters: ");

        try {
            // Use double meters to read input in meters
            // Divide ny 1000 to get the kilometers.
            double meters = Double.parseDouble(sc.nextLine());
            double km = meters / 1000;
            // Print result
            System.out.println("Result: " + meters + " m = " + km + (" km"));
            // Call for timestamp to show when
            printTimestamp();
        } catch (Exception e) {
            System.out.println("Error: Enter a number for the distance.");
        }
    }


    public static void convertWeight(Scanner sc) {
        System.out.println("\n--- Weight Converter Selected ---");
        System.out.print("Enter weight in kilograms: ");
        try {
            // Read input - switch to double
            double kg = Double.parseDouble(sc.nextLine());
            double lbs = kg * 2.20462;
            // Print result and time
            System.out.println("Result: " + kg + " kg = " + lbs + " lbs");
            printTimestamp();
        }
        catch (Exception e) {
            System.out.println("Error: Enter a valid number for the weight.");
        }
    }


    public static void convertArea(Scanner sc) {
        System.out.println("\n--- Area Converter Selected ---");
        System.out.print("Enter area in square meters: ");
        // Add try-catch
        // 1 hectare is 10.000 square meters.
        try {
            double m2 = Double.parseDouble(sc.nextLine());
            double hectares = m2 / 10000;
            System.out.println("Result: " + m2 + "  m2 = " + hectares + " hectares");
            printTimestamp();;
        }
        catch (Exception e) {
            System.out.println("Error: Enter valid number to calculate area.");
        }
    }


    public static void convertVolume(Scanner sc) {
        System.out.println("\n--- Volume Converter Selected ---");
        System.out.print("Enter Volume in liters: ");
        try {
            double liters = Double.parseDouble(sc.nextLine());
            double gallons = liters * 0.264172;
            System.out.println("Result: " + liters + " L = " + gallons + " gallons");
            printTimestamp();
        } catch (Exception e) {
            System.out.println("Error: Pick a valid number for volume.");
        }

    }
}
