package com.example.dsvk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.app.ProgressDialog.show;


public class Login extends AppCompatActivity {

    EditText email,password;
    Button login;
    Button sendEmial;
    TextView signup;//,forgotpwd;
    FirebaseAuth mAuth;
    //  private DatabaseReference mDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        //forgotpwd = findViewById(R.id.forgot);
        sendEmial = findViewById(R.id.send);

        //  mDatabase = FirebaseDatabase.getInstance().getReference();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login.this,Register.class));

            }
        });
//        forgotpwd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
//                ViewGroup viewGroup = findViewById(android.R.id.content);
//                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.customview, viewGroup, false);
//                builder.setView(dialogView);
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//            }
//        });
        //sendEmial.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Toast.makeText(Login.this,"Email Sent",Toast.LENGTH_LONG);
            //}
        //});

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = email.getText().toString();
                String pwd = password.getText().toString();
                if(emailId.isEmpty()){
                    email.setError("Enter email Id");
                    email.requestFocus();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    email.setError("Invalid Email");
                    email.requestFocus();

                }
                else if(pwd.isEmpty()){
                    password.setError("Enter password");
                    password.requestFocus();
                }
                else if(emailId.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Login.this,"Please fill out the form",Toast.LENGTH_LONG).show();
                }

                else {

                    mAuth.signInWithEmailAndPassword(emailId,pwd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            Toast.makeText(Login.this,"Logged In",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Login.this, HomePage.class));
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Login.this,"Log In Failed",Toast.LENGTH_LONG).show();

                        }
                    });


                }

            }
        });
    }
}