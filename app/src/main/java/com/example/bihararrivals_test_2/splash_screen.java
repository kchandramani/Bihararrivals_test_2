package com.example.bihararrivals_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {

    private static int timer=2000;
    ImageView imageView;
    TextView textView1;
    Animation upperanimation,buttomanimaion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        imageView=findViewById(R.id.sslogo);
        textView1=findViewById(R.id.logoname);


        upperanimation= AnimationUtils.loadAnimation(this,R.anim.upper_animation);
        buttomanimaion=AnimationUtils.loadAnimation(this,R.anim.botton_animation);
        imageView.setAnimation(upperanimation);
        textView1.setAnimation(buttomanimaion);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splash_screen.this,welcome_screen.class);
                startActivity(intent);
                finish();
            }
        },timer);



    }
}