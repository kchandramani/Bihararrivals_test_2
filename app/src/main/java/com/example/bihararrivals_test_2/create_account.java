package com.example.bihararrivals_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class create_account extends AppCompatActivity {

    private Button go_back_login;
    TextInputEditText etDate;
    TextInputLayout tvDate,name_var,email_var,ccode_var,number_var,password_var;
    DatePickerDialog.OnDateSetListener setListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        tvDate=findViewById(R.id.tv_date);
       etDate=findViewById(R.id.et_date);
    //code for going back to login page from registration page
        go_back_login=(Button) findViewById(R.id.go_back_login); //only this

        //variables for taking data from user and sending to database

        name_var=findViewById(R.id.name_input);
        email_var=findViewById(R.id.email_input);
        ccode_var=findViewById(R.id.country_code_input);
        number_var=findViewById(R.id.number_input);
        password_var=findViewById(R.id.password_input);
        //Gender variable will be added shortly


     Calendar calendar=Calendar.getInstance();
      final int year=calendar.get(Calendar.YEAR);
      final int month=calendar.get(Calendar.MONTH);
      final int day=calendar.get(Calendar.DAY_OF_MONTH);

      tvDate.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              DatePickerDialog datePickerDialog=new DatePickerDialog(create_account.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener,year,month,day);
              datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
              datePickerDialog.show();
          }
      });

        //code for going back to login page from registration page

        go_back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginAG();
            }
        });





      setListener=new DatePickerDialog.OnDateSetListener() {
          @Override
          public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
              month=month+1;
              String date=day+"/"+month+"/"+year;
             // tvDate.setText(date);

          }
      };
      etDate.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              DatePickerDialog datePickerDialog=new DatePickerDialog(create_account.this, new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker view, int year, int month, int day) {
                      month=month+1;
                      String date=day+"/"+month+"/"+year;
                      etDate.setText(date);

                  }
              },year,month,day);
              datePickerDialog.show();
          }
      });


   /*     dob_input_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y=c.get(Calendar.YEAR);
                m=c.get(Calendar.MONTH);
                d=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog g=new DatePickerDialog(create_account.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                 dob_input.setText(i+"/"+i1+"/"+i2);
                    }
                },y,m,d);
                g.show();
            }
        });  */
    }

 /*   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        go_back_login=(Button) findViewById(R.id.go_back_login);
        go_back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin2();
            }
        });

    }
    public void openLogin2(){
        Intent intent=new Intent(this,login.class);
        startActivity(intent);
    }  */

    public void openLoginAG() {
        Intent intent=new Intent(this,login.class);
        startActivity(intent);
    } //Till here



}