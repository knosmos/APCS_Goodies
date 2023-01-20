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

    public Inventory(LinkedHashMap<String, Product[]> products) {
        this.products = products;
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

    public LinkedHashMap<String, Product[]> getProducts() {
        return this.products;
    }

    public void purchase(int index) {
        int counter=0;
        for (String key : products.keySet()) {
            for (Product product : products.get(key)) {
                if (counter == index) {
                    product.setQuantity(product.getQuantity() - 1);
                    updateProfitData(index);
                }
                counter++;
            }
        }
    }

    public void updateProfitData(int index){
        Product item = this.getItem(index);
        this.revenue += item.getSalePrice();
        this.cost += item.getCostPricePerItem(); //cost per single item
    }

    public double getRevenue(){
        return this.revenue;
    }

    public double getCost(){
        return this.cost;
    }

    public void displayProfitData() {
        System.out.printf("\033[96mProfits: \033[0m $%.2f\n", this.getRevenue() - this.getCost());
        System.out.printf("\033[92mRevenue: \033[0m $%.2f\n", this.getRevenue());
        System.out.printf("\033[91mCosts: \033[0m $%.2f\n", this.getCost());
    }

    public void restock(int index) {
        Product item = getItem(index);
        item.setQuantity(45);
        System.out.printf("\033[92m%s\033[0m has been restocked\n", item.getName());
    }
}
