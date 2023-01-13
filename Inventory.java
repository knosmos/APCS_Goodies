import java.util.LinkedHashMap;

public class Inventory {
    LinkedHashMap<String, Product[]> products;
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
                }
                counter++;
            }
        }
    }

    public void restock(int index) {

    }
}
