package com.example.maccos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    public static TextView itemCount;
    public Button clearOrder;
    public static TextView totalPrice;
    public static ArrayList<Food> orderList = new ArrayList<>();
    public static ArrayList<Double> orderPrices = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().hide();

        status = findViewById(R.id.status);
        itemCount = findViewById(R.id.itemCount);
        clearOrder = findViewById(R.id.clearOrder);
        totalPrice = findViewById(R.id.priceTotal);

        clearOrder.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                orderList.clear();
                orderPrices.clear();
                startActivity(getIntent());
                finish();
                overridePendingTransition(0, 0);
            }
        });

        int items = orderList.size();
        itemCount.setText(items + " Items Overall");

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
