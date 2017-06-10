/*
 * TCSS 305
 * Assignment 2 - shoppingcart
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;


/**
 * Item class that represents a grocery store item.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public final class Item {
    /** Format for the currency.*/
    private static final NumberFormat NF = NumberFormat.getCurrencyInstance(Locale.US);
    
    /** The name of the Item. */
    private final String myName;
    
    /** The price of the Item. */
    private final BigDecimal myPrice;
    
    /** The bulk quantity of the Item. */
    private final int myBulkQuantity;
    
    /** The bulk price of the Item. */
    private final BigDecimal myBulkPrice;
   
    
    /**
     * Constructor that takes name and price.
     * 
     * @param theName 
     * @param thePrice 
     */
    public Item(final String theName, final BigDecimal thePrice) {
        this(theName, thePrice, 0, null);

    }

/**
 * Constructor that takes items with bulk quantity.
 * 
 * @param theName 
 * @param thePrice 
 * @param theBulkQuantity 
 * @param theBulkPrice 
 * @throws IllegalArgumentException
 * @throws IllegalArgumentException
 */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        
        if (thePrice.intValue() < 0) {
            throw new IllegalArgumentException();
        }
        if (theName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        myName = Objects.requireNonNull(theName);
        myPrice = Objects.requireNonNull(thePrice);
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;

    }

/**
 * Method that returns the price.
 * 
 * @return myPrice
 */
    public BigDecimal getPrice() {
        
        return myPrice;
    }
    
/**
 * Method that returns the Bulk quantity.
 * 
 * @return myBulkQuantity
 */
    public int getBulkQuantity() {
        
        return myBulkQuantity;
    }
    
/**
 * Method that returns the bulk price.
 * 
 * @return myBulkPrice
 */
    public BigDecimal getBulkPrice() {
        
        return myBulkPrice;
    }

    /**
     * Method that is true if the Item is bulk priced. 
     * 
     * @return True if the item has bulk pricing
     */
    public boolean isBulk() {
        Boolean result = false;
        
        if (myBulkPrice != null) {
            result = true;
        }
        return result;
    }
/**
 * ToString that represents the Item.
 * 
 * @return toString
 * 
 */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(128);
        final String comma = ", ";
        final String space = " ";
        if (isBulk()) {
            builder.append(myName);
            builder.append(comma);
            builder.append(NF.format(myPrice));
            builder.append(space);
            builder.append('(');
            builder.append(myBulkQuantity);
            builder.append(" for ");
            builder.append(myBulkPrice);
            builder.append(')');
        } else {
            builder.append(myName);
            builder.append(comma);
            builder.append(NF.format(myPrice));
        }
        return builder.toString();
    }

/**
 * Equals method that compares two Items.
 * 
 */
    @Override
    public boolean equals(final Object theOther) {
        
        final boolean result;
        if (this == theOther) {
            result = true;
        } else if (theOther == null || this.getClass() != theOther.getClass()) {
            result = false;
        } else {
            final Item other = (Item) theOther;
            result = toString().equals(other.toString());
        }
        return result;
    }

/**
 * HashCode method.
 * @return Hash of Item
 * 
 */
    @Override
    public int hashCode() {
        
        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
    }

}
