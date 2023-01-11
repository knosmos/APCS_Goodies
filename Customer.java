/*
Customer class.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

public class Customer {
    private double total;
    public Customer() {
        total = 0;
    }
    public void addToTotal(double cost) {
        total += cost;
    }
    public double getTotal() {
        return total;
    }
}