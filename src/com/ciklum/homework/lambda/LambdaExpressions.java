package com.ciklum.homework.lambda;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class LambdaExpressions {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s18_l58_lambda_expressions.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 58. Lambda Expressions ***\n");

        ALambdaInterface singleMethod = () -> System.out.println("* Lambda single expression");
        singleMethod.someMethod();

        System.out.println("* Lambda expression with parameters");
        CalculateFunctionalInterface sum = (a, b) -> a + b;
        System.out.println("Result of expression: " + sum.compute(12, 10));

        System.out.println("* Lambda expression with parameters and multiple lines");
        CalculateFunctionalInterface nonZeroDivider = (a, b) -> {
            if (a == 0 || b == 0) {
                return 0;
            }
            return a / b;
        };
        System.out.println("Result of expression: " + nonZeroDivider.compute(12, 10));

        StringWorkerFunctionalInterface reversed = (s) -> {
          StringBuilder result = new StringBuilder();
          for (int i = s.length() - 1; i >= 0; i--)
              result.append(s.charAt(i));

          return result.toString();
        };

        System.out.println("* Reverse string with lambda");
        System.out.println(reversed.work("Vehicle"));

    }
}
