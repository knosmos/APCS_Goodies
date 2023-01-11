/*
Main driver code. Handles menu flow and customer interaction.

Project: Shopping System for Goodies Co with OOP concepts and file management
Java 11
Jieruei Chang, Melvin Huang, 2023 (Goodies Co Tryhards)
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class GoodiesDriver {
    public static void main(String args[]) {
        // Load data
        DataReader reader = new DataReader("data.txt");
        LinkedHashMap<String, Product[]> products = reader.parseData();
        
        // Initialize Menus
        Splash splash = new Splash("splash.txt");

        Menu mainMenu = new Menu(
            new String[]{"Business Operation", "Customer", "Exit"}
        );

        CustomerMenu customerMenu = new CustomerMenu(products);

        // Initialize customer
        Customer customer = new Customer();
        Scanner scan = new Scanner(System.in);

        // Main Loop
        boolean quit = false;
        do {
            splash.display();
            mainMenu.displayMenu();
            int selection = mainMenu.getInput();

            // Customer selected
            if (selection == 2) {
                boolean continueShop = true;
                do {
                    System.out.println("\nWhat would you to buy?");
                    customerMenu.displayMenu();
                    int productIndex = customerMenu.getInput() - 1;
                    Product selectedProduct = customerMenu.getItem(productIndex);
                    customer.addToTotal(selectedProduct.getSalePrice());
                    System.out.printf("You have added %s to your cart.\n", selectedProduct.getName());

                    // prompt
                    System.out.println("Would you like to buy more? (y/n)");
                    continueShop = scan.next().equals("y");
                } while (continueShop);
                System.out.printf("Your total is $%.2f\n", customer.getTotal());
                System.out.println("Thank you for shopping with us! :)\n");
            }

            else {
                quit = true;
            }
        } while (!quit);
    }
}


/*
Sample Output:


                       _ _
                      | (_)
  __ _  ___   ___   __| |_  ___  ___    ___ ___
 / _` |/ _ \ / _ \ / _` | |/ _ \/ __|  / __/ _ \
| (_| | (_) | (_) | (_| | |  __/\__ \ | (_| (_) |
 \__, |\___/ \___/ \__,_|_|\___||___/  \___\___(_)
  __/ |
 |___/

[1] Business Operation
[2] Customer
[3] Exit

What is your selection?
2

What would you to buy?

SNACKS
(#)  (Item)         (Sale Price)
[ 1] Chips          $0.75
[ 2] Popcorn        $0.75
[ 3] Pop Corners    $0.75
[ 4] Cheeze it      $0.75
[ 5] Gold Fish      $0.75
[ 6] Oreo Cookies   $0.75
[ 7] Fruit Snack    $0.25
[ 8] Trail Mix      $0.50
[ 9] Nutrigrain     $0.50
[10] Peanut Bar     $0.50

DRINKS
(#)  (Item)         (Sale Price)
[11] Coke           $1.25
[12] Sprite         $1.25
[13] Sunkist        $1.25
[14] Brisk          $1.25
[15] Ginger Ale     $1.25
[16] Water          $1.00
[17] Capri Sun      $0.75

ELSE
(#)  (Item)         (Sale Price)
[18] Ice cream      $1.00
[19] Klondike Bars  $1.25
[20] Italian Ice    $1.25
[21] Ice pop        $0.25

What is your selection?
18
You have added Ice cream to your cart.
Would you like to buy more? (y/n)
y

What would you to buy?

SNACKS
(#)  (Item)         (Sale Price)
[ 1] Chips          $0.75
[ 2] Popcorn        $0.75
[ 3] Pop Corners    $0.75
[ 4] Cheeze it      $0.75
[ 5] Gold Fish      $0.75
[ 6] Oreo Cookies   $0.75
[ 7] Fruit Snack    $0.25
[ 8] Trail Mix      $0.50
[ 9] Nutrigrain     $0.50
[10] Peanut Bar     $0.50

DRINKS
(#)  (Item)         (Sale Price)
[11] Coke           $1.25
[12] Sprite         $1.25
[13] Sunkist        $1.25
[14] Brisk          $1.25
[15] Ginger Ale     $1.25
[16] Water          $1.00
[17] Capri Sun      $0.75

ELSE
(#)  (Item)         (Sale Price)
[18] Ice cream      $1.00
[19] Klondike Bars  $1.25
[20] Italian Ice    $1.25
[21] Ice pop        $0.25

What is your selection?
NotAValidNumber
Please enter a number.
12
You have added Sprite to your cart.
Would you like to buy more? (y/n)
y

What would you to buy?

SNACKS
(#)  (Item)         (Sale Price)
[ 1] Chips          $0.75
[ 2] Popcorn        $0.75
[ 3] Pop Corners    $0.75
[ 4] Cheeze it      $0.75
[ 5] Gold Fish      $0.75
[ 6] Oreo Cookies   $0.75
[ 7] Fruit Snack    $0.25
[ 8] Trail Mix      $0.50
[ 9] Nutrigrain     $0.50
[10] Peanut Bar     $0.50

DRINKS
(#)  (Item)         (Sale Price)
[11] Coke           $1.25
[12] Sprite         $1.25
[13] Sunkist        $1.25
[14] Brisk          $1.25
[15] Ginger Ale     $1.25
[16] Water          $1.00
[17] Capri Sun      $0.75

ELSE
(#)  (Item)         (Sale Price)
[18] Ice cream      $1.00
[19] Klondike Bars  $1.25
[20] Italian Ice    $1.25
[21] Ice pop        $0.25

What is your selection?
100000

What is your selection?
9
You have added Nutrigrain to your cart.
Would you like to buy more? (y/n)
n
Your total is $2.75
Thank you for shopping with us! :)


                       _ _
                      | (_)
  __ _  ___   ___   __| |_  ___  ___    ___ ___
 / _` |/ _ \ / _ \ / _` | |/ _ \/ __|  / __/ _ \
| (_| | (_) | (_) | (_| | |  __/\__ \ | (_| (_) |
 \__, |\___/ \___/ \__,_|_|\___||___/  \___\___(_)
  __/ |
 |___/

[1] Business Operation
[2] Customer
[3] Exit

What is your selection?
3
*/