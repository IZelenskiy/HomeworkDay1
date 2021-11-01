package com.ciklum.homework.concurrency.producerconsumer.simple;

import java.util.List;

public class Producer implements Runnable {
    List<Integer> questionList = null;
    final int LIMIT = 5;
    private int questionNumber;

    public Producer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void readQuestions(int questionNumber) throws InterruptedException {
        synchronized (questionList) {
            while (questionList.size() == LIMIT) {
                System.out.println("Waiting for questions...");
                questionList.wait();
            }
        }

        synchronized (questionList) {
            System.out.println("New Question: " + questionNumber);
            questionList.add(questionNumber);
            Thread.sleep(100);
            questionList.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                readQuestions(questionNumber++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
