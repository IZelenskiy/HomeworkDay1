package com.ciklum.homework.concurrency;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ThreadRunnable {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s15_l36_runnable_interface_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 36. Introducing to multithreading ***\n");

        System.out.println("Start thread 1");
        Thread t1 = new Thread(new SecondTask("Thread 1"));
        t1.start();

        System.out.println("Hello World!");

        System.out.println("Start thread 2");
        Thread t2 = new Thread(new SecondTask("Thread 2"));
        t2.start();

        System.out.println("Start thread 3");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " | Number: " + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread 3");
        t3.start();

    }

}

class SecondTask implements Runnable {
    private final String name;

    public SecondTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " | Number: " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
