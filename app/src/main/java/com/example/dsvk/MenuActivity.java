package com.example.dsvk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView menuRecView;
    private MenuRecyclerViewAdapter adapter;
    private Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        adapter = new MenuRecyclerViewAdapter(this);
        menuRecView = findViewById(R.id.menuRecView);
        order = findViewById(R.id.order);

        menuRecView.setAdapter(adapter);
        menuRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setFoods(Utils.getInstance().getAllDishes());
        Utils.getInstance();

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, FavouriteFood.class));
                finish();
            }
        });


    }




}