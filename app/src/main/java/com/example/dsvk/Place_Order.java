package com.example.dsvk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Place_Order extends AppCompatActivity {
    EditText show_price;
    Button order;
    EditText get_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place__order);
        Bundle intent = getIntent().getExtras();
        String price = intent.getString("CheckOut");

        show_price = findViewById(R.id.totvalue);
        order = findViewById(R.id.finalorder);
        get_address = findViewById(R.id.useraddress);

        show_price.setText(price);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add = get_address.getText().toString();
                if (add.isEmpty()){
                    get_address.setError("Address is required");
                    get_address.requestFocus();
                    return ;
                }

                Toast.makeText(Place_Order.this,"Order Placed!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
