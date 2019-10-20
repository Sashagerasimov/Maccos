package com.example.maccos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<Food> foodsToAdapt;

    public void setData(ArrayList<Food> foodsToAdapt) {
        this.foodsToAdapt = foodsToAdapt;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.example_food, parent, false);

        FoodViewHolder foodViewHolder = new FoodViewHolder(view);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        final Food foodAtPosition = foodsToAdapt.get(position);

        holder.name.setText(foodAtPosition.getName());
        holder.description.setText(foodAtPosition.getDescription());
        holder.price.setText("$"+ String.format("%,.2f", foodAtPosition.getPrice()));
        holder.itemImageView.setImageResource(foodAtPosition.getImageDrawableId());



        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, Click.class);
                intent.putExtra("foodID", foodAtPosition.getFoodID());
                context.startActivity(intent);
            }
        });

        holder.itemImageView.setImageResource(foodAtPosition.getImageDrawableId());
    }

    @Override
    public int getItemCount() {
        return foodsToAdapt.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public TextView description;
        public TextView price;
        public ImageView itemImageView;

        public FoodViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.textView);
            description = v.findViewById(R.id.textView2);
            price = v.findViewById(R.id.textView3);
            itemImageView = v.findViewById(R.id.imageView);
        }
    }
}