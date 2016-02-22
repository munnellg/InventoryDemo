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
 * A simple Shield class. Doesn't do much yet. Just displays its name and a 
 * description.
 * 
 * @author Gary Munnelly
 */
public class Shield implements IItem {
    /**
     * Default name of the Shield
     */
    private static final String DEFAULT_NAME = "Shield";
    /**
     * Default description of the Shield
     */
    private static final String DEFAULT_DESCRIPTION = 
            "A gigantic shield for a gigantic wuss.";
    
    /**
     * The name of this Shield
     */
    private String name;
    
    /**
     * A description of this Shield
     */
    private String description;
    
    /**
     * Default constructor for the Shield class. Initialises the name to 
     * DEFAULT_NAME and the description to DEFAULT_DESCRIPTION
     */
    public Shield() {
        this(Shield.DEFAULT_NAME, Shield.DEFAULT_DESCRIPTION);
    }
    
    /**
     * Constructor for the Shield class
     * 
     * @param name The name of this Shield
     * @param description A description of this Shield
     */
    public Shield( String name, String description ) {
        this.name = name;
        this.description = description;
    }
    
    /**
     * Get the name of this Shield
     * 
     * @return The name of the Shield as a String
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Get a description of this Shield
     * 
     * @return A description of the Shield as a String
     */
    @Override
    public String getDescription() {
        return this.description;
    }    
}
