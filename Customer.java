/*
Customer class. Stores the total amount of money spent by the customer.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

public class Customer {
    private double total;

    // initialize current total
    public Customer() {
        total = 0;
    }

    // add item cost to total
    public void addToTotal(double cost) {
        total += cost;
    }

    // get current total cost
    public double getTotal() {
        return total;
    }
}