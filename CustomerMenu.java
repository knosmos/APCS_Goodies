/*
Customer menu. Allows for selection of items to purchase.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

import java.util.LinkedHashMap;

public class CustomerMenu extends Menu {
    private LinkedHashMap<String, Product[]> products;

    // Initialize products and number of items
    public CustomerMenu(LinkedHashMap<String, Product[]> products) {
        super();
        this.products = products;
        int numItems = 0; // calculate how many items we have in total
        for (String key : products.keySet()) {
            numItems += products.get(key).length;
        }
        this.setNumItems(numItems);
    }

    // Display customer menu
    public void displayMenu() {
        int counter = 1;
        for (String key : products.keySet()) {
            System.out.println();
            System.out.println("\033[93m" + key.toUpperCase() + "\033[0m"); // print category name
            System.out.println("\033[96m(#)  (Item)         (Sale Price)\033[0m");
            for (Product product : products.get(key)) { // for each category...
                System.out.println(
                    String.format("\033[91m[%2d]\033[0m %s", counter, product) // print product
                );
                counter++;
                delay();
            }
            delay();
        }
    }
}