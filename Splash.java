/*
Splash header.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Splash {
    Scanner sc;
    File file;
    ArrayList<String> lines = new ArrayList<String>();
    public Splash(String filename) {
        // load file
        try {
            file = new File(filename);
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("Splash file not found.");
        }

        // read and store splash header
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
    }
    public void display() {
        System.out.println("\033[92m"); // ANSI code for green
        for (String line : lines) {
            System.out.println(line); // Print each line of the splash header
        }
        System.out.println("\033[0m"); // ANSI end code
    }
}