/*
 * TCSS 305
 * Assignment 2 - shoppingcart
 */

package model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class ShoppingCart {
    
    /** List containing myOrder.*/
    private List<ItemOrder> myOrder;

    /** If you are a member or not.*/
    private boolean myMembership;

/**
 * ShoppingCart constructor.
 * 
 */
    public ShoppingCart() {
        myMembership = false;
        myOrder = new LinkedList<ItemOrder>();

    }

/**
 * Adds the items to the order and checks if item is already there.
 * @param theOrder 
 */
    public void add(final ItemOrder theOrder) {
        int index = 0;
        int start = -1;
        for (final ItemOrder order : myOrder) {
            if (order.getItem().equals(theOrder.getItem())) {
                start = index;
            }
            index++;
        }
        if (start > -1) {
            myOrder.set(start, theOrder);
            
        } else {
            myOrder.add(theOrder);
        }
    }

/**
 * Method that sets the membership.
 * @param theMembership 
 */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

/**
 * Method that calculates the total price.
 * @return price
 */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        total = total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        int singleItems = 0;
        for (final ItemOrder order : myOrder) {
            if (myMembership) {
                if (order.getItem().isBulk()) {
           
                    final int numBulkItems = order.getQuantity() 
                                    / order.getItem().getBulkQuantity();
                    singleItems = order.getQuantity() - (numBulkItems 
                                    * order.getItem().getBulkQuantity());
                    total = total.add(order.getItem().getBulkPrice().multiply
                                      (new BigDecimal(numBulkItems)));
                    total = total.add(order.getItem().getPrice().multiply
                                      (new BigDecimal(singleItems)));
                } else {
                    final int quan = order.getQuantity();
                    total = total.add(order.getItem().getPrice().multiply
                                      (new BigDecimal(quan)));
                }
            } else {
                final int quan = order.getQuantity();
                total = total.add(order.getItem().getPrice().multiply(new BigDecimal(quan)));
            }
        }

        return total;
       
    }
    
/**
 * Clears the orders from the cart.
 * 
 */
    public void clear() {
        myOrder = new LinkedList<ItemOrder>();
        
    }
/**
 * ToString method for the shoppingcart.
 * 
 * @return toString
 */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(128);
        builder.append("The Order: ");
        builder.append(myOrder);
        builder.append(" The Total: ");
        builder.append(calculateTotal());
        return builder.toString();
    }

}
