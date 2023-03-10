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
    /*
    Main program flow; handles menu commands and costomer interactions
    */
    public static void main(String args[]) {
        // Load inventory
        Inventory inventory = new Inventory("data.txt");
        
        // Initialize Menus
        Splash splash = new Splash("splash.txt");

        Menu mainMenu = new Menu(
            new String[]{"Business Operation", "Customer", "Exit"}
        );

        Menu businessMenu = new Menu(
            new String[]{"View Inventory", "Re-stock", "View profits data", "Back to Main Menu"}
        );

        CustomerMenu customerMenu = new CustomerMenu(inventory.getProducts());

        // initialize input handler
        Scanner scan = new Scanner(System.in);

        // Main Loop
        boolean quit = false;
        do {
            // display initial selection menu
            splash.display();
            mainMenu.displayMenu();
            int selection = mainMenu.getInput();

            // Business Operations selected
            if (selection == 1) {
                boolean continueBusinessOperations = true;
                do {
                    System.out.println("\nBusiness Operations");
                    businessMenu.displayMenu();
                    int businessSelection = businessMenu.getInput();
                    if (businessSelection == 1) {
                        // display Inventory
                        InventoryMenu inventoryMenu = new InventoryMenu(inventory);
                        inventoryMenu.displayMenu();
                    }
                    else if (businessSelection == 2) {
                        // Re-stock
                        System.out.print("Enter the index of the item you want to restock: ");
                        int index = scan.nextInt();
                        inventory.restock(index - 1);
                    }
                    else if (businessSelection == 3){
                        // View Profits data
                        inventory.displayProfitData();
                    }
                    else {
                        // back to Main Menu
                        continueBusinessOperations = false;
                    }
                } while (continueBusinessOperations);
            }

            // Customer selected
            else if (selection == 2) {
                boolean continueShop = true;
                // Initialize customer
                Customer customer = new Customer();
                do {
                    customerMenu.displayMenu();
                    int productIndex = customerMenu.getInput() - 1;
                    Product selectedProduct = inventory.getItem(productIndex);
                    customer.addToTotal(selectedProduct.getSalePrice());
                    System.out.printf("You have added \033[92m%s\033[0m to your cart.\n", selectedProduct.getName());

                    System.out.println("Updating registry...");
                    inventory.purchase(productIndex);

                    // prompt
                    System.out.println("Would you like to buy more? (y/n)");
                    continueShop = scan.next().equals("y");
                } while (continueShop);
                // print total and exit to main menu
                System.out.printf("\nYour total is \033[92m$%.2f\033[0m\n", customer.getTotal());
                System.out.println("Thank you for shopping with us! :)\n");
            }

            else {
                quit = true;
            }
        } while (!quit);

        // store updated data
        System.out.println("\033[91mWriting updated data to disk...\033[0m");
        try {
            DataWriter writer = new DataWriter("data.txt");
            writer.writeData(inventory);            
        }
        catch (Exception e) {
            System.out.println("Error writing to disk.");
            System.out.println(e);
        }


        // Goodbye message
        System.out.println("\033[91mSystems shutting down...\033[0m");
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