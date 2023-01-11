/*
Generic Menu.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

import java.util.Scanner;

public class Menu {
    private String[] items;
    private Scanner scan;
    private int numItems;

    public Menu() {
        scan = new Scanner(System.in);
    }

    public Menu(String[] items) {
        this.setItems(items);
        scan = new Scanner(System.in);
    }

    public void setItems(String[] items) {
        this.items = items;
        setNumItems(items.length);
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public void displayMenu() {
        for (int i=0; i < this.numItems; i++) {
            System.out.println(
                String.format("\033[91m[%d]\033[0m %s", i+1, this.items[i])
            );
        }
    }

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
}
