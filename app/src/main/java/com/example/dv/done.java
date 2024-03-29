package com.example.dv;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class done extends AppCompatActivity {

    TextView confirmed;
    LottieAnimationView lottie;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        lottie =findViewById(R.id.deliveryboy);
        confirmed=findViewById(R.id.confirmed);

        confirmed.animate().translationY(-1200).setDuration(2700).setStartDelay(2000);
        lottie.animate().translationX(1000).setDuration(2000).setStartDelay(4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        },5500);

    }
}