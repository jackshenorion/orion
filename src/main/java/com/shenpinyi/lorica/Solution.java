package com.shenpinyi.lorica;

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

    private void run(String[] args) {
        if (args.length != 2) {
            printCommandHelp();
            return;
        }
        Optional<MyDate> dateA = getDate(args[0]);
        Optional<MyDate> dateB = getDate(args[1]);
        if (!dateA.isPresent() || !dateB.isPresent()) {
            printCommandHelp();
            return;
        }
        int elapsedDays = dateA.get().compareTo(dateB.get()) < 0 ?
                getDaysBetweenDates(dateA.get(), dateB.get()) :
                getDaysBetweenDates(dateB.get(), dateA.get());
        System.out.println(String.format("The days between %s and %s is %d", dateA.get(), dateB.get(), elapsedDays));
    }

    private void printCommandHelp() {
        System.out.println("Please input valid command, e.g.: diff.jar 17/08/2017 17/09/2018");
        System.out.println("The valid date should between [01/01/1901, 31/12/2999]");
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
