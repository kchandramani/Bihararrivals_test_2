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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class create_account extends AppCompatActivity {

   // private Button go_back_login;
    TextInputEditText etDate;
    TextInputLayout tvDate, name_db, email_db, number_db, password_db;
    Button regButton;
    DatePickerDialog.OnDateSetListener setListener;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        tvDate = findViewById(R.id.tv_date);
        etDate = findViewById(R.id.et_date);
        //code for going back to login page from registration page
       // go_back_login = (Button) findViewById(R.id.go_back_login); //only this

        //variables for taking data from user and sending to database

        name_db = findViewById(R.id.name_input);
        email_db = findViewById(R.id.create_email_input);
       // dob_db = findViewById(R.id.tv_date);
        // ccode_var=findViewById(R.id.country_code_input);
        number_db = findViewById(R.id.number_input);
        password_db = findViewById(R.id.create_password_input);
        regButton = findViewById(R.id.done_button_input);
        //Gender variable will be added shortly


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(create_account.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        //code for going back to login page from registration page

       /* go_back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginAG();
            }
        }); */


        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                // tvDate.setText(date);

            }
        };
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(create_account.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        etDate.setText(date);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        //save the data into the database
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  String name = name_var.getEditText().getText().toString();
                String email = email_var.getEditText().getText().toString();
                String dob = tvDate.getEditText().getText().toString();
                String phone = number_var.getEditText().getText().toString();
                String password = password_var.getEditText().getText().toString();*/







                                        // Database connection


                                        firebaseDatabase=FirebaseDatabase.getInstance();
                                        reference=firebaseDatabase.getReference("datauser");

                String name = name_db.getEditText().getText().toString();
                String email = email_db.getEditText().getText().toString();
                String phone = number_db.getEditText().getText().toString();
                String dob = tvDate.getEditText().getText().toString();
                String password = password_db.getEditText().getText().toString();




                                       UserHelperClass helperClass = new UserHelperClass(name, email, phone,dob,password);
                                        reference.child(phone).setValue(helperClass);
                                         //reference.setValue("Test 166554");

                                      //  reference.child(email_db).setValue(storingdatass);
                                        Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), main_dashboard.class);
                 startActivity(intent);
                  finish();
















            }
        });



    } //on Create Method


    /*public void openLoginAG() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    } //Till here */

    public void loginButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);

    }

    //private



  /*  public void registerButtonClick(View view) {


        String name_r = name_var.getEditText().getText().toString();
        String email_r = email_var.getEditText().getText().toString();
        String dob_r = dob_var.getEditText().getText().toString();
        String number_r = number_var.getEditText().getText().toString();
        String password_r = password_var.getEditText().getText().toString();

       if (!name_r.isEmpty()) {
            name_var.setError(null);
            name_var.setErrorEnabled(false);
            if (!email_r.isEmpty()) {
                email_var.setError(null);
                email_var.setErrorEnabled(false);
                if (!number_r.isEmpty()) {
                    number_var.setError(null);
                    number_var.setErrorEnabled(false);
                    if (!dob_r.isEmpty()) {
                        dob_var.setError(null);
                        dob_var.setErrorEnabled(false);
                        if (!password_r.isEmpty()) {
                            password_var.setError(null);
                            password_var.setErrorEnabled(false);
                            if (email_r.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {


                            /*    // Database connection


                                firebaseDatabase = FirebaseDatabase.getInstance();
                                reference = firebaseDatabase.getReference("datauser");

                                String name_db = name_var.getEditText().getText().toString();
                                String email_db = email_var.getEditText().getText().toString();
                                String dob_db = dob_var.getEditText().getText().toString();
                                String number_db = number_var.getEditText().getText().toString();
                                String password_db = password_var.getEditText().getText().toString();


                                storingdata storingdatass = new storingdata(name_db, email_db, dob_db, number_db, password_db);

                                reference.child(email_db).setValue(storingdatass);
                                Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();

                              //  Intent intent = new Intent(getApplicationContext(), main_dashboard.class);
                               // startActivity(intent);
                              //  finish();


                            } else {
                                email_var.setError("Invalid Email.");
                            }
                        } else {
                            password_var.setError("Please enter correct the Password.");
                        }
                    } else {
                        dob_var.setError("Please enter correct Date.");
                    }
                } else {
                    number_var.setError("Please enter the Number.");
                }

            } else {
                email_var.setError("Please Enter Your Email.");
            }
        } else {
            name_var.setError("Please Enter Your Full Name.");
        }
    } */


} //main header


