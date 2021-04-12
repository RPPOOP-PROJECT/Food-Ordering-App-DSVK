package com.example.dsvk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView menuRecView;
    private MenuRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        adapter = new MenuRecyclerViewAdapter(this);
        menuRecView = findViewById(R.id.menuRecView);

        menuRecView.setAdapter(adapter);
        menuRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food(1, "VadaPav", "Rs 10", "https://c8.alamy.com/comp/PEYDE0/indian-special-traditional-fried-food-vada-pav-PEYDE0.jpg", "A plate of vada pav with seasoning of red chilli powder and a green chilli."));
        foods.add(new Food(2,"Samosa", "Rs 15", "https://thumbs.dreamstime.com/b/samosa-24578861.jpg", "Samosa, a crispy and spicy deep fried snack "));
        foods.add(new Food(3, "Veg Biryani", "Rs 100","https://content.jwplatform.com/thumbs/czz75DO6-720.jpg", "Vegetable biryani is an aromatic rice dish made by cooking basmati rice with mix veggies, herbs & biryani spices"));
        foods.add(new Food(4, "Veg Thali", "Rs 60", "https://post.healthline.com/wp-content/uploads/2020/07/thali-indian-732x549-thumbnail-732x549.jpg","thali includes rice, bhakri roti (a millet flatbread), bharli vangi (stuffed brinjal), amti (spicy tangy tur lentil), pitla ( thick chickpea flour curry), kothimbir wadi (corainder cutlet), chawli chi usal (black eyed beans curry)"));
        foods.add(new Food(5, "Mango Lassi", "Rs 30","https://www.cookwithmanali.com/wp-content/uploads/2014/05/Indian-Mango-Lassi-Recipe.jpg","A mango lassi is basically a yogurt based mango milkshake or smoothie"));
        foods.add(new Food(6, "Bread Patties", "Rs. 15", "https://i.ytimg.com/vi/983YrTDZ_Lw/maxresdefault.jpg", "Bread Pakoda or Bread patties is a crunch bread patties stuffed with spiced Potato filling, coated in seasoned gram flour batter and deep fried"));
        foods.add(new Food(7, "Veg Sandwich", "Rs 40", "https://punampaul.com/wp-content/uploads/2020/03/Veg-Toast-Sandwich.jpg", "Delicious toasted veg sandwich with tasty vegetable fillings between the two breads"));
        foods.add(new Food(8, "Puri Bhaji", "Rs 50", "https://previews.123rf.com/images/schastnyi/schastnyi1806/schastnyi180600003/103824180-traditional-indian-vegeterian-meal-puri-bhaji.jpg", "Tasty puri bhaji has 4 pieces of puri served with aaloo matar sabzi"));
        foods.add(new Food(9, "Sheera", "Rs. 70", "https://i0.wp.com/www.attammatv.com/media/Sheera-Recipe1.jpg", "Yummy traditional maharastrian sweet dish"));
        adapter.setFoods(foods);


    }
}