/*
Product class. Stores information (name, quantity, wholesale price, retail price) about a product.

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

    // Constructor; initializes instance fields and calculates cost price per item
    public Product(String name, int quantity, double costPrice, double salePrice) {
        this.name = name;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.costPricePerItem = (double) costPrice / 45.0; // we assume each case has 45
    }

    // Get cost price per item
    public double getCostPricePerItem(){
        return costPricePerItem;
    } 

    // Get product name
    public String getName() {
        return name;
    }

    // Get product quantity
    public int getQuantity() {
        return quantity;
    }

    // Set quantity of product
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // get cost price of product
    public double getCostPrice() {
        return costPrice;
    }

    // get sale price of product
    public double getSalePrice() {
        return salePrice;
    }

    // format as a string (for display in CustomerMenu)
    public String toString() {
        return String.format("%-15s$%-10.2f", name, salePrice); 
    }

    // format as a string (for display in InventoryMenu)
    public String detailedInfo() {
        return String.format("%-15s%-8d$%-10.2f$%-10.2f", name, quantity, costPrice, salePrice); 
    }
}