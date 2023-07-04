package com.example.softwaremethodology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

/**
 * Controls DonutORder activity
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class DonutOrder extends AppCompatActivity {
    /** text input layout */
    private TextInputLayout textInputQuantity;
    /** context */
    private static Context context;
    /** quantity */
    private int quantity;

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
        setContentView(R.layout.activity_donut_order);

        TextView sub = findViewById(R.id.subtotal);
        sub.setText(Double.toString(MainActivity.subtotal));

        Button addBtn = findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = quantity();
                if (validateQuantity()) {
                    MainActivity.currentItem.setQuantity(temp);
                    Toast.makeText(DonutOrder.context,"ADDED TO BASKET", Toast.LENGTH_SHORT).show();
                    Intent main = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(main);
                }
            }
        });

        textInputQuantity = findViewById(R.id.inputQuantity);

        DonutOrder.context = getApplicationContext();
    }

    /**
     * Returns quantity
     * @return quantity
     */
    private int quantity() {
        String stringQuantity = textInputQuantity.getEditText().getText().toString().trim();
        try {
            quantity = Integer.parseInt(stringQuantity);
        } catch (NumberFormatException e) {
            return -1;
        }
        return quantity;
    }

    /**
     * validates quantity
     * @return true if valid, false otherwise
     */
    private boolean validateQuantity() {
        String stringQuantity = textInputQuantity.getEditText().getText().toString().trim();
        if (stringQuantity.isEmpty()) {
            Toast.makeText(DonutOrder.context,"ENTER NUMBER!", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            quantity = Integer.parseInt(stringQuantity);
        } catch (NumberFormatException e) {
            Toast.makeText(DonutOrder.context, "TYPE AN INTEGER!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}