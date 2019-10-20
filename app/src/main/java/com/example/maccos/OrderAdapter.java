package com.example.maccos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.maccos.Order.itemCount;
import static com.example.maccos.Order.orderList;
import static com.example.maccos.Order.orderPrices;
import static com.example.maccos.Order.totalPrice;

// We need to give a type in angle brackets <> when we extend RecyclerView.Adapter
// It's saying that we want an adapter that adapts to ArticleViewHolder (our custom ViewHolder)
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    // class variable that holds the data that we want to adapt
    private ArrayList<Food> ordersToAdapt;

    public void setData(ArrayList<Food> ordersToAdapt) {
        // This is basically a Setter that we use to give data to the adapter
        this.ordersToAdapt = ordersToAdapt;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // First create a View from the layout file. It'll probably be a ViewGroup like
        // ConstraintLayout that contains more Views inside it.
        // This view now represents your entire one item.
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.example_order, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {
        // Compare what we have in this method, to what we used to have in MainActivity

        // 'position' is the index of the ViewHolder currently being bound (note VIEWHOLDER). So
        // if position is 0, then we are binding the first ViewHolder in the list. This means the
        // corresponding data object will be at index 0 of our data ArrayList.
        final Food foodAtPosition = ordersToAdapt.get(position);

        holder.name.setText(foodAtPosition.getName());
        holder.description.setText(foodAtPosition.getDescription());
        holder.price.setText("$" + String.format("%,.2f", foodAtPosition.getPrice()));
        holder.itemImageView.setImageResource(foodAtPosition.getImageDrawableId());

        double sum = 0;
        for (double i : orderPrices)
            sum = sum + i;
            String sums = String.format("%,.2f", sum);
        totalPrice.setText("$" + String.valueOf(sums));

        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderList.remove(foodAtPosition);
                notifyItemRemoved(position);
                orderPrices.remove(foodAtPosition.getPrice());

                int items = orderList.size();
                itemCount.setText(items + " Items Overall");

                double sum = 0;
                for (double i : orderPrices)
                    sum = sum + i;
                String sums = String.format("%,.2f", sum);
                totalPrice.setText("$" + String.valueOf(sums));
            }
        });

        holder.itemImageView.setImageResource(foodAtPosition.getImageDrawableId());
    }

    @Override
    public int getItemCount() {
        return ordersToAdapt.size();
    }

    // ViewHolder represents one item, but doesn't have data when it's first constructed.
    // We assign the data in onBindViewHolder.
    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public TextView description;
        public TextView price;
        public ImageView itemImageView;
        public ImageView deleteImageView;

        // This constructor is used in onCreateViewHolder
        public OrderViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
            view = v;
            name = v.findViewById(R.id.textView);
            description = v.findViewById(R.id.textView2);
            price = v.findViewById(R.id.textView3);
            itemImageView = v.findViewById(R.id.imageView);
            deleteImageView = v.findViewById(R.id.delete);
        }
    }
}