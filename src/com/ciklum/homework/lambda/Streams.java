package com.ciklum.homework.lambda;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) throws IOException {
        PrintStream fileStream = new PrintStream("s18_l60_streams_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 60. Streams ***\n");

        System.out.println("\n* Integer stream");
        IntStream.range(1, 10).forEach((x) -> System.out.print(x));

        System.out.println("\n* Integer stream with skip first 5 element");
        IntStream.range(1, 10).skip(5).forEach((x) -> System.out.print(x));

        System.out.println("\n* Integer stream with sum (from 1 to 5)");
        int value = IntStream.range(1, 5).sum();
        System.out.println(value);

        System.out.println("\n* Stream OF, sort and find first");
        Stream.of("Hello", "bottle", "Africa")
                .sorted()
                .findFirst()
                .ifPresent((x) -> System.out.println(x));

        System.out.println("\n* Stream from array, filter and print");
        String[] items = {"car", "computer", "box", "tent", "toy"};
        Stream.of(items)
                .filter((x) -> x.startsWith("t"))
                .sorted()
                .forEach((x) -> System.out.print(x + ", "));

        System.out.println("\n* Average of squares of an int array");
        Arrays.stream(new int[] {2, 4, 5, 8, 10})
                .map((x) -> x * x)
                .average()
                .ifPresent(n -> System.out.println(n));

        System.out.println("\n* Stream from a list, filter and print");
        List<String> listOfItems = Arrays.asList("Computer", "Box", "Pencil", "Car", "Tent", "TV-set");
        listOfItems.stream()
                .map(x -> x.toLowerCase(Locale.ROOT))
                .filter(x -> x.startsWith("c"))
                .sorted()
                .forEach(x -> System.out.print(x + ", "));

        System.out.println("\n* Streaming files");
        Stream<String> lines = Files.lines(Paths.get("files/wordFile.txt"));
        lines.sorted()
                .filter(l -> l.length() > 6)
                .forEach(x -> System.out.print(x + ", "));
        lines.close();

        System.out.println("\n* Streaming files (words contains)");
        List<String> words = Files.lines(Paths.get("files/wordFile.txt"))
                .filter(x -> x.contains("th"))
                .collect(Collectors.toList());
        words.forEach(x -> System.out.print(x + ", "));

        System.out.println("\n* Splitting CSV");
        Stream<String> rows = Files.lines(Paths.get("files/stockDataCsv.txt"));
        int rowCount = (int) rows
                .map(x -> x.split(","))
                .filter(x -> x.length > 3)
                .count();
        System.out.println(rowCount + " good rows.");
        rows.close();

    }

}
