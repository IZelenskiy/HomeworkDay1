package com.ciklum.homework.concurrency.threadpool;

public class MessageProcessor implements Runnable {
    private int message;

    public MessageProcessor(int message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " [RECEIVED] Message = " + this.message);
        respondToMessage();
        System.out.println(Thread.currentThread().getName() + " (DONE) Processing message = " + this.message);
    }

    private void respondToMessage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Unable to process message " + this.message);
        }
    }
}
