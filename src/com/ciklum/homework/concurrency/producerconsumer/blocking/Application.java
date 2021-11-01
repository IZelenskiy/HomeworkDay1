package com.ciklum.homework.concurrency.producerconsumer.blocking;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s15_l40_producer_consumer_2_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 40. Producer and Consumer using a BlockingQueue ***\n");

        BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);

        Thread t1 = new Thread(new Producer(questionQueue));
        Thread t2 = new Thread(new Consumer(questionQueue));

        t1.start();
        t2.start();
    }

}
