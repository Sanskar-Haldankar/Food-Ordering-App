package com.example.dv.Models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dv.OrdersActivity;
import com.example.dv.R;
import com.example.dv.done;

public class address extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        findViewById(R.id.confirmpayment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doneintent=new Intent(address.this, done.class);
                startActivity(doneintent);
                finish();
            }
        });
    }
}