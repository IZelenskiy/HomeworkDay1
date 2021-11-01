package com.ciklum.homework.collections;

import com.ciklum.homework.collections.model.Vehicle;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TraversingCollection {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s11_l26_traversing_collections_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 26. Traversing collection and Custom Types ***\n");

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("String " + i);
        }

        // Traversing with for
        System.out.println("*** Traversing with FOR ***\n");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("*** Traversing with FOR EACH ***\n");
        printList(list);

        System.out.println("*** Custom Type ***\n");
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Toyota", "Camry", 20000, false));
        vehicles.add(new Vehicle("Toyota", "Prado", 30000, true));
        vehicles.add(new Vehicle("Subaru", "Outback", 15000, true));
        vehicles.add(new Vehicle("Chevrolet", "Camaro", 40000, false));

        for (Vehicle car : vehicles) {
            System.out.println(car);
        }
    }

    public static void printList(List<String> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
