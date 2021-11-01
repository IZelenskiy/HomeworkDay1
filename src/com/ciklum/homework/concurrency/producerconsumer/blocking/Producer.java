package com.ciklum.homework.concurrency.producerconsumer.blocking;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    int questionNumber;
    BlockingQueue<Integer> questionQueue;

    public Producer(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    int nextQuestion = questionNumber++;
                    System.out.println("Got new Question: " + nextQuestion);
                    questionQueue.put(nextQuestion);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
