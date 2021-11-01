package com.ciklum.homework.collections;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Introduction {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s11_l25_collections_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 25. Introduce to Collections ***\n");

        System.out.println("*** Raw types ***");
        ArrayList rawList = new ArrayList();
        rawList.add("String One");
        rawList.add(29);
        rawList.add(155.5);
        rawList.add('H');

        for (Object item : rawList) {
            System.out.println(item);
        }

        System.out.println("*** Explicit Conversion ***");
        String stringItem = (String) rawList.get(0);
        int intItem = (int) rawList.get(1);
        System.out.println(stringItem);
        System.out.println(intItem);

        System.out.println("*** Parameterized collections ***");
        ArrayList<String> list = new ArrayList<>();
        list.add("String One");
        list.add("String Two");
        list.add("String Three");

        for (Object item : list) {
            System.out.println(item);
        }
    }
}
