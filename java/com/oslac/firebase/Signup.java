package com.oslac.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button submit = findViewById(R.id.submit);
        EditText email = findViewById(R.id.otp);
        EditText password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        constraintLayout = findViewById(R.id.view);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAccount(email.getText().toString(),password.getText().toString());

            }
        });
    }
    public void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Snackbar.make(constraintLayout,"Your account has been created",Snackbar.LENGTH_SHORT).show();
                }
                else{
                    Snackbar.make(constraintLayout,"Some error occurred",Snackbar.LENGTH_SHORT).show();
                }

            }
        });


    }
}