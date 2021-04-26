package com.example.dsvk;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Food> orderedItem;
    private static ArrayList<Food> allDishes;
    private static ArrayList<Food> favDish;
    private DatabaseReference eventDatabase;



    private Utils(){

        if(null == allDishes){
            allDishes = new ArrayList<>();
            initD();

        }


        if(null == orderedItem){
            orderedItem = new ArrayList<>();
        }

        if(null == favDish){
            favDish = new ArrayList<>();
        }


    }

    public static ArrayList<Food> getAllDishes() {
        return allDishes;
    }

    public static ArrayList<Food> getFavDish() {
        return favDish;
    }

    private void initD() {
        eventDatabase = FirebaseDatabase.getInstance().getReference().child("Foods");

        eventDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Food g = postSnapshot.getValue(Food.class);
                    allDishes.add(g);
                }
                System.out.println(allDishes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
     public static Utils getInstance(){
        if (null != instance) {
            return instance;
        }

        else{
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Food> getOrderedItem() {
        return orderedItem;
    }

    public Food getFoodById(int id){
        for(Food f:allDishes){
            if(f.getId()==id){
                return f;
            }
        }
        return null;
    }
    public boolean addToAlreadyFav(Food food){
        return favDish.add(food);
    }
    public boolean addToOrdered(Food food){
        return orderedItem.add(food);
    }
}


