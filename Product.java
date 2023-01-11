/*
Product class.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

public class Product {
    private String name;
    private int quantity;
    private double costPrice;
    private double salePrice;

    public Product(String name, int quantity, double costPrice, double salePrice) {
        this.name = name;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public String toString() {
        return String.format("%-15s$%-10.2f", name, salePrice); 
    }
}