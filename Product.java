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
    private double costPricePerItem;

    public Product(String name, int quantity, double costPrice, double salePrice) {
        this.name = name;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.costPricePerItem = (double) costPrice / (double) quantity;
    }

    public double getCostPricePerItem(){
        return costPricePerItem;
    } 

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String detailedInfo() {
        return String.format("%-15s%-8d$%-10.2f$%-10.2f", name, quantity, costPrice, salePrice); 
    }
}