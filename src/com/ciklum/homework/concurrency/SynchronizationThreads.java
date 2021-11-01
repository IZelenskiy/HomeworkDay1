package com.ciklum.homework.concurrency;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SynchronizationThreads {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s15_l37_synchronization_threads_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 37. Synchronization ***\n");

        Sequence sequence = new Sequence();
        Worker worker1 = new Worker(sequence);
        worker1.start();
        Worker worker2 = new Worker(sequence);
        worker2.start();
    }

}

class Worker extends Thread {
    Sequence sequence = null;

    public Worker(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " | " + sequence.getNext());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Sequence {
    private int value = 0;

    public synchronized int getNext() {
        value++;
        return value;
    }
}

