package com.example.dsvk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import static android.app.ProgressDialog.show;


public class Register_Details extends AppCompatActivity implements View.OnClickListener{
    public FirebaseAuth mAuth;
    public EditText Name, Password, Age, email;
    public Button register_firebase;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__details);

        Name = (EditText)findViewById(R.id.register_name);
        Password = (EditText)findViewById(R.id.register_pass);
        Age = (EditText)findViewById(R.id.register_age);
        email = (EditText)findViewById(R.id.register_Email);
        register_firebase = (Button)findViewById(R.id.register_btn);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        register_firebase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.register_btn:
                register_user();
                break;
        }
    }

    public void register_user() {
        String user_email = email.getText().toString().trim();
        String user_name = Name.getText().toString().trim();
        String user_age = Age.getText().toString().trim();
        String user_password = Password.getText().toString().trim();
        String user_Phone = getIntent().getStringExtra("phone");
        if (user_name.isEmpty()){
            Name.setError("Name is required");
            Name.requestFocus();
            return ;
        }
        else if (user_email.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return ;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(user_email).matches()){
            email.setError("Enter valid email!");
            email.requestFocus();
            return;
        }
        else if (user_age.isEmpty()){
            Age.setError("Enter name");
            Age.requestFocus();
            return ;
        }
        else if (user_password.isEmpty()){
            Password.setError("Enter name");
            Password.requestFocus();
            return ;
        }
        else if (user_password.length() < 6){
            Password.setError("Password should be 6 characters atleast!");
            Password.requestFocus();
            return ;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    User user = new User(user_name, user_age, user_email, user_Phone);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Register_Details.this, "User Registered!", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }
                            else{
                                Toast.makeText(Register_Details.this, "Failed to Register!", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Register_Details.this, "Failed Register!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }


}