//NATALIE CHERNYSHEVA

import java.util.*;
import java.io.*;

public class WorkSchedule {
    // Create a Scanner object to read user input
    static Scanner in = new Scanner(System.in);

    // Create a list to store the workdays
    static List<Workday> workdays = new ArrayList<>();

    public static void main(String[] args) {
        // Variable to store the hourly rate of pay
        double hourlyRate;

        // Variables to store the month and the number of days worked in the month
        int month, daysWorked;

        // Boolean flag to keep the program running
        boolean runProgram = true;

        // Ask the user for their usual hourly rate
        System.out.print("Enter your usual hourly rate: ");
        hourlyRate = Double.parseDouble(in.nextLine()); // Convert the input string to a double

        // Ask the user for the month they are recording (1 for January, 2 for February, etc.)
        System.out.print("Enter the month (1-12): ");
        month = Integer.parseInt(in.nextLine()); // Convert the input string to an integer

        // Ask the user for the number of days they worked in that month
        System.out.print("Enter the number of days worked in the month: ");
        daysWorked = Integer.parseInt(in.nextLine()); // Convert the input string to an integer

        // Loop to get details for each workday
        for (int i = 0; i < daysWorked; i++) {
            System.out.println("Enter details for day " + (i + 1));

            // Ask for the day of the week (e.g., "Monday")
            System.out.print("Day of the week: ");
            String dayOfWeek = in.nextLine();

            // Ask for the date (e.g., "15/06/2024")
            System.out.print("Date (dd/mm/yyyy): ");
            String date = in.nextLine();

            // Ask for the time interval they worked (e.g., "9am-5pm")
            System.out.print("Time interval (e.g., 9am-5pm): ");
            String timeInterval = in.nextLine();

            // Create a new Workday object and add it to the list
            workdays.add(new Workday(dayOfWeek, date, timeInterval, hourlyRate));
        }

        // Loop to keep the program running until the user decides to quit
        while (runProgram) {
            // Display the menu and get the user's choice
            int userChoice = getUserChoice();

            // Perform actions based on the user's choice
            switch (userChoice) {
                case 1:
                    // Show the work schedule
                    showWorkSchedule();
                    break;
                case 2:
                    // Delete an entry from the schedule
                    deleteEntry();
                    break;
                case 3:
                    // Placeholder for exporting the schedule to a file
                    System.out.println("File has been downloaded");
                    break;
                case 0:
                    // Exit the program
                    runProgram = false;
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    // Method to display the menu and get the user's choice
    private static int getUserChoice() {
        // Display the menu options
        System.out.println();
        System.out.println("(1) Show Work Schedule\t(2) Delete Entry\t(3) Export to File");
        System.out.println("Enter 0 to quit");

        // Read and return the user's choice
        return Integer.parseInt(in.nextLine());
    }

    // Method to show the work schedule
    private static void showWorkSchedule() {
        // Print the header for the work schedule table
        System.out.printf("%-5s %-12s %-15s %-12s %-6s %-10s%n", "Day", "Date", "Time Interval", "Total Hours", "Rate", "Total Pay");

        // Loop through the list of workdays and print each one
        for (int i = 0; i < workdays.size(); i++) {
            Workday wd = workdays.get(i); // Get the workday at index i
            System.out.printf("%-5s %-12s %-15s %-12d %-6.2f %-10.2f%n", wd.getDayOfWeek(), wd.getDate(), wd.getTimeInterval(), wd.getTotalHours(), wd.getRate(), wd.getTotalPay());
        }
    }

    // Method to delete an entry from the work schedule
    private static void deleteEntry() {
        // Ask the user for the index of the entry they want to delete
        System.out.print("Enter the index of the entry you want to delete: ");
        int index = Integer.parseInt(in.nextLine()); // Convert the input string to an integer

        // Check if the index is valid
        if (index >= 0 && index < workdays.size()) {
            // Remove the entry at the specified index
            workdays.remove(index);
            System.out.println("Entry deleted successfully.");
        } else {
            // Print an error message if the index is invalid
            System.out.println("Invalid index.");
        }
    }
}
