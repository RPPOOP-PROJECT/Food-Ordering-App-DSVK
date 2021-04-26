package com.example.dsvk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DishActivity extends AppCompatActivity {
    public static final String FOOD_ID_KEY = "foodId";

    private TextView dishName, dishPrice,dishDesc;
    private Button btnOrders, btnFavs,plus,minus;
    private TextView quan ;
    private ImageView dish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);
        //plus = getViewById(R.id.plus2);
        plus = findViewById(R.id.plus2);
        minus = findViewById(R.id.minus);
        quan = findViewById(R.id.quantity);
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
                handleOrderedFood(incomingfood);

            }
        }


    }

    private void handleOrderedFood(Food incomingfood) {
        ArrayList <Food> Ordered = Utils.getInstance().getOrderedItem();
        boolean alreadyOrdered = false;

        for(Food f:Ordered){
            if(f.getId() == incomingfood.getId()){
                alreadyOrdered = true;
            }
        }


        boolean finalAlreadyOrdered = alreadyOrdered;
        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalAlreadyOrdered){
                    incomingfood.setQuantity(quan.getText().toString());
                }
                else {
                    incomingfood.setQuantity(quan.getText().toString());
                    if (Utils.getInstance().addToOrdered(incomingfood)) {
                        Toast.makeText(DishActivity.this, "Dish added", Toast.LENGTH_SHORT).show();
                        System.out.println("Successful");


                    } else {
                        Toast.makeText(DishActivity.this, "Error! try again", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    private void handleAlreadyFav(Food incomingfood) {
        ArrayList <Food> AlreadyAddedFav = Utils.getInstance().getFavDish();
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
            btnFavs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToAlreadyFav(incomingfood)){
                        Toast.makeText(DishActivity.this,"Dish added",Toast.LENGTH_SHORT).show();
                        System.out.println("Successful");
                        btnFavs.setEnabled(false);
                        btnFavs.setClickable(false);


                    }
                    else {
                        Toast.makeText(DishActivity.this,"Error! try again",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
  /*plus.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            int count = Integer.parseInt(String.valueOf(quan.getText()));
            count++;
            quan.setText(""+count);
        }
    });
        minus.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int count = Integer.parseInt(String.valueOf(quan.getText()));
            if(count >0) {
                count--;
                quan.setText("" + count);
            }
        }
    });*/



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
        quan = findViewById(R.id.quantity);
        dish = findViewById(R.id.dish);
        plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int count = Integer.parseInt(String.valueOf(quan.getText()));
                count++;
                quan.setText(""+count);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(String.valueOf(quan.getText()));
                if(count >0) {
                    count--;
                    quan.setText("" + count);
                }
            }
        });
    }
}



