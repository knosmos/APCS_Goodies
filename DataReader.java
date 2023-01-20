/*
Reads and parses data.txt file, converting it to an ordered map of categories and Product arrays.
Can also print the raw data, if such a use case arises.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class DataReader {
    Scanner sc;
    File file;
    public DataReader(String filename) {
        try {
            file = new File(filename);
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // print the raw data for some reason (temporary, Elia said to do this apparently?)
    public void printRawData() {
        System.out.println("Loading Raw Data:");
        boolean keepGoing = true;
        do {
            String line = sc.nextLine();
            System.out.println(line);
            if (line.equals("end")) {
                // check for end
                keepGoing = false;
            }
        } while (keepGoing);
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