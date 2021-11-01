package com.ciklum.homework.datetime;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class ParseDate {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s10_l119_parse_date_time_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 119. Parse date and time ***\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date = LocalDate.parse("02 15 2010", formatter);
        LocalTime time = LocalTime.parse("11:33");

        System.out.println(date);
        System.out.println(time);

        LocalDate myDate = LocalDate.of(2010, Month.APRIL, 5);
        String dateString = formatter.format(myDate);
        System.out.println(dateString);

        LocalDate anotherDate = LocalDate.parse(dateString, formatter);
        anotherDate = anotherDate.plusMonths(4).plusDays(1);
        System.out.println(formatter.format(anotherDate));
    }

}
