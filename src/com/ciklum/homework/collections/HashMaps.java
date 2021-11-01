package com.ciklum.homework.collections;

import com.ciklum.homework.collections.model.Vehicle;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMaps {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s11_l29_has_map.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 29. Hash Maps ***\n");

        Map<String, Vehicle> cars = new HashMap<>();
        cars.put("Lexus", new Vehicle("Lexus", "RX420", 10000, true));
        cars.put("Audi", new Vehicle("Audi", "A3", 12000, false));
        cars.put("Subaru", new Vehicle("Subaru", "Outback", 8000, false));
        cars.put("Toyota", new Vehicle("Toyota", "RAV4", 10000, true));

        System.out.println("* Traversing Map Keys");
        for (String key : cars.keySet()) {
            System.out.println(key);
        }

        System.out.println("* Traversing Map Values");
        for (Vehicle value : cars.values()) {
            System.out.println(value);
        }

        System.out.println("* Traversing Map Entries");
        for (Map.Entry<String, Vehicle> entry : cars.entrySet()) {
            System.out.println("  KEY: " + entry.getKey());
            System.out.println("  VALUE: " + entry.getValue());
        }

        System.out.println("* TreeMap sorting");
        Map<String, Vehicle> treeMap = new TreeMap<>(cars);
        for (Map.Entry<String, Vehicle> entry : treeMap.entrySet()) {
            System.out.println("  KEY: " + entry.getKey());
            System.out.println("  VALUE: " + entry.getValue());
        }
    }
}
