package com.ciklum.homework.concurrency.threadpool;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s15_l41_thread_pools_and_executor_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 41. Thread pools and Executor Framework ***\n");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable processor = new MessageProcessor(2);
        executor.execute(processor);

        Runnable processor1 = new MessageProcessor(3);
        executor.execute(processor1);

        Runnable processor2 = new MessageProcessor(4);
        executor.execute(processor2);

        System.out.println("* Shut down the service");
        executor.shutdown();
//        executor.shutdownNow(); // Terminate the service immediately

        System.out.println("* Await termination");
        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!executor.isTerminated()) {
        }

        System.out.println("Submitted all tasks...");
    }

}
