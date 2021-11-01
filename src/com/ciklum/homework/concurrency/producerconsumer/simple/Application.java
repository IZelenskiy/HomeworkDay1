package com.ciklum.homework.concurrency.producerconsumer.simple;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s15_l39_producer_consumer_1_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 39. Producer and Consumer with notify() and wait() ***\n");

        List<Integer> questionList = new ArrayList<>();

        Thread t1 = new Thread(new Producer(questionList));
        Thread t2 = new Thread(new Consumer(questionList));

        t1.start();
        t2.start();

    }

}
