package com.example.softwaremethodology;

/**
 * Abstract superclass for all menu items
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public abstract class MenuItem {
    /** Forces all subclasses to implement this method which returns item price */
    public abstract double itemPrice();

    /**
     * Get flavor
     * @return flavor
     */
    public abstract String getFlavor();

    /**
     * Sets quantity
     * @param q to set quantity to
     */
    public abstract void setQuantity(int q);

    /**
     * Gets quantity
     * @return quantity
     */
    public abstract int getQuantity();

    /**
     * Gets type
     * @return type
     */
    public abstract String getType();
}