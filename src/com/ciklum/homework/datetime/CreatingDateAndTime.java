package com.ciklum.homework.datetime;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class CreatingDateAndTime {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s10_l115_creating_date_and_time_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 115. Creating date and time ***\n");

        System.out.println("\n* Creating date");
        System.out.println("Local Date: " + LocalDate.now());
        System.out.println("Local Time: " + LocalTime.now());
        System.out.println("Local Datetime: " + LocalDateTime.now());

        System.out.println("\n* Certain date");
        LocalDate ld = LocalDate.of(2010, Month.AUGUST, 12);
        LocalTime lt = LocalTime.of(11, 33);
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(LocalDateTime.of(ld, lt));

        System.out.println("\n* Calendar");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, Calendar.JANUARY, 14);
        Date january = calendar.getTime();
        System.out.println(january);

    }
}
