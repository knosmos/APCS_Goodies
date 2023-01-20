/*
Does the inverse of DataReader.java. Converts Inventory object to a txt file.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.io.IOException;

public class DataWriter {
    private BufferedWriter writer;
    public DataWriter(String filename) throws IOException {
        writer = new BufferedWriter(new FileWriter(filename));
    }

    // Writes updated data to text file.
    public void writeData(Inventory inventory) {
        LinkedHashMap<String, Product[]> products = inventory.getProducts();
        products.forEach (
            (category, p) -> {
                try {
                    writer.write(category);
                }
                catch (IOException e) {
                    System.out.println("you done goofed");
                }
                for (Product prod : p) {
                    writer.write();
                }
            }
        );
    }

    // Returns an ordered map of product categories and products.
    public LinkedHashMap<String, Product[]> parseData() {
        boolean keepGoing = true; // break would work better here but you took off points last time so i'm using this instead
        
        LinkedHashMap<String, Product[]> products = new LinkedHashMap<String, Product[]>();
        
        String currentCategory = "none";
        ArrayList<Product> currentProducts = new ArrayList<Product>();;

        do {
            String line = sc.nextLine();
            if (!line.contains(",")) {
                // save previous category
                if (!currentCategory.equals("none")) {
                    products.put(
                        currentCategory,
                        currentProducts.toArray(
                            new Product[currentProducts.size()]
                        )
                    );
                }
                // start new category
                currentCategory = line;
                currentProducts = new ArrayList<Product>();
                
                if (line.equals("end")) {
                    // check for end
                    keepGoing = false;
                }
            }
            else {
                // parse and add product to current category
                String[] data = line.split(",");
                currentProducts.add(new Product(
                    data[0],
                    Integer.parseInt(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3])
                ));
            }
        } while (keepGoing);
        return products;
    }
}