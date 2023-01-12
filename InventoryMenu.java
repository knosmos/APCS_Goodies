/*
Business inventory menu.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

import java.util.LinkedHashMap;

public class InventoryMenu extends Menu {
    private LinkedHashMap<String, Product[]> products;

    public InventoryMenu(LinkedHashMap<String, Product[]> products) {
        super();
        this.products = products;
        int numItems = 0;
        for (String key : products.keySet()) {
            numItems += products.get(key).length;
        }
        this.setNumItems(numItems);
    }

    public void displayMenu() {
        int counter = 1;
        for (String key : products.keySet()) {
            System.out.println();
            System.out.println("\033[93m" + key.toUpperCase() + "\033[0m");
            System.out.println("\033[96m(#)  (Item)    (Quantity) (Cost/case) (Sale Price)\033[0m");
            for (Product product : products.get(key)) {
                System.out.println(
                    String.format("\033[91m[%2d]\033[0m %s", counter, product.detailedInfo())
                );
                counter++;
                delay();
            }
            delay();
        }
    }

    public Product getItem(int index) {
        int counter = 0;
        for (String key : products.keySet()) {
            for (Product product : products.get(key)) {
                if (counter == index) {
                    return product;
                }
                counter++;
            }
        }
        return null;
    }
}