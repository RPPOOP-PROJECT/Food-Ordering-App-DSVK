package com.example.dsvk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;
import com.example.dsvk.Food;

import java.util.ArrayList;

import kotlin.Suppress;

import static com.example.dsvk.DishActivity.FOOD_ID_KEY;


public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "MenuRecViewAdapter";

    private ArrayList<Food> foods = new ArrayList<>();
    private Context mContext;

    public MenuRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_recycler_view_adapter, parent, false);
        // ViewHolder holder = new ViewHolder(view);
        // return holder;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtDishName.setText(foods.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(foods.get(position).getImageUrl())
                .into(holder.imgDish);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, foods.get(position).getName()+ " Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, DishActivity.class);
                intent.putExtra(FOOD_ID_KEY,foods.get(position).getId());

                mContext.startActivity(intent);
            }
        });

        holder.txtDescription.setText(foods.get(position).getDesc());
        holder.pricetext.setText(foods.get(position).getPrice());
        holder.quantity.setText(foods.get(position).getQuantity());
        if(foods.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        } else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }


    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView parent;
        private ImageView imgDish;
        private TextView txtDishName;

        private ImageView downArrow, upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtDescription, pricetext;
        private TextView quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgDish = itemView.findViewById(R.id.imgDish);
            txtDishName = itemView.findViewById(R.id.txtDishName);
            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            pricetext = itemView.findViewById(R.id.pricetext);
            quantity = itemView.findViewById(R.id.quantity);


            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Food food = foods.get(getAdapterPosition());
                    food.setExpanded(!food.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Food food = foods.get(getAdapterPosition());
                    food.setExpanded(!food.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }


}
