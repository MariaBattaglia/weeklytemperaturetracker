package WeeklyTemperatureTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatureTracker {
    public static void main(String[] args) {
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter daily average temperatures. Type 'week' to finish and see results.");

        while (true) {
            System.out.print("Enter day of the week (or 'week' to finish): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("week")) {
                break;
            }

            if (!isValidDay(input)) {
                System.out.println("Invalid day. Please enter a valid day (Monday to Sunday).");
                continue;
            }

            if (days.contains(capitalize(input))) {
                System.out.println("Temperature for " + capitalize(input) + " already entered.");
                continue;
            }

            System.out.print("Enter average temperature for " + capitalize(input) + ": ");
            try {
                double temp = Double.parseDouble(scanner.nextLine());
                days.add(capitalize(input));
                temperatures.add(temp);
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature. Please enter a numeric value.");
            }
        }

        // Output the results
        if (days.isEmpty()) {
            System.out.println("No data entered.");
        } else {
            System.out.println("\nTemperature Report:");
            double sum = 0;
            for (int i = 0; i < days.size(); i++) {
                System.out.println(days.get(i) + ": " + temperatures.get(i) + "°");
                sum += temperatures.get(i);
            }
            double average = sum / temperatures.size();
            System.out.printf("Weekly average temperature: %.2f°\n", average);
        }

        scanner.close();
    }

    // Helper method to validate day input
    public static boolean isValidDay(String day) {
        String[] validDays = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };
        for (String d : validDays) {
            if (d.equalsIgnoreCase(day)) {
                return true;
            }
        }
        return false;
    }

    // Capitalize the first letter
    public static String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}