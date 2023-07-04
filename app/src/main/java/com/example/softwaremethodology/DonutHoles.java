package com.example.softwaremethodology;

/**
 * Donut holes class that extends MenuItem which is used throughout the project
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class DonutHoles extends MenuItem {
    /** Instance variable for flavor */
    private String flavor;
    /** Instance variable for quantity */
    private int quantity;

    /**
     * Constructor for donut holes object that sets the flavor
     * @param flavor flavor as a String
     */
    public DonutHoles(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Constructor without quantity
     * @param flavor set flavor
     */
    public DonutHoles(String flavor) {
        this.flavor = flavor;
        this.quantity = 0;
    }

    /**
     * Gets the price of the donut holes
     * @return double that represents the price of a donut hole
     */
    @Override
    public double itemPrice() {
        return 0.39;
    }

    /**
     * Get flavor
     * @return flavor
     */
    @Override
    public String getFlavor() {
        return flavor + " DONUT HOLE";
    }

    /**
     * Sets quantity
     * @param q to set quantity to
     */
    @Override
    public void setQuantity(int q) {
        this.quantity = q;
    }

    /**
     * Gets quantitiy
     * @return quantity
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets type
     * @return type
     */
    @Override
    public String getType() {
        return "DONUT HOLE";
    }

    /**
     * Overrides the toString() method to return the data
     * @return String representning the data
     */
    @Override
    public String toString() {
        return quantity + " " + flavor + " Donut Hole(s)";
    }
}
