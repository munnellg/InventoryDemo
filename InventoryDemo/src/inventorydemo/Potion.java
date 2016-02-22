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

/**
 * A simple potion class. Doesn't do much yet. Just displays its name and a 
 * description.
 * 
 * @author Gary Munnelly
 */
public class Potion implements IItem {
    /**
     * Default name of the potion
     */
    private static final String DEFAULT_NAME = "Potion";
    /**
     * Default description of the potion
     */
    private static final String DEFAULT_DESCRIPTION = 
            "Could be magical. "
            + "Could be bleach. "
            + "The only way to find out is to drink it.";
    
    /**
     * The name of this potion
     */
    private String name;
    
    /**
     * A description of this potion
     */
    private String description;
    
    /**
     * Default constructor for the Potion class. Initializes the name to 
     * DEFAULT_NAME and the description to DEFAULT_DESCRIPTION
     */
    public Potion() {
        this(Potion.DEFAULT_NAME, Potion.DEFAULT_DESCRIPTION);
    }
    
    /**
     * Constructor for the Potion class
     * 
     * @param name The name of this potion
     * @param description A description of this potion
     */
    public Potion( String name, String description ) {
        this.name = name;
        this.description = description;
    }
    
    /**
     * Get the name of this potion
     * 
     * @return The name of the potion as a String
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Get a description of this potion
     * 
     * @return A description of the potion as a String
     */
    @Override
    public String getDescription() {
        return this.description;
    }    
}
