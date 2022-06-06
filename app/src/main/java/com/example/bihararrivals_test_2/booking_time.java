package com.example.bihararrivals_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class booking_time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_time);
    }



    public void payment_page(View view) {
        Intent intent = new Intent(getApplicationContext(), payment_screen.class);
        startActivity(intent);

    }
}