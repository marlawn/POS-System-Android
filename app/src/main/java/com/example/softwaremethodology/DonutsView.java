package com.example.softwaremethodology;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * controls DonutsView activity
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class DonutsView extends AppCompatActivity {
    /** items arraylist */
    private ArrayList<MenuItem> items;
    /** recyclerview */
    private RecyclerView recyclerView;
    /** listener */
    private recyclerAdapter.RecyclerViewClickListener listener;

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
        setContentView(R.layout.activity_donuts_view);

        recyclerView = findViewById(R.id.recycle);
        items = new ArrayList<>();

        setInfo();
        setAdapter();
    }

    /**
     * Set adapter
     */
    private void setAdapter() {
        setOnClickListener();
        recyclerAdapter adapter = new recyclerAdapter(items, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    /**
     * setsonclicklistener
     */
    private void setOnClickListener() {
        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                MainActivity.currentItem = items.get(position);
                Intent nextPage = new Intent(getApplicationContext(), DonutOrder.class);
                startActivity(nextPage);
            }
        };
    }

    /**
     * Sets information
     */
    private void setInfo() {
        items.add(new CakeDonut("BLUEBERRY"));
        items.add(new CakeDonut("DEVILS FOOD"));
        items.add(new CakeDonut("STRAWBERRY FROSTED"));
        items.add(new CakeDonut("UBE"));

        items.add(new DonutHoles("BUTTERNUT"));
        items.add(new DonutHoles("CINNAMON SUGAR"));
        items.add(new DonutHoles("JELLY"));
        items.add(new DonutHoles("OLD FASHIONED"));

        items.add(new YeastDonut("BOSTON CREAM"));
        items.add(new YeastDonut("CHOCOLATE FROSTED"));
        items.add(new YeastDonut("GLAZED"));
        items.add(new YeastDonut("JELLY"));
    }

}