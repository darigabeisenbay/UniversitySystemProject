package lab_3.task_5;

import java.util.Scanner;

public class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && second >= 0 && second < 60) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            System.out.println("Error: invalid type for time");
        }
    }

    public int getHour()   { return hour; }
    public int getMinute() { return minute; }
    public int getSecond() { return second; }

    public int toTotalSeconds() {
        return hour * 3600 + minute * 60 + second;
    }

    public String toUniversal() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String toStandard() {
        int h;
        String period;
        if (hour == 0 || hour == 12) {
            h = 12;
        } else {
            h = hour % 12;
        }
        if (hour < 12) {
            period = "AM";
        } else {
            period = "PM";
        }
        return String.format("%02d:%02d:%02d %s", h, minute, second, period);
    }

    public void add(Time t2) {
        this.second += t2.second;
        this.minute += this.second / 60;
        this.second %= 60;

        this.minute += t2.minute;
        this.hour += this.minute / 60;
        this.minute %= 60;

        this.hour += t2.hour;
        this.hour %= 24;
    }

    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.toTotalSeconds(), other.toTotalSeconds());
    }

    @Override
    public String toString() {
        return toUniversal();
    }

    public static void main(String[] args) {
        Scanner timee = new Scanner(System.in);
        System.out.println("Enter hour minute and second");
        int h1 = timee.nextInt();
        int m1 = timee.nextInt();
        int s1 = timee.nextInt();

        Time t = new Time(h1, m1, s1);
        System.out.println("Universal: " + t.toUniversal());
        System.out.println("Standard: " + t.toStandard());
        System.out.println("Enter new time: hour, minute and second: ");
        int h2 = timee.nextInt();
        int m2 = timee.nextInt();
        int s2 = timee.nextInt();

        Time t2 = new Time(h2, m2, s2);
        t.add(t2);
        System.out.println("Result after adding: " + t.toUniversal());
        System.out.println("Standard: " + t.toStandard());
    }
}