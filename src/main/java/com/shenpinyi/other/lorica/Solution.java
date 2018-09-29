package com.shenpinyi.other.lorica;

import java.util.Optional;

public class Solution {

    private static final int[] daysOfMonths = new int[]{
            0, // month index starts from 1
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31};
    private static final int[] daysOfMonthsLeapYear = new int[]{
            0, // month index starts from 1
            31, 29, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31};

    public int run(String[] args) {
        if (args.length != 2) {
            printCommandHelp();
            return -1;
        }
        Optional<Integer> elapsedDays = getElapsedDays(args[0], args[1]);
        if (elapsedDays.isPresent()) {
            System.out.println(String.format("The days between %s and %s is %d", args[0], args[1], elapsedDays.get()));
            return 1;
        } else {
            printCommandHelp();
            return -1;
        }
    }

    public void printCommandHelp() {
        System.out.println("Please input valid command, e.g.: java Solution 17/08/2017 17/09/2018");
        System.out.println("The valid date should between [01/01/1901, 31/12/2999]");
    }

    public Optional<Integer> getElapsedDays(String day1, String day2) {
        Optional<MyDate> dateA = getDate(day1);
        Optional<MyDate> dateB = getDate(day2);
        if (!dateA.isPresent() || !dateB.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(dateA.get().compareTo(dateB.get()) < 0 ?
                getDaysBetweenDates(dateA.get(), dateB.get()) :
                getDaysBetweenDates(dateB.get(), dateA.get()));
    }

    private Optional<MyDate> getDate(String arg) {
        MyDate date = null;
        try {
            String[] tokens = arg.split("/");
            if (tokens.length == 3) {
                int day = Integer.valueOf(tokens[0]);
                int month = Integer.valueOf(tokens[1]);
                int year = Integer.valueOf(tokens[2]);
                if (validateDate(year, month, day)) {
                    date = new MyDate(year, month, day);
                }
            }
        } catch (Exception e) {
        }
        return Optional.ofNullable(date);
    }

    private boolean validateDate(int year, int month, int day) {
        if (year < 1901 || year > 2999) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > (isLeapYear(year) ? daysOfMonthsLeapYear[month] : daysOfMonths[month])) {
            return false;
        }
        return true;
    }

    private int getDaysBetweenDates(MyDate startDate,
                                    MyDate endDate) {
        int daysOfStartYear = getDaysStartFromYear(startDate, startDate.getYear());
        int daysOfEndYear = getDaysStartFromYear(endDate, startDate.getYear());
        int daysDiff = daysOfEndYear - daysOfStartYear - 1;
        return daysDiff > 0 ? daysDiff : 0;
    }

    private int getDaysStartFromYear(MyDate date, int fromYear) {
        int fullYear = fromYear;
        int totalDays = 0;
        while (fullYear < date.getYear()) {
            totalDays += isLeapYear(fullYear) ? 366 : 365;
            fullYear++;
        }
        totalDays += getDaysWithInYear(date);
        return totalDays;
    }

    private int getDaysWithInYear(MyDate date) {
        boolean isLeapYear = isLeapYear(date.getYear());
        int fullMonth = 1;
        int totalDays = 0;
        while (fullMonth < date.getMonth()) {
            totalDays += isLeapYear ? daysOfMonthsLeapYear[fullMonth] : daysOfMonths[fullMonth];
            fullMonth++;
        }
        totalDays += date.getDay();
        return totalDays;
    }

    private boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        new Solution().run(args);
    }

    static class MyDate implements Comparable<MyDate> {

        private int year;
        private int month;
        private int day;

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        @Override
        public String toString() {
            return "" + day + '/' + month + '/' + year;
        }

        @Override
        public int compareTo(MyDate o) {
            if (year != o.year) return year - o.year;
            if (month != o.month) return month - o.month;
            if (day != o.day) return day - o.day;
            return 0;
        }
    }
}
