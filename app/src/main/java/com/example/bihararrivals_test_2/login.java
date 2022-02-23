package com.example.bihararrivals_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class login extends AppCompatActivity {

    //button type variable
    Button create_button;
    Button login_button;
    TextInputLayout username_var,password_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        create_button=(Button) findViewById(R.id.create_account_button_input);
        login_button=findViewById(R.id.login_button_input);

        username_var=findViewById(R.id.email_input);
        password_var=findViewById(R.id.password_input);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=username_var.getEditText().getText().toString();
                String password=password_var.getEditText().getText().toString();

                if(!username.isEmpty()){
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);
                    if(!password.isEmpty()){
                        password_var.setError(null);
                        password_var.setErrorEnabled(false);
                    }
                    else {
                        password_var.setError("Please enter correct Password.");
                    }

                }else {
                    username_var.setError("Plase enter correct user name.");
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