package com.example.dsvk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button btnMenu, btnWishlist, btnOrder, btnFavourites,btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initViews();

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, About.class);
                startActivity(intent);
            }
        });
        btnFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, FavouriteFood.class);
                startActivity(intent);

            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, CartFood.class);
                startActivity(intent);

            }
        });

    }
    private void initViews(){
        btnMenu = findViewById(R.id.btnMenu);
        btnFavourites = findViewById(R.id.btnFavourites);
        btnOrder = findViewById(R.id.btnOrder);
        //btnWishlist = findViewById(R.id.btnWishlist);
        btnAbout = findViewById(R.id.btnAbout);
    }
}
