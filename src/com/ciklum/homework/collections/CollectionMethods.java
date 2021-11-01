package com.ciklum.homework.collections;

import com.ciklum.homework.collections.model.Vehicle;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class CollectionMethods {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s11_l28_collection_methods_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 28. Collection Methods ***\n");

        List<Integer> list = new ArrayList<>();
        list.add(55);
        list.add(52);
        list.add(13);
        list.add(64);
        list.add(39);
        list.add(34);
        list.add(20);
        list.add(10);
        list.add(10);
        list.add(10);

        List<Integer> newList = new ArrayList<>();
        newList.add(30);
        newList.add(30);
        newList.add(39);
        newList.add(34);
        newList.add(20);
        newList.add(10);
        newList.add(10);
        newList.add(55);
        newList.add(52);

        boolean contains = list.contains(20);
        System.out.println("* Contains method: " + contains);

        boolean isEmpty = list.isEmpty();
        System.out.println("* IsEmpty method: " + isEmpty);

        System.out.println("* Retain All method");
        list.retainAll(newList);
        System.out.println(list);

        System.out.println("* New HashSet based on List");
        HashSet<Integer> hashSet = new HashSet<>(list);
        System.out.println(hashSet);

        System.out.println("* Sort List with integers");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("* Sort List with custom types");
        List<Vehicle> cars = new ArrayList<>();
        cars.add(new Vehicle("Lexus", "RX420", 30000, true));
        cars.add(new Vehicle("Toyota", "RAV4", 18000, true));
        cars.add(new Vehicle("Audi", "A3", 12000, false));
        cars.add(new Vehicle("Toyota", "RAV4", 10000, true));
        cars.add(new Vehicle("Subaru", "Outback", 5000, false));
        Collections.sort(cars);

        for (Vehicle car : cars) {
            System.out.println(car);
        }

    }

}
