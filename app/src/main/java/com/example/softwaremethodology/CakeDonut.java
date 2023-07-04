package com.example.softwaremethodology;

/**
 * Cake donut class which extends MenuItem used throughout the project
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class CakeDonut extends MenuItem {
    /** Instance variable representing flavor */
    private String flavor;
    /** Instance variable representing quantity */
    private int quantity;

    /**
     * Constructor withtout quantity
     * @param flavor to be inputted.
     */
    public CakeDonut(String flavor) {
        this.flavor = flavor;
        this.quantity = 0;
    }

    /**
     * Constructor that takes in flavor and quantity
     * @param flavor String representing flavor
     * @param quantity integer representing quantity
     */
    public CakeDonut(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Returns the item price
     * @return double representing the item price
     */
    @Override
    public double itemPrice() {
        return 1.79;
    }

    /**
     * Gets the flavor
     * @return flavor in String form
     */
    public String getFlavor() {
        return flavor + " CAKE DONUT";
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
     * Gets quantity
     * @return quantity
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the type
     * @return type
     */
    @Override
    public String getType() {
        return "CAKE DONUT";
    }

    /**
     * Returns string representing the data
     * @return String representing the data
     */
    @Override
    public String toString() {
        return quantity + " " + flavor + " Cake Donut(s)";
    }
}
