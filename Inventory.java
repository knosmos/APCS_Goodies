/*
Inventory class. Mostly just a wrapper for the LinkedHashMap<String, Product[]> of products/categories.
Also contains methods for calculating profit data, as well as purchasing and restocking items.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

import java.util.LinkedHashMap;

public class Inventory {
    LinkedHashMap<String, Product[]> products;
    private double revenue = 0;
    private double cost = 0;

    // initialize Inventory with existing products hashmap
    public Inventory(LinkedHashMap<String, Product[]> products) {
        this.products = products;
    }

    // initialize Inventory with data file filename
    public Inventory(String filename) {
        DataReader reader = new DataReader(filename);
        this.products = reader.parseData();
    }

    // Get item located at specific index in products
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

    // Get products hashmap
    public LinkedHashMap<String, Product[]> getProducts() {
        return this.products;
    }

    // purchase an item, reduce its quantity, and update profits
    public void purchase(int index) {
        Product item = this.getItem(index);
        item.setQuantity(item.getQuantity() - 1);
        updateProfitData(index);
    }

    // recalculate revenue and cost
    public void updateProfitData(int index){
        Product item = this.getItem(index);
        this.revenue += item.getSalePrice();
        this.cost += item.getCostPricePerItem(); //cost per single item
    }

    // get revenue
    public double getRevenue(){
        return this.revenue;
    }

    // get cost
    public double getCost(){
        return this.cost;
    }

    // calculate profit, display profit/revenue/cost
    public void displayProfitData() {
        System.out.printf("\033[96mProfits: \033[0m $%.2f\n", this.getRevenue() - this.getCost());
        System.out.printf("\033[92mRevenue: \033[0m $%.2f\n", this.getRevenue());
        System.out.printf("\033[91mCosts: \033[0m $%.2f\n", this.getCost());
    }

    // reset an item's quantity to 45
    public void restock(int index) {
        Product item = getItem(index);
        item.setQuantity(45);
        System.out.printf("\033[92m%s\033[0m has been restocked\n", item.getName());
    }
}
