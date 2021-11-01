package com.ciklum.homework.concurrency;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Introducing {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s15_l35_introducing_multithreading_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 35. Introducing to multithreading ***\n");

        System.out.println("Start thread 1");
        Task task1 = new Task("Thread 1");
        task1.start();

        System.out.println("Hello World!");

        System.out.println("Start thread 2");
        Task task2 = new Task("Thread 2");
        task2.start();
    }

}

class Task extends Thread {

    public Task(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " | Number: " + i);
        }
    }

}