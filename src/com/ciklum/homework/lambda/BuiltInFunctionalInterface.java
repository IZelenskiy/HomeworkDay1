package com.ciklum.homework.lambda;

import com.ciklum.homework.lambda.model.Car;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class BuiltInFunctionalInterface {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("s18_l59_built_in_functional_interface.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 59. Built In Functional Interface ***\n");

        List<Car> cars = Arrays.asList(
                new Car("Honda", "Accord", "Red", 17300),
                new Car("Subaru", "Forester", "Black", 30000),
                new Car("Lexus", "RX300", "White", 20000),
                new Car("Toyota", "Camry", "White", 19000),
                new Car("Suzuki", "Grand", "Red", 12500)
        );

        System.out.println("* Methods without lambda");
        System.out.println("- Printing cars between price 19000 and 20000");
        printCarsPriceRange(cars, 19000, 20000);
        System.out.println();
        System.out.println("- Printing cars by color white");
        printCarByColor(cars, "White");

        System.out.println("\n* Methods with lambda as a parameter");
        System.out.println("- Printing cars between price 19000 and 20000");
        printCars(cars, new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getPrice() >= 19000 && car.getPrice() <= 20000;
            }
        });
        System.out.println();
        System.out.println("- Printing cars by color white");
        printCars(cars, (c) -> c.getColor().equals("White"));

        System.out.println("\n* Use Java functional Interface (Function)");
        Function<Car, String> carPriceAndColor = (c) -> "Price: " + c.getPrice() + ", Color: " + c.getColor();
        String simpleCar = carPriceAndColor.apply(cars.get(0));
        System.out.println(simpleCar);
    }

    public static void printCars(List<Car> cars, Predicate<Car> predicate) {
        for (Car car : cars) {
            if (predicate.test(car))
                car.printCar();
        }
    }

    public static void printCarsPriceRange(List<Car> cars, int low, int high) {
        for (Car c : cars) {
            if (low <= c.getPrice() && c.getPrice() <= high)
                c.printCar();
        }
    }

    public static void printCarByColor(List<Car> cars, String color) {
        for (Car c : cars) {
            if (c.getColor().equals(color))
                c.printCar();
        }
    }
}

@FunctionalInterface
interface CarCondition<T> {
    boolean test(T car);
}
