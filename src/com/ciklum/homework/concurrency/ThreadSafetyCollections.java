package com.ciklum.homework.concurrency;

import com.ciklum.homework.concurrency.model.Product;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafetyCollections {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        PrintStream fileStream = new PrintStream("s15_l38_thread_safety_collections_out.txt");
        System.setOut(fileStream);
        System.out.println("*** Lecture 38. Thread safety with collections ***\n");

        InventoryManager inventoryManager = new InventoryManager();

        System.out.println("* Populating objects to collection");
        Thread inventoryTask = new Thread(new Runnable() {
            @Override
            public void run() {
                inventoryManager.populateSoldProducts();
            }
        });

        System.out.println("* Display objects");
        Thread displayTask = new Thread(new Runnable() {
            @Override
            public void run() {
                inventoryManager.displaySoldProducts();
            }
        });

        inventoryTask.start();
        Thread.sleep(2000);
        displayTask.start();
    }

}

class InventoryManager {
    List<Product> soldProductsList = new CopyOnWriteArrayList<>();
    List<Product> purchasedProductsList = new ArrayList<>();

    public void populateSoldProducts() {
        for (int i = 0; i < 1000; i++) {
            Product product = new Product(i, "test_product_" + i);
            soldProductsList.add(product);
            System.out.println("ADDED: " + product.name);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts() {
        for(Product product : soldProductsList) {
            System.out.println("PRINT PRODUCT: " + product.name);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
