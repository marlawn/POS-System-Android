package com.example.softwaremethodology;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Adapter for the RecyclerView view
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    /** items arraylist */
    private ArrayList<MenuItem> items;
    /** listener */
    private RecyclerViewClickListener listener;

    /**
     * Constructor
     * @param items items arraylist
     * @param listener listener
     */
    public recyclerAdapter(ArrayList<MenuItem> items, RecyclerViewClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    /**
     * Sets the recyclerview holder for each one
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView text;
        private ImageView image;

        public MyViewHolder(final View view) {
            super(view);
            text = view.findViewById(R.id.blueberry_cake);
            image = view.findViewById(R.id.donutImage);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }

    /**
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    /**
     * Handles images
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = items.get(position).getFlavor();
        holder.text.setText(name);

        if (name.equals("BLUEBERRY CAKE DONUT")) holder.image.setImageResource(R.drawable.cake_blueberry);
        if (name.equals("DEVILS FOOD CAKE DONUT")) holder.image.setImageResource(R.drawable.cake_devils_food);
        if (name.equals("STRAWBERRY FROSTED CAKE DONUT")) holder.image.setImageResource(R.drawable.cake_strawberry_frosted);
        if (name.equals("UBE CAKE DONUT")) holder.image.setImageResource(R.drawable.cake_ube);

        if (name.equals("BUTTERNUT DONUT HOLE")) holder.image.setImageResource(R.drawable.hole_butternut);
        if (name.equals("CINNAMON SUGAR DONUT HOLE")) holder.image.setImageResource(R.drawable.hole_cinnamon_sugar);
        if (name.equals("JELLY DONUT HOLE")) holder.image.setImageResource(R.drawable.hole_jelly);
        if (name.equals("OLD FASHIONED DONUT HOLE")) holder.image.setImageResource(R.drawable.hole_old_fashioned);

        if (name.equals("BOSTON CREAM YEAST DONUT")) holder.image.setImageResource(R.drawable.yeast_boston_cream);
        if (name.equals("CHOCOLATE FROSTED YEAST DONUT")) holder.image.setImageResource(R.drawable.yeast_chocolate_frosted);
        if (name.equals("GLAZED YEAST DONUT")) holder.image.setImageResource(R.drawable.yeast_glazed);
        if (name.equals("JELLY YEAST DONUT")) holder.image.setImageResource(R.drawable.yeast_jelly);
    }

    /**
     * returns item count
     * @return item count
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * interface
     */
    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}
