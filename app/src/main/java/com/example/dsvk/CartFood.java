package com.example.dsvk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.dsvk.CartViewAdapter.overallTotalPrice;


public class CartFood extends AppCompatActivity {
    private RecyclerView dishOrder;
    private CartViewAdapter adapter;
    private TextView Total_price;
    private Button total_button, placeOrder;
    private TextView or;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_food);
        adapter = new CartViewAdapter(this);
        dishOrder = findViewById(R.id.Ordered);
        Total_price = findViewById(R.id.OutputPrice);
        total_button = findViewById(R.id.CalculateCheckOut);
         or = findViewById(R.id.orda);
         placeOrder = findViewById(R.id.place_Order);
       // order = findViewById(R.id.order);
        dishOrder.setAdapter(adapter);
        dishOrder.setLayoutManager(new LinearLayoutManager(this));
        adapter.setFoods(Utils.getOrderedItem());
        String ordered_price = String.valueOf(overallTotalPrice);

        total_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total_price.setText(String.valueOf(overallTotalPrice));
            }
        });

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartFood.this, Place_Order.class);
                intent.putExtra("CheckOut", String.valueOf(overallTotalPrice));
                startActivity(intent);
            }
        });

    }
}