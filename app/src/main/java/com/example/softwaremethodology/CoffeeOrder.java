package com.example.softwaremethodology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * CoffeeOrder class that controls the CoffeeOrder Activity
 * @author Marlon Vergara
 * @author Luis Castellanoss
 */
public class CoffeeOrder extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    /** intializes quantity to 0 */
    private int quantity = 0;

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
        setContentView(R.layout.activity_coffee_order);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quantity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button addBtn = findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.currentItem.setQuantity(quantity);
                Intent myInt = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myInt);
            }
        });

        TextView sub = findViewById(R.id.subtotal);
        sub.setText(Double.toString(MainActivity.subtotal));
    }

    /**
     * Deals  with the selected item
     * @param parent The AdapterView where the selection happened
     * @param view The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString() + " item(s) selected.";
        if (parent.getItemAtPosition(position).toString().equals("One")) quantity = 1;
        if (parent.getItemAtPosition(position).toString().equals("Two")) quantity = 2;
        if (parent.getItemAtPosition(position).toString().equals("Three")) quantity = 3;
        if (parent.getItemAtPosition(position).toString().equals("Four")) quantity = 4;
        if (parent.getItemAtPosition(position).toString().equals("Five")) quantity = 5;

        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    /**
     * N/A
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}