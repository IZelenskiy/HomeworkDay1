package com.ciklum.homework.lambda;

import com.ciklum.homework.lambda.model.Walkable;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FunctionalInterfaces {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s18_l57_functional_interfaces_and_lambdas.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 57. Functional interfaces and lambdas ***\n");

        System.out.println("* Single line lambda");
        walker(() -> System.out.println("Single line lambda walking..."));

        System.out.println("* Multiple line lambda");
        walker(() -> {
            System.out.println("Multiple line lambda walking...");
            System.out.println("Multiple line lambda walking else...");
        });

        System.out.println("* Functional interface");
        Walkable aBlockOfCode = () -> {
            System.out.println("Functional interface method output");
        };

        System.out.println("* Variable as a method");
        walker(aBlockOfCode);
    }

    public static void walker(Walkable walkableEntity) {
        walkableEntity.walk();
    }

}
