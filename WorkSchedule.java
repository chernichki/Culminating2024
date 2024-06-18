import java.util.*;
import java.io.*;

public class WorkSchedule {
    static Scanner in = new Scanner(System.in);
    static List<Workday> workdays = new ArrayList<>();

    public static void main(String[] args) {
        double hourlyRate;
        int month, daysWorked;
        boolean runProgram = true;

        System.out.print("Enter your usual hourly rate: ");
        hourlyRate = Double.parseDouble(in.nextLine());

        System.out.print("Enter the month (1-12): ");
        month = Integer.parseInt(in.nextLine());

        System.out.print("Enter the number of days worked in the month: ");
        daysWorked = Integer.parseInt(in.nextLine());

        for (int i = 0; i < daysWorked; i++) {
            System.out.println("Enter details for day " + (i + 1));
            System.out.print("Day of the week: ");
            String dayOfWeek = in.nextLine();
            System.out.print("Date (dd/mm/yyyy): ");
            String date = in.nextLine();
            System.out.print("Time interval (e.g., 9am-5pm): ");
            String timeInterval = in.nextLine();

            workdays.add(new Workday(dayOfWeek, date, timeInterval, hourlyRate));
        }

        while (runProgram) {
            int userChoice = getUserChoice();

            switch (userChoice) {
                case 1:
                    showWorkSchedule();
                    break;
                case 2:
                    deleteEntry();
                    break;
                case 3:
                    System.out.println("File has been downloaded");
                    break;
                case 0:
                    runProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }