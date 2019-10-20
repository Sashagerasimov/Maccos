package com.example.maccos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Click extends AppCompatActivity {

    public TextView name;
    public TextView description;
    public TextView price;
    public ImageView pic;
    public Button add;
    public EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        getSupportActionBar().hide();

        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        pic = findViewById(R.id.pls);



        int foodPosition = getIntent().getIntExtra("foodID", -1);
        final Food currentFood = Database.getFoodById(foodPosition);


        name.setText(currentFood.getName());
        description.setText(currentFood.getDescription());
        price.setText(String.format("$" + "%,.2f", currentFood.getPrice()));
        pic.setImageResource(currentFood.getImageDrawableId());

        add = findViewById(R.id.add);
        amount = findViewById(R.id.editText);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (amount.getText().toString().equals("")){
                    Toast.makeText(Click.this, "Please enter quantity", Toast.LENGTH_SHORT).show();
                } else {
                    int quantity = Integer.parseInt(amount.getText().toString());

                    for (int i = 0; i < quantity; i++) {
                        String text = currentFood.getName();
                        Toast.makeText(Click.this, quantity + " " + text + "(s)" + " added to order", Toast.LENGTH_SHORT).show();
                        Order.orderPrices.add(currentFood.getPrice());
                        Order.orderList.add(currentFood);
                        finish();
                    }
                }
            }
        });
    }
}
