package com.ciklum.homework.datetime;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class UsingDateAndTime {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s10_l116_using_date_and_time_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 116. Using Date and Time***\n");

        System.out.println("\n* Add days and months to time");
        LocalDate date = LocalDate.of(2010, Month.AUGUST, 10);
        System.out.println(date);
        date = date.plusDays(5).plusMonths(2);
        System.out.println(date);

        System.out.println("\n* Add hours and minutes to time");
        LocalTime time = LocalTime.of(10, 30);
        System.out.println(time);
        time = time.plusHours(2).plusMinutes(22);
        System.out.println(time);

        System.out.println("\n* Plus and minus to time");
        LocalDateTime localDateTime = LocalDateTime.of(date, time);
        System.out.println(localDateTime);
        localDateTime = localDateTime.minusHours(10).plusDays(2).plusWeeks(3);
        System.out.println(localDateTime);

        Date myDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.MONTH, 2);
        myDate = calendar.getTime();
        System.out.println(myDate);

    }
}
