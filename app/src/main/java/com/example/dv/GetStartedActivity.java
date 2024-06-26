package com.example.dv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        findViewById(R.id.getstartedbtntxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Mainintent=new Intent(GetStartedActivity.this,MainActivity.class);
                startActivity(Mainintent);
                finish();
            }
        });
    }
}