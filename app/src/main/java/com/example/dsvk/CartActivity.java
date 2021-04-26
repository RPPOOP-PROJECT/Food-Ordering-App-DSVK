package com.example.dsvk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    public static final String FOOD_ID_KEY = "foodId";

    private TextView dishName, dishPrice,dishDesc;
    private Button btnOrders, btnFavs;
    private ImageView dish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initViews();
        Intent intent = getIntent();
        if(null != intent){
            int foodId = intent.getIntExtra(FOOD_ID_KEY,-1);
            if(foodId != -1){
                Food incomingfood = Utils.getInstance().getFoodById(foodId);
                if(null != incomingfood){
                    setData(incomingfood);
                }
                handleAlreadyFav(incomingfood);


            }
        }

    }

    private void handleAlreadyFav(Food incomingfood) {
        ArrayList <Food> AlreadyAddedFav = Utils.getInstance().getOrderedItem();
        boolean existInAlreadyFavFoods = false;
        for(Food f:AlreadyAddedFav){
            if(f.getId() == incomingfood.getId()){
                existInAlreadyFavFoods = true;
            }
        }
        if(existInAlreadyFavFoods){
            btnFavs.setEnabled(false);
            btnFavs.setClickable(false);
        }
        else{
            btnOrders.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToOrdered(incomingfood)){
                        Toast.makeText(CartActivity.this,"Dish added",Toast.LENGTH_SHORT).show();
                        System.out.println("Successful");



                    }
                    else {
                        Toast.makeText(CartActivity.this,"Error! try again",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }


    private void setData(Food item){
        dishName.setText(item.getName());
        dishPrice.setText(item.getPrice());
        dishDesc.setText(item.getDesc());

        Glide.with(this)
                .asBitmap().load(item.getImageUrl())
                .into(dish);
    }

    private void initViews() {
        dishName = findViewById(R.id.dishName);
        dishPrice = findViewById(R.id.dishPrice);
        dishDesc = findViewById(R.id.dishDesc);

        btnFavs = findViewById(R.id.btnFavs);
        btnOrders = findViewById(R.id.btnOrders);

        dish = findViewById(R.id.dish);
    }
}



