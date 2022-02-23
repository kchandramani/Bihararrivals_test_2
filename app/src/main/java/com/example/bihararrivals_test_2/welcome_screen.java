package com.example.bihararrivals_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome_screen extends AppCompatActivity {
    private Button welcome_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);


        welcome_button=(Button) findViewById(R.id.welcome_button);
        welcome_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openLogin();

            }
        });
    }
    public void openLogin(){
        Intent intent=new Intent(this,login.class);
                startActivity(intent);
    }
}