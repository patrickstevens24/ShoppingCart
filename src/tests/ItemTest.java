/*
 * TCSS 305
 * Assignment 2 - Shoppingcart
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import model.Item;
import org.junit.Before;
import org.junit.Test;




/**
 * Testing the Item class.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class ItemTest {
    
    /** The Item we are going to test. */
    private Item myItem;

    /**
     * A method to initialize the test fixture before each test.
     * 
     */
    @Before
    public void setUp() {
        myItem = new Item("Berry", new BigDecimal("1.00"), 5, new BigDecimal("14.00"));
    }

    /**
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test
    public void testHashCode() {
        final Item i = myItem;
        assertEquals(i.hashCode(), myItem.hashCode());
    }

    /**
     * Test method for {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test
    public void testItemStringBigDecimal() {
        final Item i = new Item("Berry", new BigDecimal("1.00"));
        assertEquals("Testing for same price", "Berry", i.toString());
        
    }

    /**
     * Test method for {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test
    public void testItemStringBigDecimalIntBigDecimal() {
        assertEquals("Berry, $1.00 (5 for $14.00)", myItem.toString());
        
    }

    /**
     * Test method for {@link model.Item#getPrice()}.
     */
    @Test
    public void testGetPrice() {
        assertEquals(new BigDecimal("1.00"), myItem.getPrice());
    }

    /**
     * Test method for {@link model.Item#getBulkQuantity()}.
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals(5, myItem.getBulkQuantity());
    }

    /**
     * Test method for {@link model.Item#getBulkPrice()}.
     */
    @Test
    public void testGetBulkPrice() {
        assertEquals(new BigDecimal("14.00"), myItem.getBulkPrice());
    }

    /**
     * Test method for {@link model.Item#isBulk()}.
     */
    @Test
    public void testIsBulk() {
        assertTrue(myItem.isBulk());
    }

    /**
     * Test method for {@link model.Item#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Berry, $1.00 (5 for $14.00)", myItem.toString());
    }

    /**
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObject() {
        final Item same = new Item("Berry", new BigDecimal("1.00"), 
                                   5, new BigDecimal("14.00"));
        final Item notSame = new Item("Grape", new BigDecimal("1.00"), 
                                      5, new BigDecimal("14.00"));
        
        assertTrue(myItem.equals(same));
        assertFalse(myItem.equals(notSame));
        assertTrue(myItem.equals(myItem));
    }
    
    /**
     * Test method for equals method.
     */
    @Test
    public void testEqualsObjectFalse() {
        assertFalse(myItem.equals(null));
        assertFalse(myItem.equals("FAIL!"));
        assertFalse(myItem.equals(new Object()));
    }
    
    /**
     * Test when prices is less than zero.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPricesException() { 
        new Item("Berry", new BigDecimal("-1"), 5, new BigDecimal("14.00"));
    }
    
    /**
     * Test when name is empty.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNameNotEmpty() { 
        new Item("", new BigDecimal("1.00"), 5, new BigDecimal("14.00"));
    }

}
