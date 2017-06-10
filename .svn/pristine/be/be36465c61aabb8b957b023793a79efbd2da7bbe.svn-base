/*
 * TCSS 305
 * Assignment 2 - shoppingcart
 */

package model;

import java.util.Objects;

/**
 * Class that stores the information from each order.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public final class ItemOrder {
    
    /** The Item. */
    private final Item myItem;
    
    /** The quantity of the item. */
    private final int myQuantity;

    /**
     * Constructor for ItemOrder.
     * 
     * @param theItem 
     * @param theQuantity 
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        
        myItem = theItem;
        myQuantity = theQuantity;
    }

    /**
     * Method that returns the Item.
     * 
     * @return myItem
     */
    public Item getItem() {
        return Objects.requireNonNull(myItem);
        //return myItem;
    }
    /**
     * Method that returns the quantity.
     * 
     * @return myQuantity
     */
    public int getQuantity() {
        return Objects.requireNonNull(myQuantity);
        //return myQuantity;
    }

    /**
     * ToString method that returns a string representation of the ItemOrder.
     * @return toString
     */
    @Override
    public String toString() {
        
        final StringBuilder builder = new StringBuilder(128);
        builder.append("Quantity: ");
        builder.append(getQuantity());
        builder.append(" (");
        builder.append(myItem.toString());
        builder.append(") ");         

        return builder.toString();
    }
}
