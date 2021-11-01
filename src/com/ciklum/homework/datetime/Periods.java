package com.ciklum.homework.datetime;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Periods {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s10_l117_periods_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 117. Periods ***\n");

        LocalDate start = LocalDate.of(2017, Month.AUGUST, 1);
        LocalDate end = LocalDate.of(2017, Month.SEPTEMBER, 30);

        Period period = Period.ofWeeks(1);

        cleanAnimalCage(start, end);
        System.out.println("Date " + start + " plus period "+ period.getDays() + " days = " + start.plus(period));

        System.out.println("\n* Years and month period");
        Period yearAndMonth = Period.ofYears(1).plusMonths(1);
        System.out.println(yearAndMonth);

        cleanAnimalCage(start, end, yearAndMonth);

    }

    public static void cleanAnimalCage(LocalDate start, LocalDate end, Period period) {
        while (start.isBefore(end)) {
            System.out.println("Need to clean the cage on date = " + start);
            start = start.plus(period);
        }
    }

    public static void cleanAnimalCage(LocalDate start, LocalDate end) {
        while (start.isBefore(end)) {
            System.out.println("Need to clan the cage on date = " + start);
            start = start.plusMonths(1);
        }
    }

}
