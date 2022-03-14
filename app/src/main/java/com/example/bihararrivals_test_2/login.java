package com.example.bihararrivals_test_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    //button type variable
    Button create_button;
    Button login_button;
    TextInputLayout email_vr,password_vr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        create_button=findViewById(R.id.create_account_button_input);
        login_button=findViewById(R.id.login_button_input);

        email_vr=findViewById(R.id.email_input_login);
        password_vr=findViewById(R.id.password_input_login);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=email_vr.getEditText().getText().toString();
                String password=password_vr.getEditText().getText().toString();

                if(!email.isEmpty()){
                    email_vr.setError(null);
                    email_vr.setErrorEnabled(false);
                    if(!password.isEmpty()){
                        password_vr.setError(null);
                        password_vr.setErrorEnabled(false);


                        final String email_data=email_vr.getEditText().getText().toString();
                        final String password_data=password_vr.getEditText().getText().toString();

                        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference=firebaseDatabase.getReference("datauser");

                        Query check_email=databaseReference.orderByChild("email").equalTo(email_data);

                        check_email.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()) {
                                    email_vr.setError(null);
                                    email_vr.setErrorEnabled(false);
                                    String passwordcheck=snapshot.child(email_data).child("password").getValue(String.class);
                                    if(passwordcheck.equals(password_data)) {
                                        password_vr.setError(null);
                                        password_vr.setErrorEnabled(false);
                                        Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();

                                        Intent intent=new Intent(getApplicationContext(),main_dashboard.class);
                                        startActivity(intent);
                                        finish();

                                    }else {
                                        password_vr.setError("Wrong Password");
                                    }



                                }else {
                                    email_vr.setError("User Does not Exist ");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });






                    } else {
                        password_vr.setError("Please enter correct Password.");
                    }

                }else {
                    email_vr.setError("Please enter correct user name.");
                }
            }
        });


        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistr();
            }
        });

    }
    public void openRegistr(){
        Intent intent=new Intent(this,create_account.class);
        startActivity(intent);
    }



}