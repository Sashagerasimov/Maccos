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
import static com.example.maccos.Order.status;
import static com.example.maccos.Order.totalPrice;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private ArrayList<Food> ordersToAdapt;

    public void setData(ArrayList<Food> ordersToAdapt) {
        this.ordersToAdapt = ordersToAdapt;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.example_order, parent, false);
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {
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

                if (orderList.size() < 1){
                    status.setText("No items in order.");
                }
            }
        });

        holder.itemImageView.setImageResource(foodAtPosition.getImageDrawableId());
    }

    @Override
    public int getItemCount() {
        return ordersToAdapt.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public TextView description;
        public TextView price;
        public ImageView itemImageView;
        public ImageView deleteImageView;

        public OrderViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.textView);
            description = v.findViewById(R.id.textView2);
            price = v.findViewById(R.id.textView3);
            itemImageView = v.findViewById(R.id.imageView);
            deleteImageView = v.findViewById(R.id.delete);
        }
    }
}