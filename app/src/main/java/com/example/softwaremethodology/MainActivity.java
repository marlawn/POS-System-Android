package com.example.softwaremethodology;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * MainActivity activity (FRONT PAGE)
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class MainActivity extends AppCompatActivity {
    /** decimal format */
    private static final DecimalFormat df = new DecimalFormat("0.00");
    /** current item */
    public static MenuItem currentItem;
    /** basket arraylist */
    public static ArrayList<MenuItem> basket = new ArrayList<>();
    /** orders arraylist */
    public static ArrayList<String> orders = new ArrayList<>();
    /** order number */
    public static int orderNumber = 1;
    /** subtotal */
    public static double subtotal = 0.00;
    /** Tax */
    public static double tax = 0.00;
    /** total */
    public static double total = 0.00;

    /**
     * Starts when the activity is created, initializes and sets and declares views
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton donutsBtn = findViewById(R.id.donutButton);
        donutsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(getApplicationContext(), DonutsView.class);
                startActivity(myInt);
            }
        });

        ImageButton coffeeBtn = findViewById(R.id.coffeeButton);
        coffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(getApplicationContext(), CoffeeView.class);
                startActivity(myInt);
            }
        });

        ImageButton basketBtn = findViewById(R.id.basketButton);
        basketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(getApplicationContext(), BasketView.class);
                startActivity(myInt);
            }
        });

        ImageButton ordersBtn = findViewById(R.id.orderButton);
        ordersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(getApplicationContext(), OrdersView.class);
                startActivity(myInt);
            }
        });
    }

    /**
     * Handles activity on resume
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (currentItem != null) {
            subtotal += currentItem.itemPrice() * currentItem.getQuantity();
            subtotal = Double.parseDouble(df.format(subtotal));
            tax = subtotal * 0.06625;
            tax = Double.parseDouble(df.format(tax));
            total = subtotal + tax;
            total = Double.parseDouble(df.format(total));
            System.out.println(subtotal);
            basket.add(currentItem);
        }
        if (!basket.isEmpty()) {
            System.out.println("current basket: " + basket.toString());
            System.out.println("tax: " + tax + "subtotal: " + subtotal + "total: " + total);
        }
        if(!orders.isEmpty()) {
            System.out.println("current orders: " + orders.toString());
        }
    }
}