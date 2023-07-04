package com.example.softwaremethodology;

/**
 * Yeast donut class used throughout the project
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class YeastDonut extends MenuItem {
    /** Instance variable representing the flavor */
    private String flavor;

    /** Instance variable representing the quantity */
    private int quantity;

    /**
     * Constructor that assigns the flavor to itself
     * @param flavor as a String
     */
    public YeastDonut(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Constructor without quantity
     * @param flavor
     */
    public YeastDonut(String flavor) {
        this.flavor = flavor;
        this.quantity = 0;
    }

    /**
     * Gets the cost of coffee
     * @return double that represents the coffee price
     */
    @Override
    public double itemPrice() {
        return 1.59;
    }

    /**
     * get flavor
     * @return flavor
     */
    @Override
    public String getFlavor() {
        return flavor + " YEAST DONUT";
    }

    /**
     * sets quantity
     * @param q to set quantity to
     */
    @Override
    public void setQuantity(int q) {
        this.quantity = q;
    }

    /**
     * gets quantity
     * @return quantity
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * gets type
     * @return type
     */
    @Override
    public String getType() {
        return "YEAST DONUT";
    }

    /**
     * Overrides the toString() method to return new String
     * @return String representing data
     */
    @Override
    public String toString() {
        return quantity + " " + flavor + " Yeast Donut(s)";
    }
}
