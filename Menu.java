/*
Generic Menu. Implements capability to display a menu and get + validate user input.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

import java.util.Scanner;

public class Menu {
    private String[] items;
    private Scanner scan;
    private int numItems;

    // Constructor for empty Menu; initializes input handler
    public Menu() {
        scan = new Scanner(System.in);
    }

    // Constructor for Menu with items
    public Menu(String[] items) {
        this.setItems(items);
        scan = new Scanner(System.in);
    }

    // Sets Menu items
    public void setItems(String[] items) {
        this.items = items;
        setNumItems(items.length);
    }

    // Sets number of items
    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    // Display menu
    public void displayMenu() {
        for (int i=0; i < this.numItems; i++) {
            System.out.println(
                String.format("\033[91m[%d]\033[0m %s", i+1, this.items[i])
            );
            delay();
        }
    }

    // Get menu selection from user and validate input
    public int getInput(){
        int result;
        do {
            System.out.println("\nWhat is your selection?");
            while (!scan.hasNextInt()) { // handle non-numeric input
                System.out.println("Please enter a number.");
                scan.next(); // clears existing input
            }
            result = scan.nextInt();
        } while (result <= 0 || result > this.numItems);
        return result;
    }

    // small delay to make the menu display look cooler
    public void delay() {
        try {
            Thread.sleep(10);
        }
        catch (Exception e) {
            System.out.println("Error in Thread.sleep");
        }
    }
}
