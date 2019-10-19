package com.example.maccos;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    private RecyclerView oRecyclerView;
    private RecyclerView.LayoutManager oLayoutManager;
    public TextView status;
    public static TextView totalPrice;
    public static ArrayList<Food> orderList = new ArrayList<>();
    public static ArrayList<Double> orderPrices = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().hide();

        status = findViewById(R.id.status);
        totalPrice = findViewById(R.id.priceTotal);

        if (orderList.size() < 1 || orderPrices.size() < 1) {
            status.setText("No items in order.");
            totalPrice.setText("$0.00");
        } else {
            status.setText("");

            oRecyclerView = findViewById(R.id.recyclerView2);
            oLayoutManager = new LinearLayoutManager(this);
            oRecyclerView.setLayoutManager(oLayoutManager);

            OrderAdapter orderAdapter = new OrderAdapter();

            // We wrote our setData method to be like a setter, so we give our ArrayList from
            // FakeDatabase to the Adapter.
            orderAdapter.setData(orderList);
            oRecyclerView.setAdapter(orderAdapter);
        }
    }
}