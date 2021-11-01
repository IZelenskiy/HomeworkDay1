package com.ciklum.homework.collections;

import com.ciklum.homework.collections.model.Vehicle;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class SetCollection {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s11_l27_set_collections_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 27. HashSet and LinkedHashSet ***\n");

        Set<String> strings = new HashSet<>();
        strings.add("BMW");
        strings.add("Audi");
        strings.add("Subaru");
        strings.add("Toyota");
        strings.add("Toyota");

        for (String string : strings) {
            System.out.println(string);
        }

        Set<Vehicle> cars = new HashSet<>();
        Vehicle car1 = new Vehicle("Lexus", "RX420", 10000, true);
        Vehicle car2 = new Vehicle("Toyota", "RAV4", 10000, true);
        Vehicle car3 = new Vehicle("Audi", "A3", 12000, false);
        Vehicle car4 = new Vehicle("Toyota", "RAV4", 10000, true);
        Vehicle car5 = new Vehicle("Subaru", "Outback", 8000, false);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        for (Vehicle item : cars) {
            System.out.println(item);
        }

    }

}
