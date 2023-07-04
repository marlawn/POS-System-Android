package com.example.softwaremethodology;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * BasketView which controls the BasketView Activity Screen
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class BasketView extends AppCompatActivity {
    /** Initializes the listview */
    ListView listView;

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
        setContentView(R.layout.activity_basket_view);

        listView = findViewById(R.id.myListView);
        ArrayAdapter<MenuItem> arrayAdapter = new ArrayAdapter<MenuItem>(this, android.R.layout.simple_list_item_1, MainActivity.basket);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(BasketView.this)
                        .setTitle("Do you want to remove from list?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.basket.remove(position);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
                return false;
            }
        });

        Button placeOrder = findViewById(R.id.placeOrderButton);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.basket.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLACE ORDER INCOMPLETE (EMPTY BASKET)", Toast.LENGTH_SHORT ).show();
                } else {
                    MainActivity.orders.add(MainActivity.orderNumber + ": " + MainActivity.basket.toString() + " $" + MainActivity.total);
                    MainActivity.orderNumber++;
                    MainActivity.basket.clear();
                    MainActivity.currentItem = null;
                    MainActivity.subtotal = 0.00;
                    MainActivity.tax = 0.00;
                    MainActivity.total = 0.00;
                    Toast.makeText(getApplicationContext(), "ORDER ADDED", Toast.LENGTH_SHORT ).show();
                }

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
            }
        });

        TextView sub = findViewById(R.id.subtotal);
        TextView tax = findViewById(R.id.tax);
        TextView tot = findViewById(R.id.total);
        sub.setText(Double.toString(MainActivity.subtotal));
        tax.setText(Double.toString(MainActivity.tax));
        tot.setText(Double.toString(MainActivity.total));
    }


}