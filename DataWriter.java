/*
Does the inverse of DataReader.java. Serializes an Inventory object and writes the result to a txt file.

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
    
    // Initialize filewriter
    public DataWriter(String filename) {
        try {
            writer = new BufferedWriter(new FileWriter(filename));
        }
        catch (IOException e) {
            System.out.println("IOException when creating DataWriter.");
        }
    }

    // Writes updated data to text file.
    public void writeData(Inventory inventory) throws IOException {
        LinkedHashMap<String, Product[]> products = inventory.getProducts();
        products.forEach (
            (category, p) -> {
                try {
                    writer.write(category);
                    writer.newLine();
                    for (Product prod : p) {
                        writer.write(String.format("%s,%d,%d,%.2f",
                            prod.getName(),
                            prod.getQuantity(),
                            (int) prod.getCostPrice(),
                            prod.getSalePrice()
                        ));
                        writer.newLine();
                    }    
                }
                catch (IOException e) {
                    System.out.println("IOException when writing data.");
                    System.out.println(e);
                }
            }
        );
        try {
            writer.write("end");
            writer.close();            
        }
        catch (IOException e) {
            System.out.println("IOException when writing data.");
        }
    }
}