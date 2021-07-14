package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Third extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    ProgressBar p1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        e1=(EditText)findViewById(R.id.editTextTextPersonName3);
        e2=(EditText)findViewById(R.id.editTextTextPersonName4);
        b1=(Button)findViewById(R.id.button4);
        b2=(Button)findViewById(R.id.button5);
        firebaseAuth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String s1=e1.getText().toString();
               String s2=e2.getText().toString();
               if(s1.isEmpty()){
                   e1.setError("Enter Email");
                   return;
               }else {
                   if (s2.isEmpty()){
                       e2.setError("Enter Password");
                       return;
                   }
               }
               p1.setVisibility(View.VISIBLE);
               firebaseAuth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           Toast.makeText(Third.this, "Sucessfully Registered", Toast.LENGTH_SHORT).show();
                           p1.setVisibility(View.INVISIBLE);
                           Intent i=new Intent(Third.this,Second.class);
                           startActivity(i);
                           finish();
                       }
                       else{
                           Toast.makeText(Third.this, "Try Again", Toast.LENGTH_SHORT).show();
                           p1.setVisibility(View.INVISIBLE);
                           Intent k=new Intent(Third.this,Second.class);
                           startActivity(k);
                           finish();
                       }
                       }


               });

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Third.this,Second.class);
                startActivity(j);
                finish();

            }
        });
    }
}