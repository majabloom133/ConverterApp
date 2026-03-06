package se.lexicon;

// Import scanner to read input, and LocalDateTime for date/time
import java.util.Scanner;

import static se.lexicon.TimeUtils.printTimestamp;

public class Main {
    // Added this to include class level scope as well, just to learn
    static double sekToUsdRate = 0.095;
    static double sekToEurRate = 0.088;

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
            System.out.println("7. Speed (Km/h to mph)");
            System.out.println("8. Time (Hours to Minutes)");
            System.out.println("9. Power (Watts to Horsepower)");
            System.out.println("10. Exit");
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
                    convertSpeed(scanner);
                    break;
                case "8":
                    convertTime(scanner);
                    break;
                case "9":
                    convertPower(scanner);
                    break;
                case "10":
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

    // METHODS

    // Keeping old code to show how i changed it from having more than 1 task/method, to only 1,
    /*
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
            double eur = sek * sekToEurRate;
            // Changed to class level scope
            System.out.println("Result: ");
            System.out.println(sek + " SEK = " + usd + " USD");
            System.out.println(sek + " SEK = " + eur + " EUR");
            TimeUtils.printTimestamp();
        } catch (Exception e) {
            System.out.println("Error: Enter a valid number (use dots for decimals)");
        }
    } */

    // This only handles the input and calls for calculation
    public static void convertCurrency(Scanner sc) {
        System.out.println("\n--- Currency Converter Selected. ---");
        System.out.print("Enter amount in SEK: ");
        try {
            double sek = Double.parseDouble(sc.nextLine());
            // The line below sends the job to another method
            calculateAndPrintCurrency(sek);
            TimeUtils.printTimestamp();
        } catch (Exception e) {
            System.out.println("Error: Enter a valid number.");
        }
    }
    // Handles only calculations and printing of the result.
    public static void calculateAndPrintCurrency(double sek) {
        double usd = sek * sekToUsdRate;
        double eur = sek * sekToEurRate;
        System.out.println("Result: ");
        System.out.println(sek + " SEK = " + usd + " USD");
        System.out.println(sek + " SEK = " + eur + " EUR");
    }

    // Here the content in TimeUtils used to be.

        // Temperature method
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
            TimeUtils.printTimestamp();
        } catch (Exception e) {
            System.out.println("Invalid input! Use numbers only.");
        }
    }

                // Length converter
        public static void convertLength (Scanner sc){
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
                TimeUtils.printTimestamp();
            } catch (Exception e) {
                System.out.println("Error: Enter a number for the distance.");
            }
        }

        // Weight converter
        public static void convertWeight (Scanner sc){
            System.out.println("\n--- Weight Converter Selected ---");
            System.out.print("Enter weight in kilograms: ");
            try {
                // Read input - switch to double
                double kg = Double.parseDouble(sc.nextLine());
                double lbs = kg * 2.20462;
                // Print result and time
                System.out.println("Result: " + kg + " kg = " + lbs + " lbs");
                TimeUtils.printTimestamp();
            } catch (Exception e) {
                System.out.println("Error: Enter a valid number for the weight.");
            }
        }

        // Area converter
        public static void convertArea (Scanner sc){
            System.out.println("\n--- Area Converter Selected ---");
            System.out.print("Enter area in square meters: ");
            // Add try-catch
            // 1 hectare is 10.000 square meters.
            try {
                double m2 = Double.parseDouble(sc.nextLine());
                double hectares = m2 / 10000;
                System.out.println("Result: " + m2 + "  m2 = " + hectares + " hectares");
                TimeUtils.printTimestamp();
                ;
            } catch (Exception e) {
                System.out.println("Error: Enter valid number to calculate area.");
            }
        }

        // Volume converter
        public static void convertVolume (Scanner sc){
            System.out.println("\n--- Volume Converter Selected ---");
            System.out.print("Enter Volume in liters: ");
            try {
                double liters = Double.parseDouble(sc.nextLine());
                double gallons = liters * 0.264172;
                System.out.println("Result: " + liters + " L = " + gallons + " gallons");
                TimeUtils.printTimestamp();
            } catch (Exception e) {
                System.out.println("Error: Pick a valid number for volume.");
            }
        }

        // Speed converter
        public static void convertSpeed (Scanner sc){
            System.out.println("\n--- Speed Converter Selected ---");
            System.out.print("Enter speed in km/h: ");
            try {
                double kmh = Double.parseDouble(sc.nextLine());
                double mph = kmh * 0.621371;
                System.out.println("Result: " + kmh + " km/h = " + mph + " mph");
                TimeUtils.printTimestamp();
            } catch (Exception e) {
                System.out.println("Error: Enter a valid number for speed");
            }
        }

        // Power converter
        public static void convertPower(Scanner sc) {
            // Creating instance of PowerConverter class, naming it "Power Analysis Tool"
            PowerConverter myApp = new PowerConverter("Power Analysis Tool");
            // Calling instance method - works because of previous line
            myApp.printWelcome();
            System.out.print("Enter power in Watts: ");
            try {
                double watts = Double.parseDouble(sc.nextLine());
                double hp = PowerConverter.calculateHp(watts);
                // Calling a static method via the class name "PowerConverter"
                // It's a Utility task - doesn't need a specific object
                System.out.println("Result: " + watts + " W = " + hp + " hp");
                TimeUtils.printTimestamp();
            } catch (Exception e) {
                System.out.println("Error: Enter valid number for power.");
            }
        }

        // Time converter
        public static void convertTime (Scanner sc){
            System.out.println("\n--- Time Converter Selected ---");
            System.out.print("Enter time in hours: ");
            try {
                double hours = Double.parseDouble(sc.nextLine());
                double minutes = hours * 60;
                System.out.println("Result: " + hours + " hours = " + minutes + " minutes");
                TimeUtils.printTimestamp();
            } catch (Exception e) {
                System.out.println("Error: Enter a valid number for hours.");
            }
        }
        // Close main
}

// A separate class to practice Static vs Instance members
// Asked AI for help, since this is new for me.
class PowerConverter {
    // Static field: Shared by ALL instances of the class (Global rate)
    static double wattToHpFactor = 0.001341;
    // Instance field: Unique data for each object
    String converterName;
    // Constructure: Used to create a new instance (object) of this class
    public PowerConverter(String name) {
        this.converterName = name;
    }
    // Instance method: Operates on a specfific object's data (Uses this name)
    public void printWelcome() {
        System.out.println("\n---" + this.converterName + " Selected ---");
    }
    // Static method: Static method: Belongs to the class itself. Performs a Utility task.
    public static double calculateHp(double watts) {
        // Does a calculation that doesn't need object-specific data
        return watts * wattToHpFactor;
    }
}
