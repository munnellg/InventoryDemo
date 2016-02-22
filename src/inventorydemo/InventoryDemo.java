/*
 * The MIT License
 *
 * Copyright 2016 Gary Munnelly.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package inventorydemo;

import java.util.Scanner;

/**
 * Demonstrates the behaviour of the Inventory class
 * @author Gary Munnelly
 */
public class InventoryDemo {
    public static Inventory inventory = new Inventory();
    public static IItem holding = null;
    
    /**
     * Create a new item and put it in the inventory
     */
    public static void createNewItem() {
        IItem item;
        
        // Display options for item type
        System.out.println("What type of item would you like to create");
        System.out.println("1: Sword");
        System.out.println("2: Shield");
        System.out.println("3: Potion");
        
        // Get user selection
        Scanner input = new Scanner(System.in);
        
        // Validate
        if(input.hasNextInt()) {
            int idx = input.nextInt();
            input.nextLine();
            
            // Get item options from user
            System.out.println("Enter item name:");
            String name = input.nextLine();
            System.out.println("Enter item description:");
            String description = input.nextLine();
            
            // Build the item
            switch(idx) {
                case 1:
                    item = new Sword(name, description);
                    break;
                case 2:
                    item = new Shield(name, description);
                    break;
                case 3:
                    item = new Potion(name, description);
                    break;
                default:
                    System.out.println("Invalid item type");
                    return;                
            }
            
            // Test if item was successfully added
            if(!inventory.insertItem(item)){
                System.out.println("Unable to add item. Item discarded");                        
            }
        } else {
            System.out.println("Invalid choice");
        }
    }
    
    /**
     * Displays what is in the player's hand
     */
    public static void displayHolding() {
        // If we're not holding anything, display an appropriate message
        if(holding == null) {
            System.out.println("You aren't holding anything");
        } else {
            // Otherwise show the item
            System.out.printf("You are holding a %s --> %s\n", 
                    holding.getName(), 
                    holding.getDescription());
        }
    }
    
    /**
     * Get an item from the inventory and put it in the player's hand
     */
    public static void getItem() {
        if(holding != null) {
            System.out.println("You're already holding something. Either drop "
                    + "it or put it back in the inventory before grabbing "
                    + "something else");
        } else {
            System.out.print(
                    "Enter the index of the item you'd like to take: ");
            
            Scanner input = new Scanner(System.in);
            
            if(input.hasNextInt()) {
                int index = input.nextInt();
                holding = inventory.getItem(index);
                if(holding == null) {
                    System.out.println("There's no item at that index");
                }
            }
            
            input.nextLine();
        }        
    }
    
    /**
     * Put whatever item the player is currently holding into the inventory
     */
    public static void putItem() {
        if(holding == null) {
            System.out.println("You're not holding anything that can be put in "
                    + "the inventory.");
        } else {
            inventory.insertItem(holding);
            holding = null;
        }        
    }
    
    /**
     * Drop whatever item the player is currently holding
     */
    public static void dropItem() {
        if(holding == null) {
            System.out.println(
                    "You're not holding anything that can be dropped.");
        } else {            
            holding = null;
        }        
    }
    
    /**
     * Main function. Kick off the demonstration
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char action;
        
        do {
            // Display interface
            System.out.println("\nHAND:");
            System.out.println("----");
            displayHolding();
            System.out.println("\nINVENTORY:");
            System.out.println("---------");
            inventory.listContents();
            
            System.out.println("\nWhat would you like to do?");
            System.out.println("\tc: Create new Item");
            System.out.println("\tg: Get Item from Inventory");
            System.out.println("\tp: Put current Item in Inventory");
            System.out.println("\td: Drop current Item");
            System.out.println("\tq: Quit the program");
            
            // Create a scanner to read user input
            Scanner input = new Scanner(System.in);
            
            // Get command from the user
            if (input.hasNext()) {
                action = input.nextLine().charAt(0);                
            } else {
                action = '0';
            }
            
            // Evaluate the command
            switch(action) {
                case 'c':
                    createNewItem();
                    break;
                case 'g':
                    getItem();
                    break;
                case 'p':
                    putItem();
                    break;
                case 'd':
                    dropItem();
                    break;
                case 'q':
                    break;                
                default:
                    System.out.println("Invalid input. Try again.");
            }
        } while(action != 'q');        
    }    
}
