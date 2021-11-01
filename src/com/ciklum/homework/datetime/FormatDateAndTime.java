package com.ciklum.homework.datetime;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatDateAndTime {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s10_l118_format_date_and_time_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 118. Formatting date and time ***\n");

        LocalDate date = LocalDate.of(2010, Month.APRIL, 15);
        LocalTime time = LocalTime.of(11, 22, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));

        System.out.println("\n* DateTime Formatter");
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter mediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println("SHORT FORMAT: " + shortFormatter.format(dateTime));
        System.out.println("MEDIUM FORMAT: " + mediumFormatter.format(dateTime));

        System.out.println("\n* Custom Formatter");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(formatter));

    }


}
