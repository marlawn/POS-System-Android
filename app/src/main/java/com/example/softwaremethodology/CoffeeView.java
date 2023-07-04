package com.example.softwaremethodology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Controls CoffeeView Activity
 * @author  Marlon Vergara
 * @author Luis  Castellanos
 */
public class CoffeeView extends AppCompatActivity {
    /** coffe adins*/
    ArrayList<String> addIns = new ArrayList<>();
    /** checkboxes */
    CheckBox fvBox;
    /** checkboxes */
    CheckBox icBox;
    /** checkboxes */
    CheckBox cBox;
    /** checkboxes */
    CheckBox mBox;

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
        setContentView(R.layout.activity_coffee_view);

        Button shortBtn = findViewById(R.id.shortBtn);
        shortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(getApplicationContext(), CoffeeOrder.class);
                add();
                MainActivity.currentItem = new Coffee("Short", addIns);
                startActivity(myInt);
            }
        });

        Button tallBtn = findViewById(R.id.tallBtn);
        tallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(getApplicationContext(), CoffeeOrder.class);
                add();
                MainActivity.currentItem = new Coffee("Tall", addIns);
                startActivity(myInt);
            }
        });

        Button grandeBtn = findViewById(R.id.grandeBtn);
        grandeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(getApplicationContext(), CoffeeOrder.class);
                add();
                MainActivity.currentItem = new Coffee("Grande", addIns);
                startActivity(myInt);
            }
        });

        Button ventiBtn = findViewById(R.id.ventiBtn);
        ventiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(getApplicationContext(), CoffeeOrder.class);
                add();
                MainActivity.currentItem = new Coffee("Venti", addIns);
                startActivity(myInt);
            }
        });

        fvBox = findViewById(R.id.frenchBox);
        icBox = findViewById(R.id.irishBox);
        cBox = findViewById(R.id.caramelBox);
        mBox = findViewById(R.id.mochaBox);
    }

    /**
     * Adds the addins
     */
    private void add() {
        if (fvBox.isChecked()) addIns.add("French Vanilla");
        if (icBox.isChecked()) addIns.add("Irish Cream");
        if (cBox.isChecked()) addIns.add("Caramel");
        if (mBox.isChecked()) addIns.add("Mocha");
    }
}