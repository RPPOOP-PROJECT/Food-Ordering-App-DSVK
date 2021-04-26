package com.example.dsvk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

public class FavouriteFood extends AppCompatActivity {
    private RecyclerView dishOrder;
    private MenuRecyclerViewAdapter adapter;
    private Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_food);
        adapter = new MenuRecyclerViewAdapter(this);
        dishOrder = findViewById(R.id.Ordered);
        order = findViewById(R.id.order);
        dishOrder.setAdapter(adapter);
        dishOrder.setLayoutManager(new LinearLayoutManager(this));
        adapter.setFoods(Utils.getFavDish());
    }
}