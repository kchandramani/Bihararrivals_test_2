package com.example.bihararrivals_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class search_guide extends AppCompatActivity {

    private String apiKey="AIzaSyDCVFDEaJIua44gqZX4F-YQoJj_wbbWcVc";
    TextInputEditText bdate;
    TextInputLayout b_inputdate;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_guide);



        bdate = findViewById(R.id.b_date);
        b_inputdate = findViewById(R.id.b_input_date);



        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        b_inputdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(search_guide.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });




        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                // tvDate.setText(date);

            }
        };
        bdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(search_guide.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        bdate.setText(date);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        if(!Places.isInitialized()) {
            Places.initialize(getApplicationContext(),apiKey);
        }
        // Create a new PlacesClient instance
        PlacesClient placesClient = Places.createClient(this);





    }

    public void search_guide(View view) {
        Intent intent = new Intent(getApplicationContext(), booking_time.class);
        startActivity(intent);

    }
}