public class Workday {
    private String dayOfWeek;
    private String date;
    private String timeInterval;
    private int totalHours;
    private double rate;
    private double totalPay;

    public Workday(String dayOfWeek, String date, String timeInterval, double rate) {
        this.dayOfWeek = dayOfWeek;
        this.date = date;
        this.timeInterval = timeInterval;
        this.totalHours = calculateTotalHours(timeInterval);
        this.rate = rate;
        this.totalPay = this.totalHours * this.rate;
    }

    private int calculateTotalHours(String interval) {
        String[] times = interval.split("-");
        String[] start = times[0].split("am|pm");
        String[] end = times[1].split("am|pm");

        int startHour = Integer.parseInt(start[0].trim());
        int endHour = Integer.parseInt(end[0].trim());

        if (times[0].contains("pm") && startHour != 12) startHour += 12;
        if (times[1].contains("pm") && endHour != 12) endHour += 12;
        if (times[0].contains("am") && startHour == 12) startHour = 0;
        if (times[1].contains("am") && endHour == 12) endHour = 0;

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