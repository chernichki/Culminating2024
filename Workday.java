//NATALIE CHERNYSHEVA

public class Workday {
    private String dayOfWeek;
    private String date;
    private String timeInterval;
    private int totalHours;
    private double rate;
    private double totalPay;

    public Workday(String dayOfWeek, String date, String timeInterval, double rate) {
        this.dayOfWeek = dayOfWeek; //this is day of the week
        this.date = date; //this is the date
        this.timeInterval = timeInterval; //this is the time interval
        this.totalHours = calculateTotalHours(timeInterval); //to be able to have a calculation from using the time interval input
        this.rate = rate; // the hour rate of user
        this.totalPay = this.totalHours * this.rate; // the total pay is the calculation of the number of hours multiplied by the hour rate
    }

    private int calculateTotalHours(String interval) { //this part required a lot of research to be able to understand and do
        // Split the interval string into start and end times based on the hyphen
        String[] times = interval.split("-");

        // Split the start and end times based on "am" or "pm"
        String[] start = times[0].split("am|pm");
        String[] end = times[1].split("am|pm");

        // Parse (analyzing) the start and end hours as integers, trimming any whitespace
        int startHour = Integer.parseInt(start[0].trim());
        int endHour = Integer.parseInt(end[0].trim());

         // If the start time is in the PM and not 12 PM, add 12 to convert to 24-hour format
        if (times[0].contains("pm") && startHour != 12) startHour += 12;

        // If the end time is in the PM and not 12 PM, add 12 to convert to 24-hour format
        if (times[1].contains("pm") && endHour != 12) endHour += 12;

        // If the start time is 12 AM, convert it to 0 (midnight)
        if (times[0].contains("am") && startHour == 12) startHour = 0;

        // If the end time is 12 AM, convert it to 0 (midnight)
        if (times[1].contains("am") && endHour == 12) endHour = 0;

        // Return the difference between the end and start times to get total hours worked
        return endHour - startHour;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getDate() {
        return date;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public double getRate() {
        return rate;
    }

    public double getTotalPay() {
        return totalPay;
    }
}
