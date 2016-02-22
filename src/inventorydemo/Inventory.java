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

import java.util.Arrays;

/**
 * A simple inventory class which will hold an array of objects that implement
 * the IItem interface. There is an upper limit on the number of items the
 * inventory can contain, but not on the total weight. Hardly realistic, but
 * is only being used as an example in any case.
 * 
 * @author Gary Munnelly
 */
public class Inventory {
    /**
     * The default size of the inventory in the event a capacity is not 
     * specified
     */
    private static final int DEFAULT_MAX_CAPACITY = 10;
      
    /**
     * The number of items currently stored in our inventory
     */
    private int numItems;
    
    /**
     * Data structure used to store inventory contents
     */
    private IItem [] contents;
            
    /**
     * Default constructor for the Inventory class
     * 
     * Initialise inventory to have capacity of DEFAULT_MAX_CAPACITY
     */
    public Inventory( ) {
        // Call other constructor and pass DEFAULT_MAX_CAPACITY as argument
        this(Inventory.DEFAULT_MAX_CAPACITY);
    }
    
    /**
     * Constructor for the Inventory class. Initialise the inventory to have
     * the capacity passed as argument.
     * 
     * @param maxCapacity The maximum number of item of our inventory can hold
     */
    public Inventory( int maxCapacity ) {
        
        // Create new array of items
        this.contents = new IItem[maxCapacity];        
                
        // Initialize all items in the array to be null
        Arrays.fill(this.contents, 0, this.contents.length, null);
        
        // Set our number of items to zero
        this.numItems = 0;
    }
    
    /**
     * Get the maximum number of items we can store in this inventory
     * 
     * @return The length of the inventory contents array
     */
    public int getMaxCapacity() {
        return this.contents.length;
    }
     
    /**
     * Get the number of items we currently have stored in our inventory
     * 
     * @return The number of items in the inventory
     */
    public int getNumItems() {
        return this.numItems;
    }
    
    /**
     * Retrieve a reference to an item in the inventory
     * 
     * @param i The index of the item we are looking for.
     * @return A reference to the item at index i. Will be null if item not 
     * found or the index is invalid
     */
    public IItem getItem(int index) {
        IItem item = null;
        
        // Ensure index is valid
        if(index < this.contents.length && index >= 0) {
            // retrieve the item
            item = this.contents[index];
            this.dropItem(index);
        }
        
        // Return the item/null
        return item;
    }
    
    /**
     * Insert a new item into the inventory. Maintains alphabetical sorting by
     * the name of the item.
     * 
     * @param item The item that we're adding to the inventory
     * @return True if item successfully added, false otherwise
     */
    public boolean insertItem (IItem item) {
        // Ensure that we haven't exceeded the maximum capacity of our 
        // inventory
        if(this.numItems >= this.contents.length || item == null) {
            return false;
        }
        
        // Find the appropriate place to insert the item such that the array
        // remains sorted. The insertion point is either where we find an empty 
        // (null) slot or where our new item alphabetically comes before 
        // an item
        for(int i=0; i<this.contents.length; i++) {
            // Test
            if(this.contents[i] == null || 
                    item.getName().compareTo(this.contents[i].getName()) < 0) {                
                // Insert
                this.insertItemAt(item, i);                
                this.numItems++;
                break;
            }
        }
        
        return true;
    }
    
    /**
     * Delete an item from the inventory and maintain the order of the elements
     * in the list.
     * @param index The index of the item to be deleted
     * @return True if the delete succeeded. False otherwise.
     */
    public boolean dropItem (int index) {
        // Check that the index is valid
        if(index >= this.contents.length || index < 0) {
            // Return false on invalid index
            return false;
        }
        
        // Reorder array items, overwriting the element we want to delete
        for(int i=index; i<this.contents.length-1; i++) {
            // Exit early if we've shuffled everything that needs to be moved
            if(this.contents[i] == null) {
                return true;
            }
            this.contents[i] = this.contents[i+1];            
        }
        
        // Add null at the very end of the array (basically deal with the case
        // where the array was completely full and we removed an item.
        this.contents[this.contents.length-1] = null;
        
        // Indicate success
        return true;
    }
    
    /**
     * Print the contents of the inventory to the command line. Will show
     * the string "EMPTY" for slots that haven't been filled
     */
    public void listContents() {
        // Iterate over inventory contents
        for(int i=0; i<this.contents.length; i++) {
            
            // Print the index of the current item
            System.out.printf("%2d: ",i);
            // If this slot isn't empty, print the item details
            if( this.contents[i] != null ) {                
                System.out.printf("%-7s --> ", this.contents[i].getName());
                System.out.println(this.contents[i].getDescription());
            } else {
                // Print empty if the slot doesn't contain an item
                System.out.printf("%-7s\n", "EMPTY");
            }            
        }
    }
    
    /** 
     * Inserts an item at the specified index, shuffling other elements down
     * the array as appropriate.
     * 
     * @param item The item to be inserted
     * @param index The index at which to insert the array
     */
    private void insertItemAt(IItem item, int index) {    
        // Iterate over array contents and shuffle elements down
        for(int i=index; i<this.contents.length; i++) {
            // If we find a null item, we can stop early. We're at the end of 
            // the list of items
            if ( item == null ) {
                break;
            }
            IItem temp = this.contents[i];
            this.contents[i] = item;
            item = temp;
        }
    }
}
