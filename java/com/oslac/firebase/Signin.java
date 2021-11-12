package com.oslac.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Button submit = findViewById(R.id.submit);
        EditText email = findViewById(R.id.otp);
        EditText password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        constraintLayout = findViewById(R.id.view);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Signin(email.getText().toString(),password.getText().toString());

            }
        });
    }
    public void Signin(String email, String password){
       mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
           @Override
           public void onSuccess(AuthResult authResult) {
               Snackbar.make(constraintLayout,"Successfully sign in",Snackbar.LENGTH_SHORT).show();
           }
       });


    }
}