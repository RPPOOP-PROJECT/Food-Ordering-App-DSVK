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


public class CartViewAdapter extends RecyclerView.Adapter<CartViewAdapter.ViewHolder>{

    private static final String TAG = "CartViewAdapter";

    private ArrayList<Food> foods = new ArrayList<>();
    private Context mContext;
    private TextView output;


    public static int overallTotalPrice = 0;

    public CartViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_card, parent, false);
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


//        holder.parent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, foods.get(position).getName()+ " Selected", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mContext, DishActivity.class);
//                intent.putExtra(FOOD_ID_KEY,foods.get(position).getId());
//
//                mContext.startActivity(intent);
//            }
//        });

        //holder.txtDescription.setText(foods.get(position).getDesc());
        String indivisual_price = foods.get(position).getPrice().toString();
        String indivisual_quan = foods.get(position).getQuantity().toString();


        holder.pricetext.setText(indivisual_price);
        holder.quantity.setText(indivisual_quan);

        int price = Integer.parseInt(indivisual_price);
        int quan = Integer.parseInt(indivisual_quan);

        int total_indi = price * quan;

        overallTotalPrice += total_indi;

        holder.orta.setText(String.valueOf(overallTotalPrice));
        System.out.println(overallTotalPrice);
        String string_of_total = String.valueOf(total_indi);

        holder.total_price.setText(string_of_total);



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
        private Button btnOrders;

//        private ImageView downArrow, upArrow;
//        private RelativeLayout expandedRelLayout;
//        private TextView txtDescription;
        private TextView pricetext;
        private TextView quantity;
        private TextView total_price;

        private TextView orta;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.card);
            imgDish = itemView.findViewById(R.id.imageIndi);
            txtDishName = itemView.findViewById(R.id.nameIndi);
            btnOrders = itemView.findViewById(R.id.btnOrders);
//            downArrow = itemView.findViewById(R.id.btnDownArrow);
//            upArrow = itemView.findViewById(R.id.btnUpArrow);
//            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
//            txtDescription = itemView.findViewById(R.id.txtDescription);
            pricetext = itemView.findViewById(R.id.priceIndi);
            quantity = itemView.findViewById(R.id.quanIndi);
            total_price = itemView.findViewById(R.id.totalIndi);
            orta = itemView.findViewById(R.id.orda);







//            downArrow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Food food = foods.get(getAdapterPosition());
//                    food.setExpanded(!food.isExpanded());
//                    notifyItemChanged(getAdapterPosition());
//                }
//            });
//
//            upArrow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Food food = foods.get(getAdapterPosition());
//                    food.setExpanded(!food.isExpanded());
//                    notifyItemChanged(getAdapterPosition());
//                }
//            });

        }
    }


}
